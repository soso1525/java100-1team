package java100.app.domain;

import java.sql.Date;

public class Msg {
    
    protected int mno;
    protected String mcont;
    protected Date mdt;
    protected String mcheck;
    protected int msend;
    protected int mrecv;
    protected Member writer;
    
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public String getMcont() {
        return mcont;
    }
    public void setMcont(String mcont) {
        this.mcont = mcont;
    }
    public Date getMdt() {
        return mdt;
    }
    public void setMdt(Date mdt) {
        this.mdt = mdt;
    }
    public String getMcheck() {
        return mcheck;
    }
    public void setMcheck(String mcheck) {
        this.mcheck = mcheck;
    }
    public int getMsend() {
        return msend;
    }
    public void setMsend(int msend) {
        this.msend = msend;
    }
    public int getMrecv() {
        return mrecv;
    }
    public void setMrecv(int mrecv) {
        this.mrecv = mrecv;
    }
    public Member getWriter() {
        return writer;
    }
    public void setWriter(Member writer) {
        this.writer = writer;
    }
    
    
}
