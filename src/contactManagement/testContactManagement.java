package contactManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class testContactManager{
    
	ContactManager cm;
	
	
    @BeforeEach
	    void setUp() {
	        cm = new ContactManager();
	    }
	
	@Test
	
	void testName() {
		Contact c=new Contact(1,null,null,"9765456782"); 
		
		assertFalse(cm.addContact(c),"name shouldn't be null value");
		
	}
	
	@Test
	
	void testFname() {
		Contact c=new Contact(1,null,"mk","9765456782");
		assertFalse(cm.addContact(c),"first name shouldn't be null value");
	}
	
    @Test
	
	void testLname() {
		Contact c=new Contact(1,"midlaj",null,"9765456782");
		assertFalse(cm.addContact(c),"last name shouldn't be null value");
	}
    
   @Test
	
	void testValidPhoneNumber() {
		Contact c=new Contact(1,"midlaj",null,"9765456782");
		assertEquals(10,c.phoneNumber.length(),"contact number should be of 10 digits");
	}
   
   @Test
	
	void testAddContact() {
		Contact c=new Contact(1,"midlaj",null,"9765456782");
		assertTrue(cm.addContact(c),"contact is not added");
	}
   
   @Test
	
	void testDeleteEmptyContact() {
		Contact c=null;
		assertFalse(cm.deleteContact(c),"can't delete a contact which is empty");
	}
   
   @Test
   void testDeleteContact_Success() {
       Contact c = new Contact(1,"midlaj", "mk", "7689765478");
       cm.addContact(c);
       assertTrue(cm.deleteContact(c));
   }
   
   @Test
   public void testUpdateContact_Success() {
     
       Contact c = new Contact(1, "midlaj", "mk", "0987654321");
       assertTrue(cm.updateContact(c),"update success");

       
       
       
       Contact contactInMap = cm.map.get(1);
       assertEquals("midlaj", contactInMap.fname, "The first name should be updated");
       assertEquals("mk", contactInMap.lname, "The last name should be updated");
       assertEquals("0987654321", contactInMap.phoneNumber, "The phone number should be updated");
   }
   
   @Test
   public void testUpdateContact_NullContact() {
	   assertFalse(cm.updateContact(null));
   }
   
   @Test
   public void testUpdateContact_NotFound() {
      
	   Contact c = new Contact(1, null, null, "0987654321");
	   assertFalse(cm.updateContact(c));

    
   }
   
   @Test
   public void testViewContact_Success() {
	   Contact c = new Contact(1, "midlaj", "mk", "0987654321");
	   assertNotNull(cm.viewContact(c));

      
       assertEquals(1, c.id, "The contact ID should match");
       assertEquals("midlaj", c.fname, "The contact name should match");
       assertEquals("mk", c.lname, "The contact email should match");
       assertEquals("0987654321", c.phoneNumber, "The contact phone number should match");
   }
   
   @Test
   public void testViewContact_NotFound() {
	   Contact c = new Contact(1, null, null, "0987654321");
	   assertNull(cm.viewContact(c));

   }
   
   
}
