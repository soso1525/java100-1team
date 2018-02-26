package java100.app.domain;

import java.util.Arrays;

public class Question {

    int no;
    String article;
    String[] articles;
    String context;
    Member member;
    int lno;
    int nno;
  

	@Override
	public String toString() {
		return "Question [no=" + no + ", article=" + article + ", articles=" + Arrays.toString(articles) + ", context="
				+ context + ", member=" + member + ", lno=" + lno + ", nno=" + nno + "]";
	}

	public String[] getArticles() {
		return articles;
	}

	public void setArticles(String[] articles) {
		this.articles = articles;
	}

	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
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
	public int getNo() {
        return this.no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    public String getContext() {
        return this.context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public Member getMember() {
        return this.member;
    }
    public void setMember(Member member) {
        this.member = member;
    }

}










