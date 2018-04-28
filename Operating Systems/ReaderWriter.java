class Database{
	private int readers;
	public Database(){
		this.readers=0;
	}
	public void read(int number){
		synchronized(this){
			this.readers++;
			System.out.println("reader " + number + "starts reading");			
		}
		final int DELAY=5000;
		try{
		Thread.sleep((int) (Math.random() * DELAY)); 
		}
		catch(InterruptedException e) {}
		synchronized(this){
			this.readers--;
			if(this.readers==0)
				this.notifyAll();
			System.out.println("reader " + number + "stops reading");			
		}
	}
	public synchronized void write(int number){
			while(this.readers > 0)
			{
				try{
				this.wait(); 
				}
				catch(InterruptedException e) {}
			}
			System.out.println("writer " + number + "starts writing");			
		final int DELAY=5000;
		try{
		Thread.sleep((int) (Math.random() * DELAY)); 
		}
		catch(InterruptedException e) {}
			this.notifyAll();
			System.out.println("writer " + number + "stops writing");			
		
	}
}

class Reader extends Thread {
	private static int readers=0;
	Database database;
	private int number;
	public Reader(Database database)
	{
		this.database = database;
		this.number = Reader.readers++;
	}
	public void run()
	{
		while (true){
		final int DELAY=5000;
		try{
		Thread.sleep((int) (Math.random() * DELAY)); 
		}
		catch(InterruptedException e) {}
		this.database.read(this.number);
		}
	}
}

class Writer extends Thread {
	private static int writers=0;
	Database database;
	private int number;
	public Writer(Database database)
	{
		this.database = database;
		this.number = Writer.writers++;
	}
	public void run()
	{
		while (true){
		final int DELAY=5000;
		try{
		Thread.sleep((int) (Math.random() * DELAY)); 
		}
		catch(InterruptedException e) {}
		this.database.write(this.number);
		}
	}
}

public class ReaderWriter {

	public static void main(String args[]){
		final int READERS = 3;
		final int WRITERS =2;
		Database database = new Database();
		for(int i=0;i<READERS;i++)
			new Reader(database).start();
		for(int i=0;i<WRITERS; i++)
			new Writer(database).start();
			
	}
}

/*
Output:
reader 0starts reading
reader 1starts reading
reader 0stops reading
reader 0starts reading
reader 1stops reading
reader 0stops reading
writer 0starts writing
writer 0stops writing
writer 1starts writing
writer 1stops writing
writer 0starts writing
writer 0stops writing
reader 1starts reading
reader 2starts reading
reader 0starts reading
reader 2stops reading
*/