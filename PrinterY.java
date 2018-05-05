	class PrinterY implements Runnable
	{
	    private int counter = 0;
	    private BinarySemaphore YSemaphore = new BinarySemaphore(1);
	    private BinarySemaphore XSemaphore = new BinarySemaphore(0);
	    private String printout;

	    public PrinterY (int counter, BinarySemaphore XSemaphore, BinarySemaphore YSemaphore, String printout)
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
	            //System.out.println("X "+b.value);    

	            try{

	                XSemaphore.P();
	                System.out.println(printout  + " " + index);
	                index++;
	                Thread.sleep(100);

	            }
	            catch (InterruptedException e)
	            {}
	            finally
	            {
	                YSemaphore.V();
	            }
	        }
	    }


}
