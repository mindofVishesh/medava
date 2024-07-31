package edu.uc.cs3003.medava;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Transporter {

    // Declare the private fields to store the transporter name and temperature ranges
    private String mTransporterName;
    private double mLowTemperature, mHighTemperature;

    private List<Object> goods;

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

        public boolean load(Object itemToLoad) {
        try {
            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
                    Double.class, Double.class);
            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
            if (resultOfMethodCall) {
                goods.add(itemToLoad);
            }
            return resultOfMethodCall;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            return false;
        }
    }

    public Object unload() {
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