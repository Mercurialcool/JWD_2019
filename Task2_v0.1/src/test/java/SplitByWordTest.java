import by.vadim.parser.StandartSplit;
import by.vadim.parser.SplitByWord;
import org.testng.annotations.Test;

public class SplitByWordTest {
    @Test
    public void paragraphTest() {
        String str="someword,";
        SplitByWord splitter=new SplitByWord();
        StandartSplit standartSplit = new StandartSplit();
        splitter.setNextSplitter(standartSplit);
        splitter.split(str);
    }
}
