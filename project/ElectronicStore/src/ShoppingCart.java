import java.util.Iterator;

class ShoppingCart extends ItemList implements Visitor{ 	//metodele accept sunt ca niste reduceri sau feature-uri speciale 
	double buget;
	public ShoppingCart(){					//sortarea shoppingcartului crescator dupa pret,folosind PretComparator implementat
		super(new PretComparator());
	}

	public ShoppingCart(double buget){
		super(new PretComparator());
		this.buget = buget;						//setarea bugetului
	}


	public boolean add(Item i){								//adaugarea unui item, daca se accepta, se scade din buget 
        if(buget < i.getItemPrice()){
            return false;
        }
        else{
            super.add(i);
            buget = buget - i.getItemPrice();
            return true;
        }
    }
	
	public void visit(BookDepartment bookDepartment) {				//se implementeaza metoda accept, aplicanduse -10% prod
		double bookCost;														//din bookDepartment
		for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ) {
            Item i = iter.next();
            if(i.getDepartment().equals("bookDepartment")) {
                bookCost = i.getItemPrice() - 0.1*i.getItemPrice();
                i.setItemPrice(bookCost);
            }
        }
	}
	
	
	public void visit(MusicDepartment musicDepartment) {			//se implementeaza metoda accept,adauga 10% la buget din total prod din musicDept
		double musicCost,newCost = 0;
		for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ) {
			Item i = iter.next();
            if(i.getDepartment().equals("musicDepartment")) {
            	musicCost = 0.1*i.getItemPrice();
                newCost = newCost + musicCost;
            }
        }
		buget = buget + newCost;
	}
	
	public void visit(SoftwareDepartment softwareDepartment) {			//se implementeaza metoda accept,
        double min = this.getItem(0).getItemPrice(), softwareCost;			

        for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ){
            Item i = iter.next();
            if(i.getItemPrice() < min)
                min = i.getItemPrice();
        }
        if(buget < min){								//se aplica reducerea, daca cel mai ieftin produs este mai mare decit bugetul ramas
            for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ){
                Item i = iter.next();
                if(i.getDepartment().equals("softwareDepartment")){
                	softwareCost = i.getItemPrice() - 0.2*i.getItemPrice();
                    i.setItemPrice(softwareCost);
                }
            }
        }
	}
	
	public void visit(VideoDepartment videoDepartment) {			//se implementeaza metoda accept
        double max = this.getItem(0).getItemPrice(), s = 0, videoCost;
        

        for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ){
            Item i = iter.next();
            if(i.getItemPrice() > max) {
                max = i.getItemPrice();
            }
        }
        
        if(s > max) {
            for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ){
                Item i = iter.next();
                if(i.getDepartment().equals("videoDepartment")) {
                	videoCost = i.getItemPrice() - 0.1*i.getItemPrice();
                    i.setItemPrice(videoCost);
                }
            }
            buget = buget + 0.05*max;									//in orice caz , se adauga 5% din produsele videodept la buget 
        }
        
        
        for(Iterator<Item> iter = this.listIterator(); iter.hasNext(); ) {
            Item i = iter.next();
            if(i.getDepartment().equals("videoDepartment")) {
                s = s + i.getItemPrice();
            }
        }
        
    }

	
}
