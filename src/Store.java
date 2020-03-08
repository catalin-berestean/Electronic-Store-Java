import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Store {
	ShoppingCart sCart;
	WishList wList;				
	static String nume;
	Customer aux = null;
	ArrayList<Customer> clients = new ArrayList<Customer>();		//avem o lista de clienti si una de departamente
	ArrayList<Department> dept = new ArrayList<Department>();		//pentru o obtine o singura instantiere a Store, implementam 
	private static Store store = null;								//Singleton design pattern
	public Store() {}
	public Store(String nume) {
		Store.nume = nume;
	}
	public Store(String nume, ArrayList<Customer> clients, ArrayList<Department> dept){
		Store.nume = nume;
		this.clients = clients;
		this.dept = dept;
	}
	public void enter(Customer client) {						//clientul a intrat, deci se adauga la lista de clienti
		clients.add(client);
	}
	public void exit(Customer client) {							//clientul a iesit, deci se scoate la lista de clienti
		clients.remove(client);
	}
	public Customer getCustomer(String cName) {						//se gaseste clientul dupa nume 
		ArrayList<Customer> clients2 = getCustomers();
		for(Iterator iterator = clients2.iterator(); iterator.hasNext();) {
			aux = (Customer) ((ListIterator) clients2).next();
			if(aux.getName().equals(cName)) {					//iterand prin clienti, daca cName se gaseste, este returnat
				return aux;
			}
		}
		throw new NoSuchElementException();
	}
	public ArrayList<Customer> getCustomers() {
		return clients;										//get-uri pentru department, customeri si itemi, shoppingcart
	}
	public ArrayList<Department> getDepartments() {
		return dept;
	}
	public void addDepartment(Department new_dept) {
		dept.add(new_dept);
	}
	public Department getDepartment(String nume){
          for(Iterator iterator = getDepartments().iterator(); iterator.hasNext();){
            	Department dept = getDepartments().iterator().next();
                if(dept.getDepartmentName() == nume)
                  return dept;
          }
           throw new NoSuchElementException();
    	}	
	public ShoppingCart getShoppingCart(Double buget) {
		return new ShoppingCart(buget);
	}
	
	public Item getItem(int id) {
		return null;
	}
	public static Store getInstance() {					//aplicarea Singleton, implementand getInstance()
		if(store == null) {
			store = new Store(nume);	
		}
		return store;
	}
	
}
