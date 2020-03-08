build:
	javac Test.java
	javac BookDepartment.java
	javac MusicDepartment.java
	javac SoftwareDepartment.java
	javac VideoDepartment.java
	javac Item.java
	javac ItemList.java
	javac Department.java
	javac ShoppingCart.java
	javac WishList.java
	javac Observer.java
	javac Subject.java
	javac Visitor.java
	javac Notfication.java
	javac PretComparator.java
	javac NumeComparator.java
	javac Customer.java
	javac Store.java
run: build
	for number in 0 1 2 3 4 5 6 7 8 9 ; do \
        cp ./Teste/Test0$$number/store.txt ./ ; \
		cp ./Teste/Test0$$number/customers.txt ./ ; \
		cp ./Teste/Test0$$number/events.txt ./ ; \
		java Test ; \
		cp ./output.txt ./Teste/Test0$$number/ ; \
    	done

clean:
	$(RM) *.class