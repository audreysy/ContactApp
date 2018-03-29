package contactapp;

public class ContactAppManager {
    
    FileHandler handler = new FileHandler(this);
    
    int count = 0;
    int max = 10;
    static boolean addCheck;
    static int index;
    
    //Creates array of Contact objects and parallel array of names to be displayed
    Contact[] contactList = new Contact[max];
    String[] nameList = new String[max];
    String[] tempList = new String[max];
    
    public ContactAppManager() {
       
        //Loads contact information stored in text file
        String[] s;
        String[] data = handler.loadData();
        
        try {
            for (int i = 0; i < data.length; i++) {
                
                //Data is split into different elements wherever there is a space
                s = data[i].split(" ");
                tempList[i] = s[0];
                
                Contact c = new Contact();
                contactList[count] = c;
                
                //Each element in the array corresponds to a contact detail
                contactList[i].setFirstName(s[0]);
                contactList[i].setLastName(s[1]);
                contactList[i].setPhoneNumber(s[2]);
                contactList[i].setEmail(s[3]);
                
                nameList[i] = s[1] + ", " + s[0];
                
                count++;
            }
        }
        catch (NullPointerException e) {
            System.out.println(e);
            }
    }
    
    //Method to add a new contact to the Contacts array
    void addContact(
            String firstName,
            String lastName,
            String phoneNumber,
            String email) {
        
        String[] s = null;
        
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        FileHandler handler = new FileHandler(this);
        
        if (count <= max) {
            contactList[count] = contact;
            nameList[count] = lastName + ", " + firstName;
            count++;
        }
        else {
        }
        
        s = new String[count];
        
        for (int i = 0; i < count; i++) {
            s[i] = contactList[i].getFirstName() + " " + contactList[i].getLastName() + " " + contactList[i].getPhoneNumber() + " " + contactList[i].getEmail();
        }
        
        //Saves all contact information on text file
        handler.saveData(s);
        
}
       
Contact getContact(int i) {
    return contactList[i];
}

String[] getContactNames() {
    String[] returnNames = new String[count];
    for (int i = 0; i < count; i++) {
        returnNames[i] = nameList[i];
    }
    return returnNames;
}

//Method to edit an existing contact from the Contacts array
void editContact(int i) {
   
    String[] s = null;
    
    nameList[i] = contactList[i].getLastName() + ", " + contactList[i].getFirstName();
    
    s = new String[count];
    
    for (int j = 0; j < count; j++) {
        s[j] = contactList[j].getFirstName() + " " + contactList[j].getLastName() + " " + contactList[j].getPhoneNumber() + " " + contactList[j].getEmail();
    }
    
    //Saves all contact information on text file
    handler.saveData(s);
    
}
    
//Method to remove a contact from the Contacts array
void removeContact(int index) {
    
    String[] s = null;
    
    for (int i = index; i < count-1; i++) {
        contactList[i] = contactList[i+1];
        nameList[i] = nameList[i+1];
    }
    contactList[count] = null;
    nameList[count] = null;
    count = count - 1;
    
    s = new String[count];
    
    for (int i = 0; i < count; i++) {
        s[i] = contactList[i].getFirstName() + " " + contactList[i].getLastName() + " " + contactList[i].getPhoneNumber() + " " + contactList[i].getEmail();
    }
    
    //Saves all contact information on text file
    handler.saveData(s);
    
}

}
