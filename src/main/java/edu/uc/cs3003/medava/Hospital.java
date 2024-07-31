package edu.uc.cs3003.medava;

public class Hospital {

    // Declare the private field to store the hospital name
    private String name;

    // Constructor to initialize the hospital name
    public Hospital(String hospitalName) {
        this.name = hospitalName;
    }

    // Method to receive medicines from the transporter
    void receive(Transporter t) {
        while (!t.isEmpty()) {
            Medicine unloaded = t.unload();
            System.out.println(String.format("Receiving %s off the %s transporter.", unloaded.getMedicineName(), t.getTransporterName()));
        }
    }

    // Getter method to retrieve the hospital name
    public String name() {
        return name;
    }
}