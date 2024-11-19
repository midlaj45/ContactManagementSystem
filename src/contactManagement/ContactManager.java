package contactManagement;

import java.util.HashMap;
import java.util.Map;

public class ContactManager implements ContactManagementSystem{
   
      Map<Integer,Contact> map=new HashMap<>();
    
	
	public boolean addContact(Contact c) {
		
		if (c.fname == null || c.lname==null||c.phoneNumber.length()!=10) {
			
		
		  return false;
		}
		 map.put(c.id, c); 
		    return true;
		    	
	}

	
	public boolean deleteContact(Contact c) {
		if (!map.containsKey(c.id)) {
	        return false;
	    }
	    map.remove(c.id);
	    return true;
		
	}

	
	public boolean updateContact(Contact c) {
		 if (map.containsKey(c.id)) {
		        map.put(c.id, c);
		        return true;
		    }
		    return false;
		
	}

	
	public Contact viewContact(Contact c) {
		
			return map.get(c.id);
		}
}
   

