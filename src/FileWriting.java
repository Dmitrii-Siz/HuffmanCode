import java.io.FileWriter;//write to file
import java.io.IOException;//in case an exception occurs when reading the file
import java.util.ArrayList;//ArrayList self-explanatory
//Used to store the frequency of the words
import java.util.HashMap;
import java.util.Map;

//New class responsible for writing words:
public class FileWriting {

   //No constructor needed

    //Method responsible for writing words:
    public static void WriteWords(ArrayList<String> textFromTextFile) throws IOException {

        Map<String, Integer> HashMap = new HashMap<String, Integer>();

        //takes the first String from the ArrayList
        for (String i : textFromTextFile) {

            //SAME WORD CHECKER:
            //regEx to remove all the .?!, from the string:
            i = i.replaceAll("[!?,.]", "");
            //if the word has a '’' then split it and if the second half contains an s then
            //set that word to same word just without the ’s
            if(i.contains("’")){
                String[] dividedString = i.split("’");
                if(dividedString.length == 2){
                    if(dividedString[1].equals("s")){
                        i = dividedString[0];
                    }
                }
            }

            Integer j = HashMap.get(i);
            //if 'i's' frequency is 0 then set it to 1 and if it's then increment its frequency
            //'j' is the number of times it appeared
            HashMap.put(i, (j == null) ? 1 : j + 1);
        }

        // Writing to the frequency Text File:
        //opens the file to write to
        FileWriter fw = new FileWriter("frequencies.txt");

        for (Map.Entry<String, Integer> val : HashMap.entrySet()) {
            fw.write(val.getKey()+" "+val.getValue()+"\n");
        }

        //closes the text file:
        fw.close();

    }
}
