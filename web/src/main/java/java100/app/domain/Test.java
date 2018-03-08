package java100.app.domain;

public class Test {
	int no;
	int ano;
	String type; // 인적성 or 면접
	String date; // 시험일자
	String time; // 시험 시간
	String location;
	String prepare; // 준비물
	int check; // 합격여부
	Apply apply;
	Member member;
	
	@Override
	public String toString() {
		return "Test [no=" + no + ", ano=" + ano + ", type=" + type + ", date=" + date + ", time=" + time
				+ ", location=" + location + ", prepare=" + prepare + ", check=" + check + ", apply=" + apply
				+ ", member=" + member + "]"; 
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrepare() {
		return prepare;
	}

	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
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

}