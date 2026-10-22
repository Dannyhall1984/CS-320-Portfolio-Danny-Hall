package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContact() {
        Contact contact = new Contact(
                "12345",
                "Danny",
                "Hall",
                "5025551234",
                "123 Main Street");

        assertEquals("12345", contact.getContactID());
        assertEquals("Danny", contact.getFirstName());
        assertEquals("Hall", contact.getLastName());
        assertEquals("5025551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Danny", "Hall", "5025551234", "123 Main Street");
        });
    }

    @Test
    void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Danny", "Hall", "5025551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "DannyDannyDanny", "Hall", "5025551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Hall", "5025551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "HallHallHall", "5025551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", null, "5025551234", "123 Main Street");
        });
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", "502555123", "123 Main Street");
        });
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", "50255512345", "123 Main Street");
        });
    }

    @Test
    void testPhoneNotDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", "502555ABCD", "123 Main Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", null, "123 Main Street");
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", "5025551234", "123 Main Street 123 Main Street 123 Main Street");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Danny", "Hall", "5025551234", null);
        });
    }

    @Test
    void testContactAtMaximumLengths() {
        Contact contact = new Contact(
                "1234567890", "DannyLHall", "HallDannyL", "5025551234", "123456789012345678901234567890");

        assertEquals("1234567890", contact.getContactID());
        assertEquals("DannyLHall", contact.getFirstName());
        assertEquals("HallDannyL", contact.getLastName());
        assertEquals("5025551234", contact.getPhone());
        assertEquals("123456789012345678901234567890",
                contact.getAddress());
    }
}
