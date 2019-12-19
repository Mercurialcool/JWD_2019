package by.vadim.splitters;

import by.vadim.composite.Text;

public class TextSplitter {
	private final SplitByParagraph splitByParagraph;

	public TextSplitter(SplitByParagraph splitByParagraph) {
		this.splitByParagraph = splitByParagraph;
	}

	public Text split(String fullText) {
		return new Text(splitByParagraph.split(fullText));
	}
}
