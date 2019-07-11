/**
 * 
 */

/**
 * @author aswanth
 *
 */
import java.io.*;
public class Customer {
    
    String name;
    long phone_no;
    String username;
    String password;
    House h;
    Customer(String nam,String user,String pass,long phone){
        name=nam;
        username=user;
        password=pass;
        phone_no=phone;
    }
    
    
    void book_house(int no_houses,int no_customers,int no_places,Customer []customer,House [] house,String[]places)throws IOException{
        if(h!=null){
        	System.out.println("\nEach user is allowed to book only 1 house\n");
        	return;
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nThe list of places are : ");
        for(int i=0;i<no_places;i++){
            System.out.println(places[i]);
        }
        int flag=0;int k=0;
        int temp[]=new int[no_houses];
        System.out.print("\nEnter the place :");
        String place=br.readLine();
        int correct=0;
        for(int i=0;i<no_houses;i++){
            if(house[i].place.equalsIgnoreCase(place))
            {
                correct=1;
                if(house[i].isRented==false){
                    flag=1;
                    house[i].display();
                    temp[k++]=house[i].house_no;
                }
            }
        }
        if(correct==0){System.out.println("\nYou have entered an invalid place name");return;}
        else if(flag==0){System.out.println("\nSorry, No houses available right now");
        return;
        }
        System.out.println("Choose a house number. Press -1 if not satisfied");
        int c=-1;
        try{
         c=Integer.parseInt(br.readLine());
        }catch(NumberFormatException e){System.out.println("Please enter only numbers");}
        if(c==-1||c<-1)return;
        int flag2=0;flag=0;
        for(int i=0;i<no_houses;i++){
            if(house[i].house_no==c){
                flag=1;
                for(int m=0;m<k;m++){
                    if(temp[m]==house[i].house_no){
                            System.out.println("\nThank You for Booking the House");
                            System.out.println("\nThe details of the owner are given below");
                            house[i].owner.display();
                            house[i].isRented=true;
                            h=house[i];
                            flag2=1;
                            System.out.println("\nPress any key to go back");
                            br.readLine();
                   		 }
                    
                }
                if(flag2==0)System.out.println("The house no you have entered does not exist in the entered area");
            }
            
        }
        if(flag==0)
                System.out.println("You have entered an invalid house number");
    
    }
    void vacate_house(int no_houses,int no_customers,int no_places,Customer []customer,House [] house,String[] places)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if(h==null){
            System.out.println("\nYou have not rented any house yet");
            return;
        }
        for(int i=0;i<no_houses;i++){
            if(h==house[i]){
                System.out.println("\nYou have currently rented this house.");
                house[i].display();
                System.out.println("Do you want to vacate it 1.Yes 2.No");
                int c=Integer.parseInt(br.readLine());
                if(c==1){
                    house[i].isRented=false;
                    h=null;
                    
                    System.out.println("Thank you");
                }
                else if(c<1||c>2)System.out.println("Invalid option");
            }
        }
        
    }
    
}
