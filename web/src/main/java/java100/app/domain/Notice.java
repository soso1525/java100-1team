package java100.app.domain;

public class Notice {
	CompanyMember companyMember;
    int no;
    String image;
    int nType;
    String startDate;
    String endDate;
    int viewCount;
    Member writer;

	public int getnType() {
		return nType;
	}
	public void setnType(int nType) {
		this.nType = nType;
	}
	public CompanyMember getCompanyMember() {
		return companyMember;
	}
	public void setCompanyMember(CompanyMember companyMember) {
		this.companyMember = companyMember;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
    public Member getWriter() {
        return writer;
    }
    public void setWriter(Member writer) {
        this.writer = writer;
    }
    
}