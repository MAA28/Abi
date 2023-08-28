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

		bookStack.prettyPrint();



		for(int i = 0; i < 10; i++) {
			Book popedBook = bookStack.pop();
			System.out.println("Poped book:");
			popedBook.prettyPrint();
		}
	}
}

class BookStack {
	Book[] books;
	int last_index;

	BookStack() {
		books = new Book[1];
		last_index = 0;
	}

	public void push(Book new_book) {
		if (last_index >= books.length - 1) double_capacity();

		books[last_index] = new_book; 
		last_index++;
	}

	private void double_capacity() {
		System.out.println("Capacity doubled: " + books.length);
		Book[] oldBooks = books;
		books = new Book[oldBooks.length * 2];
		for(int i = 0; i < oldBooks.length; i++) {
			books[i] = oldBooks[i];
		}
	}

	private void half_capacity() {
		Book[] oldBooks = books;
		books = new Book[oldBooks.length / 2];
		for(int i = 0; i < books.length; i++) {
			books[i] = oldBooks[i];
		}
		System.out.println("Capacity halfed: " + books.length);

	}

	public Book pop() {
		if (last_index <= 0) throw new IndexOutOfBoundsException();
		else if (last_index <= books.length / 2) half_capacity();

		Book retrievedBook = books[last_index - 1];
		last_index--;
		return retrievedBook;
	}

	public void prettyPrint() {
		System.out.println("BookStack( capacity: " + books.length + " books: [");
		for (int i = 0; i < last_index; i++) {
			System.out.print("\t");
			books[i].prettyPrint();
		}
		System.out.println("])");
	}
}



class Book {
	String title;
	String author;

	Book (String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void prettyPrint() {
		System.out.println("Book( title: \"" + this.title + "\" author: " + author + ")");
	}
}