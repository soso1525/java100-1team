package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Msg2;
import java100.app.service.MemberService;
import java100.app.service.Msg2Service;

@RestController
@RequestMapping("/msg2")
@SessionAttributes("loginUser")
public class Msg2Controller {
    @Autowired Msg2Service msg2Service;
    @Autowired MemberService memberService;
    @Autowired ServletContext servletContext;
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(Msg2 msg2,
           @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        msg2.setWriter(loginUser);
        
        msg2Service.add(msg2);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
//    @RequestMapping("form")
//    public Object form() throws Exception {
//        return "msg2/form";
//    }
    
//    @RequestMapping(value="check-memb-id", method=RequestMethod.GET)
//    @ResponseBody
//    public String checkMembInfo (@RequestParam String id) throws Exception {
//        
//        boolean exist = memberService.isMatchMemberId(id);
//        
//        return "{\"success\": " + exist + "}";
//    }
    
    @RequestMapping("receiveList")
    public Object receiveList (
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
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
        
        int totalCount = msg2Service.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("writer", loginUser);
        result.put("list", msg2Service.receiveList(pageNo, pageSize, options, loginUser));
        return result;
    }
    
    @RequestMapping("sendList")
    public Object sendList(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
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
        
        
        
        int totalCount = msg2Service.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("writer", loginUser);
        result.put("list", msg2Service.sendList(pageNo, pageSize, options, loginUser));
        return result;
    }
     
    @RequestMapping("{mno}")
    public Object view(@PathVariable int mno, @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("writer", loginUser);
        result.put("data", msg2Service.get(mno, loginUser));
        return result;
    }
    
//    @RequestMapping("update")
//    public String update(Msg msg) throws Exception {
//        
//        msgService.update(msg);
//        return "redirect:list";
//    }

    @RequestMapping("delete")
    public Object delete(int mno) throws Exception {

        msg2Service.delete(mno);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
 
}
