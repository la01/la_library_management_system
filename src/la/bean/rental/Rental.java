package la.bean.rental;

import java.util.ArrayList;

public class Rental {
	private int memberId;
	private ArrayList<Integer> bookId;

	public Rental(int memberId, ArrayList<Integer> bookId) {
		this.memberId = memberId;
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public ArrayList<Integer> getBookId() {
		return bookId;
	}
}
