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
public class Services implements Comparable<Services> {

    private int id;
    private String name;
    private int price;

    public Services() {
        id = 0;
        name = "";
        price = 0;
    }

    public Services(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if (price >= 0) {
            this.price = price;
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

    public void inputServices() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Service's ID: ");
                id = sc.nextInt();
                if (id <= 0) {
                    throw new Exception();
                }
                check = false;
            } catch (InputMismatchException e){
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
                System.out.print("--> Input Service's Name: ");
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
                System.out.print("--> Input Service's Price: ");
                price = sc.nextInt();
                if (price <= 0) {
                    throw new Exception();
                }
                check = false;
            } catch (InputMismatchException e){
                System.out.println("Price is a number!\n");
                check = true;
            } catch (Exception e) {
                System.out.println("Price is a positive number!\n");
                check = true;
            }
        } while (check);

    }

    public void outputServices() {
        System.out.printf("%-10s %-15s %-13s\n", "ID", "Name", "Price");
        System.out.printf("%-10d %-15s %d\n", getId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Services{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Services o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }

}
