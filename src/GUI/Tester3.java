/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Log;
import DTO.Pet;
import DTO.Services;
import List.LogList;
/**
 *
 * @author Admin
 */
public class Tester3 {
    public static void main(String[] args) {
        Pet p = new Pet(1, "Cat", "22/02/2000", "Male", null);
        Services svc = new Services(1, "Cat mong", 3000);
        Pet pet = new Pet(2, "ADog", "22/02/2000", "Male", null);
        Log log1 = new Log(pet, svc);
        Log log = new Log(p, svc);
        LogList logList = new LogList();
        logList.addLog(log);
        logList.addLog(log1);

        //logList.displayAll();
    }
    
}
