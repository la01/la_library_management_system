package la.bean.book;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int categoryCode;
	private String categoryName;
	
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
}
