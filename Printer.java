	class Printer implements Runnable
	{
	    private int counter = 0;
	    private BinarySemaphore b = new BinarySemaphore(1);
	    private String printout;

	    public Printer (int counter, BinarySemaphore b, String printout)
	    {
	        this.counter=counter;
	        this.b = b;
	        this.printout = printout;
	    }

	    public void run()
	    {
	        while (true)
	        {
	            //System.out.println("X "+b.value);    

	            try{

	                b.P();
	                System.out.println(printout);
	                Thread.sleep(500);

	            }
	            catch (InterruptedException e)
	            {}
	            finally
	            {
	                b.V();
	            }
	        }
	    }


}
