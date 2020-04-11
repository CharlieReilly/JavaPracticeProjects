package InterfaceChallenge;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Employee implements ISaveable{

    public long empId;
    public String firstName;
    public String lastName;
    public double salary;
    public String department;

    public Employee(long empId, String firstName, String lastName, double salary, String department) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;

        System.out.println(this);
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public ArrayList valuesToList() throws IllegalAccessException {
        ArrayList<String> values = new ArrayList<>();
        Class<?> classRef = getClass();
        Field[] fields = classRef.getFields();

        for(Field f : fields){
            f.setAccessible(true);
            System.out.println("Adding value " + f.get(this) + " to the ArrayList.");
            values.add(String.valueOf(f.get(this)));
        }

        System.out.println("ArrayList Successfully Created!");
        return values;
    }

    @Override
    public void populateFromList(ArrayList values) {
        this.empId = Long.parseLong((String)values.get(0));
        this.firstName = (String) values.get(1);
        this.lastName = (String) values.get(2);
        this.salary = Double.parseDouble((String)values.get(3));
        this.department = (String) values.get(4);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Employee Name: " + firstName + " " + lastName + "    Id: " + empId + "\n"
                + "Role: " + getClass().getSimpleName() + "\n"
                + "Department: " + department + "\n"
                + "Salary: £" + df.format(salary) + "\n";
    }
}
