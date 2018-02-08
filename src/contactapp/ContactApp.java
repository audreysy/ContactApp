package contactapp;

public class ContactApp {

    public static void main(String[] args) {
        ContactAppManager manager = new ContactAppManager();
        ContactAppMainForm ui = new ContactAppMainForm(manager);
        ui.setVisible(true);
    }
        
}

