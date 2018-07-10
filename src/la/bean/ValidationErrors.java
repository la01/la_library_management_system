package la.bean;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {

	List<ValidationError> errors;

	public ValidationErrors() {
		errors = new ArrayList<ValidationError>();
	}

	public void add(ValidationError e) {
		if(e != null) {
			errors.add(e);
		}
	}

	public int getSize() {
		return errors.size();
	}

	public List<ValidationError> getList() {
		return errors;
	}
}
