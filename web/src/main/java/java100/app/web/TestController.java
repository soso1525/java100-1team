package java100.app.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Test;
import java100.app.service.TestService;

@Controller
@RequestMapping("/test")
@SessionAttributes("loginUser")
public class TestController {
	@Autowired ServletContext servletContext;
	@Autowired TestService testService;


	@RequestMapping("form")
	public String form() throws Exception {
		return "test/form";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Test test, @ModelAttribute(value = "loginUser") Member loginUser)
			throws Exception {

		int ano = test.getAno();
		test.setMember(loginUser);
		testService.insert(test);

		return "redirect:../apply/list";
	}

	@RequestMapping("{no}")
	public String view(@PathVariable int no, Model model) throws Exception {
		model.addAttribute("test", testService.findByNo(no));
		return "test/view";
	}

	@RequestMapping("update")
	public String update(Test test) throws Exception {
		testService.update(test);
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(int no) throws Exception {
		testService.delete(no);
		return "redirect:../apply/list";
	}
}
