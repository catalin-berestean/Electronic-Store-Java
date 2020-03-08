class Item {									
	private String itemName;
	private int itemID;
	private double itemPrice;
	private String dept;
	public Item() {}
	public Item(String iName, int ID, double iPrice) {		//constructorul produsului
		this.itemName = iName;
		this.itemID = ID;
		this.itemPrice = iPrice;
	}
	public int getItemID(){									//set si get pentru nume, id, pret
		return itemID;
	}
	public String getItemName(){
		return itemName;
	}
	public double getItemPrice(){
		return itemPrice;
	}
	public String getDepartment() {
		return dept;
	}
	public void setDepartment(String dept) {
		this.dept = dept;
	}
	public void setItemID(int ID) {
		this.itemID = ID;
	}
	public void setItemName(String iName) {
		this.itemName = iName;
	}
	public void setItemPrice(double iPrice) {
		this.itemPrice = iPrice;
	}
	public String toString() {													//afisarea
		return getItemName()+";"+ getItemID()+";"+getItemPrice();
	}
}

