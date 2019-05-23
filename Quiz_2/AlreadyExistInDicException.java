class AlreadyExistInDicException extends Exception {
	AlreadyExistInDicException(){
		super("AlreadyExistInDicException");
	}
	AlreadyExistInDicException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "this word already exists in dictionary";
	}
}