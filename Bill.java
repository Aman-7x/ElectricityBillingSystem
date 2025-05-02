import java.time.LocalDate;
import java.util.Scanner;

public class Bill {
private String name;
private String address;
private String zone;
private String division;
private long mobNo;
private int currentRead;
private int reading;
private int perviousRead;
private int charges;
private int charges1;
private int chargesSub;
private int fixed;
private double gst;
private String type;
    void setName(String name){
    this.name=name;
}
String getName(){
    return name;
}
    
    int getReading(){
        return reading;
    }

    void setCharges(int charges){
        this.charges=charges;
    }
    int getCharges(){
        return charges;
    }


   public void inputs(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name : ");
        setName(sc.nextLine());
        System.out.print("Enter Address : ");
        address = sc.nextLine();
        System.out.print("Enter your Zone : ");
        zone = sc.nextLine();
        System.out.print("Enter Division : ");
        division = sc.nextLine();
        System.out.print("Enter Mobile No. : ");
         mobNo = sc.nextLong();
        System.out.print("Enter Current Reading : ");
        currentRead = sc.nextInt();
        System.out.print("Enter Previous Reading : ");
        perviousRead = sc.nextInt();
        if(perviousRead <= currentRead )
            reading = currentRead - perviousRead ;
        else{
        System.out.println("Wrong Reading");
        System.exit(0);
        }
       
        
     }

    int domestic(){

        if(reading<=100 ){
            charges=reading*4;
        }else if (reading <=200 && reading>100) {
            charges=reading*6;
        }else if (reading <=300 && reading > 200) {
            charges=reading*8;
        }else if (reading > 300) {
            charges=reading*10;
        }
       // setCharges(charges);
        fixed = 100;
        return charges;
    }

    int subsidy(){
        charges1=charges;
        if(reading<=100){
         
            charges=charges-(2*reading);
            chargesSub = 2*reading;
        }
        return charges;
    }

     void gsts(){
            double temp=(double)18/(double)100;
            gst = (double)charges1*(temp);
            gst = (double)charges*(temp);

        //return gst;
     }
    int commercial(){
        charges = reading*15;
        fixed = 300;
        charges1=charges;
        return charges;
    }
    void output(){

        
          LocalDate currentDate = LocalDate.now();
          LocalDate dueDate = currentDate.plusDays(15);
        System.out.println("________________________________________________________________________________\n" + 
                           "                                                                                             \n" + 
                           "           Madhya Pradesh Paschim Kshetra Vidyut Vitran Company Ltd.                         \n" + //
                           "                  G.P.H. Compound, Pologround, "+division+" (M.P.)                           \n" + //
                           "                        (Wholly Owned by Govt. of M.P.)                                      \n"+
                           "      GSTNo.23AADCM7397N1ZU                CINNo.U40109MP2002SGC015121                       \n"+
                           "      CallCentreNo.1912                    https://www.mpwz.co.in                            \n" + //
                           "_______________________________________________________________________________              ");

        System.out.println("   Security Deposited : INR 0.00   Total Amount Payable Till Due Date: "+(charges+gst+fixed)+" ");
        System.out.println("   Security Deposite Pending:INR 0.00 Total Amount Payable After Due Date: "+(charges+gst+fixed+200)+" ");
        System.out.println("                                      Due Date:         "+dueDate+"           ");
        System.out.println("________________________________________________________________________________\n" + 
                           "  ConsumerNo. N3963011731  (SKZ47-4)   ConnectionType: "+type+"  URBAN                       \n" + 
                           "   Name : "+name+"                          Meter serial No. : AVON03064761                                      \n" + //
                           "   Address : "+address+"                     DC/Zone: "+zone+"                                             \n"+
                           "   Mobile No. : "+mobNo+"                   FeederCode   8022738702                                       \n"+
                           "   Email id        **                       DTR Code:   SKZ0000156                                        \n" + //
                           "_______________________________________________________________________________              ");
        System.out.println("Reading Detail");
         System.out.println("________________________________________________________________________________\n" + 
                           "   Current Reading : "+currentRead+" ,              Current Date : "+currentDate+"                                 \n" + 
                           "   Previous Reading : "+perviousRead+"              Unit Consumption : "+reading+"                                   \n" + //
                           "_______________________________________________________________________________                              ");
        System.out.println("Billing Details");
         System.out.println("________________________________________________________________________________\n" + 
                           "  Energy Charge : "+charges1+"                 Fixed Charges : "+fixed+"                                  \n" + 
                           "  Current Month Bill : "+(charges1+fixed)+"    Subsidy Amount :  "+chargesSub+"                              \n" + //
                           "  Gst(18%) : "+gst+"                            Total Bill : "+(charges + fixed + gst)+"                                              \n" +  
                           "_______________________________________________________________________________             ");

     }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bill ob = new Bill();

        ob.inputs();
        
        System.out.println("Choose Your Connection Type");
        System.out.println("(1) Domestic \n(2) Commercial ");
        int n=sc.nextInt();
        
        switch (n) {
            case 1:
                ob.type = "Domestic";
                ob.domestic();
                ob.subsidy();
                ob.gsts();
                ob.output();
                break;
            case 2:
                ob.type = "Commercial";
                ob.commercial();
              
                ob.gsts();
                ob.output();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        

    
    }
}
