package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Apply;
import java100.app.domain.Member;
import java100.app.domain.Test;
import java100.app.service.ApplyService;
import java100.app.service.TestService;

@RestController
@RequestMapping("/test")
@SessionAttributes("loginUser")
public class TestController {

	@Autowired ServletContext servletContext;
	@Autowired ApplyService applyService;
	@Autowired TestService testService;

	@RequestMapping("form")
	public String form() throws Exception {
		return "test/form";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Object add(int ano, Apply apply, Test test, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		test.setAno(ano);
		HashMap<String, Object> result = new HashMap<>();
		testService.add(test);
		result.put("status", "success");
		return result;
	}

	@RequestMapping(value = "addTest", method = RequestMethod.POST)
	public Object addTest(Apply apply, Test test, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		HashMap<String, Object> result = new HashMap<>();

		apply.setMember(loginUser);
		applyService.add(apply);
		
		test.setAno(apply.getAno());
		testService.add(test);
		
		result.put("status", "success");
		result.put("ano", apply.getAno());
		return result;
	}

	@RequestMapping("{ano}")
	public Object list(@PathVariable int ano) throws Exception {
		// result.put("letter", letterService.get(no));
		// result.put("question", questionService.list(no));
		HashMap<String, Object> result = new HashMap<>();
		result.put("test", testService.list(ano));
		return result;
	}

	@RequestMapping("update")
	public Object update(Test test) throws Exception {
		testService.update(test);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public Object delete(int no) throws Exception {
		testService.delete(no);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}
}
