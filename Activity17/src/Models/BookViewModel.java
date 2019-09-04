package Models;

public class BookViewModel {
	public int Id=0;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public Float getDiscount() {
		return Discount;
	}
	public void setDiscount(Float discount) {
		Discount = discount;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		CatName = catName;
	}
	public String Name = "";
	public String Author = "";
	public Float Price = 0f;
	public Float Discount = 0f;
	public String Image = "";
	public String CatName = "";
}
