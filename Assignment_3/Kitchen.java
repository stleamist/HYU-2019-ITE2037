class Kitchen {
	private int ovenNum;
	private int fryNum;
	private int potNum;
	
	public Kitchen() {
		ovenNum = 1;
		fryNum = 3;
		potNum = 3;
	}
	
	public synchronized void useOven() throws InterruptedException {
		while (ovenNum == 0) {
			System.out.println("The oven is in use.");
			wait();
		}
		if (ovenNum > 0) {
			ovenNum -= 1;
		}
	}
	public synchronized  void releaseOven() throws InterruptedException {
		if (ovenNum < 1) {
			ovenNum += 1;
		}
		notifyAll();
	}
	
	public synchronized void useFriedPan() throws InterruptedException {
		while (fryNum == 0) {
			System.out.println("The fried pan is in use.");
			wait();
		}
		if (fryNum > 0) {
			fryNum -= 1;
		}
	}
	public synchronized  void releaseFriedPan() throws InterruptedException {
		if (fryNum < 3) {
			fryNum += 1;
		}
		notifyAll();
	}
	
	public synchronized void usePot() throws InterruptedException {
		while (potNum == 0) {
			System.out.println("The pot is in use.");
			wait();
		}
		if (potNum > 0) {
			potNum -= 1;
		}
	}
	public synchronized  void releasePot() throws InterruptedException {
		if (potNum < 3) {
			potNum += 1;
		}
		notifyAll();
	}
}