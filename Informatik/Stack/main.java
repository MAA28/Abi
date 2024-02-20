class Main {
	public static void main(String[] args) {
		Book b1 = new Book("Was tun?", "Lenin");
		Book b2 = new Book("Das Kapital", "Marx");
		Book b3 = new Book("Dialektik der Natur", "Engels");
		Book b4 = new Book("Kommunisten heute", "Holz");
		Book b5 = new Book("Das Manifest", "Marx & Engels");
		Book b6 = new Book("Krieg und Frieden", "Lenin");
		Book b7 = new Book("Dialektischer Materialismus", "Stalin");
		Book b8 = new Book("Das kleine rote Büchlein", "Mao");
	
		BookStack bookStack = new BookStack();

		bookStack.push(b1);
		bookStack.push(b2);
		bookStack.push(b3);
		bookStack.push(b4);
		bookStack.push(b5);
		bookStack.push(b6);
		bookStack.push(b7);
		bookStack.push(b8);

		/*
		Book stack:
			Das kleine rote Büchlein
			Dialektischer Materialismus
			Krieg und Frieden
			Das Manifest
			Kommunisten heute
			Dialektik der Natur
			Das Kapital
			Was tun?
		*/


		for(int i = 0; i < 10; i++) {
			Book popedBook = bookStack.pop();
			System.out.println("Poped book:");
			popedBook.prettyPrint();
		}
	}
}

class BookStack {
	Book top;


	public void push(Book new_book) {
		if(top == null) top = new_book;
		else {
			new_book.lower_book = top;
			top = new_book;
		}
	}


	public Book pop() {
		if (top == null) throw new IndexOutOfBoundsException();
		Book popedBook = top;
		top = top.lower_book;
		return popedBook; 
	}

}



class Book {
	String title;
	String author;
	Book lower_book;

	Book (String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void prettyPrint() {
		System.out.println("Book( title: \"" + this.title + "\" author: " + author + ")");
	}
}