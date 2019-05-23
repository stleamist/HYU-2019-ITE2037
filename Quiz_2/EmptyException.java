class EmptyException extends Exception {
	EmptyException(){
		super("EmptyException");
	}
	EmptyException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "list is empty";
	}
}