package la.bean.book;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

	private int id;
	private String ISBNCode;
	private String name;
	private int categoryCode;
	private String categoryName;
	private String author;
	private String publisher;
	private Date publishedDay;
	private Date addedDay;
	private Date removedDay;

	public Book() {
	}

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
}
