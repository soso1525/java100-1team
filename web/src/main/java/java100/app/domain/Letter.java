package java100.app.domain;

public class Letter {
    
    int lno;
    int ano;
    String lsdt;
    String ledt;
    int lscheck;
    int lpcheck;
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









