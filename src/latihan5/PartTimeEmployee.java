package latihan5;

class PartTimeEmployee extends Employee {
    // Properties
    private double upahPerJam;
    private int jamKerja;

    // Constructor
    public PartTimeEmployee(String name, String employeeId, String department,
                            double upahPerJam, int jamKerja) {
        super(name, employeeId, department);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    // Override calculateSalary
    @Override
    public double calculateSalary() {
        return upahPerJam * jamKerja;
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        return 500000; // Bonus tetap Rp 500,000
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Part-Time Employee");
    }

    // Override generatePayslip untuk info lebih detail
    @Override
    public void generatePayslip() {
        System.out.println("=== PAYSLIP ===");
        System.out.println("Name: " + name);
        System.out.println("Type: Part-Time Employee");
        System.out.println("Hourly Rate: " + EmployeePayrollSystem.formatRupiah(upahPerJam));
        System.out.println("Hours Worked: " + jamKerja + " hours");
        System.out.println("Base Salary: " + EmployeePayrollSystem.formatRupiah(calculateSalary()));
        System.out.println("Bonus: " + EmployeePayrollSystem.formatRupiah(calculateBonus()));
        System.out.println("Total: " + EmployeePayrollSystem.formatRupiah(calculateSalary() + calculateBonus()));
    }
}