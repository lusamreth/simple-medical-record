/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package simple.medical.record;

import java.util.Scanner;

import simple.medical.record.services.DoctorService;

// import javax.crypto.spec.PBEKeySpec;

import simple.medical.record.services.LoginService;
import simple.medical.record.services.RegisterService;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void mainHeader() {
        System.out.println("Welcome to simple medical record system!");
        System.out.println("------------------------------------------");
        System.out.println("Main menu:");
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();

        String[] serviceNames = { "register", "login", "doctor-menu", "exit" };
        String[] doctorServiceMenu = { "create", "login" };

        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        boolean isAuth = false;
        while (isRunning) {
            printMenu(serviceNames);
            System.out.print("=> Choice: ");
            int selected = sc.nextInt();
            if (isAuth) {
                System.out.println("-- [[LOGINED]] --");
            }
            switch (selected) {
                case 1:
                    System.out.println("Register selected!");
                    new RegisterService().run();
                    break;
                case 2:
                    System.out.println("Login selected!");
                    LoginService ls = new LoginService();
                    ls.run();
                    Boolean isLogined = ls.getLogin();
                    isAuth = isLogined;
                    break;
                case 3:
                    if (!isAuth) {
                        System.out.println("Must login before creating doctor!");
                        main(args);
                        break;
                    }
                    App.printMenu(doctorServiceMenu);
                    doctorMenuHandler();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid service to select");
                    break;
            }

            if (!isRunning) {
                break;
            }
        }
        sc.close();
    }

    public static void printMenu(String[] serviceNames) {

        for (int i = 0; i < serviceNames.length; i++) {
            String serviceName = serviceNames[i];
            System.out.println(i + 1 + "." + "" + serviceName);
        }
    }

    public static void doctorMenuHandler() {
        Scanner sc = new Scanner(System.in);
        System.out.print("=> Choice: ");
        int selected = sc.nextInt();
        Boolean isAuth = false;
        // Person BindInfo
        switch (selected) {
            case 1:
                System.out.println("create doctor selected!");
                DoctorService ds = new DoctorService();
                ds.run();
                break;
            case 2:
                System.out.println("login selected!");
            default:
                System.out.println("Invalid service to select");
                break;
        }
        sc.close();
    }

}
