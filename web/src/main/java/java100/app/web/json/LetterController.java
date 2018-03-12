package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Apply;
import java100.app.domain.Letter;
import java100.app.domain.Member;
import java100.app.domain.Question;
import java100.app.service.ApplyService;
import java100.app.service.LetterService;
import java100.app.service.QuestionService;

@RestController
@RequestMapping("/letter")
@SessionAttributes("loginUser")
public class LetterController {
	@Autowired
	ServletContext servletContext; // for file
	@Autowired
	LetterService letterService;
	@Autowired
	QuestionService questionService;
	@Autowired
	ApplyService applyService;

	@RequestMapping("list")
	public Object list(@ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("letterList", letterService.findAll(loginUser.getNo()));
		result.put("status", "success");
		return result;
	}

	@RequestMapping("form")
	public Object form() throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		return result;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Object add(int ano, Letter letter, int[] lengths, String[] contents, String[] articles, MultipartFile file,
			@ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		letter.setAno(ano);
		letter.setMember(loginUser);

		System.out.println("file: " + file);

		if (!file.isEmpty()) {
			String uploadDir = servletContext.getRealPath("/download");
			String filename = writeUploadFile(file, uploadDir);
			letter.setLfile(filename);
		} else {
			letter.setLfile("");
		}

		HashMap<String, Object> result = new HashMap<>();
		letterService.add(letter);

		for (int i = 0; i < articles.length; i++) {
			Question q = new Question();
			q.setArticle(articles[i]);
			q.setContent(contents[i]);
			q.setLength(lengths[i]);
			q.setLno(letter.getLno());
			System.out.println("Question: " + q);
			questionService.add(q);
		}

		result.put("status", "success");
		return result;
	}

	@RequestMapping(value = "addLetter", method = RequestMethod.POST)
	public Object addLetter(Apply apply, Letter letter, int[] lengths, String[] contents, String[] articles,
			MultipartFile file, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		apply.setMember(loginUser);
		letter.setApply(apply);
		letter.setMember(loginUser);

		System.out.println("file: " + file);

		if (!file.isEmpty()) {
			String uploadDir = servletContext.getRealPath("/download");
			String filename = writeUploadFile(file, uploadDir);
			letter.setLfile(filename);
		} else {
			letter.setLfile("");
		}

		HashMap<String, Object> result = new HashMap<>();
		letterService.addLetter(apply, letter);

		for (int i = 0; i < articles.length; i++) {
			Question q = new Question();
			q.setArticle(articles[i]);
			q.setContent(contents[i]);
			q.setLength(lengths[i]);
			q.setLno(letter.getLno());
			System.out.println("Question: " + q);
			questionService.add(q);
		}

		result.put("status", "success");
		return result;
	}

	@RequestMapping("{ano}")
	public Object view(@PathVariable int ano) throws Exception {
		// result.put("letter", letterService.get(no));
		// result.put("question", questionService.list(no));
		HashMap<String, Object> result = new HashMap<>();
		result.put("letterList", letterService.list(ano));
		return result;
	}
	
	@RequestMapping("update")
	public Object update(int lno, Letter letter, int[] lengths, String[] contents, String[] articles, int[] qnos, MultipartFile file,
			@ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
		letter.setLno(lno);
		letter.setMember(loginUser);

		if (!file.isEmpty()) {
			String uploadDir = servletContext.getRealPath("/download");
			String filename = writeUploadFile(file, uploadDir);
			letter.setLfile(filename);
		} else {
			letter.setLfile("");
		}

		HashMap<String, Object> result = new HashMap<>();
		letterService.update(letter);

		for (int i = 0; i < articles.length; i++) {
			Question q = new Question();
			q.setArticle(articles[i]);
			q.setContent(contents[i]);
			q.setLength(lengths[i]);
			q.setQno(qnos[i]);
			questionService.update(q);
		}

		result.put("status", "success");
		return result;
	}

	@RequestMapping("delete")
	public Object delete(int no) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", "success");
		result.put("ano", letterService.getAno(no));
		letterService.delete(no);
		return result;
	}

	long prevMillis = 0;
	int count = 0;

	// 다른 클라이언트가 보낸 파일명과 중복되지 않도록
	// 서버에 파일을 저장할 때는 새 파일명을 만든다.
	synchronized String getNewFilename(String filename) {
		long currMillis = System.currentTimeMillis();
		if (prevMillis != currMillis) {
			count = 0;
			prevMillis = currMillis;
		}

		return currMillis + "_" + count++ + extractFileExtName(filename);
	}

	// 파일명에서 뒤의 확장자명을 추출한다.
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

}
