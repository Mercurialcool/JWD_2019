package by.vadim.composite;

import java.util.List;

public class Lexeme {

	private final Word word;

	private final List<Character> delimiters;

	@Override
	public String toString() {
		return word.toString() + delimiters.toString(); //todo delimiters toString
	}

	public Lexeme(Word word, List<Character> delimiters) {
		this.word = word;
		this.delimiters = delimiters;
	}
}
