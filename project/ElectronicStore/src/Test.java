import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) throws FileNotFoundException {		//calea catre store.txt
			Scanner scanner = new Scanner(new File("C:\\Users\\Catalin\\eclipse-workspace\\ElectronicStore\\src\\Teste\\test00\\store.txt"));
			String numeMagazin = scanner.nextLine();	//memoreaza numeMagazin
			System.out.println(numeMagazin);			//printez continutul store.txt
			while(scanner.hasNextLine()) {
				String camp = scanner.nextLine();		
				System.out.println(camp);
				Scanner parser = new Scanner(camp);
		        parser.useDelimiter(";");				//delimitator pentru a afisa atributele item-ului
				String dept = parser.next();
				int deptID = parser.nextInt();
				int nrProduse = scanner.nextInt();
				System.out.println(nrProduse);
				
				switch(dept) {							//in dependenta de ce department este identificat,acela se adauga
					case "BookDepartment": 
						Store.getInstance().addDepartment(new BookDepartment(dept, deptID));
					case "MusicDepartment": 
						Store.getInstance().addDepartment(new MusicDepartment(dept, deptID));
					case "SoftwareDepartment": 
						Store.getInstance().addDepartment(new SoftwareDepartment(dept, deptID));
					case "VideoDepartment": 
						Store.getInstance().addDepartment(new VideoDepartment(dept, deptID));
				}
				
		        scanner.nextLine();		
			//folosirea unei bucle for pentru a parcurge toate produsele departamentului
		        for(int i = 0; i < nrProduse; i++){
		            camp = scanner.nextLine();
		            parser = new Scanner(camp);
		            parser.useDelimiter(";");			//delimitator pentru a afisa atributele item-uluis
		            String numeProdus = parser.next();
		            int ID = parser.nextInt();
		            double pret = parser.nextDouble();
		            Item item = new Item(numeProdus,ID,pret);
		            System.out.println(item);
		        }
			}																			//calea catre customers.txt
			scanner = new Scanner(new File("C:\\Users\\Catalin\\eclipse-workspace\\ElectronicStore\\src\\Teste\\test00\\customers.txt"));
	        int nrClients = scanner.nextInt();
	        scanner.nextLine();
		    while(scanner.hasNextLine()){
		        String line1 = scanner.nextLine();
		        Scanner parsed = new Scanner(line1);
		        parsed.useDelimiter(";");						//delimitator pentru a afisa atributele item-ului
		        String clientName = parsed.next();
		        double buget = parsed.nextDouble();
		        Customer client = new Customer(clientName, buget);
		        Store.getInstance().enter(client);
		        nrClients--;
		    	
			}														//calea catre events.txt
			scanner = new Scanner(new File("C:\\Users\\Catalin\\eclipse-workspace\\ElectronicStore\\src\\Teste\\test00\\events.txt"));
	        scanner.nextLine();
	        System.out.println("\n");
	        while(scanner.hasNextLine()){										   //afisez events.txt
	            String camp = scanner.nextLine();
	            Scanner parser = new Scanner(camp);
	            parser.useDelimiter(";");							//delimitator pentru a afisa atributele item-ului
	            System.out.println(camp);          
	            String clientName = parser.next();
		    String action = parser.next();

	            switch(action){						//aici se evalueaza operatiile din events.txt
				    case "addItem":						//extragerea numelui, itemului si dept		
				        Item produs = Store.getInstance().getItem(ItemID);
				        Department dept = Store.getInstance().getDepartment(produs.getDepartment());
					int ItemID = parser.nextInt();
				        if(parser.next().contains("WishList")){			//in dependenta de locatie, acolo se va adauga item-ul
				            (Store.getInstance().getCustomer(clientName)).wList.add(produs);
				            dept.addObserver((Store.getInstance().getCustomer(clientName));
				        }
				        else{
				            (Store.getInstance().getCustomer(clientName)).sCart.add(produs);
				            dept.enter(Store.getInstance().getCustomer(clientName));
				        }
				    case "getItems":
				    
				    case "addProduct":
				    	
				    case "delProduct":
				    
				    case "getItem":
				    
				    case "getTotal":
	            }
	        }
	}
}
