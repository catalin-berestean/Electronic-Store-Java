Nume: Berestean

Prenume: Catalin

Grupa: 323CC

Grad de dificultate a temei: mediu spre dificil

Timp alocat temei: 5 zile


				
						
							README - Tema POO - Supermarket

	


	
	In aceasta tema am avut de implementat un magazin online, bazat pe mai multe clase, legate intre ele prin relatii de mostenire si  interfete care au facilitat o mai usoara procesare a datelor in program. Mai mult de atit, pe parcursul rezolvarii temei, am observat cit de strans se leaga fiecare clasa una de alta, fiind necesare absolut toate pentru ca programul sa fie functional si user-friendly.

	
	Am inceput prin a implementa clasa ItemList, clasa ce adapteaza o lista dublu inlantuita de itemi(produse) si in care am mai implementat 2 clase ajutatoare: Node si ItemIterator. Am dezvoltat cat se poate de desfasurat logica clasei, astfel majoritatea metodelor fiind intuitive si usor de folosit. Am folosit si interfata Comparable pentru a putea sorta natural.

	
	Mai apoi, am continuat cu clasa Department unde am considerat clientii, produse si cumparatorii interesati ca fiind colectii iar metodele atribuite acestora au fost completate pe deplin. Metodele addObserver si removeObserver sunt pentru a diferentia mai usor clientii ce au si nu au produse in WishList. 

	
	
	In clasa Item efectiv am descris atributele unui item si definit metodele de set si get.

	
	In clasa Customer am inclus cate un ShoppingCart si WishList, deasemenea si o colectie de notificari, in constructorul clasei acestea fiind instantiate.

		In clasa Notification  am descris printr-o enumeratie tipurile de notificari si atributele acesteia(data trimiterii, departament, produs).

	
	Comparatorii NumeComparator si PretComparator sorteaza in ordine crescatoare, si respectiv alfabetica, itemii. 

	
	In clasa ShoppingCart, am implementat metoda de add care scade din buget costul unui item, deasemenea, am implementat metodele de accept, din clasele BookDepartment, VideoDepartment, MusicDepartment, Software Department care erau ca anumite particularitati ale departamentelor(aduceau o reducere, intorceau o suma in buget, etc).

	
	In clasa WishList, am utilizat in constructorul clasei comparatorul PretComparator pentru a ordona crescator dupa pret produsele, deasemenea datorita mostenirii clasei ItemList, am putut apela metodele deja implementate in ea.

	
	Iar clasa Store, este efectiv clasa in care se reunesc toate elementele necesare unui magazin: WishList, ShoppingCart, Department, Customer.Deasemenea, am utilizat design pattern-ul Singleton , pentru a beneficia de o instantiere unica a clasei Store.

	
	In clasa Test, am realizat citirea fisierelor de testare a functionalitatii.
	
	La compilare am o eroare, dar logica functiilor e clar decrisa in ceea ce fac pe tot parcursul temei.

	
	Datorita acestei teme, am invatat mai bine structura limbajului Java si am inteles cum functioneaza paradigma OOP pe baza unei probleme din viata reala.