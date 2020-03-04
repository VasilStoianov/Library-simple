package Library;

import java.text.DecimalFormat;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Building {

    private String name;
   

    private static Map<String, Integer> booksInLib = new HashMap<String, Integer>();
    private static Map<String, Integer> takenBooks = new HashMap<String, Integer>();
    private static Map<String, Book> taxes = new HashMap<String, Book>();
    
    public Building(String name){
        this.name = name;
        booksInLib.put("It", 2);
        booksInLib.put("Harry Potter", 4);
        booksInLib.put("Game of thrones", 6);
        booksInLib.put("Six seas", 1);
        booksInLib.put("Война и мир", 2);
        
        
    }
    public String getName(){
        return name;
    }

    public void buyBooks(String bookName, int copies) {
        if (booksInLib.containsKey(bookName)) {
            int coppiesInLib = booksInLib.get(bookName);
            int allCoppies = copies + coppiesInLib;
            booksInLib.put(bookName, allCoppies);
        } else {
            booksInLib.put(bookName, copies);
        }
    }

    public boolean giveBook(String bookName) {
        if (booksInLib.containsKey(bookName) && booksInLib.get(bookName) > 0) {
            System.err.println("You are getting book  " + bookName);
            Book book = new Book(bookName);
            taxes.put(bookName, book);
            book.bookTaken();
            book.start();
            
            booksInLib.put(bookName, booksInLib.get(bookName) - 1);
         if (takenBooks.containsKey(bookName)) {
            takenBooks.put(bookName, takenBooks.get(bookName)+1);
        }
         takenBooks.put(bookName, 1);
         
         return true;

        } else {
            System.out.println("No such book or no coppies left available");
            return false;
        }

    }

    public boolean returnBook(String bookName) {
        if (booksInLib.containsKey(bookName)) {
            booksInLib.put(bookName, booksInLib.get(bookName) + 1);
            if (takenBooks.containsKey(bookName) && takenBooks.get(bookName) > 1) {
                takenBooks.put(bookName, takenBooks.get(bookName)-1);
            }
            takenBooks.remove(bookName);
            System.out.print("You returned ");
            System.err.println(bookName);
            DecimalFormat df = new DecimalFormat("####0.00");
            System.out.println("You owe us " + df.format(taxes.get(bookName).getTax()));
            System.out.println("Goodbye");
            return true;
        } else {
            booksInLib.put(bookName, 1);
            return false;
        }

    }

    public void listAllBooks() {
        Set<Entry<String, Integer>> set = booksInLib.entrySet();
        for (Entry<String, Integer> book : set) {
            System.out.print("Book name: " + book.getKey() + " ||");
            System.out.print(" Coppies " + book.getValue());
            System.out.println();
            
        }
    }
    

}
