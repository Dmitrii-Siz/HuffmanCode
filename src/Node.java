import java.util.ArrayList;
import java.util.Map;

//Node class
public class Node{

    //private variables:
    private final ArrayList<String> data;
    private final Map<String, String> tableOfValues;
    private final BinaryTree rootOfTree;

    //constructor
    public Node(ArrayList<String> data, Map<String, String> tableOfValues, BinaryTree rootOfTree) {
        this.data = data;
        this.tableOfValues = tableOfValues;
        this.rootOfTree = rootOfTree;
    }

    //Generate the Encoded message from the original
    public String encode(){
        StringBuilder builder = new StringBuilder();
        for (String element: data) {
            String[] substrings = element.split("");
            for(String letter: substrings){
                //appends the huffman value to the builder StringBuilder
                builder.append(tableOfValues.get(letter));
            }
        }
        //returns the generated huffmancode
        return builder.toString();
    }
}