package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static final File myFile = new File("./my-file.txt");
	
	public static void main(String[] args) {
		
//		Book b1 = new Book("Titolo1", 30, "Autore1", "Editore1");
//		System.out.println(b1);
//	
//		Book b2 = new Book("Titolo2", 23, "Autore2", "Editore2");
//		System.out.println(b2);
		
		// EXCEPTION of Class BOOK
		Scanner in = new Scanner(System.in);
		
		System.out.print("Quanti libri vuoi inserire? ");
		String strBookCount = in.nextLine();
		final int BOOK_COUNT = Integer.valueOf(strBookCount);
		
		
		Book[] books = new Book[BOOK_COUNT];
		int booksIndex = 0;
		
		
		while (booksIndex < BOOK_COUNT) {

			System.out.println("\nLibro " + (booksIndex + 1));
			System.out.print("Inserisci il titolo: ");
			String strTitolo = in.nextLine();
			
			System.out.print("Inserisci il numero di pagine: ");
			String strNumeroPagine = in.nextLine();
			int numeroPagine = Integer.valueOf(strNumeroPagine);
			
			System.out.print("Inserisci il nome dell'autore: ");
			String strAutore = in.nextLine();
			
			System.out.print("Inserisci il nome dell'editore: ");
			String strEditore = in.nextLine();
			
			
			Book b = null;
			
			try {
				
				b = new Book(strTitolo, numeroPagine, strAutore, strEditore);
				
				books[booksIndex++] = b;
				
			} catch (Exception e) {
				
				System.out.println("\nError in book: " + e.getMessage());
			}
		}
		
		in.close();
		
//		for (int i = 0; i < books.length; i++) {
//			System.out.println(books[i]);
//		}
		// Fine EXCEPTION of Class BOOK
		
		/**********************************************************************************/
		
		// FILE - WRITE
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter(myFile);
			
			for (int i = 0; i < books.length; i++) {
				
				Book b = books[i];
				
				myWriter.write("Libro " + (i+1) + "\n"
						+ "\nTitolo: " + b.getTitolo() + "\n"
						+ "Numero pagine: " + b.getNumeroPagine() + "\n"
						+ "Autore: " + b.getAutore() + "\n"
						+ "Editore: " + b.getEditore()
						+ "\n-----------------------------\n"
						);
			}
			
		} catch (IOException e) {
			
			System.out.println("Error writing file: " + e.getMessage());
			
		} finally {
			
			if (myWriter != null) {
				try {
					myWriter.close();
				} catch (IOException e) { }
			}
		}
		
		// FILE - READ
		Scanner reader = null;
		
		try {
			
			reader = new Scanner(myFile);
			
			System.out.println("\n-----------------------------");
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file: " + e.getMessage());
			
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
