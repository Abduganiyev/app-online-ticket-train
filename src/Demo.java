import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List<User> users = new ArrayList<>();
    public static List<Ticket> tickets = new ArrayList<>();
    public static List<Ticket> trainSchedule = new ArrayList<>();
    public static List<Ticket> myOrders = new ArrayList<>();
    public static User onlineuser = new User();
    public static Integer indexId=1;
    public static Scanner sc;

    public static void main(String[] args) {

        users.add(new User(indexId++,"umar@mail.ru","UmarAli","Abdu","123"));
        users.add(new User(indexId++,"karim@mail.ru","Karim","Abdu","123"));

        tickets.add(new Ticket(1,"БУХАРА","ТОШКЕНТ",2,134.500,new Train("12",100)));
        tickets.add(new Ticket(2,"ТОШКЕНТ","БУХАРА",2,134.500,new Train("10",100)));

        trainSchedule.add(tickets.get(0));
        trainSchedule.add(tickets.get(1));

        while (true){
            sc = new Scanner(System.in);
            System.out.println("1. Sing In");
            System.out.println("2. Sing On");
            System.out.println("0. Exit");

            int choise = sc.nextInt();

            switch (choise) {
                case 1:
                    signIn();
                    break;
                case 2:
                    signOn();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void signIn() {
        System.out.print("Email: ");
        String email = sc.next();
        for (User user : users) {
            if (user!=null){
                if (user.getEmail().equals(email)){
                    while (true) {
                        System.out.print("Password: ");
                        String passord = sc.next();
                        if (user.getPassword().equals(passord)) {
                            onlineuser = user;
                            break;
                        }
                    }
                }
            }
        }

        if (onlineuser!=null) {
            System.out.println("Welcome to "+onlineuser.getFirstname()+"\n");
            mainMenu();
        }
    }

    private static void signOn() {
        sc = new Scanner(System.in);

        System.out.println("First name: ");
        String firstname = sc.next();

        System.out.println("Last name: ");
        String lastname = sc.next();

        while (true) {
            System.out.print("Email: ");
            String email = sc.next();
            boolean validate = onlineuser.validate(email);
            if (validate) {
                onlineuser.setEmail(email);
                break;
            }
            else
                System.out.println("Email is not valid");
        }

        while (true) {
            System.out.print("password: ");
            String password = sc.next();


            System.out.print("password retype: ");
            String passwordRe = sc.next();

            boolean succes=false;
            if (password.equals(passwordRe)){
                System.out.println("Succesfuly created!\n");
                succes=true;
            }

            if (succes) {
                onlineuser.setFirstname(firstname);
                onlineuser.setLastname(lastname);
                onlineuser.setPassword(password);
                onlineuser.setId(indexId++);
                users.add(onlineuser);
                break;
            }
        }
    }

    private static void mainMenu() {
        sc = new Scanner(System.in);
        int choose;

        do {
            System.out.println("Choose the operation:");
            System.out.println("1. Train Schedule");
            System.out.println("2. Buy ticket");
            System.out.println("3. My orders");
            System.out.println("4. Personal data");
            System.out.println("5. Change password");
            System.out.println("6. Log out");

            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    trainSchedule();
                    break;
                case 2:
                    buyticket();
                    break;
                case 3:
                    showMyOrders();
                    break;
                case 4:
                    userInfo();
                    break;
                case 5:
                    changePassword();
                    break;
                case 0:
                    return;
            }
        } while (choose<6);
        System.out.println("Thank you for attetion!");
    }

    private static void changePassword() {
        while (true) {
            System.out.print("Old password: ");
            String password = sc.next();

            if (onlineuser.getPassword().equals(password)) {
                while (true) {
                    System.out.print("New password: ");
                    String newPass = sc.next();

                    System.out.print("Retype new password: ");
                    String passwordRe = sc.next();

                    if (newPass.equals(passwordRe)) {
                        onlineuser.setPassword(newPass);
                        System.out.println("Succesfuly changed!\n");
                        break;
                    }
                }
                break;
            }
        }
    }

    private static void userInfo() {
        System.out.println(onlineuser.getId()+"\t"+
                onlineuser.getLastname()+" "+
                onlineuser.getFirstname()+"\t"+
                onlineuser.getEmail());
        System.out.println();
    }

    private static void showMyOrders() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getTicketNo()+"\t"+
                    ticket.getDepartureStation()+" --- "+
                    ticket.getDestinationStation()+"\t"+
                    ticket.getClassCategory()+"\t"+" class");
        }
    }

    private static void buyticket() {
        System.out.println();
        System.out.print("From: ");
        String stationFrom = sc.next();

        departureTrains(stationFrom);

        System.out.println();
        System.out.print("To: ");
        String stationTo = sc.next();

        for (Ticket ticket : tickets) {
            if (ticket.getDepartureStation().equals(stationFrom)
                    && ticket.getDestinationStation().equals(stationTo)) {
                System.out.println(ticket.getTicketNo()+"\t"+
                        ticket.getDepartureStation()+"\t"+
                        ticket.getDestinationStation()+"\t"+
                        ticket.getClassCategory()+"\t"+" class"+
                        ticket.getPrice()+"\t");
            }
        }

        System.out.println("Do you want to buy? 1 - Yes 2 - No");
        int choose = sc.nextInt();

        for (Ticket ticket : tickets) {
            if (ticket.getDepartureStation().equals(stationFrom)
                    && ticket.getDestinationStation().equals(stationTo)) {
                myOrders.add(ticket);
            }
        }

        System.out.println("This ticket was purshed");
        System.out.println("---------------------------");
    }

    private static void trainSchedule() {
        int choose;
        System.out.print("Choose a station: ");
        String station = sc.next();

        do {
            System.out.println("1 - Arrival 2 - Departure 3 - Exit");

            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    arrivalTrains(station);
                    break;
                case 2:
                    departureTrains(station);
                    break;
                case 3:
                    break;
            }

        } while (choose!=3);
    }

    private static void departureTrains(String station) {
        System.out.println("Depature:");
        System.out.println("-------------------------------------------------");
        for (Ticket ticket : trainSchedule) {
            if (ticket.getDepartureStation().equals(station)){
                System.out.println(ticket.getTrain().getTrainNo()+"\t\t"+
                        ticket.getDepartureStation()+"\t\t"+
                        ticket.getDestinationStation()+"\t\t"+
                        ticket.getClassCategory()+"\t\t"+
                        ticket.getPrice());
            }
        }
        System.out.println("-------------------------------------------------");
    }

    private static void arrivalTrains(String station) {
        System.out.println("Arrivals:");
        System.out.println("--------------------------------");
        for (Ticket ticket : trainSchedule) {
            if (ticket.getDestinationStation().equals(station)){
                System.out.println(ticket.getTrain().getTrainNo()+"\t\t"+
                        ticket.getDestinationStation()+"\t\t"+
                        ticket.getDepartureStation()+"\t\t"+
                        ticket.getClassCategory()+"\t\t"+
                        ticket.getPrice());
            }
        }
        System.out.println("--------------------------------");
    }
}