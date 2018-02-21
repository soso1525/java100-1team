package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.CompanyMember;
import java100.app.domain.Member;
import java100.app.service.CompanyMemberService;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired MemberService memberService;
	@Autowired CompanyService companyService;
	@Autowired CompanyMemberService companyMemberService;

	@RequestMapping("list")
	public Object list() throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("memberList", companyMemberService.list());
		result.put("status", "success");
		return result;
	}

	@RequestMapping("{no}")
	public Object view(@PathVariable int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		Member member = memberService.get(no);
		result.put("member", member);
		result.put("cmember", companyMemberService.get(no));
		result.put("status", "success");
		return result;
	}

	@RequestMapping("cAdd")
	public Object cAdd(Member member, CompanyMember cmember) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.cAdd(member, cmember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("form")
	public String form() throws Exception {
		return "company/form";

	}

	@RequestMapping("update")
	public Object update(Member member, CompanyMember cmember) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.updateCmember(member, cmember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public Object delete(int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.deleteCmember(no);
		result.put("status", "success");
		return result;
	}

	@RequestMapping(value = "check-comp-info", method = RequestMethod.GET)
	@ResponseBody
	public String checkCompInfo(@RequestParam String cname, @RequestParam String cnum) throws Exception {

		System.out.println(cname + ": " + cnum);
		boolean exist = companyService.isMatchCompanyInfo(cname, cnum);

		return "{\"success\": " + exist + "}";
	}
}
