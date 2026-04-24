import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    // TODO: Implement this function to convert the scanner's input to a list of words and periods
    List<String> tokens = new ArrayList<>(); 
    while(scanner.hasNext()){
        String temp = scanner.next();
        
        //this loop will check the last character of every word for a '.' 
        //and if one is found it will replace it in the word with an empty space and then add the cleaned word and a separate '.' to the return list.
        if(temp.charAt(temp.length()-1) == '.'){ 
          temp = temp.replace('.', ' ');
          temp = temp.trim();

          tokens.add(temp.toLowerCase());
          tokens.add(".");
        }
        else
        tokens.add(temp.toLowerCase());
    }

    return tokens;
  }

      public static void main(String[] args) {
      
        Tokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is Dr.Smith's example.");
        System.out.print(tokenizer.tokenize(scanner).toString());
        WordPredictor u = new UnigramWordPredictor(tokenizer);
        u.train(scanner);
      }

    }


