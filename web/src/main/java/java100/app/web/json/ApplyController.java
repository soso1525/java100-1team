package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Apply;
import java100.app.domain.Member;
import java100.app.service.ApplyService;
import java100.app.service.LetterService;
import java100.app.service.TestService;

@RestController
@RequestMapping("/apply")
@SessionAttributes("loginUser")
public class ApplyController {
	@Autowired ServletContext servletContext;
    @Autowired ApplyService applyService;
    @Autowired LetterService letterService;
    @Autowired TestService testService;
    
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
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
    	HashMap<String, Object> result = new HashMap<>();
        result.put("apply", applyService.list(loginUser));
        return result;
    }
    
    @RequestMapping("add")
    public Object add(
    		Apply apply,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	apply.setMember(loginUser);
    	applyService.add(apply);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no, Model model) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	
        result.put("data", applyService.get(no));
        result.put("letter", letterService.list(no));
        result.put("test", testService.list(no));
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Apply apply) throws Exception {
    	applyService.update(apply);
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int ano) throws Exception {
    	applyService.delete(ano);
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        return result;
    }
}
