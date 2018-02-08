package java100.app.domain;

import java.util.Date;

public class Apply {
    
    int ano;
    String aname;
    String adt;
    int ino;
    IndividualMember writer;
    Member member;
    
	public String getAdt() {
		return adt;
	}
	public void setAdt(String adt) {
		this.adt = adt;
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









