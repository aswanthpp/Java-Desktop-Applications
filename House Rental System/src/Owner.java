/**
 * @author aswanth
 *
 */
public class Owner {
	    
	    String name;
	    long phone_no;
	    Owner(String nam,long pho){
	        name=nam;
	        phone_no=pho;
	    }
	    
	    void display(){
	        System.out.println("Name : "+name);
	        System.out.println("Phone no : "+phone_no);
	        System.out.println();
	    }
}
