class NotInDicException extends Exception {
	NotInDicException(){
		super("NotInDicException");
	}
	NotInDicException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "this word not exists in dictionary";
	}
}