package by.vadim.comparator;

import java.util.Comparator;

import by.vadim.composite.Word;

public class WordsInSentenceComparator implements Comparator<Word> {


	@Override
	public int compare(Word o1, Word o2) {
		return o1.methodToBeDone().size()
				- o2.methodToBeDone().size();
	}


}
