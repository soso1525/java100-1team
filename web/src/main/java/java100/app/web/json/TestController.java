package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Test;
import java100.app.service.TestService;

@RestController
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
	public Object add(Test test, @ModelAttribute(value = "loginUser") Member loginUser)
			throws Exception {
		test.setMember(loginUser);
		testService.insert(test);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping("{no}")
	public Object view(@PathVariable int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("test", testService.findByNo(no));
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
