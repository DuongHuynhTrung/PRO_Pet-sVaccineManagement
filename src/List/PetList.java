/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Owner;
import DTO.Pet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class PetList {

    Pet[] list;
    TreeSet<Pet> t;
    int n;

    public PetList() {
        t = new TreeSet<>();
        list = new Pet[100];
        n = 0;
    }

    public boolean addPet(Pet p) {
        list[n] = p;
        n++;
        return t.add(p);
    }

    public Pet getPet(int id) {
        return searchPet(id);
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public int takeLenght() {
        return t.size();
    }

    public Pet searchPet(int id) {
        for (Pet pet : t) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public Pet getIdPet(int index) {
        return list[index];
    }

    public Pet gPet(String name) {
        name = name.toLowerCase();
        for (Pet pet : t) {
            if (pet.getName().toLowerCase().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public void displayAll() {
        if (t.size() == 0) {
            System.out.println("         Pet list is Empty!");
        } else {
            System.out.println("                 All information of Pet: ");
            for (Pet pet : t) {
                pet.OutputPet();
            }
        }

    }

    public void displayPet(int id) {
        Pet p = searchPet(id);
        if (p == null) {
            System.out.println("           Pet doesn't exist!");
        } else {
            System.out.println("                 Information of Pet:");
            p.OutputPet();
        }

    }

    public boolean updatePet(int id, OwnerList ownerList) {
        Pet p = searchPet(id);
        if (p == null) {
            return false;
        }
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int input = 0;
        do {
            try {
                System.out.println("");
                p.OutputPet();
                System.out.println("Which one you want to update: ");
                System.out.println("*************************");
                System.out.println("*    1 - Name           *");
                System.out.println("*    2 - Birthday       *");
                System.out.println("*    3 - Gender         *");
                System.out.println("*    4 - Owner          *");
                System.out.println("*    5 - Exit           *");
                System.out.println("*************************");
                System.out.print("--> Input your choice: ");
                sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input < 1 || input > 5) {
                    throw new Exception();
                }
                switch (input) {
                    case 1:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Pet'name: ");
                                p.setName(sc.nextLine());
                                if (p.getName().equals("")) {
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
                                System.out.print("--> Input new Pet'birthday (dd/MM/yyyy): ");
                                String date = sc.nextLine();
                                if (dateValidation(date)) {
                                    p.setBirthday(date);
                                } else {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("Birthday must follow format!\n");
                                check = true;
                            }
                        } while (check);
                        check = true;
                        break;
                    case 3:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Pet'gender (Male/Female): ");
                                String gender = sc.nextLine();
                                if ((p.getGender().toLowerCase().equals("male")) || p.getGender().toLowerCase().equals("female")) {
                                    p.setGender(gender);
                                } else {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("Gender must follow format!\n");
                                check = true;
                            }
                        } while (check);
                        check = true;
                        break;
                    case 4:
                        String isremove = "";
                        System.out.println("Update Pet's Owner");
                        if (p.getOwner() == null) {
                            System.out.println("\nThis Pet doesn't have Owner!");
                            System.out.println("If you want to set relationship "
                                    + "between this Pet and other Owner \nGo to Number 4 "
                                    + "at Management - Menu\n");
                        } else {
                            System.out.print("Do you want to remove this Pet's Owner?"
                                    + "Y = Yes/ N = No /Other = Change Owner: ");
                            sc = new Scanner(System.in);
                            isremove = sc.nextLine();
                            if (isremove.toLowerCase().equals("y")) {
                                p.setOwner(null);
                                System.out.println("\nRemoved.");
                                System.out.println("If you want to set relationship "
                                        + "between this Pet and other Owner \nGo to Number 4 "
                                        + "at Management - Menu\n");
                            } else if (isremove.toLowerCase().equals("n")) {
                                check = true;
                                break;
                            } else {

                                int idUpdate = 0;
                                boolean checkIdUpdate = false;
                                do {
                                    try {
                                        System.out.println("-----------------------------------------");
                                        ownerList.displayAll();
                                        System.out.println("-----------------------------------------\n");
                                        sc = new Scanner(System.in);
                                        System.out.print("--> Input Owner's ID you want to Update: ");
                                        idUpdate = sc.nextInt();
                                        if (ownerList.searchOwner(idUpdate) == null) {
                                            throw new Exception();
                                        }
                                        checkIdUpdate = false;
                                    } catch (Exception e) {
                                        System.out.println("\nInput Invalied!");
                                        System.out.println("Input again!\n");
                                        checkIdUpdate = true;
                                    }
                                } while (checkIdUpdate);
                                if (p.getOwner() == ownerList.searchOwner(idUpdate)) {
                                    System.out.println("\n          This owner already owns it!");
                                    check = true;
                                    break;
                                }
                                p.setOwner(ownerList.searchOwner(idUpdate));
                                System.out.println("\n        Changed!");
                            }
                        }
                        check = true;
                        break;
                    case 5:
                        check = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nInput Invalied");
                System.out.println("Input again");
                check = true;
            }
        } while (check);
        return true;
    }

    public boolean removePet(int id) {
        Pet p = searchPet(id);
        if (p == null) {
            return false;
        }
        return t.remove(p);
    }

    private boolean dateValidation(String date) {
        boolean valid = false;
        String pattern = "(0?[0-9]|[12][0-9]|3[01])\\/(0?[0-9]|1[0-2])\\/([0-9]{4})";
        if (date.matches(pattern)) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); //Date not to be lenient
            try {
                dateFormat.parse(date);
                valid = true;
            } catch (ParseException e) {
                valid = false;
            }
        }
        return valid;

    }

    public void setOwner(int id, Owner owner) throws Exception {
        Pet p = searchPet(id);
        p.setOwner(owner);
    }
}
