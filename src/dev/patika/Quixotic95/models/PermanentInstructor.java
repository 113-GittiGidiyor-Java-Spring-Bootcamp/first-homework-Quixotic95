package dev.patika.Quixotic95.models;

public class PermanentInstructor extends Instructor {

    private double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
