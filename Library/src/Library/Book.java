package Library;

/**
 * TODO: Document me!
 *
 * @author JE62848
 *
 */



public class Book extends Thread {
private static final double START_TAX = 2.0;

    
    private String name;
    private double tax;
    private boolean isTaken;
    
    
    public Book(String name){
        this.name = name;
        tax = START_TAX;
    }

  

    public String getBookName() {
        return name;
    }
    @Override
        public void run() {
        try {
            Thread.sleep(2500);
            while(isTaken){
                Thread.sleep(1000);
                tax = tax * 1.10;
//                if (isReturn) {
//                 return;
             //}
            }
        } catch (InterruptedException e) {
          System.out.println("Cant increase tax..." + e.getMessage() );
        }
          
        }
    public void bookTaken(){
        isTaken = true;
    }
    
    public void bookReturned(){
        isTaken = false;
    }
    public void resetTax(){
        tax = START_TAX;
    }

    /**
     * @return
     */
    public double getTax() {
        
        return tax;
    }
    
}
