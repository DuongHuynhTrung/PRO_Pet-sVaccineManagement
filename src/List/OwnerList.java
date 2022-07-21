/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Owner;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class OwnerList {

    TreeSet<Owner> t;

    public OwnerList() {
        t = new TreeSet<>();
    }

    public boolean addOwner(Owner own) {
        return t.add(own);
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public int takeLenght() {
        return t.size();
    }

    public Owner searchOwner(int id) {
        for (Owner owner : t) {
            if (owner.getId() == id) {
                return owner;
            }
        }
        return null;
    }

    public boolean removeOwner(int id) {
        Owner own = searchOwner(id);
        if (own == null) {
            return false;
        }
        t.remove(own);
        return true;
    }

    public boolean updateOwner(int id) {
        Owner owner = searchOwner(id);
        if (owner == null) {
            return false;
        }
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        do {
            try {
                System.out.println("");
                owner.outputOwner();
                System.out.println("Which one you want to update: ");
                System.out.println("*************************");
                System.out.println("*    1 - Name           *");
                System.out.println("*    2 - Address        *");
                System.out.println("*    3 - Exit           *");
                System.out.println("*************************");
                System.out.print("--> Input your choice: ");
                sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input < 1 || input > 3) {
                    throw new Exception();
                }
                switch (input) {
                    case 1:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Owner's Name: ");
                                owner.setName(sc.nextLine());
                                if (owner.getName().equals("")) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("Name can not Empty!\n");
                                check = true;
                            }
                        } while (check);
                        check = true;
                        break;
                    case 2:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Owner's Address: ");
                                owner.setAddress(sc.nextLine());
                                if (owner.getAddress().equals("")) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("Address can not Empty!\n");
                                check = true;
                            }
                        } while (check);

                        check = true;
                        break;
                    case 3:
                        check = false;
                        break;

                }
            } catch (Exception e) {
                System.out.println("\nInput Invalied!");
                System.out.println("Input again!");
                check = true;
            }
        } while (check);
        return true;
    }

    public void displayAll() {
        if (t.size() == 0) {
            System.out.println("         Owner list is Empty!");
        } else {
            System.out.println("     All information of Owner: ");
            for (Owner owner : t) {
                owner.outputOwner();
            }
        }

    }

    public void displayOwner(int id) {
        Owner owner = searchOwner(id);
        if (owner == null) {
            System.out.println("            Owner doesn't exist!");
        } else {
            System.out.println("     Information of Owner:");
            owner.outputOwner();
        }
    }
}
