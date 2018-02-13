package java100.app.web.json;

import java.io.File;
import java.io.IOException;
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
import java100.app.domain.Notice;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;
import java100.app.service.NoticeService;

@RestController
@RequestMapping("/notice")
@SessionAttributes("loginUser")
public class NoticeController {
    @Autowired NoticeService noticeService;
    @Autowired ServletContext servletContext;
    @Autowired MemberService memberService;
    @Autowired CompanyService comService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align
            ) throws Exception {
        
//        if (pageNo < 1) {
//            pageNo = 1;
//        }
//        
//        if (pageSize < 5 || pageSize > 15) {
//            pageSize = 5;
//        }
//        
//        HashMap<String,Object> options = new HashMap<>();
//        if (words != null && words[0].length() > 0) {
//            options.put("words", words);
//        }
//        options.put("orderColumn", orderColumn);
//        options.put("align", align);
//        
//        int totalCount = memberService.getTotalCount();
//        int lastPageNo = totalCount / pageSize;
//        if ((totalCount % pageSize) > 0) {
//            lastPageNo++;
//        }
//        
//        model.addAttribute("pageNo", pageNo);
//        model.addAttribute("lastPageNo", lastPageNo);
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("list", noticeService.list());
        return result;
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "notice/form";
        
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
       
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("data", noticeService.get(no));
        
        return result;
    }
    
    @RequestMapping("add")
    public Object add(
            Notice notice,
            MultipartFile file,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
    	notice.setImage(addFile(file));
        notice.setWriter(loginUser);
        noticeService.add(notice);
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(MultipartFile file, Notice notice) throws Exception {
    	notice.setImage(addFile(file));
        noticeService.update(notice);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {

    	noticeService.delete(no);
    	
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