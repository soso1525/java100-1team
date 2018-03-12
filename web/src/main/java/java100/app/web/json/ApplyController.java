package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Apply;
import java100.app.domain.Letter;
import java100.app.domain.Member;
import java100.app.domain.Resume;
import java100.app.service.ApplyService;
import java100.app.service.LetterService;
import java100.app.service.ResumeService;
import java100.app.service.TestService;

@RestController
@RequestMapping("/apply")
@SessionAttributes("loginUser")
public class ApplyController {
	@Autowired
	ServletContext servletContext;
	@Autowired
	ApplyService applyService;
	@Autowired
	LetterService letterService;
	@Autowired
	ResumeService resumeService;
	@Autowired
	TestService testService;

	@RequestMapping("state")
	public Object getState(int ano, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		Apply apply = applyService.getState(ano);
		result.put("aname", apply.getAname());
		if (apply.getTest() == null) {
			result.put("state", "서류");
		} else {
			result.put("state", apply.getTest().getType());
		}
		return result;
	}

	@RequestMapping("list")
	public Object list(Model model, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("apply", applyService.list(loginUser));
		return result;
	}

	@RequestMapping("add")
	public Object add(Apply apply, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		apply.setMember(loginUser);
		applyService.add(apply);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");

		return result;
	}

	@RequestMapping("add-simple")
	public Object addSimple(Apply apply, Letter letter, MultipartFile[] files,
			@ModelAttribute(value = "loginUser") Member loginUser) throws Exception {

		ArrayList<String> list = new ArrayList<>();
		for (MultipartFile part : files) {
			if (part.isEmpty())
				list.add("");
			else
				list.add(this.addFile(part));
		}

		apply.setMember(loginUser);
		applyService.add(apply);

		Resume resume = null;

		if (!list.get(0).equals("")) {
			resume = new Resume();
			resume.setFile(list.get(0));
			resume.setMember(loginUser);
			// resume.setIno(loginUser.getNo());
			resume.setTitle(apply.getAname() + "이력서");
			resume.setCheck("1");
		}

		if (!list.get(1).equals("")) {
			letter.setAno(apply.getAno());
			letter.setLtit(apply.getAname() + "자소서");
			letter.setLfile(list.get(1));
		}

		if (resume != null)
			resumeService.add(resume);
		if (letter.getLfile() != null)
			letterService.add(letter);

		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping("{no}")
	public Object view(@PathVariable int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("data", applyService.get(no));
		result.put("letter", letterService.list(no));
		result.put("test", testService.list(no));
		return result;
	}

	@RequestMapping("find")
	public Object find(String aname) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("data", applyService.getApply(aname));
		return result;
	}

	@RequestMapping("update")
	public Object update(Apply apply) throws Exception {
		applyService.update(apply);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public Object delete(int ano) throws Exception {
		applyService.delete(ano);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	long prevMillis = 0;
	int count = 0;

	synchronized private String getNewFilename(String filename) {
		long currMillis = System.currentTimeMillis();
		if (prevMillis != currMillis) {
			count = 0;
			prevMillis = currMillis;
		}

		return currMillis + "_" + count++ + extractFileExtName(filename);
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
