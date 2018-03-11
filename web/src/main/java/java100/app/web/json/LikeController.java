package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Like;
import java100.app.domain.Member;
import java100.app.service.CompanyService;
import java100.app.service.LikeService;
import java100.app.service.MemberService;

@RestController
@RequestMapping("like")
@SessionAttributes("loginUser")
public class LikeController {
    @Autowired ServletContext servletContext;
    @Autowired MemberService memberService;
    @Autowired LikeService likeService;
    @Autowired CompanyService comService;
    
    @RequestMapping("list")
    public Object list(@ModelAttribute(value="loginUser") Member loginUser) throws Exception {
   
        HashMap<String,Object> result = new HashMap<>();
        
  
        result.put("list", likeService.list(loginUser));
        
        return result;
    }
    
    
    
    @RequestMapping("add")
    public Object scrap(int nno, @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	Like like = new Like();
    	like.setNno(nno);
    	like.setIno(loginUser.getNo());
        likeService.add(like);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int nno) throws Exception {

    	likeService.delete(nno);
    	
    	HashMap<String,Object> result = new HashMap<>();
        
    	result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("{nno}")
    public Object view(@PathVariable int nno,
    		@ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", likeService.get(nno, loginUser));
        return result;
    }
    
}
