package model;

public class Food681 {
	private String name;
	private float price;
	private String description;
	private String photo;
	
	
	public Food681() {
		// TODO Auto-generated constructor stub
	}
	
	public Food681(String name, float price, String description, String photo) {
		//id tự động tăng, không cần thêm
		this.name = name;
		this.price = price;
		this.description = description;
		this.photo = photo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Food681 [name=" + name + ", price=" + price + ", description=" + description
				+ ", photoLink=" + photo + "]";
	}
	
	
}

