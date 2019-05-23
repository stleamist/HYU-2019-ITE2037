import java.util.ArrayList;

public class DictionaryArray implements Dictionary {
	private ArrayList<WordDefinitionPair> dicList;
	
	public DictionaryArray() {
		this.dicList = new ArrayList<WordDefinitionPair>();
	}
	
	public ArrayList<WordDefinitionPair> getDicList() {
		return this.dicList;
	}
	
	@Override
	public boolean isEmpty() {
		return this.dicList.isEmpty();
	}
	
	@Override
	public void insertEntry(String word, String definition) throws AlreadyExistInDicException {
		for (WordDefinitionPair pair: this.dicList) {
			if (word.equals(pair.getWord())) {
				throw new AlreadyExistInDicException();
			}
		}
		
		WordDefinitionPair pair = new WordDefinitionPair(word, definition);
		
		this.dicList.add(pair);
	}
	
	@Override
	public void getDefinition(String word) throws EmptyException, NotInDicException{
		if (this.dicList.isEmpty()) {
			throw new EmptyException();
		}
		
		for (WordDefinitionPair pair: this.dicList) {
			System.out.printf("word: %s, getWord: %s\n", word, pair.getWord());
			if (word.equals(pair.getWord())) {
				System.out.printf("%s mean: %s\n", pair.getWord(), pair.getDefinition());
				return;
			}
		}
		
		throw new NotInDicException();
	}
	
	@Override
	public void removeWord(String word) throws EmptyException, NotInDicException {
		if (this.dicList.isEmpty()) {
			throw new EmptyException();
		}
		
		for (WordDefinitionPair pair: this.dicList) {
			if (word.equals(pair.getWord())) {
				// TODO: pair가 레퍼런스인지 확인하기
				this.dicList.remove(pair);
				return;
			}
		}
		
		throw new NotInDicException();
	}
	
	@Override
	public void printWords() throws EmptyException {
		if (this.dicList.isEmpty()) {
			throw new EmptyException();
		}
		
		for (int i = 0; i < this.dicList.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, this.dicList.get(i).getWord());
		}
	}
	
	@Override
	public void printAll() throws EmptyException {
		if (this.dicList.isEmpty()) {
			throw new EmptyException();
		}
		
		for (WordDefinitionPair pair: this.dicList) {
			System.out.println("***************************************");
			System.out.printf("Word: %s\n", pair.getWord());
			System.out.printf("Definition: %s\n", pair.getDefinition());
		}
	} 
}