package la.bean.later;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class LaterRental implements Serializable{

	private int rentalId;
	private int memberId;
	private List<HashMap<Integer, String>> bookList;
	private String familyName;
	private String name;
	private String zip;
	private String address;
	private String tel;
	private String email;

}
