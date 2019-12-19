package by.vadim.composite;

import java.util.List;

public class Paragraph {

	private final List<Sentence> sentences;

	public Paragraph(List<Sentence> sentences) {
		this.sentences = sentences;
	}
}
