package la.bean.later;

import java.util.ArrayList;
import java.util.List;

import la.bean.member.Member;

public class LaterRental extends Member{

	private int rentalId;
	private List<LaterBook> bookList;

	public LaterRental() {
		bookList = new ArrayList<LaterBook>();
	}
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public List<LaterBook> getBookList() {
		return bookList;
	}
	public void setBookList(List<LaterBook> bookList) {
		this.bookList = bookList;
	}
	public void addBook(LaterBook e) {
		this.bookList.add(e);
	}
}
