package pleasework;

public class Item{
	
		//attributes, + static variable to keep changes
		private static int nextId = 1;
		private int id;
		private String name;
		private double price;
		private int quantity;
		

	// open ai helped with nextID apparently it shows that once you add to the next id at 1 you will increment the whole unit if you call upon the ID 
			//default constructor
	public Item() {}
	public Item(int id, String name, double price, int quantity)
	{
		this.id = nextId++;
		this.name = name;
		this.price = price;
		this.quantity =quantity;
	}
	//getters and setters for all but nextId
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
		
}