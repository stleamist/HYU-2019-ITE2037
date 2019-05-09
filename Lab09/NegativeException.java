public class NegativeException extends Exception {
	NegativeException(){
		super("NegativeException");
	}
	NegativeException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "work time must be positive";
	}
}