package java100.app.domain;

public class Question {

    int no;
    String article;
    String context;
    Member member;
    int lno;
    int nno;
    

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
    public String getArticle() {
        return this.article;
    }
    public void setArticle(String article) {
        this.article = article;
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









