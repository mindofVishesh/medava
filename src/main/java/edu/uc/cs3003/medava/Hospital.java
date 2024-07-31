package edu.uc.cs3003.medava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Hospital {

    // Declare the private field to store the hospital name
    private String name;

    // Constructor to initialize the hospital name
    public Hospital(String hospitalName) {
        this.name = hospitalName;
    }

    
    void receive(Transporter t) {
        while (!t.isEmpty()) {
            try {
                Object unloaded = t.unload();
                Method getScheduleMethod = unloaded.getClass().getMethod("getSchedule");
                MedicineSchedule getScheduleMethodResult = (MedicineSchedule) getScheduleMethod.invoke(unloaded);
                Method getMedicineNameMethod = unloaded.getClass().getMethod("getMedicineName");
                String getMedicineNameMethodResult = (String) getMedicineNameMethod.invoke(unloaded);
                System.out.println(String.format("Checking whether Hospital can receive %s.", getMedicineNameMethodResult));
                if (getScheduleMethodResult != MedicineSchedule.Uncontrolled) {
                    System.out.println(String.format("Hospital cannot receive controlled substances and %s is a %s.",
                            getMedicineNameMethodResult, getScheduleMethodResult.asString()));
                } else {
                    System.out.println(String.format("Accepted a shipment of %s.", getMedicineNameMethodResult));
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // No need to do anything
            }
        }
    }

    // Getter method to retrieve the hospital name
    public String name() {
        return name;
    }
}