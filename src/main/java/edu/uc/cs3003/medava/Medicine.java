package edu.uc.cs3003.medava;

public abstract class Medicine {

    // Declare the private field to store the medicine name
    private String mMedicineName;

    public abstract MedicineSchedule getSchedule();

    // Constructor that takes a single parameter (the name of the medicine)
    public Medicine(String medicineName) {
        this.mMedicineName = medicineName;
    }

    // Getter method to retrieve the name of the medicine
    public String getMedicineName() {
        return mMedicineName;
    }

    // Method to check if the temperature range is acceptable
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        if (this.minimumTemperature() <= lowTemperature &&
                highTemperature <= this.maximumTemperature()) {
            return true;
        }
        return false;
    }

    // Default implementation of minimum temperature method
    public double minimumTemperature() {
        return 0.0;
    }

    // Default implementation of maximum temperature method
    public double maximumTemperature() {
        return 100.0;
    }
}