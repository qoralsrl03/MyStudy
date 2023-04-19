package ch09_class.hompage;

public class Member {
	private String stuId; // 학번
	private String id; // 아이디
	private String pw; // 비밀번호
	private String name; // 이름

	public Member() {
	}

	public Member(String id, String pw) {
		MemberDB memDB = MemberDB.getInstance();
		this.id = id;
		this.pw = pw;
	}
	
	public Member(String id, String pw, String name) {
		MemberDB memDB = MemberDB.getInstance();
		this.stuId = memDB.makeStuId();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public Member(String stuId, String id, String pw, String name) {
		super();
		this.stuId = stuId;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [stuId=" + stuId + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

}
