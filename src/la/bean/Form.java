package la.bean;

public abstract class Form {

	protected ValidationError checkRequired(String propertyName, String propety) {
		if(propety == null || propety.length() == 0) {
			return new ValidationError(propertyName + "が入力されていません");
		}
		return null;
	}
	protected ValidationError checkLength(String propertyName, String property, int min, int max) {
		if(property == null) {
			return null;
		} else if(property.length() < min) {
			return new ValidationError(propertyName + "は" + min + "文字以上である必要があります");
		} else if(property.length() > max) {
			return new ValidationError(propertyName + "は" + max + "文字以下である必要があります");
		}
		return null;
	}
	protected ValidationError checkInteger(String propertyName, String property) {
		try {
			Integer.parseInt(property);
		} catch(NumberFormatException e) {
			return new ValidationError(propertyName + "は数値ではありません");
		} catch(Exception e) {
			return null;
		}
		return null;
	}
	protected ValidationError checkRange(String propertyName, String property, int min, int max) {
		ValidationError e = checkInteger(propertyName, property);
		if(e != null) {
			return e;
		}
		int number = Integer.parseInt(property);
		if(number < min) {
			return new ValidationError(propertyName + "は" + min + "以下である必要があります");
		} else if(number > max) {
			return new ValidationError(propertyName + "は" + max + "以上である必要があります");
		}
		return null;
	}

	public abstract ValidationErrors validate();
}
