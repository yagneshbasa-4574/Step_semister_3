package week6.assigment_problems;

public class CompanyEmployee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        CompanyEmployee employee1 =
            new CompanyEmployee("Ravi", 50000);

        CompanyEmployee employee2 =
            new CompanyEmployee("Anitha", 60000);

        CompanyEmployee employee3 =
            new CompanyEmployee("Karthik", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}