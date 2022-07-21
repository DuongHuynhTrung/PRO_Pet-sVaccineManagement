/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Pet implements Comparable<Pet> {

    private int id;
    private String name;
    private String birthday;
    private String gender;
    private Owner owner;

    public Pet() {
        id = 0;
        name = "";
        birthday = "";
        gender = "";
        owner = null;
    }

    public Pet(int id, String name, String birthday, String gender, Owner owner) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
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
        if (!(name.equals(""))) {
            this.name = name;
        } else {
            throw new Exception();
        }
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws Exception {
        if (gender.toUpperCase().equals("MALE") || gender.toUpperCase().equals("FEMALE")) {
            this.gender = gender;
        } else {
            throw new Exception();
        }
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void inputPet() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Pet'id: ");
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
                System.out.print("--> Input Pet'name: ");
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
                System.out.print("--> Input Pet'birthday (dd/MM/yyyy): ");
                String date = sc.nextLine();
                if (dateValidation(date)) {
                    birthday = date;
                } else {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Birthday must follow format!\n");
                check = true;
            }
        } while (check);

        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Pet'gender (Male/Female): ");
                gender = sc.nextLine();
                if ((gender.toLowerCase().equals("male")) || gender.toLowerCase().equals("female")) {
                    setGender(gender);
                } else {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Gender must follow format!\n");
                check = true;
            }
        } while (check);
        
    }

    public void OutputPet() {
        if (owner == null) {
            System.out.printf("%-10s %-15s %-13s %-12s %s\n", "ID", "Name", "Birthday", "Gender", "Owner");
            System.out.printf("%-10d %-15s %-13s %-12s %s\n", getId(), getName(), getBirthday(), getGender(), "Empty!");
        } else {
            System.out.printf("%-10s %-15s %-13s %-12s %s\n", "ID", "Name", "Birthday", "Gender", "Owner");
            System.out.printf("%-10d %-15s %-13s %-12s %s\n", getId(), getName(), getBirthday(), getGender(), owner.getName());
        }

    }

    @Override
    public int compareTo(Pet o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
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
}
