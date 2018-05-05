	class PrinterX implements Runnable
	{
	    private int counter = 0;
	    private BinarySemaphore XSemaphore = new BinarySemaphore(0);
	    private BinarySemaphore YSemaphore = new BinarySemaphore(1);
	    private String printout;

	    public PrinterX (int counter, BinarySemaphore XSemaphore, BinarySemaphore YSemaphore, String printout)
	    {
	        this.counter=counter;
	        this.XSemaphore = XSemaphore;
	        this.YSemaphore = YSemaphore;
	        this.printout = printout;
	    }

	    public void run()
	    {
	    	int index=0;
	    	while (index<=counter)
	        {
	            

	            try{

	                
	            	YSemaphore.P();
	                System.out.println(printout + " " + index);
	                index++;
	                Thread.sleep(100);

	            }
	            catch (InterruptedException e)
	            {}
	            finally
	            {
	                XSemaphore.V();
	            }
	        }
	    }


}
