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


        switch (printMenu()){
            case 1:
                viewContacts(contactList);
                break;

            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }

    }

    public static List<Contact> loadcontacts(){
        List<Contact> contacts = new ArrayList<>();
        Path path = Paths.get("data", "contacts.txt");
        try{
            List<String> bufferList = Files.readAllLines(path);
            for(String line : bufferList){
               String [] split = line.split("/");
               Contact contact = new Contact(split[0], split[1]);
               contacts.add(contact);

            }
        }catch (IOException e){
            e.printStackTrace();
        }

       return contacts;
    }

    public static int printMenu(){
        Input input = new Input();
        return  input.getInt(1,5,  "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

    }

    public static void viewContacts(List<Contact> contactList){
        System.out.println("Name | Phone number");
        System.out.println("---------------");

        for(Contact contact: contactList){
            System.out.println(contact.getName() + " | " + contact.getNumber());

        }
    }

}
