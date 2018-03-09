package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Question;
import java100.app.service.QuestionService;

@RestController
@RequestMapping("/question")
@SessionAttributes("loginUser")
public class QuestionController {
	@Autowired ServletContext servletContext;
    @Autowired QuestionService questionService;
    
    @RequestMapping("form")
    public Object form() throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        return result;
    }
    
    @RequestMapping("add")
    public Object add(
    		Question question,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        question.setMember(loginUser);
        questionService.add(question);
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("compName", questionService.getCompanyName(no));
    	result.put("file", questionService.getFileName(no));
        result.put("question", questionService.list(no));
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Question question) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
        questionService.update(question);
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
    	HashMap<String, Object> result = new HashMap<>();
    	result.put("status", "success");
    	questionService.delete(no);
        return result;
    }
}
