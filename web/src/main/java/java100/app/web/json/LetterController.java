package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Letter;
import java100.app.domain.Member;
import java100.app.service.LetterService;
import java100.app.service.QuestionService;

@RestController
@RequestMapping("/letter")
@SessionAttributes("loginUser")
public class LetterController {
	@Autowired ServletContext servletContext;
    @Autowired LetterService letterService;
    @Autowired QuestionService questionService;
    
    @RequestMapping("form")
    public Object form() throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        return result;
    }
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(
    		Letter letter,
    		MultipartFile file,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
    	String uploadDir = servletContext.getRealPath("/download");
        String filename = writeUploadFile(file, uploadDir);
        letter.setLfile(filename);
        letter.setMember(loginUser);
        letterService.add(letter);
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
        result.put("letter", letterService.get(no));
        result.put("question", questionService.list(no));
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Letter letter) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        letterService.update(letter);
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
    	letterService.delete(no);
        return result;
    }
    
    long prevMillis = 0;
    int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }  
}
