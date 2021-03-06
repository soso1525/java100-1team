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

import java100.app.domain.IndividualMember;
import java100.app.domain.Member;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("list")
	public Object list(@RequestParam(value = "pn", defaultValue = "1") int pageNo,
			@RequestParam(value = "ps", defaultValue = "5") int pageSize,
			@RequestParam(value = "words", required = false) String[] words,
			@RequestParam(value = "oc", required = false) String orderColumn,
			@RequestParam(value = "al", required = false) String align, Model model) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("list", memberService.list());
		return result;
	}

	@RequestMapping("{no}")
	public Object iView(@PathVariable int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("data", memberService.get(no));
		return result;
	}
	


	@RequestMapping("iAdd")
	public Object iAdd(Member member, IndividualMember iMember) throws Exception {
		HashMap<String, Object> result = new HashMap<>();	
		memberService.iAdd(member, iMember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("form")
	public String form() throws Exception {
		return "member/form";

	}

	@RequestMapping("update")
	public Object update(Member member, IndividualMember imember) throws Exception {
		memberService.updateImember(member, imember);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public String delete(int no) throws Exception {

		memberService.delete(no);
		return "redirect:list";
	}

	@RequestMapping(value = "check-memb-id", method = RequestMethod.GET)
	@ResponseBody
	public String checkMembId(@RequestParam String id) throws Exception {
		boolean exist = memberService.isMatchMemberId(id);
		return "{\"success\": " + exist + "}";
	}

	@RequestMapping(value = "check-memb-email", method = RequestMethod.GET)
	@ResponseBody
	public String checkMembEmail(@RequestParam String email) throws Exception {
		boolean exist = memberService.isMatchMemberEmail(email);
		return "{\"success\": " + exist + "}";
	}
}
