package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Member;
import java100.app.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("update")
    public String update(Member member) throws Exception {

        memberService.update(member);
        return "redirect:list";
    }
}
