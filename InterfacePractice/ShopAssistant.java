package InterfaceChallenge;

import java.util.ArrayList;

public class ShopAssistant extends Employee{

    public ShopAssistant(long empId, String firstName, String lastName, double salary, String department) {
        super(empId, firstName, lastName, salary, department);
    }

    @Override
    public ArrayList valuesToList() throws IllegalAccessException {
        return super.valuesToList();
    }

    @Override
    public void populateFromList(ArrayList values) {
        super.populateFromList(values);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
