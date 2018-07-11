package la.bean.member;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{

	private int id;
	private String familyName;
	private String name;
	private String postal;
	private String address;
	private String tel;
	private String email;
	private Date birthday;
	private String password;
	private char role;
	private Date join;
	private Date leave;

	public Member(String familyName, String name, String postal, String address,
			String tel, String email, Date birthday) {
		this.familyName = familyName;
		this.name = name;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
	}

	public Member(int id, String familyName, String name, String postal, String address,
			String tel, String email, Date birthday) {
		this.id = id;
		this.familyName = familyName;
		this.name = name;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	public Date getJoin() {
		return join;
	}

	public void setJoin(Date join) {
		this.join = join;
	}

	public Date getLeave() {
		return leave;
	}

	public void setLeave(Date leave) {
		this.leave = leave;
	}

	public int getId() {
		return id;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getName() {
		return name;
	}

	public String getPostal() {
		return postal;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}
}
