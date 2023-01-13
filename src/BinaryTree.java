//Binary Tree Created for huffman code:

//HuffmanTree
//interface for the compareTo method
public class BinaryTree implements Comparable<BinaryTree>{

    //private variables:
    private int frequency;
    private String character;
    private BinaryTree leftNode;
    private BinaryTree rightNode;

    //constructor:


    public BinaryTree(int frequency, String character, BinaryTree leftNode, BinaryTree rightNode) {
        this.frequency = frequency;
        this.character = character;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //Getters and Setters
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public BinaryTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTree leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTree getRightNode() {
        return rightNode;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setRightNode(BinaryTree rightNode) {
        this.rightNode = rightNode;
    }

    //isLastNode no left or right children then this method would return true:
    boolean isLastNode(){
        return this.leftNode == null && this.rightNode == null;
    }


    //compare to method
    @Override
    public int compareTo(BinaryTree o) {
        //compare the 2 integer frequencies
        int CompareFreq = Integer.compare(this.frequency, o.frequency);
        if(CompareFreq != 0){
            return CompareFreq;
        }
        //if the frequency is the same we can just return 0
        return 0;
    }
}
