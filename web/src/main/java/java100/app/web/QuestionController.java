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
import java100.app.domain.Question;
import java100.app.service.QuestionService;

@Controller
@RequestMapping("/question")
@SessionAttributes("loginUser")
public class QuestionController {
	@Autowired ServletContext servletContext;
    @Autowired QuestionService questionService;
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "question/form";
    }
    
    @RequestMapping("add")
    public String add(
    		Question question,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        int lno = question.getLno();
        question.setMember(loginUser);
        questionService.add(question);
        
        return "redirect:../letter/" + lno;
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("question", questionService.get(no));
        return "question/view";
    }
    
    @RequestMapping("update")
    public String update(Question question) throws Exception {
        
        questionService.update(question);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

    	questionService.delete(no);
        return "redirect:../apply/list";
    }
}
