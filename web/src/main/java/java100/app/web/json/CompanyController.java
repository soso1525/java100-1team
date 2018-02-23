package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.CompanyMember;
import java100.app.domain.Member;
import java100.app.service.CompanyMemberService;
import java100.app.service.CompanyService;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired MemberService memberService;
	@Autowired CompanyService companyService;
	@Autowired ServletContext servletContext;
	@Autowired CompanyMemberService companyMemberService;

	@RequestMapping("list")
	public Object list() throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("memberList", companyMemberService.list());
		result.put("status", "success");
		return result;
	}

	@RequestMapping("{no}")
	public Object view(@PathVariable int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		Member member = memberService.get(no);
		result.put("member", member);
		result.put("cmember", companyMemberService.get(no));
		result.put("status", "success");
		return result;
	}

	@RequestMapping("cAdd")
	public Object cAdd(Member member, CompanyMember cmember) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.cAdd(member, cmember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("update")
	public Object update(CompanyMember cmember, MultipartFile file) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		cmember.setLogo(addFile(file));
		companyMemberService.update(cmember);
		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public Object delete(int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		memberService.deleteCmember(no);
		result.put("status", "success");
		return result;
	}

	@RequestMapping(value = "check-comp-info", method = RequestMethod.GET)
	@ResponseBody
	public String checkCompInfo(@RequestParam String cname, @RequestParam String cnum) throws Exception {

		System.out.println(cname + ": " + cnum);
		boolean exist = companyService.isMatchCompanyInfo(cname, cnum);

		return "{\"success\": " + exist + "}";
	}
	
	long prevMillis = 0;
    int count = 0;
    
   synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }
    
    private String addFile(MultipartFile part) throws IOException {
    	String uploadDir = servletContext.getRealPath("/download");
        
        String filename = this.writeUploadFile(part, uploadDir);
        return filename;
    }
}
