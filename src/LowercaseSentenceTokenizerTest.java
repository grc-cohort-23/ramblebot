import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class LowercaseSentenceTokenizerTest {

    // Wave 1
    @Test
    void testTokenizeWithNoCapitalizationOrPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("this is a lowercase sentence without a period");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "lowercase", "sentence", "without", "a", "period"), tokens);
    }

    // Wave 2
    /*
     * Write your test here! using format like up there
     */ 
    @Test
    public void testTokenizeWithLotOfSpaces() {

        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();


        Scanner scanner = new Scanner("hello     hi hi hi    hello hello");
        List<String> tokens = tokenizer.tokenize(scanner);

        // 6 word -> 6 token -> size 6
        assertEquals(6, tokens.size());
        // check 
        assertEquals("hello", tokens.get(0));
        assertEquals("hi", tokens.get(3));
        assertEquals("hello", tokens.get(5));
}
    

    // Wave 3
    @Test
    void testTokenizeWithCapitalization() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("This is a SENTENCE with sTrAnGe capitalization");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "sentence", "with", "strange", "capitalization"), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeSentenceWithPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is an example.");
        List<String> tokens = tokenizer.tokenize(scanner);
        // end with world. -> seperate out
        assertEquals(List.of("hello", "world", ".", "this", "is", "an", "example", "."), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeWithInternalPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is Dr.Smith's example.");
        List<String> tokens = tokenizer.tokenize(scanner);
        // world end with . "word." -> seperate
        // dr.smith's . have . connecting dr and smith with . -> else?
        assertEquals(List.of("hello", "world", ".", "this", "is", "dr.smith's", "example", "."), tokens);
    }
    
}
