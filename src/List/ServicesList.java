/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Services;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class ServicesList {

    TreeSet<Services> t;

    public ServicesList() {
        t = new TreeSet<>();
    }

    public boolean addServices(Services svc) {
        return t.add(svc);
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public Services getServices(int id) {
        return searchServices(id);
    }

    public int takeLenght() {
        return t.size();
    }

    public Services searchServices(int id) {
        for (Services services : t) {
            if (services.getId() == id) {
                return services;
            }
        }
        return null;
    }

    public boolean removeServices(int id) {
        Services svc = searchServices(id);
        if (svc == null) {
            return false;
        }
        t.remove(svc);
        return true;
    }

    public boolean updateServies(int id) {
        Services svc = searchServices(id);
        Scanner sc = new Scanner(System.in);
        if (svc == null) {
            return false;
        }
        int input = 0;
        boolean check = false;
        do {
            try {
                System.out.println("");
                svc.outputServices();
                System.out.println("Which one you want to update: ");
                System.out.println("*************************");
                System.out.println("*    1 - Name           *");
                System.out.println("*    2 - Price          *");
                System.out.println("*    3 - Exit           *");
                System.out.println("*************************");
                sc = new Scanner(System.in);
                System.out.print("--> Input your choice: ");
                input = sc.nextInt();
                if (input < 1 || input > 3) {
                    throw new Exception();
                }
                switch (input) {
                    case 1:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Service's Name: ");
                                svc.setName(sc.nextLine());
                                if (svc.getName().equals("")) {
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
                                System.out.print("--> Input new Service's Price: ");
                                svc.setPrice(sc.nextInt());
                                if (svc.getPrice() <= 0) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Price is a number!\n");
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Price is a positive number!\n");
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
            System.out.println("        Services list is Empty!");
        } else {
            System.out.println("     All information of Services: ");
            for (Services services : t) {
                services.outputServices();
            }
        }

    }

    public void displayServices(int id) {
        Services svc = searchServices(id);
        if (svc == null) {
            System.out.println("        Service doesn't exist!");
        } else {
            System.out.println("        Information of Service:");
            svc.outputServices();
        }
    }

}
