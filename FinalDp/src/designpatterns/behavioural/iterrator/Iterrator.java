package designpatterns.behavioural.iterrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iterrator {

	public static void main(String[] args) {
		// create Books
		Book book1 = new Book("book1");
		Book book2 = new Book("book2");
		Book book3 = new Book("book3");
		Book book4 = new Book("book4");
		// store Books
		Library library = new Library(Arrays.asList(book1, book2, book3, book4));
		// library.books.forEach(e -> System.out.println(e.getBookName()));
		// list Books
		Iterator<Book> createIterator = library.createIterator();
		while (createIterator.hasNext()) {
			System.out.println(createIterator.next().getBookName());

		}


	}

}

//Interator Interface
interface Iterator<T> {
	boolean hasNext();

	T next();
}

//Concrete Iterator
class BookIterator implements Iterator<Book> {
	private List<Book> books;
	private int position;

	public BookIterator(List<Book> books) {
		this.books = books;
		position = 0;
	}

	@Override
	public boolean hasNext() {
		System.out.println(position + " < " + books.size());
		return position < books.size();
	}

	@Override
	public Book next() {
		int bookName = position;
		position++;
		return books.get(bookName);
	}
}

//Aggregator
interface Aggregator<T> {
	Iterator<T> createIterator();
}

//Concrete Aggregator
class Library implements Aggregator<Book> {
	public List<Book> books = new ArrayList<>();

	public Library(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public Iterator<Book> createIterator() {
		return new BookIterator(books);
	}

}

//context
class Book {
	private String bookName;

	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

}