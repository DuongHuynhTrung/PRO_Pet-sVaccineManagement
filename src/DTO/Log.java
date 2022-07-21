/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Log {

    Pet pet;
    Services services;

    public Log() {
        pet = null;
        services = null;
    }

    public Log(Pet pet, Services services) {
        this.pet = pet;
        this.services = services;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

}
