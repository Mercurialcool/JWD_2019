package by.vadim.splitters;

import java.util.ArrayList;
import java.util.List;

import by.vadim.composite.Sentence;

public class SplitBySentence {

	private final SplitByLexeme splitByLexeme;

	public SplitBySentence(SplitByLexeme splitByLexeme) {
		this.splitByLexeme = splitByLexeme;
	}

	public List<Sentence> split(String paragraphText) {
		// todo: split paragraphText by sentences
		return new ArrayList<>();
	}
}
