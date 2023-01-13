//imports Map, ArrayList Priority Queue...
import java.util.*;

public class Tree {

    //private variables
    private final Map<String, Integer> huffmanMap;
    private final ArrayList<String> data;

    //constructor to pass the created map of frequencies and text file data
    public Tree(Map<String, Integer> huffmanMap, ArrayList<String> data) {
        this.huffmanMap = huffmanMap;
        this.data = data;
    }

    //Generate HuffmanCode:
    public String GenerateHuffmanCode(){
        //Generate the Tree root:
        BinaryTree rootOfTree = priorityQueue();
        //Create the HuffmanValues:
        Map<String,String> tableOfValues = tableOfHuffmanValues(rootOfTree);

        return new Node(data, tableOfValues, rootOfTree).encode();
    }

    //method for the priority queue to build the Huffman Tree:
    public BinaryTree priorityQueue(){
        //initialises the new priority Queue of type binary Tree
        PriorityQueue<BinaryTree> queue = new PriorityQueue<>();
        //for each value inside the Map create a Node add it to the priorityQueue:
        for (Map.Entry<String, Integer> val : huffmanMap.entrySet()) {
            //also set its leftNode and rightNode to null since they are the leaf nodes
            queue.add(new BinaryTree(val.getValue(),val.getKey(), null, null));
        }

        //loop until there is only the root of the tree left:
        while(queue.size() > 1){
            //retrieve the nodes
            BinaryTree left = queue.poll();
            BinaryTree right = queue.poll();
            //create a parent Node with the children Nodes:
            BinaryTree parent = new BinaryTree(left.getFrequency()+right.getFrequency(), "Parent",left, right);
            //adds the parent back to the queue
            queue.add(parent);

        }
        return queue.poll();
    }

    //Generate HuffmanValues:
    public Map<String, String> tableOfHuffmanValues(BinaryTree rootOfTree){
        Map<String,String> tableOfValues = new HashMap<>();
        //method to create the huffman values
        createValueTable(rootOfTree, "", tableOfValues);

        return tableOfValues;
    }

    //helper method
    public void createValueTable(BinaryTree rootOftree, String s, Map<String, String> tableOfValues){
        if(!rootOftree.isLastNode()){
            createValueTable(rootOftree.getLeftNode(), s+"0", tableOfValues);
            createValueTable(rootOftree.getRightNode(), s+"1", tableOfValues);
        }
        else{
            tableOfValues.put(rootOftree.getCharacter(), s);
        }
    }

}