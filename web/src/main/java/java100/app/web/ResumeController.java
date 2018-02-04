package java100.app.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Resume;
import java100.app.service.ResumeService;

@Controller
@RequestMapping("/resume")
@SessionAttributes("loginUser")
public class ResumeController {
	@Autowired ServletContext servletContext;
    @Autowired ResumeService resumeService;
    
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
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
     
        model.addAttribute("list", resumeService.list());
        return "resume/list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "resume/form";
    }
    
    @RequestMapping("add")
    public String add(
    		Resume resume,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        resume.setMember(loginUser);
        resumeService.add(resume);
        
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("resume", resumeService.get(no));
        return "resume/view";
    }
    
    @RequestMapping("update")
    public String update(Resume resume) throws Exception {
        
        resumeService.update(resume);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

    	resumeService.delete(no);
        return "redirect:list";
    }
}
