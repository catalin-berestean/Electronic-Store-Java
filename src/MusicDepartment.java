public class MusicDepartment extends Department {
	MusicDepartment musicDepartment;
	String deptName;
	int deptID;
	public MusicDepartment(String deptName,int deptID)  {   //Constructorul departamentului
		this.deptName = deptName;
		this.deptID = deptID;
	}
	public void accept(Visitor visitor) {				//se implementeaza in metoda visit din ShoppingCart
		visitor.visit(this.musicDepartment);
	}
}
