import java.util.Date;

class Notification {
	Date time = new Date();		//folosesc obiect Date pentru a arata timpul la care s-a trimis notificarea
	
	enum NotificationType{		//tipurile notificari
		ADD,REMOVE,MODIFY	
	}
	
	NotificationType nType;
	int deptID;
	int productID;
	
	public Notification(int deptID,int productID,NotificationType nType, Date time){	//constructorul
		this.deptID = deptID;
		this.productID = productID;
		this.nType = nType;
		this.time = time;
	}
}
