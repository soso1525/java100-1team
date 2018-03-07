package java100.app.domain;

public class Apply {

	int ano;
	String aname;
	String adt;
	int ino;
	IndividualMember writer;
	Member member;
	Test test;
	Letter letter;

	@Override
	public String toString() {
		return "Apply [ano=" + ano + ", aname=" + aname + ", adt=" + adt + ", ino=" + ino + ", writer=" + writer
				+ ", member=" + member + ", test=" + test + ", letter=" + letter + "]";
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAdt() {
		return adt;
	}

	public void setAdt(String adt) {
		this.adt = adt;
	}

	public IndividualMember getWriter() {
		return writer;
	}

	public void setWriter(IndividualMember writer) {
		this.writer = writer;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
