import java.util.ArrayList;
import java.util.Observable;

class Department extends Observable implements Subject{
	String departmentName;
	int departmentID;
	ArrayList<Customer> clients = new ArrayList<Customer>();
	ArrayList<Customer> wishClients = new ArrayList<Customer>();
	ArrayList<Item> items = new ArrayList<Item>();
	public Department() {}
	public Department(String deptName, int deptID) {
		this.departmentName = deptName;
		this.departmentID = deptID;
	}
	public void enter(Customer client){
		clients.add(client);
	}
	public void exit(Customer client){
		clients.remove(client);
	}
	public int getID() {
		return departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public ArrayList<Customer> getCustomers() {
		return clients;
	}
	public void addItem(Item new_item){
		items.add(new_item);
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public Item getItem(){
		return items.get(0);
	}
	public void addObserver(Customer client) {
		wishClients.add(client);
	}
	public void removeObserver(Customer client) {
		wishClients.add(client);
	}
	
	public void notifyAllObservers(Notification notification) {
		for(Customer customer: wishClients) {
			customer.update(notification);
		}
	}
	public String toString() {
		return getID()+ ";" + getDepartmentName();
	}
	public void accept(Visitor visitor) {};
}
