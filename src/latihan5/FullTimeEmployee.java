package latihan5;

class FullTimeEmployee extends Employee {
    // Properties
    private double gajiPokok;
    private double tunjangan;

    // Constructor
    public FullTimeEmployee(String name, String employeeId, String department,
                            double gajiPokok, double tunjangan) {
        super(name, employeeId, department);
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
    }

    // Override calculateSalary
    @Override
    public double calculateSalary() {
        return gajiPokok + tunjangan;
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        return gajiPokok * 0.10; // 10% dari gaji pokok
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Full-Time Employee");
    }

    // Override generatePayslip untuk info lebih detail
    @Override
    public void generatePayslip() {
        System.out.println("=== PAYSLIP ===");
        System.out.println("Name: " + name);
        System.out.println("Type: Full-Time Employee");
        System.out.println("Base Salary: " + EmployeePayrollSystem.formatRupiah(gajiPokok));
        System.out.println("Allowance: " + EmployeePayrollSystem.formatRupiah(tunjangan));
        System.out.println("Bonus: " + EmployeePayrollSystem.formatRupiah(calculateBonus()));
        System.out.println("Total: " + EmployeePayrollSystem.formatRupiah(calculateSalary() + calculateBonus()));
    }
}
