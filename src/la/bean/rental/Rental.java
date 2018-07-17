package la.bean.rental;

import java.io.Serializable;
import java.util.ArrayList;

public class Rental implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int memberId;
	private ArrayList<Integer> bookId;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public ArrayList<Integer> getBookId() {
		return bookId;
	}
	public void setBookId(ArrayList<Integer> bookId) {
		this.bookId = bookId;
	}
}
