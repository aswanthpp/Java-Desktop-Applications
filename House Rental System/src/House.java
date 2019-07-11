/**
 * 
 */

/**
 * @author aswanth
 *
 */
public class House {

	int house_no;
    String model;
    String place;
    float fare;
    boolean isRented;
    
    Owner owner;
    
    House(int no,String mod,String plac,float far,boolean is,String nam,long pho){
       house_no=no;
       model=mod;
       place=plac;
       fare=far;
       isRented=is;
       owner=new Owner(nam,pho);
    }
    
    void display(){
        System.out.println("\nHouse no : "+house_no);
        System.out.println("Model : "+model);
        System.out.println("Place : "+place);
        System.out.println("Fare : "+fare);
        System.out.println();
    }
}
