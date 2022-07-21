/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Owner;
import List.OwnerList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class OwnerMenu {

    public OwnerList Menu(OwnerList ds2) {
        Scanner sc = new Scanner(System.in);
        int choice2 = 0;
        do {
            System.out.println("***********  Owner - Menu  ***********");
            System.out.println("*    1. Add Owner information        *");
            System.out.println("*    2. Display All Owner            *");
            System.out.println("*    3. Display Owner                *");
            System.out.println("*    4. Update Owner                 *");
            System.out.println("*    5. Remove Owner                 *");
            System.out.println("*    6. Exit                         *");
            System.out.println("**************************************");
            boolean checkChoice2 = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice2 = Integer.parseInt(sc.nextLine());
                    if (choice2 <= 0 || choice2 > 6) {
                        throw new Exception();
                    }

                    checkChoice2 = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied");
                    System.out.println("Input again!\n");
                    checkChoice2 = true;
                }
            } while (checkChoice2);
            System.out.println("");
            switch (choice2) {
                case 1:
                    Owner owner = new Owner();
                    owner.inputOwner();
                    if (ds2.addOwner(owner)) {
                        System.out.println("Added!\n");
                    } else {
                        System.out.println("Add fail!\n");
                    }
                    break;
                case 2:
                    ds2.displayAll();
                    System.out.println("\nPress Enter to continue!");
                    sc.nextLine();
                    break;
                case 3:
                    if (ds2.isEmpty()) {
                        System.out.println("          Owner's list is Empty!\n");
                        System.out.println("Press Enter to continue!");
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
                            System.out.println("Input again!");
                            checkIDDisplay = true;
                        }
                    } while (checkIDDisplay);
                    System.out.println("");
                    ds2.displayOwner(idDisplay);
                    System.out.println("\nPress Enter to continue!");
                    sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
                case 4:
                    if (ds2.isEmpty()) {
                        System.out.println("          Owner's list is Empty!\n");
                        System.out.println("Press Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds2.displayAll();
                    System.out.println("-----------------------------------------\n");
                    int idUpdate = 0;
                    boolean checkIdUpdate = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Owner's ID you want to Update: ");
                            idUpdate = sc.nextInt();
                            checkIdUpdate = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdUpdate = true;
                        }
                    } while (checkIdUpdate);

                    if (ds2.updateOwner(idUpdate)) {
                        System.out.println("\nUpdated!\n");
                    } else {
                        System.out.println("\nUpdate Fail!\n");
                    }
                    break;
                case 5:
                    if (ds2.isEmpty()) {
                        System.out.println("          Owner's list is Empty!\n");
                        System.out.println("Press Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds2.displayAll();
                    System.out.println("-----------------------------------------\n");
                    int idRemove = 0;
                    boolean checkIdRemove = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Owner's ID you want to Remove: ");
                            idRemove = sc.nextInt();
                            checkIdRemove = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdRemove = true;
                        }
                    } while (checkIdRemove);
                    if (ds2.removeOwner(idRemove)) {
                        System.out.println("\nRemoved!\n");
                    } else {
                        System.out.println("\nRemove fail!\n");
                    }
                    break;
                case 6:
                    System.out.println("\n********Go out of Owner - Menu********\n");
                    break;
            }
        } while (choice2 <= 5);
        return ds2;
    }
}
