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
    public Object list(Model model,  @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
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
