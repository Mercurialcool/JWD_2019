package by.vadim.comparator;

import java.util.Comparator;

import by.vadim.composite.Word;

public class LongestWordLengthComparator implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
		return getLongestWordLength(o1)
				- getLongestWordLength(o2);
	}

	private int getLongestWordLength(Word c) {

		//todo finish with new types!
	
	}
}