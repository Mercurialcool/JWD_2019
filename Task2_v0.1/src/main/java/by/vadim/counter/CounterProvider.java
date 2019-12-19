package by.vadim.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import by.vadim.composite.Component;
import by.vadim.composite.ResponsibilityLevel;

public class CounterProvider {
	public static final Function<Component, Long> WordCounter = (sentence) -> {

		List<Component> wordList = new ArrayList<>();

		sentence.getComponentList().forEach(lex -> wordList.addAll(lex.getComponentList()));
		return wordList.stream().filter(wor -> wor.getLevel() == ResponsibilityLevel.WORD).count();

	};

}