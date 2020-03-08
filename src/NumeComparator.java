import java.util.Comparator;

class NumeComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {							//comparator dupa nume
            return b.getItemName().compareTo(a.getItemName());
    }
}
