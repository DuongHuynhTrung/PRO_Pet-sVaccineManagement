/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Log;
import DTO.Owner;
import List.OwnerList;
import DTO.Pet;
import List.PetList;
import DTO.Services;
import List.LogList;
import List.ServicesList;
import Menu.LogMenu;
import Menu.OwnerMenu;
import Menu.ServicesMenu;
import Menu.petMenu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PetList petList = new PetList();
        OwnerList ownerList = new OwnerList();
        ServicesList servicesList = new ServicesList();
        LogList logList = new LogList();
        int choice = 0;

        do {
            System.out.println("*************  Management - Menu  ***************");
            System.out.println("*    1. Manage Pet list                         *");
            System.out.println("*    2. Manage Owner list                       *");
            System.out.println("*    3. Manage Services list                    *");
            System.out.println("*    4. Set relationship between Pet and Owner  *");
            System.out.println("*    5. Service usage history                   *");
            System.out.println("*    6. Exit                                    *");
            System.out.println("*************************************************");
            boolean checkChoice = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice <= 0 || choice > 6) {
                        throw new Exception();
                    }
                    System.out.println("");
                    checkChoice = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied");
                    System.out.println("Input agian\n");
                    checkChoice = true;
                }
            } while (checkChoice);

            switch (choice) {
                case 1:
                    petMenu pMenu = new petMenu();
                    petList = pMenu.Menu(petList, ownerList);
                    break;
                case 2:
                    OwnerMenu ownerMenu = new OwnerMenu();
                    ownerList = ownerMenu.Menu(ownerList);
                    break;
                case 3:
                    ServicesMenu servicesMenu = new ServicesMenu();
                    servicesList = servicesMenu.Menu(servicesList);
                    break;
                case 4:
                    boolean check = false;
                    if (petList.isEmpty()) {
                        System.out.println("\nPet's list is empty!");
                    } else if (ownerList.isEmpty()) {
                        System.out.println("\nOwner's list is empty");
                    } else {
                        int ownerID = 0;
                        int petID = 0;

                        do {
                            try {
                                System.out.println("\n           ******   Choose an Pet below   ******");
                                System.out.println("------------------------------------------------------------");
                                petList.displayAll();
                                System.out.println("------------------------------------------------------------\n");
                                sc = new Scanner(System.in);
                                System.out.print("--> Input an Pet's Id you want to choose: ");
                                petID = sc.nextInt();
                                if (petList.searchPet(petID) == null)
                                    throw new Exception();
                                if (petID <= 0) 
                                    throw new Exception();
                                check = false;
                            } catch (Exception e) {
                                    System.out.println("\nInput Invalied!");
                                    System.out.println("Input again!");
                                check = true;
                            }
                        } while (check);

                        do {
                            try {
                                System.out.println("\n          ******   Choose an Owner below   ******");
                                System.out.println("---------------------------------------------");
                                ownerList.displayAll();
                                System.out.println("---------------------------------------------\n");
                                sc = new Scanner(System.in);
                                System.out.print("--> Input an Owner's Id you want to choose: ");
                                ownerID = sc.nextInt();
                                if (ownerID <= 0) {
                                    throw new Exception();
                                }
                                if (ownerList.searchOwner(ownerID) == null)
                                    throw new Exception();
                                check = false;
                            } catch (Exception e) {
                                System.out.println("\nInput Invalied!");
                                System.out.println("Input again!");
                                check = true;
                            }
                        } while (check);
                        petList.setOwner(petID, ownerList.searchOwner(ownerID));
                        ownerList.searchOwner(ownerID).setPet(petList.searchPet(petID));
                        System.out.println("Setted!\n");
                    }
                    break;
                case 5:
                    LogMenu logMenu = new LogMenu();
                    logList = logMenu.Menu(logList, servicesList, petList);
                    break;
                case 6:
                    System.out.println("\n               **********GOOD BYE**********");
                    System.out.println("         **********HOPE TO SEE YOU SOON**********\n");
                    break;
            }

        } while (choice <= 5);
    }
}
