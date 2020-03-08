public class SoftwareDepartment extends Department {
	SoftwareDepartment softwareDepartment;
	String deptName;
	int deptID;
	public SoftwareDepartment(String deptName, int deptID) {
		this.deptName = deptName;
		this.deptID = deptID;
	}
	public void accept(Visitor visitor) {				//se implementeaza in metoda visit din ShoppingCart
		visitor.visit(this.softwareDepartment);
	}
}
