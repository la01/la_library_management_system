package la.bean.rental;

import java.io.Serializable;
import java.util.Date;

public class RentalHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int rentalId;
	private int memberId;
	private int bookId;
	private String isbn;
	private String name;
	private Date fromDay;
	private Date toDay;
	private Date rentalDate;
	private Date limitDate;
	private Date returnDate;
	private boolean later;
	private boolean noReturn;

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isLater() {
		return later;
	}

	public void setLater(boolean later) {
		this.later = later;
	}

	public boolean isNoReturn() {
		return noReturn;
	}

	public void setNoReturn(boolean noReturn) {
		this.noReturn = noReturn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getFromDay() {
		return fromDay;
	}

	public void setFromDay(Date fromDay) {
		this.fromDay = fromDay;
	}

	public Date getToDay() {
		return toDay;
	}

	public void setToDay(Date toDay) {
		this.toDay = toDay;
	}
}
