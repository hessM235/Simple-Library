package models;

public class BookCatalog {

	private Book[] bookArray = new Book[100];
	private int nextPosition = 0;

	public Book[] getBook() {
		return bookArray;
	}
	
	public int getNumberOfBooks() {
		return nextPosition;
	}

	public void addBook(Book newBook) {

		bookArray[nextPosition] = newBook;

		nextPosition++;
	}

	public Book findBook(String title) throws BookNotFoundException {

		for (int i = 0; i < nextPosition; i++)  {
			if (bookArray[i].getTitle().equalsIgnoreCase(title)) {		
				return bookArray[i];
			}
		}

		throw new BookNotFoundException();
	}
}
