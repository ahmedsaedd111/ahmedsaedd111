package parking.system.guidance;

import java.io.*;
import java.util.*;

public class ParkingSystemGuidance {
    
    public static void Enter(String name, String plateNumber, String carColor,
            String brand, int id) throws FileNotFoundException{
        int x = 0; 
        int checker = 0;
        
        Random random1 = new Random();
        int ticket_id = random1.nextInt(200);
        
        Date date = new Date();
        double timeIn = date.getTime();
        
        System.out.println("______________________________");
        System.out.println("YOUR TICKET ID IS " + ticket_id);
        System.out.println("TIME NOW IS "+ date.toString());
        System.out.println("______________________________");

        customerClassI newCustomer = new customerClassI(name, plateNumber,
                carColor, brand, id, timeIn);  

        for (int i = 0; i < 200; i++) {
            File fileThere = new File("D:\\Spots\\R"+ i +".txt");
            if (fileThere.exists())
                x++;    
        }    
        System.out.println("PLEASE CHOOCE A SPOT TO GET");
        File freeSpots = new File("D:\\Spots\\R"+ x +".txt");
        Scanner zones = new Scanner(freeSpots);
        while(zones.hasNext()){
            String freeZones = zones.nextLine();
            System.out.print(" " + freeZones);
        }
        System.out.println(" ");
        zones.close();

        Scanner inputS = new Scanner(System.in); 
        String s70 = inputS.nextLine();
        String[] args = new String[]{"D:\\Spots\\R"+ x +".txt" ,"D:\\Spots\\R"+ (x+1) +".txt" , "" + s70, "FULL"+ s70};   
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        try (
          Scanner inputSource = new Scanner(sourceFile);
          PrintWriter outputTarget = new PrintWriter(targetFile);
        ) {        
          while (inputSource.hasNext()) {
            String s1 = inputSource.nextLine();
            String s2 = s1.replaceAll(args[2], args[3]);
            outputTarget.println(s2);
            if(s70.equals(s1)){
                checker++;
            }
          }
        }
        if(checker==0){
            System.out.println("Invalid Zone");
            System.exit(-1);
        }
            // Create a file
        File file = new File("D:\\Customers\\Entered Customers\\"+ ticket_id + ".txt");
        if (file.exists()) {
          System.out.println("PLEASE TRY AGAIN");
          System.exit(0);
        }

        PrintWriter output = new PrintWriter(file);

        output.println("ID: " + newCustomer.getId());
        output.println("name: "+ newCustomer.getName());
        output.println("plate number: "+ newCustomer.getPlateNumber());
        output.println("car color: "+ newCustomer.getCarColor());
        output.println("brand: "+ newCustomer.getBrand());
        output.println(s70);
        output.println(newCustomer.getTimeIn());
        // Close the file
        output.close();        
    }
  
    public static void Exit(int ticket_id) throws FileNotFoundException{
        int x = 0, y = 0;
            File fileOut = new File("D:\\Customers\\Customers Out\\"+ ticket_id +".txt");
            if (fileOut.exists()){
                System.out.println("Already Out");
                System.exit(-1);
            }
            File fileThere = new File("D:\\Customers\\Edited Customers\\"+ ticket_id +".txt");
            if (fileThere.exists()){
                y++;
            }
            switch(y){  
                
            case(1): {
            File file = new File("D:\\Customers\\Edited Customers\\"+ ticket_id +".txt");
            try(Scanner inputFile = new Scanner(file);){
            while (inputFile.hasNext()) {
              String id= inputFile.nextLine();
              String name = inputFile.nextLine();
              String plateNumber = inputFile.nextLine();
              String carColor = inputFile.nextLine();
              String brand = inputFile.nextLine();
              String zone = inputFile.nextLine();
              double timeIn = inputFile.nextDouble();
              System.out.println(id + "\n" + 
                name + "\n" + plateNumber + "\n" + carColor + "\n" + brand +  "\n" + 
                      zone);
                Date date = new Date();
                double timeOut = (date.getTime());
                double totalTime = (timeOut - timeIn); 
                System.out.println("YOUR TOTOAL time IS " + totalTime/1000 );
                
                double amount = (totalTime/1000) * 0.00024;
                System.out.println("YOUR TOTAL AMOUNT IS " + amount );
     
                String [] args = new String[]{"D:\\Customers\\Edited Customers\\"+ ticket_id +
                        ".txt" ,"D:\\Customers\\Customers Out\\"+ ticket_id +".txt" , "hsfjjsd", "jfj"};   
                        File sourceFile = new File(args[0]);
                        File targetFile = new File(args[1]);
                        try (
                          // Create input and output files
                          Scanner inputSource = new Scanner(sourceFile);
                          PrintWriter outputTarget = new PrintWriter(targetFile);
                        ) {        
                          while (inputSource.hasNext()) {
                            String s1 = inputSource.nextLine();
                            String s2 = s1.replaceAll(args[2], args[3]);
                            outputTarget.println(s2);
                          }
                          outputTarget.println(totalTime/1000);
                          outputTarget.println(amount);
                        }
                    int xx=0;    
                    for (int i = 0; i < 60; i++) {
                    File fileThereR = new File("D:\\Spots\\R"+ i +".txt");
                    if (fileThereR.exists())
                    xx++;    
                }
                    args = new String[]{"D:\\Spots\\R"+ xx +".txt" ,"D:\\Spots\\R"+ (xx+1) +".txt" ,"FULL"+ zone , "" + zone};  
                    sourceFile = new File(args[0]);
                    targetFile = new File(args[1]);
                    try (
                      // Create input and output files
                      Scanner inputSource = new Scanner(sourceFile);
                      PrintWriter outputTarget = new PrintWriter(targetFile);
                    ) {        
                      while (inputSource.hasNext()) {
                        String s1 = inputSource.nextLine();
                        String s2 = s1.replaceAll(args[2], args[3]);
                        outputTarget.println(s2);
                      }
                    }
                    }  
            }
            break;
            }
            case(0):{
            File fileThere1 = new File("D:\\Customers\\Entered Customers\\"+ ticket_id +".txt");
            if (!fileThere1.exists()){
                System.out.println("INVALID TICKET ID");
                System.exit(-1);
            }   
            File file = new File("D:\\Customers\\Entered Customers\\"+ ticket_id +".txt");
            try(Scanner inputFile = new Scanner(file);){
            //Scanner inputFile = new Scanner(file);
            // Read data from a file
            while (inputFile.hasNext()) {
              String id= inputFile.nextLine();
              String name = inputFile.nextLine();
              String plateNumber = inputFile.nextLine();
              String carColor = inputFile.nextLine();
              String brand = inputFile.nextLine();
              String zone = inputFile.nextLine();
              double timeIn = inputFile.nextDouble();
              System.out.println(id + "\n" + 
                name + "\n" + plateNumber + "\n" + carColor + "\n" + brand +  "\n" + 
                      zone);
                      Date date = new Date();
                double timeOut = (date.getTime());
                double totalTime = (timeOut - timeIn); 
                System.out.println("YOUR TOTOAL time IS " + totalTime/1000 );

                double amount = (totalTime/1000) * 0.00024;
                System.out.println("YOUR TOTAL AMOUNT IS " + amount );
                String [] args = new String[]{"D:\\Customers\\Entered Customers\\"+ ticket_id +".txt" 
                        ,"D:\\Customers\\Customers Out\\"+ (ticket_id) +".txt" , "hsfjjsd", "jfj"};   
                File sourceFile = new File(args[0]);
                File targetFile = new File(args[1]);
                try (
                  // Create input and output files
                  Scanner inputSource = new Scanner(sourceFile);
                  PrintWriter outputTarget = new PrintWriter(targetFile);
                ) {        
                  while (inputSource.hasNext()) {
                    String s1 = inputSource.nextLine();
                    String s2 = s1.replaceAll(args[2], args[3]);
                    outputTarget.println(s2);
                  }
                  outputTarget.println(totalTime/1000);
                  outputTarget.println(amount);
                }
            int qw = 0;
            for (int i = 0; i < 60; i++) {
            File fileThereR1 = new File("D:\\Spots\\R"+ i +".txt");
            if (fileThereR1.exists())
            qw++;    
        }
            String [] args1 = new String[]{"D:\\Spots\\R"+ qw +".txt" ,"D:\\Spots\\R"+ (qw+1) +".txt" , "FULL" +zone, ""+zone};  
            sourceFile = new File(args1[0]);
            targetFile = new File(args1[1]);
            try (
              // Create input and output files
              Scanner inputSource = new Scanner(sourceFile);
              PrintWriter outputTarget = new PrintWriter(targetFile);
            ) {        
              while (inputSource.hasNext()) {
                String s1 = inputSource.nextLine();
                String s2 = s1.replaceAll(args1[2], args1[3]);
                outputTarget.println(s2);
              }
            }   
}
    }
            }
            }
    }
    
    public static void addSpot(String newSpot) throws FileNotFoundException{
        int x = 0;
        int checker = 0;
        for (int i = 0; i < 200; i++) {
            File fileThere = new File("D:\\Spots\\R"+ i +".txt");
            if (fileThere.exists())
            x++;    
        }
        String[] args = new String[]{"D:\\Spots\\R"+ x +".txt" ,"D:\\Spots\\R"+ (x+1) +".txt" , "aghsjgsahf" , "error"};   
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        try (
          // Create input and output files
          Scanner inputSource = new Scanner(sourceFile);
          PrintWriter outputTarget = new PrintWriter(targetFile);
        ) {        
          while (inputSource.hasNext()) {
            String s1 = inputSource.nextLine();
            String s2 = s1.replaceAll(args[2], args[3]);
            outputTarget.println(s2);  
            if(newSpot.equals(s1)){
                System.out.println("This spot is already exists");
                checker++;
            }
          }
          if(checker ==0)
                outputTarget.println(newSpot);
      }
    }

    public static void viewSpots() throws FileNotFoundException{
       int x = 0;
       for (int i = 0; i < 200; i++) {
        File fileThere = new File("D:\\Spots\\R"+ i +".txt");
        if (fileThere.exists())
            x++;    
        }    
        System.out.println("THERE ARE THE SPOTS:");
        File freeSpots = new File("D:\\Spots\\R"+ x +".txt");
        try (Scanner zones = new Scanner(freeSpots)) {
            while(zones.hasNext()){
                String freeZones = zones.nextLine();
                System.out.print(" " + freeZones);
            }
            System.out.println(" ");
        }
    }
       
    public static void updateUser(int ticketId, String toBeEdited, String toBeEditedWith) throws FileNotFoundException{
        String[] args = new String[]{"D:\\Customers\\Entered Customers\\"+ ticketId +".txt" ,"D:\\Customers\\Edited Customers\\"+ ticketId +".txt" , "" + toBeEdited, ""+ toBeEditedWith};   
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        try (
          // Create input and output files
          Scanner inputSource = new Scanner(sourceFile);
          PrintWriter outputTarget = new PrintWriter(targetFile);
        ) {        
          while (inputSource.hasNext()) {
            String s1 = inputSource.nextLine();
            String s2 = s1.replaceAll(args[2], args[3]);
            outputTarget.println(s2);
          }
        }
    }

    public static void viewShiftsReports(int ticket_id) throws FileNotFoundException{
            File file = new File("D:\\Customers\\Customers Out\\" +ticket_id + ".txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String id= input.nextLine();
                String name = input.nextLine();
                String plateNumber = input.nextLine();
                String carColor = input.nextLine();
                String brand = input.nextLine();
                String spotZ = input.nextLine();
                double timeIn = input.nextDouble();
                String gar = input.nextLine();
                String totalTime1 = input.nextLine();
                String amount1 = input.nextLine();
                System.out.println("TOTOAL time IS " + totalTime1 );
                System.out.println("TOTAL AMOUNT IS " + amount1 );
               
            }
        }

    }        

    public static void viewParkedCarsReports(int ticket_id) throws FileNotFoundException{
               File file = new File("D:\\Customers\\" +ticket_id + ".txt");
        // Read data from a file
        try ( // Create a Scanner for the file
                Scanner input = new Scanner(file)) {
            // Read data from a file
            while (input.hasNext()) {
                String id= input.nextLine();
                String name = input.nextLine();
                String plateNumber = input.nextLine();
                String carColor = input.nextLine();
                String brand = input.nextLine();
                String spotZ = input.nextLine();
                
                System.out.println("parked car "+ carColor);
                System.out.println("parked car "+ brand);
                System.out.println("parked car " + plateNumber );
                System.out.println("parked car " + spotZ );  
            }
        } 
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int checkUser, checkCustomer, checkAdmin;
        System.out.println("1-CUSTOMER  -  2-ADMIN");
        checkUser = input.nextInt();
        System.out.println("______________________________________");
        
        switch(checkUser){
           case(1) -> {
               System.out.println("  1-ENTER  -  2-EXIT  ");
               checkCustomer = input.nextInt();
               System.out.println("______________________________________");
               
               switch(checkCustomer){
                   case(1) -> {
                       Scanner inputEnter = new Scanner(System.in);
                       System.out.println("enter name");
                       String name = inputEnter.nextLine();
                       System.out.println("HELLO "+ name + " !");
                       System.out.println("enter plateNumber");
                       String plateNumber = inputEnter.nextLine();
                       System.out.println("enter carColor");
                       String carColor = inputEnter.nextLine();
                       System.out.println("enter brand");
                       String brand = inputEnter.nextLine();
                       System.out.println("enter id");
                       int id = inputEnter.nextInt();
                       Enter(name, plateNumber, carColor, brand, id);
                   }
                   case(2) -> {
                       System.out.println("Please enter your ticket id:");
                       int ticket_id = input.nextInt();
                       Exit(ticket_id);
                   }
                   
                   default -> {
                       System.out.println("ERROR: ENVALID CHOICE");
                       System.exit(-999);
                   }
               }
            }
                    case(2) -> {
                        Scanner Input = new Scanner(System.in);
                            System.out.println("Enter Your Password:");
                            String passWord = Input.nextLine();
                            
                            if(!"0000".equals(passWord)){
                                System.out.println("WRONG PASSWORD");
                                System.exit(-1);
                            }
                            System.out.println("1-ADD SPOTS   2-VIEW SPOTS   3-UPDATE USERS   4-VIEW SHIFTS REPORTS  5-PARKED CARS REPOETS");
                            checkAdmin = input.nextInt();
                            System.out.println("______________________________________");
                            switch(checkAdmin){
                                case(1):{
                                    System.out.println("PLEASE ENTER THE NEW SPOT");
                                    Scanner inputS = new Scanner(System.in); 
                                    String newSpot = inputS.nextLine();
                                    addSpot(newSpot);
                                    break;
                                }
                                case(2):{
                                    viewSpots();
                                    break;
                                }
                                case(3):{                                    
                                    int x = 0;
                                    for (int i = 0; i < 200; i++) {
                                    File fileThere = new File("D:\\Customers\\Entered Customers\\"+ i +".txt");
                                    if (fileThere.exists()){
                                        x++;
                                        }
                                    } 
                                    if(x==0){
                                        System.out.println("THERE ARE NO CUSTOMERS YET");
                                        System.exit(-1);
                                    }
                                    int[] y = new int[200];
                                    for (int i = 0; i < 200; i++) {   
                                            File fileThere = new File("D:\\Customers\\Entered Customers\\"+ i +".txt");
                                               if (fileThere.exists())
                                                    y[i]=i; 
                                               else
                                                   y[i]=-999;
                                    }
                                    for (int i = 0; i < 200; i++) {
                                        if(y[i]!=-999)
                                        System.out.println("id: " + y[i]);
                                    }

                                    System.out.println("Number Of Customers is:" + x);
                                    System.out.println("__________________________");
                                    System.out.println("Enter ID to edit");
                                    Scanner inputInt = new Scanner(System.in);
                                    int ticket_id = inputInt.nextInt();
                                                                    File fileThere1 = new File("D:\\Customers\\Entered Customers\\"+ ticket_id +".txt");
                                if (!fileThere1.exists()){
                                    System.out.println("INVALID TICKET ID");
                                    System.exit(-1);
                                }   
                                File file = new File("D:\\Customers\\Entered Customers\\"+ ticket_id +".txt");
                                try(Scanner inputFile = new Scanner(file);){
                                //Scanner inputFile = new Scanner(file);
                                // Read data from a file
                                while (inputFile.hasNext()) {
                                  String id= inputFile.nextLine();
                                  String name = inputFile.nextLine();
                                  String plateNumber = inputFile.nextLine();
                                  String carColor = inputFile.nextLine();
                                  String brand = inputFile.nextLine();
                                  String zone = inputFile.nextLine();
                                  double timeIn = inputFile.nextDouble();
                                  System.out.println(id + "\n" + 
                                    name + "\n" + plateNumber + "\n" + carColor + "\n" + brand +  "\n" + 
                                          zone);
                                }
                                inputFile.close();
                                }
                                    System.out.println("Enter what you want to be edited");
                                    Scanner inputS = new Scanner(System.in); 
                                    String sToBeEdited = inputS.nextLine();
                                    System.out.println("Enter what you want to edit");
                                    String sToEdit = inputS.nextLine();                                   
                                    updateUser(ticket_id, sToBeEdited, sToEdit);
                                    break;
                                }
                                case(4):{
                                    int x = 0;
                                    for (int i = 0; i < 200; i++) {
                                    File fileThere = new File("D:\\Customers\\Customers Out\\"+ i +".txt");
                                    if (fileThere.exists()){
                                        x++;
                                        }
                                    }  
                                    System.out.println("Number Of Customers is:" + x);
                                    if(x==0){
                                        System.out.println("THERE IS NO CUSTOMERS YET");
                                        System.exit(-1);
                                    }
                                    int[] y = new int[200];
                                    for (int i = 0; i < 200; i++) {   
                                        File fileThere = new File("D:\\Customers\\Customers Out\\"+ i +".txt");
                                           if (fileThere.exists())
                                                y[i]=i; 
                                           else
                                               y[i]=-999;
                                    }
                                    for (int i = 0; i < 200; i++) {
                                        if(y[i]!=-999)
                                        System.out.println("id: " + y[i]);
                                    }
                                    System.out.println("Enter ID to see the report");
                                    Scanner input1 = new Scanner(System.in);
                                    int ticket_id = input1.nextInt();
                                    viewShiftsReports(ticket_id); 
                                    break;
                                }
                                case(5):{
                                int x = 0, f = 0;
                                for (int i = 0; i < 60; i++) {
                                File fileThere = new File("D:\\Customers\\Customers Out"+ i +".txt");
                                if (fileThere.exists()){
                                    x++;
                                    }
                                }
                                for (int i = 0; i < 60; i++) {
                                File fileThere = new File("D:\\Customers\\Entered Customer\\"+ i +".txt");
                                if (fileThere.exists()){
                                    f++;
                                    }
                                }
                                int w=f-x;
                                if(w==0){
                                    System.out.println("THERE IS NO CUSTOMERS");
                                    System.exit(-1);
                                }
                                System.out.println("Number Of Exist Customers is:" + w);
                                //Give The Admin the IDs.
                                int[] y = new int[200];
                                for (int i = 0; i < 200; i++) {   
                                        File fileThere = new File("D:\\Customers\\Entered Customers\\"+ i +".txt");
                                           if (fileThere.exists())
                                                y[i]=i; 
                                           else
                                               y[i]=-999;
                                }
                                for (int i = 0; i < 200; i++) {   
                                        File fileThere = new File("D:\\Customers\\Customers Out\\"+ i +".txt");
                                           if (fileThere.exists())
                                               y[i]=-999;
                                }
                                for (int i = 0; i < 200; i++) {
                                    if(y[i]!=-999)
                                    System.out.println("id: " + y[i]);
                                }
                                System.out.println("Enter ID to see the report");
                                Scanner input1 = new Scanner(System.in);
                                int ticket_id = input1.nextInt();
                                viewParkedCarsReports(ticket_id);
                                break;
                                }
                                default:{
                                    System.out.println("INVALID CHOICE");
                                    System.exit(-1);
                                }    
                            }
                            
                    }
                    default->{
                        System.out.println("INVALID CHOICE");
                        System.exit(-1);
                    }

        }
    }
}    

