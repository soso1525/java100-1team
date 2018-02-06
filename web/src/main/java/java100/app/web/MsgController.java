package java100.app.web;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Msg;
import java100.app.service.MemberService;
import java100.app.service.MsgService;

@Controller
@RequestMapping("/msg")
@SessionAttributes("loginUser")
public class MsgController {
    @Autowired MsgService msgService;
    @Autowired MemberService memberService;
    @Autowired ServletContext servletContext;
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Msg msg,
           @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        
        msg.setWriter(loginUser);
        
        msgService.add(msg);
        
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "msg/form";
    }
    
    @RequestMapping(value="check-memb-id", method=RequestMethod.GET)
    @ResponseBody
    public String checkMembInfo (@RequestParam String id) throws Exception {
        
        boolean exist = memberService.isMatchMemberId(id);
        
        return "{\"success\": " + exist + "}";
    }
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = msgService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", msgService.list(pageNo, pageSize, options));
        return "msg/list";
    }
     
    @RequestMapping("{sno}")
    public String view(@PathVariable int sno, Model model) throws Exception {
        model.addAttribute("msg", msgService.get(sno));
        return "msg/view";
    }
    
//    @RequestMapping("update")
//    public String update(Msg msg) throws Exception {
//        
//        msgService.update(msg);
//        return "redirect:list";
//    }

    @RequestMapping("delete")
    public String delete(int mno) throws Exception {

        msgService.delete(mno);
        return "redirect:list";
    }
    
 
}
