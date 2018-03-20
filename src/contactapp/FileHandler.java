package contactapp;
import java.io.*;

public class FileHandler {
    
    BufferedReader reader;
    PrintWriter writer;
    ContactAppManager manager;
    
    //File on which the data will be stored:
    final String FILENAME = "/Users/audreysy/NetBeansProjects/ContactApp/src/contactapp/contacts.txt";
    final String OUTPUT_FILENAME = "";
    
    public FileHandler(ContactAppManager manager) {
        this.manager = manager;
    }
    
    public String[] loadData() {
        
        //List of strings to be returned:
        String[] lines = new String[10];
        String[] returnArray = null;
        int count = 0;
        
        try {
            //Creates FileReader to read the file, and will buffer it
            reader = new BufferedReader(new FileReader("/Users/audreysy/NetBeansProjects/ContactApp/src/contactapp/contacts.txt"));
            String line = reader.readLine();
            lines[count++] = line;
            
            //While loop to continue - given more lines exist in the file
            while (line != null && count < lines.length) {
                line = reader.readLine();
                lines [count++] = line;
            }
            
            //Each element in the lines array will be stored in returnArray
            returnArray = new String[count];
            for (int i = 0; i < count; i++) {
                returnArray[i] = lines[i];
            }
            
            reader.close();
        }   
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return returnArray;   
    }
    
    public void saveData(String[] data) {
        
        try {
            writer = new PrintWriter(new FileWriter(FILENAME));
            for (int i = 0; i < manager.count; i++) {
                writer.println(data[i]);
            }
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
