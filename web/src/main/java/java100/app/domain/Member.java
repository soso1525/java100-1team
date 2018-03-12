package java100.app.domain;

public class Member {
    
    protected int no;
    protected String email;
    protected String password;
    protected String id;
    protected String tel;
    protected String createdDate;
    protected String address;
    protected String type;	//1: 일반 2: 기업
    IndividualMember individualMember;
    
    
    public Member() {}

    public Member(int no, String email, String id) {
        this.no = no;
        this.email = email;
        this.id = id;
    }
    
    

	public IndividualMember getIndividualMember() {
		return individualMember;
	}

	public void setIndividualMember(IndividualMember individualMember) {
		this.individualMember = individualMember;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}









