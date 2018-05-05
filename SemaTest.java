
public class SemaTest {

	public static void main(String[] args) throws InterruptedException
	{
		 
		final int counter=100;
		    String X = "X";
		    String Y = "Y";
		    BinarySemaphore XSemaphore = new BinarySemaphore(0);
		    BinarySemaphore YSemaphore = new BinarySemaphore(1);
		    
		    Runnable Rx = new PrinterX(counter, XSemaphore, YSemaphore, X);
		    Runnable Ry = new PrinterY(counter, XSemaphore, YSemaphore, Y);        
		    Thread Tx = new Thread(Rx);
		    Thread Ty = new Thread(Ry);
		    Tx.start();
		    Ty.start();		    
		    Ty.join();
		     for (int i=0;i<counter;i++)
		     System.out.println("Main prints Z");
		    // System.exit(0);
		     

	}

}
