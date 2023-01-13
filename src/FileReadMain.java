import java.io.File;//imports file reader
import java.io.FileNotFoundException;//in case an exception occurs when reading the file
import java.io.IOException;//Exceptions library
import java.util.*;//import everything required
//Huffman Code Part:


public class FileReadMain {
    public static void main(String[] args) throws IOException {
        //stores all the words from the text file:
        ArrayList<String> words = new ArrayList<>();


        //HUFFMAN CODE Step 1:
        //Used to store the frequencies of each character:
        Map<String, Integer> HuffmanMap = new HashMap<String, Integer>();


        //Code to read the file and save to the ArrayList above:
        Scanner in = null;

        //counts the number of paragraphs in the text file
        // (set to 1 because this text file has 2 empty lines between each paragraph
        // apart from the first line):
        int numberOfParagraphs = 1;//then going to be divided by 2 to find the number of paragraphs

        //loop through the file pass all the data to the words ArrayList
        try{
            File dict = new File("Metamorphosis.txt");
            in = new Scanner(dict);

            while(in.hasNextLine()){//if it's not the last line in the text file
                String currentLine = in.nextLine();//stores the currentLine being processed

                //HUFFMAN CODE part 1:
                //get the frequency of each Letter
                if(!currentLine.trim().equals("")){
                    for (int i = 0; i < currentLine.length(); i++) {
                        //Adds each character to the HashMap:
                        //get the character at position i
                        String letter = String.valueOf(currentLine.charAt(i));
                        //Searches through the HuffmanMap for the frequency of the letter
                        Integer j = HuffmanMap.get(letter);
                        //if letter is not found then add a frequency of 1
                        // otherwise increase the frequency
                        HuffmanMap.put(letter, (j == null) ? 1 : j + 1);
                    }
                }

                //if the line is just white space then add 1 to the number of paragraphs
                if(currentLine.trim() == ""){
                    numberOfParagraphs++;
                }
                String[] listOfWords = currentLine.split(" ");
                //adds all the words to an ArrayList:
                for(String word: listOfWords){
                    //if word consists of only white spaces then it is not added
                    if(word.trim() != ""){
                        //removes the white spaces from the word
                        words.add(word.trim());

                    }

                }
            }
        }
        //catches an exception if found is not found
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        //closes the text file
        finally{
            if(in != null){
                in.close();
            }

        }
        //counts the number of characters and sentences in the text file
        int numberOfCharacters = 0;
        int numberOfSentences = 0;
        for (String word : words){
            numberOfCharacters = numberOfCharacters+word.length();
            if(word.contains(".")){
                numberOfSentences++;
            }
        }
        //returns the number of characters present
        System.out.println("There are "+numberOfCharacters+" characters in this text file");
        //returns the number of words
        System.out.println("There are "+words.size()+" words in the file");
        //returns the number of sentences
        System.out.println("There are "+numberOfSentences+" sentences in the file");
        //returns the number of paragraphs
        System.out.println("There are "+numberOfParagraphs/2+" paragraphs in the file");

        //Writing to the text file: UNCOMMENT AT THE END:
        FileWriting.WriteWords(words);

        //Huffman Code:
        //Huffman Code: consists of: BinaryTree file, Node File and Tree file
        System.out.println(new Tree(HuffmanMap, words).GenerateHuffmanCode());
    }
}
