package itviec;

import org.apache.struts.action.ActionForm;

public class JobForm extends ActionForm {

	
	private String title,shortdescription, image;

	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public JobForm(int id, String title, String shortdescription, String image) {
		super();
		this.id = id;
		this.title = title;
		this.shortdescription = shortdescription;
		this.image = image;
	}

	public JobForm() {
		super();
	}
	
	
}
