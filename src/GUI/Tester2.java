/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import List.LogList;
import DTO.Owner;
import List.OwnerList;
import DTO.Pet;
import List.PetList;
import List.ServicesList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Tester2 {

    public static void main(String[] args) throws Exception {
        PetList obj = new PetList();
        OwnerList obj2 = new OwnerList();
        ServicesList obj3 = new ServicesList();
        LogList obj4 = new LogList();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quan li danh sach Pet");
            System.out.println("1. Add a pet");
            System.out.println("2. Display all pet");
            System.out.println("3. Update Pet");
            System.out.println("4. Remove Pet");
            System.out.println("Input choice:  ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Pet p = new Pet();

                    p.inputPet();

                    if (obj.addPet(p)) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Add fail");
                    }
                    break;
                case 2:
                    obj.displayAll();
                    break;
                case 3:
                    int idUpdate;
                    System.out.println("Input IdUpdate:");
                    idUpdate = sc.nextInt();
                    if (obj.updatePet(idUpdate, obj2)) {
                        System.out.println("Updated");
                    } else {
                        System.out.println("Update fail");
                    }
                    break;
                case 4:
                    int idRemove;
                    System.out.println("Input idRemove");
                    idRemove = sc.nextInt();
                    if (obj.removePet(idRemove)) {
                        System.out.println("Removed");
                    } else {
                        System.out.println("Remove fail");
                    }
                    break;
            }
        } while (choice <= 4);
        //Lam tuong tu tren cho OwnerList
        int ans = 0;
        do {
            System.out.println("Thong tin Pet and Owner");
            System.out.println("Input Pet's id: ");
            int idPet = sc.nextInt();
            System.out.println("Input Owner's Id: ");
            int ownerId = sc.nextInt();
            Pet p = obj.searchPet(idPet);
            Owner owner = obj2.searchOwner(ownerId);
            p.setOwner(owner);
            System.out.println("Muon lam tiep tuc (1/0): ");
            ans = sc.nextInt();
        } while (ans == 1);
        //....ServicesList
        //Lam tuong tu tren cho LogList

    }
}
