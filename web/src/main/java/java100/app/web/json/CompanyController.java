package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.CompanyMember;
import java100.app.domain.Member;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	MemberService memberService;

	@Autowired
	CompanyService comService;

	@RequestMapping("list")
	public String list(@RequestParam(value = "pn", defaultValue = "1") int pageNo,
			@RequestParam(value = "ps", defaultValue = "5") int pageSize,
			@RequestParam(value = "words", required = false) String[] words,
			@RequestParam(value = "oc", required = false) String orderColumn,
			@RequestParam(value = "al", required = false) String align, Model model) throws Exception {

		return "member/list";
	}

	@RequestMapping("{no}")
	public String view(@PathVariable int no, Model model) throws Exception {

		model.addAttribute("member", memberService.get(no));
		return "member/view";
	}

	@RequestMapping("cAdd")
	public Object cAdd(Member member, CompanyMember cMember) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.cAdd(member, cMember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("form")
	public String form() throws Exception {
		return "company/form";

	}

	@RequestMapping("update")
	public String update(Member member) throws Exception {

		memberService.update(member);
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(int no) throws Exception {

		memberService.delete(no);
		return "redirect:list";
	}

	@RequestMapping(value = "check-comp-info", method = RequestMethod.GET)
	@ResponseBody
	public String checkCompInfo(@RequestParam String cname, @RequestParam String cnum) throws Exception {
		System.out.println(cname + ": " + cnum);
		boolean exist = comService.isMatchCompanyInfo(cname, cnum);
		return "{\"success\": " + exist + "}";
	}
}
