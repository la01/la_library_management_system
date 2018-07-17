package la.bean.book;

import java.io.Serializable;
import java.util.Date;

public class BookInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ISBN;
	private String name;
	private String author;
	private String categoryName;
	private String publisher;
	private Date publishedDay;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
}
