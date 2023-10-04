import java.util.*;
import java.text.*;


abstract class Ticket{
    String source ;
    String destination ;
    int totalDistance ;

    int numberOfPeople;
    double ticketFare;
    int taxPercent;
    double tax;
    double totalFare;
    String seatNumber;
    String lastSeat = "";
    String coach;

    private String pnrNumber;

    public String getPnrNumber(){
        return pnrNumber;
    }
    public void setPnrNumber(String pnrNumber){
        this.pnrNumber =  pnrNumber;
    }
    abstract void showJourney();
}



class TrainTicket extends Ticket{

    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_WHITE = "\u001B[37m";
    void showJourney(){
        System.out.print(ANSI_GREEN);
        System.out.printf("%n%30s" , "");
        System.out.println(ANSI_WHITE + "Train Journey Details : \n" );
        System.out.printf("%30s%sStarting station%23s:%s %s", "" , ANSI_WHITE,"",  ANSI_GREEN , source );
        System.out.printf("%n%30s%sDestination station%20s:%s %s", "" , ANSI_WHITE,"",  ANSI_GREEN , destination );
        System.out.printf("%n%30s%sPNR number is%26s:%s %s", "" , ANSI_WHITE,"",  ANSI_GREEN , getPnrNumber() );
        System.out.printf("%n%30s%sNumber of Passengers are%15s:%s %d", "" , ANSI_WHITE,"",  ANSI_GREEN , numberOfPeople );
        System.out.printf("%n%30s%sTicket Fare is %24s:%s Rs. %.2f", "" , ANSI_WHITE,"",  ANSI_GREEN , ( ticketFare) );
        System.out.printf("%n%30s%sTax amount is %25s:%s Rs. %.2f", "" , ANSI_WHITE,"",  ANSI_GREEN , tax );
        System.out.printf("%n%30s%sSeat Number(s)%25s:%s %s %s", "" , ANSI_WHITE,"",  ANSI_GREEN , seatNumber , lastSeat );
        System.out.printf("%n%30s%sCoach Number(s)%24s:%s %s ", "" , ANSI_WHITE,"",  ANSI_GREEN , coach);
        System.out.printf("%n%30s%sTotal Amount with Tax is%15s:%s Rs. %.2f", "" , ANSI_WHITE,"",  ANSI_GREEN , totalFare );

        System.out.print(ANSI_WHITE);
    }
}
class BusTicket extends Ticket{
    


    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_WHITE = "\u001B[37m";

    void showJourney(){

        System.out.print(ANSI_GREEN);
        System.out.printf("%n%30s%n%30s" , "" , "");
        System.out.println(ANSI_WHITE + "Bus Journey Details : \n" );
        System.out.printf("%30s%sStarting station%23s:%s %s", "" , ANSI_WHITE, "", ANSI_GREEN , source );
        System.out.printf("%n%30s%sDestination station%20s:%s %s", "" , ANSI_WHITE, "",  ANSI_GREEN , destination );
        System.out.printf("%n%30s%sNumber of Passengers are%15s:%s %d", "" , ANSI_WHITE,"",  ANSI_GREEN , numberOfPeople );
        System.out.printf("%n%30s%sTicket Fare is %24s:%s Rs. %.2f", "" , ANSI_WHITE,"",  ANSI_GREEN , (ticketFare) );
        System.out.printf("%n%30s%sTax amount is %25s:%s Rs. %.2f", "" , ANSI_WHITE,"",  ANSI_GREEN , tax );
        System.out.printf("%n%30s%sSeat Number(s)%25s:%s %s %s", "" , ANSI_WHITE,"",  ANSI_GREEN , seatNumber , lastSeat );
        System.out.printf("%n%30s%sTotal Amount with Tax is%15s:%s Rs. %.2f%n", "" , ANSI_WHITE,"",  ANSI_GREEN , totalFare );

        System.out.print(ANSI_WHITE);
    }
}

class User{
        static final String ANSI_RESET = "\u001B[0m";
        static final String ANSI_BLACK = "\u001B[30m";
        static final String ANSI_RED = "\u001B[31m";
        static final String ANSI_GREEN = "\u001B[32m";
        static final String ANSI_YELLOW = "\u001B[33m";
        static final String ANSI_BLUE = "\u001B[34m";
        static final String ANSI_PURPLE = "\u001B[35m";
        static final String ANSI_CYAN = "\u001B[36m";
        static final String ANSI_WHITE = "\u001B[37m";
    static Scanner scan = new Scanner(System.in);
    String userId = "";

    private  String userName ;
    private  String password ;
    
    Ticket trainTicketBooked;
    Ticket busTicketBooked;

    User(int userId){

        boolean loop = true;

        this.userId += userId;

        do{
            System.out.print(ANSI_YELLOW);
            System.out.printf("%n%30s" , "");
            System.out.print("Enter User Name : " + ANSI_WHITE);
            userName = scan.nextLine();
            if(userName.length() < 4) System.out.printf("%n%30s%sUserName length must be greater than 3 letters" , "" , ANSI_RED);
            else loop = false;
        }while(loop);
        loop = true;
        do{
            System.out.print(ANSI_YELLOW);
            System.out.printf("%n%30s" , "");
            System.out.print( ANSI_YELLOW+ "Enter Password  : " + ANSI_WHITE);
            password = scan.nextLine();
            if(password.length() < 4) System.out.printf("%n%30s%sPassword length must be greater than 3 letters.Enter Again%n" , "" , ANSI_RED);
            else loop = false;
        }while(loop);
        
        System.out.print(ANSI_GREEN);

        System.out.printf("%n%30s" , "");
        System.out.println("User Account created Successfully..");
        System.out.printf("%n%30s" , "");
        System.out.println("Account Details : # UserId : " + this.userId + "           @ Username : " + userName + ANSI_YELLOW);

    }

    public String getUsername(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    static User showUsers(User [] users ,int  len){
        System.out.print(ANSI_GREEN);
        if(len == -1){
            System.out.printf("%n%30s" , "");
            System.out.println( ANSI_RED +"No Users Found/Created..!" + ANSI_YELLOW);
            return null;
        }
        System.out.printf("%n%30sSelect Your Account From Following Users List :%n", "");
        System.out.println(ANSI_GREEN);
        // System.out.printf("%30s" , "");
        for(int i = 0 ; i <= len ; i++){
            System.out.printf("%30s" , "");
            System.out.println( ANSI_GREEN+"   User Id : "+ ANSI_WHITE + users[i].userId+ ANSI_GREEN + "  @ UserName "+ ANSI_WHITE + users[i].getUsername());
            // "   " +(i + 1) +
        }
        System.out.printf("%n%30s" , "");
        System.out.print(ANSI_GREEN+"Enter User Id to Select Your account : " + ANSI_WHITE);
        int option = scan.nextInt();

        if(1 <= option && option <= len + 1){
            return users[option- 1];
        }else{
            System.out.printf("%30s" , "");
            System.out.println(ANSI_RED + "Invalid Option..Try Again.." + ANSI_YELLOW);
            return null;
        }
        
    }
    static void showSingleUser(User user){
        
        if(!authenticateUser(user)){
            System.out.printf("%n%30s%sInvalid Password ...Returning to Dashboard..%s" , "" , ANSI_RED , ANSI_YELLOW);
            return;
        }
        System.out.println(ANSI_GREEN);
        System.out.printf("%n%30s" , "");
        System.out.println("*** User Id : " + user.userId + " UserName " + user.getUsername() + "\n");
        if(user.trainTicketBooked == null && user.busTicketBooked == null){
            System.out.printf("%n%30s%sYou have no Journeys planned...Returning to Dashboard..%s" , "" , ANSI_RED , ANSI_YELLOW);
        }
        if(user.trainTicketBooked != null) user.trainTicketBooked.showJourney();
        if(user.busTicketBooked != null) user.busTicketBooked.showJourney();
    }

    static boolean authenticateUser (User user){
        System.out.printf("%n%30s" , "");
        System.out.print(ANSI_YELLOW + "Enter Your Password to Authorize Your Account - UserName: " + user.getUsername()+ " Password : " + ANSI_WHITE);
        scan.nextLine();
        String givenPass = scan.nextLine();
        if((givenPass).equals(user.getPassword())){
            return true;
        }
        else return false;
        
    }

    static User ticketBooking(User user , String type){

        // creating ticket 
        if(type.equals("train")) user.trainTicketBooked = new TrainTicket();
        else user.busTicketBooked = new BusTicket();
        
       
        // working
        BookingSys.showRoutes();
        System.out.printf("%n%30s" , "");
        System.out.print(ANSI_YELLOW + "Enter Your option Number : " + ANSI_WHITE);
        int option = scan.nextInt();
        // scan.nextLine();

        switch(option){
            case 1:
                BookingSys.showSingleRoute(BookingSys.VizToHydStations);
                if(type.equals("train")){
                    user.trainTicketBooked = generateTicket(user.trainTicketBooked , BookingSys.VizToHydStations , BookingSys.VizToHydStationsDis , type);
                }else{
                    user.busTicketBooked = generateTicket(user.busTicketBooked , BookingSys.VizToHydStations , BookingSys.VizToHydStationsDis , type);
                }
                break;
            case 2:
                BookingSys.showSingleRoute(BookingSys.HowToPuriStations);
                if(type.equals("train")){
                    user.trainTicketBooked = generateTicket(user.trainTicketBooked , BookingSys.HowToPuriStations , BookingSys.HowToPuriStationsDis , type);
                }else{
                    user.busTicketBooked = generateTicket(user.busTicketBooked , BookingSys.HowToPuriStations , BookingSys.HowToPuriStationsDis , type);
                }
                break;
            case 3:
                BookingSys.showSingleRoute(BookingSys.ChennaiToMysoreStations);
                if(type.equals("train")){
                    user.trainTicketBooked = generateTicket(user.trainTicketBooked , BookingSys.ChennaiToMysoreStations , BookingSys.ChennaiToMysoreStationsDis , type);
                }else{
                    user.busTicketBooked =  generateTicket(user.busTicketBooked , BookingSys.ChennaiToMysoreStations , BookingSys.ChennaiToMysoreStationsDis , type);
                }
                break;
             default:
                System.out.printf("%30s" , "");
                System.out.println( ANSI_RED+ "Invalid option...returning to the Dashboard." + ANSI_YELLOW);
                return user;
        }

        return user;
    }

    static Ticket generateTicket(Ticket ticket , String [] route , int [] distances , String type){
        System.out.printf("%n%30s" , "");
        System.out.println(ANSI_YELLOW + "Enter your source and destination options(number) : " + ANSI_WHITE);
        System.out.printf("%30sSource        :" , "");
        int op1 = scan.nextInt() - 1;

        System.out.printf("%30sDestination   :" , "");
        int op2 = scan.nextInt() - 1;
        if(op1 == op2 || (op1 < 0 || route.length - 1 < op1) || (op2 < 0 || route.length - 1 < op2)){
                System.out.printf("%30s" , "");
                System.out.println(ANSI_RED + "Invalid Inputs..Options shouldn't be the Same and must in options...Returning to the dashboard" + ANSI_YELLOW );
                ticket = null;
                return ticket;
        }else{

            ticket.source = route[op1];
            ticket.destination = route[op2];

            int totalDistance = distances[op2]-distances[op1];
            if(op1 > op2) totalDistance *= -1;

            ticket.totalDistance = totalDistance;
            ticket.taxPercent = 5;
        }
        System.out.print(ANSI_GREEN);
        System.out.printf("%n%30s" , "");
        System.out.println( ANSI_YELLOW+ "Source : " + ANSI_WHITE + route[op1] + ANSI_YELLOW +"           Destination : "+ ANSI_WHITE + route[op2] );

        System.out.printf("%n%30sTotal Distance between staions%9s: %s" ,"" , "",  ticket.totalDistance );
        boolean loop = true;
        for(;loop;){
            System.out.printf("%n%30sEnter Number of Passengers%13s: " , "" , "");
            int passengers = scan.nextInt();
            if(0 < passengers && passengers < 7){
                loop = false;
                ticket.numberOfPeople = passengers;
            }else{
                System.out.printf("%n%n%30s" , "");
                System.out.println(ANSI_RED + "Number of people should be between 1 - 6 ..Enter again." + ANSI_YELLOW);
            }
        }
        float farePerOne = 0;
        if(type.equals("train")) farePerOne = 2.5f;
        else farePerOne = 4;
        ticket.ticketFare = ticket.totalDistance * ticket.numberOfPeople *  farePerOne;
        ticket.tax = ticket.ticketFare * (0.04);

        ticket.totalFare = ticket.ticketFare + ticket.tax;
        System.out.printf("%n%30sFare amount for the %s People(s)%8s: Rs.%s", "", (ticket.numberOfPeople) ,"" , (ticket.ticketFare));
        System.out.printf("%n%30sTax amount for the journey%13s: Rs.%.2f" , "", "", (ticket.tax));
        System.out.printf("%n%30sTotal Fare including tax%15s: Rs.%.2f" , "", "" ,(ticket.totalFare));
        System.out.printf("%n%n%30s" , "");
        System.out.print( ANSI_CYAN + "Do you want to continue to book ticket (Y/N): "  + ANSI_WHITE);
        char opt = scan.next().charAt(0);

        if(!(opt == 'y' || opt == 'Y')){
            System.out.printf("%n%30s" , "");
            System.out.println(ANSI_RED + "Ticket Booking Cancelled..Returning to the Dashboard." + ANSI_YELLOW);
            ticket = null;   
        }else{
            // pnr and seat and coach selection
            int seatNumber = (int)(Math.random()* 60) + 1;
            ticket.seatNumber = "" + seatNumber;
            if(type.equals("train")){
                    SimpleDateFormat ft = new SimpleDateFormat ("yyMMddhhmm");
                    String pnr = ft.format(new Date());
                    System.out.printf("%n%30sPnr Number is %26s: %s", "","",pnr);
                    
                    int coach = (int)(Math.random()*3) + 1;
                    ticket.setPnrNumber(pnr);


                    if(coach == 1 ) ticket.coach = "A" + (seatNumber % 10);
                    else if(coach == 2 ) ticket.coach = "B" + (seatNumber % 10);
                    if(coach == 3 ) ticket.coach = "S" + (seatNumber % 10);
                    System.out.printf("%n%30sYour Coach is %26s: %s", "" , "" , ticket.coach);
                
            }
            // String lastSeat = "";
            if(ticket.numberOfPeople != 1) ticket.lastSeat = "-" + (seatNumber + ticket.numberOfPeople - 1);
            System.out.printf("%n%30sYour Seat(s) Number is %17s: %s%s" , "", "" , seatNumber , ticket.lastSeat);
            System.out.printf("%n%30s%n%30s", "" , "");
            System.out.println(ANSI_GREEN+ ((type.equals("train"))? "Train " : "Bus ") + "Ticket Booked Succesfully " + ANSI_YELLOW);
        }
        return ticket;

    }
}


class BookingSys{
        static final String ANSI_RESET = "\u001B[0m";
        // static final String ANSI_BLACK = "\u001B[30m";
        static final String ANSI_RED = "\u001B[31m";
        static final String ANSI_GREEN = "\u001B[32m";
        static final String ANSI_YELLOW = "\u001B[33m";
        static final String ANSI_BLUE = "\u001B[34m";
        static final String ANSI_PURPLE = "\u001B[35m";
        static final String ANSI_CYAN = "\u001B[36m";
        static final String ANSI_WHITE = "\u001B[37m";


    static Scanner scan = new Scanner(System.in);
    // routes of bus/train transport
    static String [] routes= {"Visakhapatnam-Hyderabad" , "Kolkatta Howra-Puri" , "Chennai - Mysore"};
    // viz - hyd in between stops and their distances
    static String []  VizToHydStations = {"Visakhapatnam" , "Samrlkota" , "Rajahmundry" , "Vijayawada" , "Khammam" , "Warangal" , "Secundrabad"} ;
    static int [] VizToHydStationsDis = {0 , 151 , 201 , 350 , 450 , 557 , 699 } ;

    // kolkatta - puri in between stops and their distances
    static String []  HowToPuriStations = {"Kolkatta Howra" , "Kharagpur" , "Balasore" , "Jaipur" , "Cuttak" , "Bhuvaneswar" , "Khurda Road Jn" , "Puri"} ;
    static int [] HowToPuriStationsDis = {0 , 112 , 194 , 296 , 350 , 369 , 388 , 408} ;

    // chennai - mysore in between stops and their distances
    static String [] ChennaiToMysoreStations = {"Chennai" , "Katpadi" , "Bangalore" , "Mysore" } ;
    static int [] ChennaiToMysoreStationsDis = {0 , 122 , 288 , 401  } ;
    static {
        
        System.out.printf("%n     *************************************************  CV Train/Bus Booking System  *************************************************%n " , "" , "");
       
    }

    public static void main(String [] a){
        User [] users = new User[20];
        int lastUser = -1;
        boolean loop = true;

        outer: do{
            System.out.print(ANSI_WHITE);

            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%n%50s--------------- DASHBOARD ---------------%n%n" , "");
           
            System.out.printf("%n%30sChoose an Option to perform one of the Actions %n" , "");
            
            System.out.printf("%n%30s        1. Create a User Account.               2. Show Journeys of a User. %n%30s        3. Book a Train Ticket                  4. Book a Bus Ticket%n%30s        5. Exit...!" , "" , "" , "");
            System.out.printf("%n%n%30sEnter Your Option : " , "");
            
            int option = scan.nextInt();

            switch(option){
                case 1:            
                    System.out.print(ANSI_CYAN);
                    System.out.printf("%n%50s>>>>>>>>> Creating User Account <<<<<<<<<%n" , "");
                    if(lastUser >= 19) {
                        System.out.printf("%30s" , "");
                        System.out.println(ANSI_RED + "\n===>Users Limit exeeded" );
                    }
                    else{
                        users[++lastUser] = new User(lastUser + 1);
                    }
                    break;
                case 2:
                    System.out.print(ANSI_CYAN);
                    System.out.printf("%n%50s>>>> Displaying User Journey Details <<<<%n", "");
                    if(lastUser != -1) System.out.printf("%n%30sSelect Your Account to display Your journeys (Train/Bus)%n", "");
                    User selectedUser  = User.showUsers(users , lastUser);
                    if(selectedUser != null) User.showSingleUser(selectedUser);
                    break;
                
                case 3:
                    System.out.print(ANSI_CYAN);
                    System.out.printf("%n%50s>>>>>>>>> Booking Train Ticket <<<<<<<<<%n", "");
                    System.out.printf("%n%30s" , "");
                    System.out.println(ANSI_YELLOW + "Select your Account from the following List to Authorize and to Book Ticket:");
                    User selectedUser2  = User.showUsers(users , lastUser);
                    if( selectedUser2 == null) continue outer;

                    if(User.authenticateUser(selectedUser2)){
                        System.out.printf("%n%30s" , "");
                        System.out.println(ANSI_GREEN + "Booking Train ticket for the User : " + selectedUser2.getUsername());
                        // Train Ticket Booking function

                        selectedUser2 = User.ticketBooking(selectedUser2 , "train");
                    }else{
                        System.out.printf("%n%30s" , "");
                        System.out.println(ANSI_RED +"Invalid Password...Try Again." );
                    }
                    break;
                case 4:
                    System.out.print(ANSI_CYAN);
                    System.out.printf("%n%50s>>>>>>>>>> Booking Bus Ticket <<<<<<<<<<%n" , "");
                    System.out.printf("%n%30s" , "");
                    System.out.println(ANSI_YELLOW + "Select your Account from the following List to Authorize and to Book  Ticket:" + ANSI_WHITE);
                    User selectedUser3  = User.showUsers(users , lastUser);
                    if( selectedUser3 == null) continue outer;
                    
                    if(User.authenticateUser(selectedUser3)){
                        System.out.printf("%n%30s" , "");
                        System.out.println(ANSI_YELLOW + "Booking Bus ticket for the User : " + selectedUser3.getUsername());
                        // Bus Ticket Booking function
                        selectedUser3 = User.ticketBooking(selectedUser3 , "bus");
                    }else{
                        System.out.printf("%n%30s" , "");
                        System.out.println(ANSI_RED + "Invalid Password...Try Again." + ANSI_YELLOW );
                    }

                    break;
                
                case 5:
                    System.out.print(ANSI_GREEN);
                    System.out.printf("%n%50s>>>> Exiting Application.Thank You... <<<<%n", "");
                    loop = false;
                    break;
                default:
                    System.out.printf("%n%30s" , "");
                    System.out.println(ANSI_RED + "Invalid Option...Enter Valid Option..!");
            }
    
        }while(loop);
        System.out.println("\n" + ANSI_RESET);


    }


    static void showRoutes(){
        System.out.print(ANSI_WHITE);
        System.out.printf("%n%30s---Choose your route in which you want to travel %n%n%30s" , "" , "");
        for(int i = 0 ; i < routes.length ; i++){
            System.out.print( (i + 1) + ". " + routes[i]+ "      ");
        }
        System.out.println(ANSI_YELLOW);
    }

    static void showSingleRoute(String [] route ){
        System.out.print(ANSI_WHITE);
        System.out.printf("%n%30sChoose your source and destination from following %n%n%10s", "" , "");
        for(int i = 0 ; i < route.length ; i++){
            System.out.print((i + 1)  + ". " + route[i] + ((i != route.length - 1)?" <-> " : ""));
        }
        System.out.println(ANSI_YELLOW);
    }

}


// case 6:
//                     User selectedUser4  = showUsers(users , lastUser);
//                     System.out.println("Enter a new Password to update :");
//                     scan.nextLine();
//                     String userpass = scan.nextLine();
//                     selectedUser4 = updatePassword(selectedUser4 , userpass);
//                     break;


// static User updatePassword(User user ,String userpass){
//         user.setPassword(userpass);
//         return user;
//     }



//
// System.out.println("\nEnter your source and destination options : ");
// op1 = scan.nextInt() - 1;
// op2 = scan.nextInt() - 1;
// if(op1 == op2){
//      System.out.println("Options should not be the Same ...Returning to the dashboard");
//      return user;
// }else{
//     System.out.println("Source : " + BookingSys.VizToHydStations[op1] + " Destination : " + BookingSys.VizToHydStations[op2] );
//     totalDistance = BookingSys.VizToHydStationsDis[op2]-BookingSys.VizToHydStationsDis[op1];
//     if(op1 > op2) totalDistance *= -1;
//     System.out.println("\nTotal Distance between staions : " + totalDistance);
//     System.out.println("\nFare amount for the journey     : " + (totalDistance * 4));
// }


// static int distBwStations(String [] staions){

// }