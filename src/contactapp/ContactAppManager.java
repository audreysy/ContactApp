package contactapp;

public class ContactAppManager {
    
    FileHandler handler = new FileHandler(this);
    
    int count = 0;
    int max = 10;
    static boolean addCheck;
    static int index;
    
    Contact[] contactList = new Contact[10];
    String[] nameList = new String[10];
    String[] tempList = new String[max];
    
    public ContactAppManager() {
        
        String[] s;
        String[] data = handler.loadData();
        
        try {
            for (int i = 0; i < data.length; i++) {
                
                //Data array will be split whenever there is a space
                s = data[i].split(" ");
                tempList[i] = s[0];
                
                Contact c = new Contact();
                contactList[count] = c;
                
                contactList[i].setFirstName(s[0]);
                contactList[i].setLastName(s[1]);
                contactList[i].setPhoneNum(s[2]);
                contactList[i].setEmailAdd(s[3]);
                
                nameList[i] = s[1] + ", " + s[0];
                
                count++;
            }
        }
        catch (NullPointerException e) {
            System.out.println(e);
            }
    }
    
    void addContact(
            String firstName,
            String lastName,
            String phoneNum,
            String emailAdd) {
        
        String[] s = null;
        
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNum(phoneNum);
        contact.setEmailAdd(emailAdd);
        FileHandler handler = new FileHandler(this);
        
        if (count <= 10) {
            contactList[count] = contact;
            nameList[count] = lastName + ", " + firstName;
            count++;
        }
        else {
        }
        
        s = new String[count];
        
        for (int i = 0; i < count; i++) {
            s[i] = contactList[i].getFirstName() + " " + contactList[i].getLastName() + " " + contactList[i].getPhoneNum() + " " + contactList[i].getEmailAdd();
        }
        
        handler.saveData(s);
        
}
    
    
Contact getContact(int i) {
    return contactList[i];
}
    
void editContact(int i) {
   
    String[] s = null;
    
    nameList[i] = contactList[i].getLastName() + ", " + contactList[i].getFirstName();
    
    s = new String[count];
    
    for (int j = 0; j < count; j++) {
        s[j] = contactList[j].getFirstName() + " " + contactList[j].getLastName() + " " + contactList[j].getPhoneNum() + " " + contactList[j].getEmailAdd();
    }
    
    handler.saveData(s);
    
}
    
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
        s[i] = contactList[i].getFirstName() + " " + contactList[i].getLastName() + " " + contactList[i].getPhoneNum() + " " + contactList[i].getEmailAdd();
    }
    
    handler.saveData(s);
    
}
    
String[] getContactNames() {
    String[] returnNames = new String[count];
    for (int i = 0; i < count; i++) {
        returnNames[i] = nameList[i];
    }
    return returnNames;
}

}
