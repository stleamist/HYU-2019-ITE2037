public class TooMuchStuffException extends Exception {
	private int inputNum;
	
	TooMuchStuffException(){
		super("NegativeException");
	}
	TooMuchStuffException(int inputNum) {
		super("NegativeException");
		this.inputNum = inputNum;
	}
	
	public int getInputNum() {
		return this.inputNum;
	}
	
	@Override
	public String getMessage() {
		return "Too much stuff!";
	}
}