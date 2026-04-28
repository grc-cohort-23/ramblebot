import java.util.ArrayList;
import java.util.Arrays;
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
      //used this old stackoverflow post to help use regex instead of whitespace to remove the double space
      //https://stackoverflow.com/questions/3958955/how-to-remove-duplicate-white-spaces-in-string-using-java
      //https://stackoverflow.com/questions/8020848/how-is-the-and-or-operator-represented-as-in-regular-expressions

      List<String> words= new ArrayList<>();
      String regexArr= "\\s+";
      while(scanner.hasNextLine()) {
          String[] lineWords = scanner.nextLine().split(regexArr);
          words.addAll(Arrays.asList(lineWords));
      }
        //used https://medium.com/@AlexanderObregon/checking-if-a-word-ends-with-a-certain-letter-in-java-a87768a13563 for endsWith()
        for(int i=0;i< words.size();i++){
            String word = words.get(i).toLowerCase();
            if(word.endsWith(".")){
                words.set(i,word.substring(0,word.length()-1));
                words.add(i+1,".");
                i++;

            }
            else{
                words.set(i,word);
            }
        }


    return words;
  }
}

