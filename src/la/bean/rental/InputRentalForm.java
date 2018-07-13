package la.bean.rental;

import java.util.ArrayList;

import la.bean.Form;
import la.bean.ValidationErrors;

public class InputRentalForm extends Form {
	private String memberId;
	private ArrayList<String> bookId;

	public InputRentalForm(String memberId, ArrayList<String> bookId) {
		this.memberId = memberId;
		this.bookId = bookId;
	}

	public ValidationErrors validate() {
		ValidationErrors errors = new ValidationErrors();

		errors.add(checkRequired("会員ID", memberId));
		errors.add(checkInteger("会員ID", memberId));
		for (String str : bookId) {
			errors.add(checkRequired("資料ID", str));
			errors.add(checkInteger("資料ID", str));
		}

		return errors;
	}

	public String getMemberId() {
		return memberId;
	}

	public ArrayList<String> getBookId() {
		return bookId;
	}

}
