class WordDefinitionPair {
	private String word;
	private String definition;
	
	WordDefinitionPair(String word, String definition) {
		this.word = word;
		this.definition = definition;
	}
	
	public String getWord() {
		return this.word;
	}
	public String getDefinition() {
		return this.definition;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
}