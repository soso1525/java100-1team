package java100.app.domain;

public class Letter {
    
    int lno;
    int ano;
    String lcont;
    String lsdt;
    String ledt;
    String lscheck;
    String lpcheck;
    String lfile;
    Apply apply;
    Member member;
    
  
    
    public Letter() {}


    public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}



	public int getLno() {
        return this.lno;
    }



    public void setLno(int lno) {
        this.lno = lno;
    }



    public String getLcont() {
        return this.lcont;
    }



    public void setLcont(String lcont) {
        this.lcont = lcont;
    }



    public String getLsdt() {
        return this.lsdt;
    }



    public void setLsdt(String lsdt) {
        this.lsdt = lsdt;
    }



    public String getLedt() {
        return this.ledt;
    }



    public void setLedt(String ledt) {
        this.ledt = ledt;
    }



    public String getLscheck() {
        return this.lscheck;
    }



    public void setLscheck(String lscheck) {
        this.lscheck = lscheck;
    }



    public String getLpcheck() {
        return this.lpcheck;
    }



    public void setLpcheck(String lpcheck) {
        this.lpcheck = lpcheck;
    }



    public String getLfile() {
        return this.lfile;
    }



    public void setLfile(String lfile) {
        this.lfile = lfile;
    }




    public Apply getApply() {
		return apply;
	}



	public void setApply(Apply apply) {
		this.apply = apply;
	}



	public Member getMember() {
        return this.member;
    }



    public void setMember(Member member) {
        this.member = member;
    }



    
    
}









