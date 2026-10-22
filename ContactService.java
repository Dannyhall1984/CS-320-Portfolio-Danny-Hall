package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {

        for (Contact existingContact : contacts) {
            if (existingContact.getContactID().equals(contact.getContactID())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactID) {

        Contact contactToDelete = findContact(contactID);

        if (contactToDelete == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contactToDelete);
    }

    public void updateContact(String contactID, String firstName,
            String lastName, String phone, String address) {

        Contact contactToUpdate = findContact(contactID);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contactToUpdate.setFirstName(firstName);
        contactToUpdate.setLastName(lastName);
        contactToUpdate.setPhone(phone);
        contactToUpdate.setAddress(address);
    }

    public Contact findContact(String contactID) {

        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }

        return null;
    }
}