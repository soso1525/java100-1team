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

import java100.app.domain.Apply;
import java100.app.domain.Member;
import java100.app.service.ApplyService;
import java100.app.service.LetterService;

@Controller
@RequestMapping("/apply")
@SessionAttributes("loginUser")
public class ApplyController {
	@Autowired ServletContext servletContext;
    @Autowired ApplyService applyService;
    @Autowired LetterService letterService;
    
    
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
     
        model.addAttribute("list", applyService.list());
        return "apply/list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "apply/form";
    }
    
    @RequestMapping("add")
    public String add(
    		Apply apply,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        apply.setMember(loginUser);
        applyService.add(apply);
        
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("apply", applyService.get(no));
        model.addAttribute("letter", letterService.list(no));
        return "apply/view";
    }
    
    @RequestMapping("update")
    public String update(Apply apply) throws Exception {
        
        applyService.update(apply);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

    	applyService.delete(no);
        return "redirect:list";
    }
}
