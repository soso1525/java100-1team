package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java100.app.domain.CompanyMember;
import java100.app.domain.Member;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired MemberService memberService;
    
    @Autowired CompanyService comService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        // UI �젣�뼱�� 愿��젴�맂 肄붾뱶�뒗 �씠�젃寃� �럹�씠吏� 而⑦듃濡ㅻ윭�뿉 �몢�뼱�빞 �븳�떎.
        //
//        if (pageNo < 1) {
//            pageNo = 1;
//        }
//        
//        if (pageSize < 5 || pageSize > 15) {
//            pageSize = 5;
//        }
//        
//        HashMap<String,Object> options = new HashMap<>();
//        if (words != null && words[0].length() > 0) {
//            options.put("words", words);
//        }
//        options.put("orderColumn", orderColumn);
//        options.put("align", align);
//        
//        int totalCount = memberService.getTotalCount();
//        int lastPageNo = totalCount / pageSize;
//        if ((totalCount % pageSize) > 0) {
//            lastPageNo++;
//        }
//        
//        // view 而댄룷�꼳�듃媛� �궗�슜�븷 媛믪쓣 Model�뿉 �떞�뒗�떎.
//        model.addAttribute("pageNo", pageNo);
//        model.addAttribute("lastPageNo", lastPageNo);
//        
//        model.addAttribute("list", memberService.list(pageNo, pageSize, options));
        return "member/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("member", memberService.get(no));
        return "member/view";
    }
    
    @RequestMapping("cAdd")
    public String cAdd(Member member, CompanyMember cMember) throws Exception {
        memberService.cAdd(member, cMember);
        return "redirect:../auth/login";
    }
    // /web/app   /company/form
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
    
    @RequestMapping(value="check-comp-info", method=RequestMethod.GET)
    @ResponseBody
    public String checkCompInfo (@RequestParam String cname, @RequestParam String cnum) throws Exception {
    	
    	System.out.println(cname + ": " + cnum);
    	boolean exist = comService.isMatchCompanyInfo(cname, cnum);
    	
    	return "{\"success\": " + exist + "}";
    }
}
