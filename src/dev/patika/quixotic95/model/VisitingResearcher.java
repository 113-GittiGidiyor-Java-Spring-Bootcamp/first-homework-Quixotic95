package dev.patika.quixotic95.model;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {

    private double hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", [VisitingResearcher{" +
                    "hourlySalary=" + hourlySalary +
                    "}]" +
                '}';
    }
}
