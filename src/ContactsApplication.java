import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication {
    public static void main(String[] args) {

        List<Contact> contactList = loadcontacts();
        boolean leave = false;
        do {

            switch (printMenu()) {
                case 1:
                    viewContacts(contactList);
                    break;

                case 2:
                    contactList = addContact(contactList);
                    break;
                case 3:
                    searchContact(contactList);
                    break;
                case 4:
                    contactList = deleteContact(contactList);
                    break;
                case 5:
                    leave = true;
                    break;
            }

        } while (!leave);
        updateContact(contactList);
    }

    public static List<Contact> loadcontacts() {
        List<Contact> contacts = new ArrayList<>();
        Path path = Paths.get("data", "contacts.txt");
        try {
            List<String> bufferList = Files.readAllLines(path);
            for (String line : bufferList) {
                String[] split = line.split("/");
                Contact contact = new Contact(split[0], split[1]);
                contacts.add(contact);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public static int printMenu() {
        Input input = new Input();
        return input.getInt(1, 5, "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

    }

    public static void viewContacts(List<Contact> contactList) {
        System.out.println("Name | Phone number");
        System.out.println("---------------");

        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " | " + contact.getNumber());

        }
    }

    public static List<Contact> addContact(List<Contact> contactList) {
        Input input = new Input();
        String name = input.getString("Whats the name");
        String number = input.getString("Whats the number");

        Contact contact = new Contact(name, number);

        contactList.add(contact);

        return contactList;
    }

    public static void searchContact(List<Contact> contactList) {
        Input input = new Input();
        String userSearch = input.getString("Search a name");
        for (Contact contact : contactList) {
            if (userSearch.equals(contact.getName())) {
                System.out.println(contact.getName() + " | " + contact.getNumber());
            }
        }
    }

    public static List<Contact> deleteContact(List<Contact> contactList) {
        Input input = new Input();

        String name = input.getString("What contact do you want to delete? ");
        int delete = -1;
        for (Contact contact : contactList) {
            if (name.equals(contact.getName())) {
                delete = contactList.indexOf(contact);
            }
        }

        contactList.remove(delete);

        return contactList;
    }

    public static void updateContact(List<Contact> contactList) {
        Path path = Paths.get("data", "contacts.txt");
        try {
            List<String> bufferContact = new ArrayList<>();
            for (Contact contact : contactList) {
                bufferContact.add(contact.getName() + "/" + contact.getNumber());
            }
            Files.write(path, bufferContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
