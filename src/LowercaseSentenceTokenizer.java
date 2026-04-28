import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {

    List<String> tokens = new ArrayList<>();

   
    while(scanner.hasNext()) {

        String word = scanner.next();

        if(word.endsWith(".")) {
            String[] parts = word.split("(?=\\.)|(?<=\\.)");
            //https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters#:~:text=You%20can%20use%20lookahead%20and,%2C%20c%2C%20;%2C%20d%5D
            //I was lost trying to figure out how to keep the delimiter taht we are splitting the string with
            //this method I was trying to use to split, throws away the period essentially
            // word.split("\\.");
            
            //https://www.baeldung.com/java-split-string-keep-delimiters
            //I was having trouble because I couldn't split while keeping the delimiters
            //This source made me realize I can make a String[] of the parts of the whole word
            //so "Word." = "word", ".",
            //Then iterate through the parts to add the finniky period!
            for (String part : parts) {
                if(!part.isEmpty()) {
                    tokens.add(part.toLowerCase());
                }
            }
        } else {
            tokens.add(word.toLowerCase());
        }
        
    }

    return tokens;
  }
}

