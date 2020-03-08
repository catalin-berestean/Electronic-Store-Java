public class WishList extends ItemList{
	WishList(){							//in wishlist se uziteaza metodele uzuale, care se mostenesc si se apeleaza
		super(new PretComparator());			//se ordoneaza crescator dupa pret cu ajutorul comparatorului  PretComparator
	}
	public boolean add(Item i) {			//se apeleaza metoda din ItemList
		return super.add(i);
	}
	public Item remove(int index) {			//se apeleaza metoda din ItemList
		return super.remove(index);
	}
}
