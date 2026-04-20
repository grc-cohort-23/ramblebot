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
    // list of valid tokens
    List<String> tokenized = new ArrayList<>();
    // custom delimiter pieced together with a lot of research
    scanner.useDelimiter("[\\s]+");
    // set all characters to lowercase
    while(scanner.hasNext()) { tokenized.add(scanner.next().toLowerCase()); }
    // empty String for manipulation
    String newToken;
    // for increment
    for (int i = 0; i < tokenized.size(); i++) {
      if (tokenized.get(i).charAt(tokenized.get(i).length() - 1) == '.' &&
      tokenized.get(i).length() > 1) {
        newToken = tokenized.get(i).substring(0, tokenized.get(i).length() - 1);
        tokenized.set(i, newToken);
        tokenized.add(i + 1, ".");
      }
    }

    // for each
    // (!) 
    // does not work because for each loops depend on a constant structure size,
    // unlike for increment loops
    /*
    for (String token : tokenized) {
      if (token.charAt(token.length() - 1) == '.' && token.length() > 1) {
        int index = tokenized.indexOf(token);
        newToken = token.substring(0, token.length() - 1);
        tokenized.set(index, newToken);
        tokenized.add(index + 1, ".");
      }
    }
      */
    return tokenized;
  }
}

