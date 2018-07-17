package la.bean.member;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
	private boolean deleteFlag;
	private String stateCode;

	public void setId(int id) {
		this.id = id;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(Date birthday) {
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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean delete_flag) {
		this.deleteFlag = delete_flag;
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
	
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}
