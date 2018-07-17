package la.bean.book;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String ISBNCode;
	private String name;
	private int categoryCode;
	private String categoryName;
	private String author;
	private String rentalCode;
	private String publisher;
	private Date publishedDay;
	private String statusCode;
	private Date addedDay;
	private Date removedDay;
	private Date fromPublishDate;
	private Date toPublishDate;
	private Date fromAddedDate;
	private Date toAddedDate;
	private Date fromRemovedDate;
	private Date toRemovedDate;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getISBNCode() {
		return ISBNCode;
	}

	public void setISBNCode(String iSBNCode) {
		ISBNCode = iSBNCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedDay() {
		return publishedDay;
	}

	public void setPublishedDay(Date publishedDay) {
		this.publishedDay = publishedDay;
	}

	public Date getAddedDay() {
		return addedDay;
	}

	public void setAddedDay(Date addedDay) {
		this.addedDay = addedDay;
	}

	public Date getRemovedDay() {
		return removedDay;
	}

	public void setRemovedDay(Date removedDay) {
		this.removedDay = removedDay;
	}
	
	public String getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Date getFromPublishDate() {
		return fromPublishDate;
	}

	public void setFromPublishDate(Date fromPublishDate) {
		this.fromPublishDate = fromPublishDate;
	}

	public Date getToPublishDate() {
		return toPublishDate;
	}

	public void setToPublishDate(Date toPublishDate) {
		this.toPublishDate = toPublishDate;
	}

	public Date getFromAddedDate() {
		return fromAddedDate;
	}

	public void setFromAddedDate(Date fromAddedDate) {
		this.fromAddedDate = fromAddedDate;
	}

	public Date getToAddedDate() {
		return toAddedDate;
	}

	public void setToAddedDate(Date toAddedDate) {
		this.toAddedDate = toAddedDate;
	}

	public Date getFromRemovedDate() {
		return fromRemovedDate;
	}

	public void setFromRemovedDate(Date fromRemovedDate) {
		this.fromRemovedDate = fromRemovedDate;
	}

	public Date getToRemovedDate() {
		return toRemovedDate;
	}

	public void setToRemovedDate(Date toRemovedDate) {
		this.toRemovedDate = toRemovedDate;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
