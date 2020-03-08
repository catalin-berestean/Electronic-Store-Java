public class VideoDepartment extends Department {
	VideoDepartment videoDepartment;
	String deptName;
	int deptID;
	public VideoDepartment(String deptName, int deptID) {		 //Constructorul departamentului
		this.deptName = deptName;
		this.deptID = deptID;
	}
	public void accept(Visitor visitor) {				//se implementeaza in metoda visit din ShoppingCart
		visitor.visit(this.videoDepartment);
	}
}