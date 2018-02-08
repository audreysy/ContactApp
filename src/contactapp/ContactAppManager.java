package contactapp;

public class ContactAppManager {
    
    Contact[] contactList = new Contact[10];
    String[] nameList = new String[10];
    int count = 0;
    int max = 10;
    static boolean addCheck;
    
    
    void addContact(
            String firstName,
            String lastName,
            String phoneNum,
            String emailAdd) {
        
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNum(phoneNum);
        contact.setEmailAdd(emailAdd);
        
        if (count <= 10) {
            contactList[count] = contact;
            nameList[count] = lastName + ", " + firstName;
            count++;
        }
        else {
        }
        
}
    
void editContact(
            String firstName,
            String lastName,
            String phoneNum,
            String emailAdd,
            int i) {
    
    Contact contact = contactList[i];
    contact.setFirstName(firstName);
    contact.setLastName(lastName);
    contact.setPhoneNum(phoneNum);
    contact.setEmailAdd(emailAdd);
    
    if (i <= 10) {
        contactList[i] = contact;
        nameList[i] = lastName + ", " + firstName;
    }
    else {
    }
    
}
    
void removeContact(int index) {
    for (int i = index; i < count-1; i++) {
        contactList[i] = contactList[i+1];
        nameList[i] = nameList[i+1];
    }
    contactList[count] = null;
    nameList[count] = null;
    count = count - 1;
}
    
String[] getContactNames() {
    String[] returnNames = new String[count];
    for (int i = 0; i < count; i++) {
        returnNames[i] = nameList[i];
    }
    return returnNames;
}

}
