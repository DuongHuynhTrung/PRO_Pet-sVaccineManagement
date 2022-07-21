/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Pet;
import List.OwnerList;
import List.PetList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class petMenu {

    public PetList Menu(PetList ds1, OwnerList ownerList) {
        Scanner sc = new Scanner(System.in);
        int choice1 = 0;

        do {
            System.out.println("***********  Pet - Menu  ***********");
            System.out.println("*    1. Add Pet information        *");
            System.out.println("*    2. Display All Pet            *");
            System.out.println("*    3. Display Pet                *");
            System.out.println("*    4. Update Pet                 *");
            System.out.println("*    5. Remove Pet                 *");
            System.out.println("*    6. Exit                       *");
            System.out.println("************************************");
            boolean checkChoice1 = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice1 = Integer.parseInt(sc.nextLine());
                    if (choice1 <= 0 || choice1 > 6) {
                        throw new Exception();
                    }
                    checkChoice1 = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                    checkChoice1 = true;
                }
            } while (checkChoice1);
            System.out.println("");
            switch (choice1) {
                case 1:
                    Pet p = new Pet();
                    p.inputPet();
                    if (ds1.addPet(p)) {
                        System.out.println("Added!\n");
                    } else {
                        System.out.println("Add fail!\n");
                    }
                    break;
                case 2:
                    ds1.displayAll();
                    System.out.println("\nPress Enter to continue!");
                    sc.nextLine();
                    break;
                case 3:
                    if (ds1.isEmpty()) {
                        System.out.println("          Pet's list is Empty!\n");
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
                            System.out.print("--> Input Pet's ID you want to see information: ");
                            idDisplay = sc.nextInt();
                            checkIDDisplay = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!");
                            checkIDDisplay = true;
                        }
                    } while (checkIDDisplay);
                    System.out.println("");
                    ds1.displayPet(idDisplay);
                    System.out.println("\nPress Enter to continue!");
                    sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
                case 4:
                    if (ds1.isEmpty()) {
                        System.out.println("          Pet's list is Empty!\n");
                        System.out.println("Press Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("------------------------------------------------------------");
                    ds1.displayAll();
                    System.out.println("------------------------------------------------------------\n");
                    int idUpdate = 0;
                    boolean checkIdUpdate = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Pet's ID you want to Update: ");
                            idUpdate = sc.nextInt();
                            checkIdUpdate = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdUpdate = true;
                        }
                    } while (checkIdUpdate);
                        
                    if (ds1.updatePet(idUpdate, ownerList)) {
                        System.out.println("\nUpdated!\n");
                    } else {
                        System.out.println("\nUpdate Fail!\n");
                    }
                    break;
                case 5:
                    if (ds1.isEmpty()) {
                        System.out.println("          Pet's list is Empty!\n");
                        System.out.println("Press Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("------------------------------------------------------------");
                    ds1.displayAll();
                    System.out.println("------------------------------------------------------------\n");
                    int idRemove = 0;
                    boolean checkIdRemove = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Pet's ID you want to Remove: ");
                            idRemove = sc.nextInt();
                            checkIdRemove = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdRemove = true;
                        }
                    } while (checkIdRemove);
                    if (ds1.removePet(idRemove)) {
                        System.out.println("\nRemoved!\n");
                    } else {
                        System.out.println("\nRemove fail!\n");
                    }
                    break;
                case 6:
                    System.out.println("\n********Go out of Pet - Menu********\n");
                    break;
            }
        } while (choice1 <= 5);
        return ds1;
    }
    
}
