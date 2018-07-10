package la.bean.member;

import la.bean.Form;
import la.bean.ValidationErrors;

public class InputMemberForm extends Form{

	private String id;
	private String familyName;
	private String name;
	private String postal;
	private String address;
	private String tel;
	private String email;
	private String birthdayYear;
	private String birthdayMonth;
	private String birthdayDate;

	public InputMemberForm(String id, String familyName, String name, String postal, String address,
			String tel, String email, String birthdayYear, String birthdayMonth, String birthdayDate) {
		this.id = id;
		this.familyName = familyName;
		this.name = name;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthdayYear = birthdayYear;
		this.birthdayMonth = birthdayMonth;
		this.birthdayDate = birthdayDate;
	}

	public ValidationErrors validate() {
		ValidationErrors errors = new ValidationErrors();

		errors.add(checkRequired("苗字", familyName));
		errors.add(checkLength("苗字", familyName, 1, 10));
		errors.add(checkRequired("名前", name));
		errors.add(checkLength("名前", name, 1, 10));
		errors.add(checkRequired("郵便番号", postal));
		errors.add(checkLength("郵便番号", postal, 7, 7));
		errors.add(checkRequired("住所", address));
		errors.add(checkLength("住所", address, 1, 100));
		errors.add(checkRequired("電話番号", address));
		errors.add(checkLength("電話番号", address, 1, 20));
		errors.add(checkRequired("メールアドレス", address));
		errors.add(checkLength("メールアドレス", address, 1, 100));
		errors.add(checkRequired("誕生日-年", address));
		errors.add(checkLength("誕生日-年", address, 4, 4));
		errors.add(checkRequired("誕生日-月", address));
		errors.add(checkLength("誕生日-月", address, 1, 2));
		errors.add(checkRequired("誕生日-日", address));
		errors.add(checkLength("誕生日-日", address, 1, 2));

		return errors;
	}

	public String getId() {
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

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	public String getBirthdayDate() {
		return birthdayDate;
	}
}
