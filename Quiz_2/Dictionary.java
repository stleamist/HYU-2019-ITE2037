interface Dictionary {
	boolean isEmpty();
	void insertEntry(String word, String definition) throws AlreadyExistInDicException;
	void getDefinition(String word) throws EmptyException, NotInDicException;
	void removeWord(String word) throws EmptyException, NotInDicException;
	void printWords() throws EmptyException;
	void printAll() throws EmptyException;
}