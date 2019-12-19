package by.vadim.splitters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import by.vadim.composite.Paragraph;

public class SplitByParagraph {
	private static final String PARAGRAPH_DELIMITER_REGEXP = "\\t";

	private final SplitBySentence splitBySentence;

	public SplitByParagraph(SplitBySentence splitBySentence) {
		this.splitBySentence = splitBySentence;
	}

	public List<Paragraph> split(String fullText) {
		return Arrays
			.stream(fullText.split(PARAGRAPH_DELIMITER_REGEXP))
			.map(paragraphText -> new Paragraph(splitBySentence.split(paragraphText)))
			.collect(Collectors.toList());
	}
}
