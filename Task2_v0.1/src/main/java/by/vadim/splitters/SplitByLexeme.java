package by.vadim.splitters;

import java.util.ArrayList;
import java.util.List;

import by.vadim.composite.Lexeme;
import by.vadim.composite.Word;

public class SplitByLexeme {

	private final SplitByChars splitByChars;

	public SplitByLexeme(SplitByChars splitByChars) {
		this.splitByChars = splitByChars;
	}

	public List<Lexeme> split(String sentenceText) {
		// todo: split by lexemes then use newLexeme()
		return new ArrayList<>();
	}

	private Lexeme newLexeme(String lexemeText) {
		// lexemeText contains only 1 Word and characters at the end
		// todo: obtain Word and chars from rawText then create Lexeme using splitByChars
		Word word = new Word(new ArrayList<>());
		List<Character> delimeters = new ArrayList<>();
		return new Lexeme(word, delimeters);
	}
}
