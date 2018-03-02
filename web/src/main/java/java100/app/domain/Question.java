package java100.app.domain;

import java.util.Arrays;

public class Question {
	int qno; // 테이블 고유번호
	String article;
	String[] articles;
	String contents;
	int length;
	int lno; // 자소서번호
	int nno; // 공고번호
	Member member;
	Letter letter;
 
	@Override
	public String toString() {
		return "Question [qno=" + qno + ", article=" + article + ", articles=" + Arrays.toString(articles)
				+ ", contents=" + contents + ", length=" + length + ", lno=" + lno + ", nno=" + nno + ", member="
				+ member + "]";
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String[] getArticles() {
		return articles;
	}

	public void setArticles(String[] articles) {
		this.articles = articles;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	

}