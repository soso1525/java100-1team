package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Member;
import java100.app.domain.Resume;
import java100.app.service.ResumeService;

@RestController
@RequestMapping("/resume")
@SessionAttributes("loginUser")
public class ResumeController {
	@Autowired ServletContext servletContext;
    @Autowired ResumeService resumeService;
    
    @RequestMapping("list")
    public Object list(@RequestParam(value = "pn", defaultValue = "1") int pageNo,
          @RequestParam(value = "ps", defaultValue = "5") int pageSize,
          @RequestParam(value = "words", required = false) String[] words,
          @RequestParam(value = "oc", required = false) String orderColumn,
          @RequestParam(value = "al", required = false) String align,
          @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {

       if (pageNo < 1) {
          pageNo = 1;
       }

       if (pageSize < 5 || pageSize > 15) {
          pageSize = 5;
       }

       HashMap<String, Object> options = new HashMap<>();
       if (words != null && words[0].length() > 0) {
          options.put("words", words);
       }
       options.put("orderColumn", orderColumn);
       options.put("align", align);
       options.put("mno", loginUser.getNo());

       int totalCount = resumeService.getTotalCount();
       int lastPageNo = totalCount / pageSize;
       if ((totalCount % pageSize) > 0) {
          lastPageNo++;
       }

       HashMap<String, Object> result = new HashMap<>();
       result.put("pageNo", pageNo);
       result.put("lastPageNo", lastPageNo);
      
       if (loginUser.getType().equals("1")) {
          result.put("list", resumeService.listMy(pageNo, pageSize, options));
       } else {
          result.put("list", resumeService.list(pageNo, pageSize, options));
       }
       return result;
    }
   
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "resume/form"; 
    }
    
    @RequestMapping("add")
    public Object add(
            Resume resume,
            MultipartFile[] files,
            @ModelAttribute(value="loginUser") Member loginUser
            ) throws Exception {
        
        ArrayList<String> list = new ArrayList<>();
        for (MultipartFile part : files) {
        	if(part.isEmpty()) {
        		list.add("");
        	} else {
        		list.add(this.addFile(part));
        	}
        }
        
        resume.setImage(list.get(0));
        resume.setAvi(list.get(1));
        resume.setFile(list.get(2));
        resume.setMember(loginUser);
        
        HashMap<String,Object> result = new HashMap<>();
        
        resumeService.add(resume);
        
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("{rno}")
    public Object view(@PathVariable int rno, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("userInfo", loginUser); 
        result.put("data", resumeService.get(rno));
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Resume resume
            ,MultipartFile[] files) throws Exception {
        
        ArrayList<String> list = new ArrayList<>();
        for (MultipartFile part : files) {
            if(part.isEmpty()) {
                list.add("");
            } else {
                list.add(this.addFile(part));
            }
        }
        
        resume.setImage(list.get(0));
        resume.setAvi(list.get(1));
        resume.setFile(list.get(2));
        
        resumeService.update(resume);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        
    	resumeService.delete(no);
    	
    	HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
    	
        return result;
    }
    
    long prevMillis = 0;
    int count = 0;
    
   synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
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
    
    private String addFile(MultipartFile part) throws IOException {
    	String uploadDir = servletContext.getRealPath("/download");
        
        String filename = this.writeUploadFile(part, uploadDir);
        return filename;
    }
}
