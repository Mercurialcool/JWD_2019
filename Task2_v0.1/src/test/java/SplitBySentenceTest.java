import by.vadim.parser.StandartSplit;
import by.vadim.parser.SplitBySentence;
import org.testng.annotations.Test;

public class SplitBySentenceTest {


        @Test
        public void paragraphTest() {
            String str="First word. Second Word?";
            SplitBySentence splitter=new SplitBySentence();
            StandartSplit standartSplit = new StandartSplit();
            splitter.setNextSplitter(standartSplit);
            splitter.split(str);
        }


}
