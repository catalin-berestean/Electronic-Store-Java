import java.util.Comparator;

class PretComparator implements Comparator<Item> {					//comparator dupa pret
    public int compare(Item a, Item b) {							
            return (int) (a.getItemPrice() - b.getItemPrice());
    }
}