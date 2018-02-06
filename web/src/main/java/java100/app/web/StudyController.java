package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Member;
import java100.app.domain.Study;
import java100.app.service.MemberService;
import java100.app.service.StudyService;

@Controller
@RequestMapping("/study")
@SessionAttributes("loginUser")
public class StudyController {
    @Autowired StudyService studyService;
    @Autowired MemberService memberService;
    @Autowired ServletContext servletContext;
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Study study, MultipartFile file,
           @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        String uploadDir = servletContext.getRealPath("/download");
        
        String filename = writeUploadFile(file, uploadDir);
        
        study.setSimg(filename);
        
        study.setWriter(loginUser);
        
        studyService.add(study);
        
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "study/form";
    }
    
    @RequestMapping(value="check-memb-id", method=RequestMethod.GET)
    @ResponseBody
    public String checkMembInfo (@RequestParam String id) throws Exception {
        
        boolean exist = memberService.isMatchMemberId(id);
        
        return "{\"success\": " + exist + "}";
    }
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = studyService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", studyService.list(pageNo, pageSize, options));
        return "study/list";
    }
    
    @RequestMapping("{sno}")
    public String view(@PathVariable int sno, Model model) throws Exception {
        model.addAttribute("study", studyService.get(sno));
        return "study/view";
    }
    
    @RequestMapping("update")
    public String update(Study study) throws Exception {
        
        studyService.update(study);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int sno) throws Exception {

        studyService.delete(sno);
        return "redirect:list";
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
 
}
