class FullArrayException extends Exception {
	FullArrayException() {
		super(
			"List is full!\n" +
			"Try to expand...\n" +
			"How much will it expand?"
		);
	}
	FullArrayException(String message) {
		super(message);
	}
}