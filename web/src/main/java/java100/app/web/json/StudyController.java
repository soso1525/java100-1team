package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Member;
import java100.app.domain.Study;
import java100.app.service.MemberService;
import java100.app.service.StudyService;

@RestController
@RequestMapping("/study")
@SessionAttributes("loginUser")
public class StudyController {
    @Autowired StudyService studyService;
    @Autowired MemberService memberService;
    @Autowired ServletContext servletContext;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="8") int pageSize,
            @RequestParam(value="words", required=false) String [] words,
            @RequestParam(value="address", required=false) String address,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 3 || pageSize > 15) {
            pageSize = 3;
        }
        
        HashMap<String,Object> options = new HashMap<>();
        if ("전체".equals(address)) {
        	options.put("address", null);
        } else {
        	options.put("address", address);
        }
        
        if (words != null && words.length > 0) {
            options.put("words", words);
        }
        
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        System.out.println(options);
        
        int totalCount = studyService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", studyService.list(pageNo, pageSize, options));
        return result;
    }
    
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(Study study, 
            MultipartFile file,
           @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        String uploadDir = servletContext.getRealPath("/download");
        
        String filename = writeUploadFile(file, uploadDir);
       
        study.setSimg(filename);
        
        study.setWriter(loginUser);
        
        studyService.add(study);
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("status", "success");
        
        return result;
    }
    
//    @RequestMapping("form")
//    public String form() throws Exception {
//        return "study/form";
//    }
    
    @RequestMapping(value="check-memb-id", method=RequestMethod.GET)
    @ResponseBody
    public String checkMembInfo (@RequestParam String id) throws Exception {
        
        boolean exist = memberService.isMatchMemberId(id);
        
        return "{\"success\": " + exist + "}";
    }
    

    @RequestMapping("{sno}")
    public Object view(@PathVariable int sno) throws Exception {
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", studyService.get(sno));
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Study study,
            MultipartFile file) throws Exception {
        
        String uploadDir = servletContext.getRealPath("/download");
        
        String filename = writeUploadFile(file, uploadDir);
       
        study.setSimg(filename);
        
        studyService.update(study);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int sno) throws Exception {

        studyService.delete(sno);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("apply")
    public void applyStudy (@RequestParam Integer study,HttpSession session ) throws Exception {
    	System.out.println(study);
    	Member loginUser = (Member) session.getAttribute("loginUser"); // 세션에서 유저정보 가져옴
    	
    	int userNo = loginUser.getNo();
    	if(userNo == 0) {
    	    userNo = 1000; // TODO 안쓰임!
    	}
    	
    	
    	studyService.applyStudy ( study, userNo );
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
    
    @RequestMapping("memberList")
    public Object memberList(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="8") int pageSize,
            @RequestParam(value="words", required=false) String [] words,
            @RequestParam(value="address", required=false) String address,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            HttpSession session) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 8 || pageSize > 15) {
            pageSize = 8;
        }
        
        HashMap<String,Object> options = new HashMap<>();
        if ("전체".equals(address)) {
            options.put("address", null);
        } else {
            options.put("address", address);
        }
        
        if (words != null && words.length > 0) {
            options.put("words", words);
        }
        
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        Member loginUser = (Member) session.getAttribute("loginUser"); // 세션에서 유저정보 가져옴
        options.put("loginUserNo", loginUser.getNo());
        
        System.out.println(options);
        
        int totalCount = studyService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", studyService.memberList(pageNo, pageSize, options));
        return result;
    }
    
    @RequestMapping("myStudyUserInfo")
    public Object myStudyUserInfo (@RequestParam String sno,HttpSession session ) throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        HashMap<String,Object> options = new HashMap<>();
        
        options.put("sno", sno);
        
        result.put("list", studyService.myStudyUserInfo(options));

        return result;
        
        
    }
    
    @RequestMapping("changeId")
    public String changeId (@RequestParam int no ) throws Exception {
        System.out.println("no :>>>>>>>>>>>>>>> "+no);
        return studyService.changId(no);
        
        
    }

 
}
