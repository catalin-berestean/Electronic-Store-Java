import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
	String customerName;
	ArrayList<Notification> n;	//colectia de notificari
	ShoppingCart sCart;			//shoppingcart si wishlist pentru fiecare customer
	WishList wList;
	double money;				//bugetul customerului
	public Customer(){}
	public Customer(String customerName,double money){
		this.customerName = customerName;
		sCart = new ShoppingCart(money);
		wList = new WishList();
		n = new ArrayList<>();
	}																								
	public void setName(String customerName) {			//set si get pentru nume si buget
		this.customerName = customerName;
	}
	public String getName() {				
		return customerName;
	}
	public double getBuget() {
		return money;
	}
	public void setBuget(int money) {		
		this.money = money;
	}
	public void update(Notification notification) {
		n.add(notification);							//adaugarea notificarilor
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
