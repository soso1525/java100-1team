package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
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
import java100.app.domain.Question;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;
import java100.app.service.NoticeService;
import java100.app.service.QuestionService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/notice")
@SessionAttributes("loginUser")
public class NoticeController {
    @Autowired NoticeService noticeService;
    @Autowired ServletContext servletContext;
    @Autowired MemberService memberService;
    @Autowired CompanyService comService;
    @Autowired QuestionService questionService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="cKind", required=false) String cKind,
            @RequestParam(value="address", required=false) String address,
            @RequestParam(value="nType", required=false) String nType,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align
            ) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 9 || pageSize > 15) {
            pageSize = 9;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
            if (cKind.equals("전체")) {
            	options.put("cKind", null);
            } else {
            	options.put("cKind", cKind);
            }
            
            if (address.equals("전체")) {
            	options.put("address", null);
            } else {
            	options.put("address", address);
            }
        }
        options.put("nType", nType);
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        int totalCount = noticeService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        if(pageNo >= lastPageNo) {
            pageNo = lastPageNo;
        }
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        if (lastPageNo == 0) {
        	result.put("lastPageNo", null);
        }
        result.put("list", noticeService.list(pageNo, pageSize, options));
        
        return result;
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "notice/form";
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no,
            HttpSession session) throws Exception {
        HashMap<String, Object> result = new HashMap<>();

        Member loginUser = (Member) session.getAttribute("loginUser"); // 세션에서 유저정보 가져옴
        result.put("userInfo", loginUser.getNo()); // 유저의 no셋팅 -- 유저의 no와 공고의 작성자의 no를 확인하기 위함
        result.put("data", noticeService.get(no));
        return result;
    }
    
    @RequestMapping("add")
    public Object add(
            Notice notice,
            Question question,
            MultipartFile file,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	notice.setImage(addFile(file));
        notice.setWriter(loginUser);
        noticeService.add(notice);
        if (question.getArticles() != null) {
        	question.setNno(notice.getNo());
        	questionService.companyAdd(question);
        }
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
        String realPath = new File(uploadDir).getAbsolutePath();
        int size = 500;
        String filename = this.writeUploadFile(part, uploadDir);
        // 1519461025277_500x500_0.png
        //File thumnail = new File(realPath, thumnailPath(filename, size + "x" + size));
        Thumbnails.of( new File(realPath, filename) )
                  .size(size, size)
                  .outputQuality(1.0)
			      .outputFormat(filename.substring(filename.lastIndexOf('.') + 1 ))
			      .toFile(new File(realPath + filename));
        return filename;
    }

	private String thumnailPath(String filename, String size) {
		//1519461025277_0.png
		String [] names = filename.split("_"); 
		return names[0] + "_" + size + "_" + names[1];  
	}

    
}
