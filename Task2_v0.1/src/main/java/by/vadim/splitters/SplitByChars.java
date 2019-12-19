package by.vadim.splitters;

import java.util.List;
import java.util.stream.Collectors;

public class SplitByChars {

	public List<Character> split(String rawText) {
		return rawText
			.chars()
			.mapToObj(value -> (char) value)
			.collect(Collectors.toList());
	}
}
