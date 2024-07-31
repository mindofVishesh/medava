package edu.uc.cs3003.medava;

import java.util.List;
import java.util.ArrayList;

public class Transporter {

    // Declare the private fields to store the transporter name and temperature ranges
    private String mTransporterName;
    private double mLowTemperature, mHighTemperature;

    // Declare the goods field to store the list of medicines
    private List<Medicine> goods;

    // Constructor to initialize the transporter name and temperature ranges
    public Transporter(String transporterName, double lowTemp, double highTemp) {
        this.mTransporterName = transporterName;
        this.mLowTemperature = lowTemp;
        this.mHighTemperature = highTemp;
        this.goods = new ArrayList<>();
    }

    // Getter method to retrieve the name of the transporter
    public String getTransporterName() {
        return mTransporterName;
    }

    // Method to load a medicine into the transporter if temperature range is acceptable
    public boolean load(Medicine itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            System.out.println(String.format("Adding a %s to the transporter.", itemToLoad.getMedicineName()));
            goods.add(itemToLoad);
            return true;
        }
        return false;
    }

    // Method to unload a medicine from the transporter
    public Medicine unload() {
        return goods.remove(0);
    }

    // Method to check if the transporter is empty
    public boolean isEmpty() {
        return goods.isEmpty();
    }

    // Method to simulate the shipping of goods
    public void ship() {
        // Do some shipping!
        System.out.println("Shipping " + goods.size() + " items.");
    }
}