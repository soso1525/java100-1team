package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Msg2;
import java100.app.service.MemberService;
import java100.app.service.Msg2Service;

@RestController
@RequestMapping("/message")
@SessionAttributes("loginUser")
public class Msg2Controller {
    @Autowired Msg2Service msg2Service;
    @Autowired MemberService memberService;
    @Autowired ServletContext servletContext;
    
    @RequestMapping(value = "check-memb-id", method = RequestMethod.GET)
    @ResponseBody
    public String checkMembId(@RequestParam String id) throws Exception {
        boolean exist = memberService.isMatchMemberId(id);
        return "{\"success\": " + exist + "}";
    }
    
//    @RequestMapping(value="add")
//    public Object add(Msg2 msg2,
//           @ModelAttribute(value="loginUser") Member loginUser
//           ,@RequestParam(value="mrecv") String mrecv
//           ) throws Exception {
//        
//        msg2.setWriter(loginUser); // 보내는 사람 정
//        
//        msg2.setPid2(mrecv); // 받는사람 id
//
//        int resultAdd = msg2Service.msgAdd(msg2); // Msg insert
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("status", "success");
//        
//        return result;
//    }
    
//    @RequestMapping("form")
//    public Object form() throws Exception {
//        return "msg2/form";
//    }
    
    @RequestMapping(value="add",method = RequestMethod.POST)
    public Object test(@RequestParam(value="mrecv") String mrecv,
            @RequestParam(value="mcont") String mcont,
            @ModelAttribute(value="loginUser") Member loginUser
           ) throws Exception {
        System.out.println(mrecv);
        System.out.println(loginUser);
        Msg2 msg2 = new Msg2();
        msg2.setWriter(loginUser); // 보내는 사람 정
        msg2.setMcont(mcont);
        msg2.setPid2(mrecv); // 받는사람 id
        
        int resultAdd = msg2Service.msgAdd(msg2); // Msg insert
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("receiveList")
    public Object receiveList (
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="6") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 6 || pageSize > 15) {
            pageSize = 6;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int mrecvCount = msg2Service.getMrecvCount(loginUser.getNo());
        int lastPageNo = mrecvCount / pageSize;
        if ((mrecvCount % pageSize) > 0) {
            lastPageNo++;
        }
        if(pageNo >= lastPageNo) {
            pageNo = lastPageNo;
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
            @RequestParam(value="pn", defaultValue="2") int pageNo,
            @RequestParam(value="ps", defaultValue="6") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 6 || pageSize > 15) {
            pageSize = 6;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        
        
        int msendCount = msg2Service.getMsendCount(loginUser.getNo());
        int lastPageNo = msendCount / pageSize;
        if ((msendCount % pageSize) > 0) {
            lastPageNo++;
        }
        if(pageNo >= lastPageNo) {
            pageNo = lastPageNo;
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
