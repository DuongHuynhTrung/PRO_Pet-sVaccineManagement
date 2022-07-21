/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Storage;

import DTO.Pet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Petlist {
    ArrayList<Pet> list;
    public Petlist(){
        list = new ArrayList<>();
    }
    
    public boolean addPet(Pet p){
        return list.add(p);
    }
    
    public void displayALl(){
        //Cach 1
//        for (int i = 0; i < list.size(); i++){
//            list.get(i).outputPet();
//        }
//        
        //Cach 2
        for (Pet p : list) {
            p.OutputPet();     }
    }
    
    public int findPet(int id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id)
                return i;
            }
        return -1;
    }
    
    public Pet searchPet(int id){
        for (Pet p : list) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
    
    public boolean updatePet(int id) throws Exception{
        Pet p = searchPet(id);
        Scanner sc = new Scanner(System.in);
        if (p == null) return false;
            System.out.println("Input new Name:");
            p.setName(sc.nextLine());
            System.out.println("Input new gender: ");
            p.setGender(sc.nextLine());
            System.out.println("Input new Birthday: ");
            p.setBirthday(sc.nextLine());
        return true;
        
//        int i = findPet(id);
//        if (i == -1) return false;
//        Pet newpet = new Pet();
//        newpet.inputPet();
//        list.set(id, newpet);
//        return true;
    }
    
//    public boolean removePet(int id){
//        Pet p = seachPet(id);
//        return list.remove(p);
//     }
    public void sortById(){
        Collections.sort(list);
        
    }
}
