import by.vadim.parser.StandartSplit;
import by.vadim.parser.SplitByParagraph;

import org.testng.annotations.Test;

public class SplitByParagraphTest {

    @Test
    public void paragraphTest() {
        String str="abcd\tdef";
        SplitByParagraph splitter=new SplitByParagraph();
        StandartSplit standartSplit = new StandartSplit();
        splitter.setNextSplitter(standartSplit);
        splitter.split(str);
    }
}
