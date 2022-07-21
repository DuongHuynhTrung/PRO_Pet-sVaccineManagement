/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Owner implements Comparable<Owner> {

    private int id;
    private String name;
    private String address;
    private Pet pet;

    public Owner() {
    }

    public Owner(int id, String name, String address, Pet pet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (!name.equals("")) {
            this.name = name;
        } else {
            throw new Exception();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (!address.equals("")) {
            this.address = address;
        } else {
            throw new Exception();
        }
    }

    public void inputOwner() {
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Owner's ID: ");
                id = sc.nextInt();
                if (id <= 0) {
                    throw new Exception();
                }
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("ID is a number!\n");
                check = true;
            } catch (Exception e) {
                System.out.println("ID is a positive number!\n");
                check = true;
            }
        } while (check);

        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Owner's Name: ");
                name = sc.nextLine();
                if (name.equals("")) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Name can not Empty!\n");
                check = true;
            }
        } while (check);

        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Owner's Address: ");
                address = sc.nextLine();
                if (address.equals("")) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Address can not Empty!\n");
                check = true;
            }
        } while (check);

    }

    public void outputOwner() {
        if (pet == null) {
            System.out.printf("%-10s %-15s %-14s %s\n", "ID", "Name", "Address", "Own Pet");
            System.out.printf("%-10s %-15s %-14s %s\n", getId(), getName(), getAddress(), "?");
        } else {
            System.out.printf("%-10s %-15s %-14s %s\n", "ID", "Name", "Address", "Own Pet");
            System.out.printf("%-10s %-15s %-14s %s\n", getId(), getName(), getAddress(), getPet().getName());
        }

    }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }

    @Override
    public int compareTo(Owner o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
