package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired MemberService memberService;
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        model.addAttribute("member", memberService.get(no));
        return "member/view";
    }
    
}








