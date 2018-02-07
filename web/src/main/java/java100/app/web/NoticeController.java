package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Notice;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;
import java100.app.service.NoticeService;

@Controller
@RequestMapping("/notice")
@SessionAttributes("loginUser")
public class NoticeController {
    @Autowired NoticeService noticeService;
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
//        model.addAttribute("pageNo", pageNo);
//        model.addAttribute("lastPageNo", lastPageNo);
        
        model.addAttribute("list", noticeService.list());
        return "notice/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("notice", noticeService.get(no));
        return "notice/view";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "notice/form";
        
    }
    
    @RequestMapping("add")
    public String add(
            Notice notice,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        notice.setWriter(loginUser);
        
        noticeService.add(notice);
        
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(
            Notice notice) throws Exception {
        
        noticeService.update(notice);
        
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        noticeService.delete(no);
        return "redirect:list";
    }
    
}
