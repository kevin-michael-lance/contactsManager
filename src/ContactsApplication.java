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
            // print menu returns an integer. Switch statement evaluates the integer and executes the appropriate case.
            switch (printMenu()) {
                case 1:
                    viewContacts(contactList);
                    break;
                case 2:
                    addContact(contactList);
                    break;
                case 3:
                    searchContact(contactList);
                    break;
                case 4:
                    deleteContact(contactList);
                    break;
                case 5:
                    leave = true;
                    break;
            }
        } while (!leave);
        updateContact(contactList);
    }

    /*
        Finds contacts.txt in the data directory and reads all the files, and converts the contacts from strings to objects,
         and returns the list of contact objects.
     */
    public static List<Contact> loadcontacts() {
        List<Contact> contacts = new ArrayList<>();
        Path path = Paths.get("data", "contacts.txt");
        try {
            List<String> bufferList = Files.readAllLines(path);
            // goes through list of strings and converts them to contact objects
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

    /*
        This method prints the menu. It returns an integer that represents the users choice.
     */
    public static int printMenu() {
        Input input = new Input();
        return input.getInt(1, 5, "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
    }

    /*
        This method allows you to view the contacts.  It takes in a list of contact objects as the parameter.
         Uses for each loop to print out each individual element.
     */
    public static void viewContacts(List<Contact> contactList) {
        System.out.println("Name | Phone number");
        System.out.println("---------------");

        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " | " + contact.getNumber());
        }
    }

    /*
        This method adds a new  contact. It takes in a list of contact objects as the parameter,
         and gets the new contact name and number from user input.
     */
    public static void addContact(List<Contact> contactList) {
        Input input = new Input();
        String name = input.getString("Whats the name");
        String number = input.getString("Whats the number");

        Contact contact = new Contact(name, number);

        contactList.add(contact);
    }


    /*
        This method searches the contact list for a specific name.  User search gets a name in the form of a string,
        and the for loop goes through the contact list and checks if the user search is equal to a name in the contact list, and prints out the name and the number.
     */
    public static void searchContact(List<Contact> contactList) {
        Input input = new Input();
        String userSearch = input.getString("Search a name");
        for (Contact contact : contactList) {
            if (userSearch.equals(contact.getName())) {
                System.out.println(contact.getName() + " | " + contact.getNumber());
            }
        }
    }

    /*
        This method allows you to delete a contact by getting the user input in a the form of a string,
        and uses a for each loop to check if the user input is equal to a name in the contact list.
        If user input equals name in the contact list, then delete it by the index of that contact.
     */
    public static void deleteContact(List<Contact> contactList) {
        Input input = new Input();

        String name = input.getString("What contact do you want to delete? ");
        int delete = -1;
        for (Contact contact : contactList) {
            if (name.equals(contact.getName())) {
                delete = contactList.indexOf(contact);
            }
        }

        contactList.remove(delete);
    }

    /*
        This method updates the contact list by finding contacts.txt in the data directory.
        Creates a list of strings called bufferlist to convert contact objects to strings.
        Uses for each to go through contact list and adds contact name and number to the bufferlist.
        then it writes to contacts.txt.
     */
    public static void updateContact(List<Contact> contactList) {
        Path path = Paths.get("data", "contacts.txt");
        try {
            List<String> bufferList = new ArrayList<>();
            for (Contact contact : contactList) {
                bufferList.add(contact.getName() + "/" + contact.getNumber());
            }
            Files.write(path, bufferList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}