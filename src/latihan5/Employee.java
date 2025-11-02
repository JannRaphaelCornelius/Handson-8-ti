package latihan5;

abstract class Employee { // Dijadikan abstract agar tidak bisa diinstansiasi langsung
    // Properties
    protected String name;
    protected String employeeId;
    protected String department;

    // Constructor
    public Employee(String name, String employeeId, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }

    // Method untuk calculate salary (Abstract method di dunia nyata)
    // Di sini dibuat non-abstract agar bisa dibuat list Employee,
    // namun tetap di-override di subclass.
    public double calculateSalary() {
        return 0; // Default implementation (akan di-override)
    }

    // Method untuk calculate bonus (akan di-override)
    public double calculateBonus() {
        return 0; // Default implementation (akan di-override)
    }

    // Method display info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Department: " + department);
    }

    // Method generate payslip (Latihan 5)
    public void generatePayslip() {
        System.out.println("=== PAYSLIP ===");
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Monthly Salary: " + EmployeePayrollSystem.formatRupiah(calculateSalary()));
        System.out.println("Bonus: " + EmployeePayrollSystem.formatRupiah(calculateBonus()));
        System.out.println("Total Paid: " + EmployeePayrollSystem.formatRupiah(calculateSalary() + calculateBonus()));
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}