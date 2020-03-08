import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

abstract class ItemList {							
	double suma = 0;
	int i;
	Comparator<Item> comp;
	ItemList(){}
	ItemList(Comparator<Item> comp){						//constructor cu comparator pentru sortarea naturala
		this.comp = comp;
	}

	int size = 0;
	Node head;												
	Node start = head.getNext();	
	Node parser = head;
	ListIterator itemList = this.listIterator();			//iteratorul listei
	public static class Node{
		Node previous,next;
		Item item;
		public Node () {
			next = null;
			previous = null;
			item = null;
		}
		public Node(Node previous,Node next,Item i){
			this.previous = previous;
			this.next = next;
			this.item = i;
		}
		public Node(Item i) {
			next = null;
			previous = null;								//set si get pentru previous si next 
			this.item = i;
		}
		public void setNext(Node next) {
            this.next = next;
        }
		public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
        
        public Node getPrevious() {
            return previous;
        }
		public Item getElement() {
			return item;
		}

	}
	
	public boolean isEmpty() {									
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public boolean add(Item element) {								//adaugarea unui item in lista
        Node aux = new Node(element);
        while(!isEmpty()){
        	if(start == null) {										//la inceput
        		parser.setNext(new Node(element));
        		(new Node(element)).setPrevious(parser);
                size++;
                return true;
        	}
        	else {
        		int cmp = comp.compare(parser.getElement(),element);
        		if(cmp > 0) {
        			parser.setNext(new Node(element));
        			(new Node(element)).setPrevious(parser);
        			size++;
        			return true;
        		}
        	}
        	for(Node n = head;n.next != null ;n = n.next) {						//intre 2 noduri
        		int cmp = comp.compare(parser.getElement(),element);
        		int nextcmp = comp.compare(parser.next.getElement(),element);
        		if(cmp > 0) {
        			if(nextcmp < 0) {
        			   aux.setNext(parser.next);
        			   parser.setNext(aux);
        			   aux.setPrevious(parser);
        			   parser.next.setPrevious(aux);
        			   size++;
        			   return true;
        			}
        		}
        		}
        	}
        	return false;
        }
	
	public boolean addAll(Collection<? extends Item> comp) {				//adaugarea mai multor Item
		for(int i = 0; i < comp.size(); i++){
            for(ListIterator iterator = (ListIterator) comp.iterator(); iterator.hasNext();){
                if(!add((Item)iterator.next())){
                    return false;
                }
            }
        }
		return true;
	}
	
	public Item getItem(int index) {									//extragerea item-ului dupa index
		Item item = start.getElement();
		if(index<size && index > 0) {
			for(i=0;i<index;i++) {
				if(start.getNext() != null) {
					start = start.getNext();
				}
				else {
					return null;
				}
			}
		}
	  return item;
	}
	
	public Node getNode(int index) {						//extragerea nodului de la indexul dat
		if(index<size && index > 0) {
			for(i=0;i<index;i++) {
				if(i!=index) {
					start = start.next;
				}
				else {
					return start;
				}
			}
		}
	  return start;
	}
	
	public int indexOf(Item item) {						//aflarea indexului la care se afla item-ul
		for(i=0;i<size;i++) {
			if(item == this.getItem(i)) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexOf(Node node) {						
	    int index = 0;
	    while (parser != null) {
	        if (parser.equals(node)) {
	            return index;
	        }
	        index++;
	        parser = parser.next;
	    }
	    return -1;
	}

	public boolean contains (Node node) {					//se verifica daca node se contine in lista
		parser = head;	
		if(parser == null) {
			return false;
		}
        while(parser != null){
            if(parser == node){
                return true;
            }
            parser = parser.next;
        }
        return false;
	}
	public boolean contains (Item item) {						//se verifica daca item se contine in lista
		while(itemList.hasNext()) {
			if(itemList!=item) {
				itemList = (ListIterator<Item>)itemList.next();
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	public Item remove(int index) {								//stergere item dupa index
	   Node currNode = getNode(index);
	   Node prevNode = currNode.getPrevious();
	   Node nextNode = currNode.getNext();
	   if(index > size||index < 0 ) {
	     System.out.println("Index out of bounds!");
	   }
	   if(index != 0){
		   Item removed = currNode.getElement();
	       prevNode.setNext(nextNode);
	       nextNode.setPrevious(prevNode);
	       return removed;
	   }
	   else{
	       Item removed = parser.getElement();
	       head = head.getNext();
	       size--;
	       return removed;
	   }
	}

	public ListIterator<Item> listIterator() {							//instantierea unui iterator
		return new ItemIterator();	
	}
	
	public Double getTotalPrice() {									//obtinerea sumei totale adunate in cos
		for(Iterator<Item> iter = itemList; iter.hasNext(); ) {
			suma+=((Item) itemList.next()).getItemPrice();
		}
		return suma;
	}
	
	public String toString() {										//afisarea item-ului
        String s = "";
        while(start != null) {
            s += "[" + start.getElement() + "] ";
            start = start.getNext();
        }
        return s;
    }														//nu a fost nevoie implementarea metodelor de mai jos

	//public boolean remove(Item item);
	//public abstract boolean removeAll(Collection<? extends Item> collection);
	//public abstract ListIterator<Item> listIterator(int index);
	
	class ItemIterator implements ListIterator<Item>{
		int pos = 0;
		Node start = null,previous,aux=null;
		Node aux1 = start.next, aux2 = start.previous;
		
		public boolean hasNext() {								//verifica daca exista urmator
			return aux1!=null;
		}
		
		
		public boolean hasPrevious() {							//verifica daca exista precedent
			return aux2!=null;
		}
		
		public Item next() {									//item urmator
			if(aux1!=null) {
				aux = start;
				start = start.next;
				pos++;
				return start.item;
			}
			return null;
		}	
		public Item previous() {								//item precedent
			if(aux2!=null) {
				start = start.previous;
				pos--;
				aux = start;
				return start.item;
			}
			return null;	
		}
		public int nextIndex() {							//index urmator
			return pos;
		}
		public int previousIndex() {						//index precedent
			return pos-1;
		}

		public void add(Item i) {									//se realizeaza adaugarea intre 2 noduri
			Node n1 = start.previous,n2 = new Node(),n3 = start;
            n2.item = i;
            n1.next = n2;
            n2.next = n3;
            n3.previous = n2;
            n2.previous = n1;
            size++;
            pos++;
            aux = null;
		}
		public void set(Item i) {						//setarea unui item
			if(aux != null) {
			  aux.item = i;
			}
			else {
			  aux.item = null;
			}
		}
		public void remove() {							//stergerea
			if(aux !=null) {
				Node previous = aux1;
				Node next = aux2;
				previous.next = next;
				next.previous = previous;
				size--;
			}
			if(start == aux) {
				Node next = aux2;
				start = next;
			}
			else {
				size--;
			}
			aux = null;
		}
	}
}
