/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Log;
import DTO.Pet;
import DTO.Services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LogList {

    ArrayList<Log> logs;

    public LogList() {
        logs = new ArrayList<>();
    }

    public boolean addLog(Log log) {
        return logs.add(log);
    }

    public boolean isEmpty() {
        return logs.isEmpty();
    }

    public int takeLenght() {
        return logs.size();
    }

    public Log searchLog(Pet p) {
        for (Log log : logs) {
            if (log.getPet() == p) {
                return log;
            }
        }
        return null;
    }

    public int recordMoney(Pet pet) {
        int recordMoney = 0;
        int count = 0;
        for (int i = 0; i < takeLenght(); i++) {
            if (logs.get(i).getPet().getName().equals(pet.getName())) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("\nThis pet has not used any services yet\n");
        } else {
            for (int i = 0; i < count; i++) {
                recordMoney += logs.get(i).getServices().getPrice();
            }
        }
        return recordMoney;
    }

    public void display(Pet pet) {
        int count = -1;
        int total = 0;
        int[] arraycount = new int[100];
        for (int i = 0; i < takeLenght(); i++) {
            if (logs.get(i).getPet().getName().equals(pet.getName())) {
                count++;
                arraycount[count] = i;
                total += logs.get(i).getServices().getPrice();
            }
        }
        if (count < 0) {
            System.out.println("\nThis pet has not used any services yet\n");
        } else {
            for (int i = 0; i <= count; i++) {
                if (pet.equals(logs.get(arraycount[i]).getPet())) {
                    if (i == 0) {
                        System.out.printf("%-12s %-12s %-12s %s\n", "Pet Name", "Service", "Price", "Total Price");
                        System.out.printf("%-12s %-12s %-12d %d\n", logs.get(arraycount[i]).getPet().getName(), logs.get(arraycount[i]).getServices().getName(), logs.get(arraycount[i]).getServices().getPrice(), total);
                    } else {
                        System.out.printf("%-12s %-12s %d\n", "", logs.get(arraycount[i]).getServices().getName(), logs.get(arraycount[i]).getServices().getPrice());
                    }
                }
            }
        }
    }

    public void displayAll(PetList petList) {
        for (int i = 0; i < petList.takeLenght(); i++) { 
            display(petList.getIdPet(i));
        }
    }

    public boolean removeLog(String namePet, String serviceName) {
        String nameP = namePet.toLowerCase();
        String nameS = serviceName.toLowerCase();
        for (Log log : logs) {
            if (log.getPet().getName().toLowerCase().equals(nameP))
                if (log.getServices().getName().toLowerCase().equals(nameS))
                    return logs.remove(log);
        }
        return false;
    }
}
