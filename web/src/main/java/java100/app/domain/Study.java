package java100.app.domain;

import java.sql.Date;

public class Study {
    
    protected int sno;
    protected String sloc;
    protected String sname;
    protected String sdesc;
    protected String sint;
    protected int sppl;
    protected Date sregdt;
    protected String scorp;
    protected String simg;
    protected String scheck;
    protected int pno;
    protected Member writer;
    
    public Study() {}

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSloc() {
        return sloc;
    }

    public void setSloc(String sloc) {
        this.sloc = sloc;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getSint() {
        return sint;
    }

    public void setSint(String sint) {
        this.sint = sint;
    }

    public int getSppl() {
        return sppl;
    }

    public void setSppl(int sppl) {
        this.sppl = sppl;
    }

    public Date getSregdt() {
        return sregdt;
    }

    public void setSregdt(Date sregdt) {
        this.sregdt = sregdt;
    }

    public String getScorp() {
        return scorp;
    }

    public void setScorp(String scorp) {
        this.scorp = scorp;
    }

    public String getScheck() {
        return scheck;
    }

    public void setScheck(String scheck) {
        this.scheck = scheck;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }
    
    

}









