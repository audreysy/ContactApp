package contactapp;
import java.io.*;

public class FileHandler {
    
    BufferedReader reader;
    PrintWriter writer;
    ContactAppManager manager;
    
    //File on which contact information will be written on and read from:
    final String FILENAME = "/Users/audreysy/NetBeansProjects/ContactApp/src/contactapp/contacts.txt";
    final String OUTPUT_FILENAME = "";
    
    public FileHandler(ContactAppManager manager) {
        this.manager = manager;
    }
    
    public String[] loadData() {
        
        String[] returnArray = new String[10];
        int count = 0;
        
        try {
            //Creates FileReader to read text from file
            reader = new BufferedReader(new FileReader("/Users/audreysy/NetBeansProjects/ContactApp/src/contactapp/contacts.txt"));
            String line = reader.readLine();
            returnArray[count++] = line;
            
            //While loop to continue - given more lines exist in the file
            while (line != null && count < returnArray.length) {
                line = reader.readLine();
                returnArray[count++] = line;
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
