
public class NewThread implements Runnable {
	String name;
	Thread t;
	
	public NewThread(String threadName) {
		this.name = threadName;
		t = new Thread(this,name);
		System.out.println(name + " стартовал");
		t.start();
		
	}
	
	public void run() {
		for(int i = 5; i >0; i--) {
			System.out.println(name + ": " + i);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Sleep was corrupted");
			}
		}
		
		System.out.println("Поток: " + name + "завершен");

	}

}
