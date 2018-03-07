package java100.app.domain;

import java.util.List;

public class Letter {

	int lno;
	int ano;
	String ltit;
	String lsdt;
	String ledt;
	String writedt;
	int lscheck;
	int lpcheck;
	String lfile;
	Question question;
	List<Question> questions;
	Apply apply;
	Member member;

	@Override
	public String toString() {
		return "Letter [lno=" + lno + ", ano=" + ano + ", ltit=" + ltit + ", lsdt=" + lsdt + ", ledt=" + ledt
				+ ", writedt=" + writedt + ", lscheck=" + lscheck + ", lpcheck=" + lpcheck + ", lfile=" + lfile
				+ ", question=" + question + ", questions=" + questions + ", apply=" + apply + ", member=" + member
				+ "]";
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getLtit() {
		return ltit;
	}

	public void setLtit(String ltit) {
		this.ltit = ltit;
	}

	public String getLsdt() {
		return lsdt;
	}

	public void setLsdt(String lsdt) {
		this.lsdt = lsdt;
	}

	public String getLedt() {
		return ledt;
	}

	public void setLedt(String ledt) {
		this.ledt = ledt;
	}

	public String getWritedt() {
		return writedt;
	}

	public void setWritedt(String writedt) {
		this.writedt = writedt;
	}

	public int getLscheck() {
		return lscheck;
	}

	public void setLscheck(int lscheck) {
		this.lscheck = lscheck;
	}

	public int getLpcheck() {
		return lpcheck;
	}

	public void setLpcheck(int lpcheck) {
		this.lpcheck = lpcheck;
	}

	public String getLfile() {
		return lfile;
	}

	public void setLfile(String lfile) {
		this.lfile = lfile;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
