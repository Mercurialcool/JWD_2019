import by.vadim.parser.StandartSplit;
import by.vadim.parser.SplitByLexeme;
import org.testng.annotations.Test;

public class SplitByLexemeTest {
    @Test
    public void lexemeTest() {
        String str="lexeme1, lexeme2 lexeme3";
        SplitByLexeme splitter=new SplitByLexeme();
        StandartSplit standartSplit = new StandartSplit();
        splitter.setNextSplitter(standartSplit);
        splitter.split(str);
    }
}
