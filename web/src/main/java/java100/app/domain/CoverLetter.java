package java100.app.domain;

public class CoverLetter {
    
    int lno;
    String lcont;
    String lsdt;
    String ledt;
    String lscheck;
    String lpcheck;
    String lfile; // ���� ����� �ǹ̷�
    Apply ano; // TODO �� �ִٰ�..
    
    UploadFile file;
    
    public CoverLetter() {}


	public int getLno() {
		return lno;
	}



	public void setLno(int lno) {
		this.lno = lno;
	}



	public String getLcont() {
		return lcont;
	}



	public void setLcont(String lcont) {
		this.lcont = lcont;
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



	public String getLscheck() {
		return lscheck;
	}



	public void setLscheck(String lscheck) {
		this.lscheck = lscheck;
	}





	public String getLpcheck() {
		return lpcheck;
	}


	public void setLpcheck(String lpcheck) {
		this.lpcheck = lpcheck;
	}


	public String getLfile() {
		return lfile;
	}



	public void setLfile(String lfile) {
		this.lfile = lfile;
	}



	public Apply getAno() {
		return ano;
	}



	public void setAno(Apply ano) {
		this.ano = ano;
	}

	public UploadFile getFile() {
		return file;
	}
	public void setFile(UploadFile file) {
		this.file = file;
	}



	@Override
	public String toString() {
		return "CoverLetter [ino=" + lno + ", icont=" + lcont + ", isdt=" + lsdt + ", iedt=" + ledt + ", ischeck="
				+ lscheck + ", ipcheck=" + lpcheck + ", ifile=" + lfile + ", ano=" + ano + "]";
	}
    
    
}









