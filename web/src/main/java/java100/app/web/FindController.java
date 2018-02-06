package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Find;
import java100.app.domain.Member;
import java100.app.service.FindService;

@Controller
@RequestMapping("/find")
@SessionAttributes("loginUser")
public class FindController {
    @Autowired FindService findService;
    
    
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
     
        model.addAttribute("list", findService.list());
        return "find/list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "find/form";
    }
    
    @RequestMapping("add")
    public String addMember(
    		Find find,
    		@ModelAttribute(value="loginUser") Member loginUser) throws Exception {
//    		find.setMember(loginUser);
    		findService.addMember(find);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

    	findService.delete(no);
        return "redirect:list";
    }
}
