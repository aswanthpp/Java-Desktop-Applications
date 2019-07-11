/**
 * 
 */

/**
 * @author aswanth
 *
 */
import java.io.*;
public class Project {

    /**
     * @param args the command line arguments
     */
    int no_houses , no_customers,no_places; ;
    Customer customer[];
    House house[];
    String places[];
	int fl;
    
    void menu(Customer custom)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
        clearscreen();

    String c1 = custom.name.substring(0,1).toUpperCase() + custom.name.substring(1).toLowerCase();
    
	System.out.println("\t\t\t\t\tWELCOME "+c1+"\n\n");
	System.out.println("\n1. Rent\n2. Vacate\n3. Logout");
	int c=0;
	try{
	System.out.print("\nEnter Your Choice : ");
	c = Integer.parseInt(br.readLine());
	}catch(Exception e){System.out.println("Enter only numbers");}
	if(c==1)
        custom.book_house(no_houses, no_customers,no_places ,customer, house,places);
        else if(c==2)
        custom.vacate_house(no_houses, no_customers,no_places, customer, house,places);
        else if(c==3){
		
		login();
		}
		
        }
        
    }
    void check_username()
    {
    	
    	
    }
    void login()throws IOException{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	clearscreen();
	fl=1;
		System.out.println("\t\t\t\t\tWELCOME TO ONLINE HOUSE RENTAL PORTAL");
        System.out.println("\n1. Register\n2. Login\n3. Exit\n");
        int c=0;
        System.out.print("Enter Your Choice : ");
        try{
         c=Integer.parseInt(br.readLine());
        }catch(Exception e){System.out.println("Invalid input");login();}
        System.out.println();
        if(c==1){
            System.out.print("Enter your name : ");
            String nam=br.readLine();
            int flo=1;
            String user;
            while(true)
            {
            flo=1;
             System.out.print("Enter Username : ");
              user=br.readLine();
             for(int k=0;k<no_customers;k++)
             {
             	if(customer[k].username.equals(user))
             	{
             		System.out.println("Username already exists . Please enter another Username");
             		flo=0;
             		break;
             	}
             }
             if(flo==1)break;
             } 
             		
             System.out.print("Enter Password : ");
             String pass=br.readLine();
              System.out.print("Enter Phone no : ");
              long phone;
              while(true){
              try{
               phone=Long.parseLong(br.readLine());
              	}catch(Exception e) { System.out.print("You cant enter strings. Enter again :");continue;}
              	if(phone<1000000000)
              		System.out.println("The phone number is invalid");
              		else break;
              	}
              		
              	
              	
             Customer temp_customer=new Customer(nam,user,pass,phone);
            customer[no_customers]=temp_customer;
                        no_customers++;
                        System.out.println("\nSUCCESSFULLY REGISTERED!!!");
                        login();

        }
        else if(c==2){
            System.out.print("Enter Username : ");
            String username=br.readLine();
            System.out.print("Enter Password : ");
            String password=br.readLine();
            int flag=0;
            for(int i=0;i<no_customers;i++){
                if(customer[i].username.equals(username)){
                    flag=1;
                    if(customer[i].password.equals(password)){
                        System.out.println("\nSuccessful login\n");
                        
                        menu(customer[i]);
                    }
                    else{
                        System.out.println("Password incorrect");
                        login();
                    }
                }
            }
            if(flag==0){System.out.println("Username doesnt exist. Please register");
                        login();
            }
            

        }
        else if(c==3){
            write();
            System.exit(0);
        }
        else login();
    }
    
    void read()throws IOException{
         String fileName = "src/house.txt";
           
            FileReader fileReader = new FileReader(fileName);

           
            BufferedReader br = 
                new BufferedReader(fileReader);

		 no_houses=Integer.parseInt(br.readLine());
		 br.readLine();
                // System.out.println(no_houses);
                 house=new House[no_houses+100];
                 String mod,place,owner_name;
                 long owner_phone_no;
                 int no;float far;boolean is;
		for(int i=0;i<no_houses;i++)
		{
			
			no=Integer.parseInt(br.readLine());
                        //System.out.println(no);
                        mod=br.readLine();
                        //System.out.println(mod);
			place=br.readLine();
                        //System.out.println(place);
                        far=Float.parseFloat(br.readLine());
                        //System.out.println(far);
                        is=Boolean.parseBoolean(br.readLine());
                        //System.out.println(is);
			owner_name= br.readLine();
                        //System.out.println(owner_name);
			owner_phone_no =Long.parseLong(br.readLine());
                        //System.out.println(owner_phone_no);
                        House temp_house =new House(no,mod,place,far,is,owner_name,owner_phone_no);
                        house[i]=temp_house;
                        br.readLine();
			
		}
                no_customers=Integer.parseInt(br.readLine());
                br.readLine();
                customer=new Customer[no_customers+100];
                String nam,user,pass;long pho;int ho;
                for(int i=0;i<no_customers;i++){
                    nam=br.readLine();
                       // System.out.println(nam);
                     user=br.readLine();
                       // System.out.println(user);
                     pass=br.readLine();
                       // System.out.println(pass);
                     pho=Long.parseLong(br.readLine());
                     
                    
                     Customer temp_customer=new Customer(nam,user,pass,pho);
                      ho=Integer.parseInt(br.readLine());
                      br.readLine();
                      if(ho!=-1){
                     for(int j=0;j<no_houses;j++){
                         if(house[j].house_no==ho){
                             temp_customer.h=house[j];
                         }
                     }
                      }
                     customer[i]=temp_customer;
                }
                
                no_places=Integer.parseInt(br.readLine());
                places=new String[no_places+10];
                br.readLine();
                        
                //System.out.println(no_places);
                for(int i=0;i<no_places;i++){
                    places[i]=br.readLine();
                    //System.out.println(places[i]);
                }

            /*while((line = br.readLine()) != null) {
                System.out.println(line);
            }   */ 

            br.close();         
        }
        /*catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }*/
    void write()throws IOException{
        
        String filename="src/house.txt";
        FileWriter fw=new FileWriter(filename);
        BufferedWriter bw= new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        pw.println(no_houses);
        pw.println("");
        for(int i=0;i<no_houses;i++){
            pw.println(house[i].house_no);
            pw.println(house[i].model);
            pw.println(house[i].place);
            pw.println(house[i].fare);
            pw.println(house[i].isRented);
            pw.println(house[i].owner.name);
            pw.println(house[i].owner.phone_no);
            pw.println("");
            
        }
        pw.println(no_customers);
        pw.println("");
        for(int i=0;i<no_customers;i++){
            pw.println(customer[i].name);
            pw.println(customer[i].username);
            pw.println(customer[i].password); 
            pw.println(customer[i].phone_no);
            
            if(customer[i].h==null)pw.println("-1");
            else pw.println(customer[i].h.house_no);
            pw.println("");
        }
      /*  pw.println("2");
        pw.println("Surathkal");
        pw.println("Gandhinagar");*/
      pw.println(no_places);
      pw.println("");
        for(int i=0;i<no_places;i++){
            pw.println(places[i]);
        }
        pw.close();
    }
	void clearscreen(){
		if(fl!=0){
	try{
	Thread.sleep(2000);
	}catch(InterruptedException ex){}
	}
		System.out.println("\033[H\033[2J");
	System.out.flush();
	}

    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        
        Project obj=new Project();
        obj.read();
	    obj.clearscreen();
	
	
        obj.login();
        
        
        obj.write();
    }
    
}
