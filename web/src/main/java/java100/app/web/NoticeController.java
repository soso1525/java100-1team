package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.service.CompanyService;
import java100.app.service.MemberService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
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
        
        int totalCount = memberService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        
        model.addAttribute("list", memberService.list(pageNo, pageSize, options));
        return "notice/list";
    }
}
