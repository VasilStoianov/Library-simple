package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client extends Thread {

    private Building library;
    private String name;
    List<String> books;
    private int readingTime;

    public Client(String name, Building library, int readingTime) {
        this.name = name;
        this.library = library;
        this.readingTime = readingTime;
        books = new ArrayList<String>();
    }

    public boolean takeBook(String book) {
        if (library.giveBook(book)) {
            books.add(book);
            System.out.println(books.size());
            return true;
        } return false;

    }

    public void returnBook(String book) {
        library.returnBook(book);
        books.remove(book);
    }

    @Override
    public void run() {
        try {

            String b = books.get(new Random().nextInt(books.size()));
            System.out.println("Reading book " + b);
            Thread.sleep(readingTime * 1000);
            System.out.println("Book is read");
            returnBook(b);
            return;
        } catch (InterruptedException e) {
            System.out.println("I have other work... cant read");
        }

    }
    public void startReading(){
        start();
        
    }
    
    public String getClientName(){
    	return name;
    }
    
    

}
