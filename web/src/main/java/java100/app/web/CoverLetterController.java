package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.CompanyMember;
import java100.app.domain.CoverLetter;
import java100.app.domain.IndividualMember;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.CompanyService;
import java100.app.service.CoverLetterService;
import java100.app.service.MemberService;

@Controller
@RequestMapping("/coverletters")
public class CoverLetterController {
    @Autowired CoverLetterService cvService;
    
    @RequestMapping("list")
    public String list(Model model, HttpSession session) throws Exception {
        IndividualMember loginUser = (IndividualMember) session.getAttribute("loginUser");
        
        if ( loginUser == null) {
        	// TODO 로그인 페이지로 리다이렉트 시킴 
        	// return "redirect:/login";
        }
        int writerSeq = 1;
        List<CoverLetter> letters = cvService.findByWriter(writerSeq);
        System.out.println(letters);
        model.addAttribute("letters", letters);
        return "cv/letters";
    }
    
    @RequestMapping(value="apply", method=RequestMethod.GET)
    public String insert ( Model model ) throws Exception {
    	// 얘가 채용공고 페이지로 넘어갈때
    	model.addAttribute("ccnum", 123);
    	return "cv/apply";
    }
    
    @RequestMapping(value="apply", method=RequestMethod.POST)
    public String doInsert (
    		@RequestParam Integer ccnum, 
    		@RequestParam String lcont, 
    		HttpServletRequest req,  
    		MultipartFile [] files) throws Exception {
    	// 업로드 파일을 저장할 폴더 위치를 가져온다.
        String uploadDir = "d:/tmp"; //req.getServletContext().getRealPath("d:/tmp");
        
        // 업로드 파일 정보를 저장할 List 객체 준비
        ArrayList<String> uploadFiles = new ArrayList<>();
        
        // 클라이언트가 보낸 파일을 저장하고, 
        // 그 파일명(저장할 때 사용한 파일명)을 목록에 추가한다.
        for (MultipartFile part : files) {
            if (part.isEmpty())
                continue;
            
            String filename = this.writeUploadFile(part, uploadDir);
            
            uploadFiles.add(filename); // 저장된 파일의 경로를 넣어줌
        }
        
        CoverLetter letter = new CoverLetter();
        
        letter.setLcont(lcont);
        letter.setLfile(uploadFiles.get(0));
        
    	return "cv/apply";
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }
    
 // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    // pic.png
    // pic339939109292.png
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
}
