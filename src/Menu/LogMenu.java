/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Log;
import List.LogList;
import List.PetList;
import List.ServicesList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LogMenu {

    public LogList Menu(LogList list, ServicesList serviceslist, PetList petlist) {
        int choice = 0;
        boolean check = false;
        boolean isContinue = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***********   UsingServices - Menu   ************");
            System.out.println("*   1 - Using Services                          *");
            System.out.println("*   2 - Service usage history of specify Pet    *");
            System.out.println("*   3 - Service usage history of all Pet        *");
            System.out.println("*   4 - Cancel service                          *");
            System.out.println("*   5 - Back to Management - Menu               *");
            System.out.println("*************************************************\n");
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 5) {
                        throw new Exception();
                    }
                    check = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                    check = true;
                }
            } while (check);

            System.out.println("");
            switch (choice) {
                case 1: {
                    int ServiceID = 0;
                    int petID = 0;
                    if (petlist.isEmpty()) {
                        System.out.println("\nPet's list is Empty!");
                    } else if (serviceslist.isEmpty()) {
                        System.out.println("\nServices's list is Empty!");
                    } else {
                        do {
                            try {
                                System.out.println("---------------------------------------------");
                                petlist.displayAll();
                                System.out.println("---------------------------------------------\n");
                                sc = new Scanner(System.in);
                                System.out.print("--> Input an Pet's ID you want to choose: ");
                                petID = sc.nextInt();
                                if (petlist.searchPet(petID) == null) {
                                    throw new Exception();
                                }
                                if (petID <= 0) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("\nInput Invalied!");
                                System.out.println("Input again!\n");
                                check = true;
                            }
                        } while (check);

                        do {
                            try {
                                System.out.println("\n   ******   Choose an Services below   ******");
                                System.out.println("---------------------------------------------");
                                serviceslist.displayAll();
                                System.out.println("---------------------------------------------\n");
                                sc = new Scanner(System.in);
                                System.out.print("--> Input an Service's ID you want to choose: ");
                                ServiceID = sc.nextInt();
                                if (serviceslist.searchServices(ServiceID) == null) {
                                    throw new Exception();
                                }
                                if (ServiceID <= 0) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("\nInput Invalied!");
                                System.out.println("Input again!\n");
                                check = true;
                            }
                        } while (check);

                        Log log = new Log(petlist.getPet(petID), serviceslist.getServices(ServiceID));
                        if (list.addLog(log)) {
                            System.out.println("\nUsed!\n");
                        }
                        check = true;
                        break;
                    }
                }
                case 2: {
                    if (list.isEmpty()) {
                        System.out.println("No service used!\n");
                    } else {
                        int petID = 0;
                        do {
                            try {
                                System.out.println("---------------------------------------------");
                                petlist.displayAll();
                                System.out.println("---------------------------------------------");
                                sc = new Scanner(System.in);
                                System.out.print("--> Input an Pet's Id you want to choose: ");
                                petID = sc.nextInt();
                                sc.nextLine();
                                if (petlist.searchPet(petID) == null) {
                                    throw new Exception();
                                }
                                if (petID <= 0) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("\nInput Invalied!");
                                System.out.println("Input again!\n");
                                check = true;
                            }
                        } while (check);
                        System.out.println("\n  All information about using Services of Pet");
                        list.display(petlist.getPet(petID));
                        sc.nextLine();
                    }
                    check = true;
                    break;
                }
                case 3:
                    if (list.isEmpty() || petlist.isEmpty() || serviceslist.isEmpty()) {
                        System.out.println("No service used!\n");
                    } else {
                        System.out.println("  All information about using Services of all Pet:");
                        list.displayAll(petlist);
                        sc = new Scanner(System.in);
                        System.out.println("\nPress Enter to continue!");
                        sc.nextLine();
                    }
                    check = true;
                    break;
                case 4:
                    String serviceName = "";
                    String petName = "";
                    if (list.isEmpty() || petlist.isEmpty() || serviceslist.isEmpty()) {
                        System.out.println("No service used!\n");
                        check = true;
                        break;
                    } else {
                        check = false;
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.println("  All information about using Services of all Pet:");
                                list.displayAll(petlist);
                                System.out.print("--> Input Pet's Name you want to remove: ");
                                petName = sc.nextLine();
                                if (petName.equals("")) {
                                    throw new Exception();
                                }
                                list.display(petlist.gPet(petName));
                                System.out.print("\n--> Input Service's Name you want to remove: ");
                                sc = new Scanner(System.in);
                                serviceName = sc.nextLine();
                                if (serviceName.equals("")) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("\nInput Invalied!");
                                System.out.println("Input again!\n");
                                check = true;
                            }
                        } while (check);
                        if (list.removeLog(petName, serviceName)) {
                            System.out.println("\n Removed! \n");
                        } else {
                            System.out.println("\n Remove failed! \n");
                        }
                        check = true;
                        break;
                    }
                case 5:
                    System.out.println("\n********Go out of UsingService - Menu********\n");
                    System.out.println("");
                    check = false;
            }
        } while (choice <= 4);
        return list;
    }
}
