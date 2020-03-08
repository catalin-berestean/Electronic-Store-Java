public class BookDepartment extends Department {
	BookDepartment bookDepartment;
	String deptName;
	int deptID;
	public BookDepartment(String deptName, int deptID) { //Constructorul departamentului
		this.deptName = deptName;
		this.deptID = deptID;
	}
	public void accept(Visitor visitor) {		//se implementeaza in metoda visit din ShoppingCart
		visitor.visit(this.bookDepartment);
	}
}
