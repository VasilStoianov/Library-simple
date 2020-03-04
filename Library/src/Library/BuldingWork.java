package Library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class BuldingWork {
	
	
	
	
	public void startWorking() throws InterruptedException, IOException {
	Scanner scan = new Scanner(System.in);
    Building library = new Building("Prison Library");
    Boolean start = true;
    
    while (start) {
        System.out.println("Hello");
        Thread.sleep(750);
        System.err.println("This is " + library.getName());
        Thread.sleep(700);
        System.out.println("Please enter your name?");
        String name = scan.next();
        System.out.println("Please enter you last name");
        String lastName = scan.next();
        int readingTime = new Random().nextInt(15);
        Client client = new Client(name, library, readingTime);
        System.out.println("Please choose...");
        Thread.sleep(300);
        System.out.println("1. Show all books in library");
        Thread.sleep(300);
        System.out.println("2. Return book");
        Thread.sleep(300);
        System.out.println("3. Get book");
        int choice = scan.nextInt();

        String newChoice;

        switch (choice) {
        case 1:
            System.out.println("Listing all the books please wait ...");
            Thread.sleep(2000);
            library.listAllBooks();
            System.out.println("Type the name of the book wich you will get or type No to exit");
            newChoice = scan.nextLine();
            newChoice = scan.nextLine();
            String bookName = newChoice;
            if (newChoice.toLowerCase().equals("no")) {
                System.out.println("Goodbye");
                start = false;
                break;
            }

            else {
                if (client.takeBook(newChoice)) {
                    System.out.println("Will you read it not ? Y/N");
                    newChoice = scan.next();
                    if (newChoice.toLowerCase().equals("y")) {
                        client.startReading();
                        Thread.sleep(readingTime * 1000 + 1000);
                        File readed = new File(name + lastName + ".txt");
                        readed.createNewFile();

                        FileWriter fw = new FileWriter(readed, true); // the
                                                                      // true
                        // will append
                        // the new data
                        fw.write("Client: " + name + " " + lastName + "\n");
                        fw.write("Book: " + bookName + "\n");// appends the
                                                             // string to
                                                             // the
                        // file
                        fw.write("Readed for : " + readingTime + " seconds" + "\n");
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

                        fw.write("On date: " + dateFormat.format(new Date()) + "\n");
                        fw.write("Returned on : " + dateFormat.format(new Date()) + "\n\n");
                        fw.close();

                    }
                }
                System.out.println("Goodbye");

            }

            start = false;
            break;
        case 2:
            System.out.println("Type the book you want to return ? ");
            newChoice = scan.nextLine();
            client.returnBook(newChoice);

            start = false;
            break;
        case 3:
            System.out.println("Wait to list all the books we have..");
            Thread.sleep(3000);
            library.listAllBooks();
            System.out.println("Type the name of the book which you will get ");
            newChoice = scan.nextLine();
            newChoice = scan.nextLine();
            String bookName2 = newChoice;
            client.takeBook(newChoice);
            System.out.println("Will you read it or not ? Y/N");
            String readChoice = scan.nextLine();
            if (readChoice.toLowerCase().equals("y")) {
                client.startReading();
                File readed = new File(name + lastName + ".txt");
                Thread.sleep(readingTime * 1000 + 1000);
                FileWriter fw = new FileWriter(readed, true); // the true
                // will append
                // the new data
                fw.write("Client: " + name + " " + lastName + "\n");
                fw.write("Book: " + bookName2 + "\n");// appends the string
                                                      // to the
                // file
                fw.write("Readed for : " + readingTime + " seconds" + "\n");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

                fw.write("On date: " + dateFormat.format(new Date()) + "\n");
                fw.write("Returned on : " + dateFormat.format(new Date()) + "\n\n");
                fw.close();
                Thread.sleep(readingTime * 1000 + 1000);

                start = false;
                break;
            }

        }

    }
    scan.close();


	}
}

