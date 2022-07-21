/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Services;
import List.ServicesList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ServicesMenu {

    public ServicesList Menu(ServicesList ds3) {
       
        Scanner sc = new Scanner(System.in);
        int choice3 = 0;
        do {
            System.out.println("*********  Services - Menu  *********");
            System.out.println("*    1. Add Services                *");
            System.out.println("*    2. Display All Services        *");
            System.out.println("*    3. Display Service             *");
            System.out.println("*    4. Update Services             *");
            System.out.println("*    5. Remove Services             *");
            System.out.println("*    6. Exit                        *");
            System.out.println("*************************************");
            boolean checkChoice3 = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice3 = Integer.parseInt(sc.nextLine());
                    if (choice3 <= 0 || choice3 > 6) {
                        throw new Exception();
                    }
                    checkChoice3 = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                    checkChoice3 = true;
                }
            } while (checkChoice3);
            System.out.println("");
            switch (choice3) {
                case 1:
                    Services svc = new Services();
                    svc.inputServices();
                    if (ds3.addServices(svc)) {
                        System.out.println("Added!\n");
                    } else {
                        System.out.println("Add fail!\n");
                    }
                    break;
                case 2:
                    ds3.displayAll();
                    System.out.println("\nPress Enter to continue!");
                    sc.nextLine();
                    break;
                case 3:
                    if (ds3.isEmpty()) {
                        System.out.println("          Services list is Empty!");
                        System.out.println("\nPress Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    int idDisplay = 0;
                    boolean checkIDDisplay = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Owner's ID you want to see information: ");
                            idDisplay = sc.nextInt();
                            checkIDDisplay = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIDDisplay = true;
                        }
                    } while (checkIDDisplay);
                    System.out.println("");
                    ds3.displayServices(idDisplay);
                    System.out.println("\nPress Enter to continue!");
                    sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
                case 4:
                    if (ds3.isEmpty()) {
                        System.out.println("          Services list is Empty!");
                        System.out.println("\nPress Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds3.displayAll();
                    System.out.println("-----------------------------------------\n");
                    int idUpdate = 0;
                    boolean checkIdUpdate = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Services's ID you want to update: ");
                            idUpdate = sc.nextInt();
                            checkIdUpdate = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdUpdate = true;
                        }
                    } while (checkIdUpdate);

                    if (ds3.updateServies(idUpdate)) {
                        System.out.println("\nUpdated!\n");
                    } else {
                        System.out.println("\nUpdate Fail!\n");
                    }
                    break;
                case 5:
                    if (ds3.isEmpty()) {
                        System.out.println("          Services list is Empty!");
                        System.out.println("\nPress Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds3.displayAll();
                    System.out.println("-----------------------------------------\n");
                    int idRemove = 0;
                    boolean checkIdRemove = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Services's ID you want to Remove: ");
                            idRemove = sc.nextInt();
                            checkIdRemove = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdRemove = true;
                        }
                    } while (checkIdRemove);
                    if (ds3.removeServices(idRemove)) {
                        System.out.println("\nRemoved!\n");
                    } else {
                        System.out.println("\nRemove fail!\n");
                    }
                    break;
                case 6:
                    System.out.println("\n********Go out of Services - Menu********\n");
                    break;
            }
        } while (choice3 <= 5);
        return ds3;
    }
}
