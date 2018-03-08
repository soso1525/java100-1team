package java100.app.domain;

public class Msg {
    
    protected int mno;
    protected String mcont;
    protected String mdt;
    protected String mcheck;
    protected int mrecv;
    protected int pno;
    protected String pid;

    protected int msend;
    protected Member writer;
    
    protected String pid1; // 보내는 사람id
    protected String pid2; // 받는 사람id
    protected int pno2; // 받는 사람 no
    
    public int getPno2() {
        return pno2;
    }
    public void setPno2(int pno2) {
        this.pno2 = pno2;
    }
    public int getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno = pno;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    
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
    public String getMdt() {
        return mdt;
    }
    public void setMdt(String mdt) {
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
    
    public String getPid1() {
        return pid1;
    }
    public void setPid1(String pid1) {
        this.pid1 = pid1;
    }
    public String getPid2() {
        return pid2;
    }
    public void setPid2(String pid2) {
        this.pid2 = pid2;
    }
}
