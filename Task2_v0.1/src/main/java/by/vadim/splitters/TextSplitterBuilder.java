package by.vadim.splitters;

public class TextSplitterBuilder {

	public TextSplitter build() {
		SplitByChars splitByChars = new SplitByChars();
		SplitByLexeme splitByLexeme = new SplitByLexeme(splitByChars);
		SplitBySentence splitBySentence = new SplitBySentence(splitByLexeme);
		SplitByParagraph splitByParagraph = new SplitByParagraph(splitBySentence);

		return new TextSplitter(splitByParagraph);
	}
}
