package latihan5;
class ContractEmployee extends Employee {
    // Properties
    private double gajiKontrak;
    private int durasiKontrakBulan;

    // Constructor
    public ContractEmployee(String name, String employeeId, String department,
                            double gajiKontrak, int durasiKontrakBulan) {
        super(name, employeeId, department);
        this.gajiKontrak = gajiKontrak;
        this.durasiKontrakBulan = durasiKontrakBulan;
    }

    // Override calculateSalary
    @Override
    public double calculateSalary() {
        return gajiKontrak; // Gaji kontrak dibayar penuh per bulan (asumsi)
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        return 0; // Contract tidak dapat bonus
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Contract Employee");
    }

    // Override generatePayslip untuk info lebih detail
    @Override
    public void generatePayslip() {
        System.out.println("=== PAYSLIP ===");
        System.out.println("Name: " + name);
        System.out.println("Type: Contract Employee");
        System.out.println("Contract Salary: " + EmployeePayrollSystem.formatRupiah(gajiKontrak));
        System.out.println("Contract Duration: " + durasiKontrakBulan + " months");
        System.out.println("Bonus: " + EmployeePayrollSystem.formatRupiah(calculateBonus()));
        System.out.println("Total: " + EmployeePayrollSystem.formatRupiah(calculateSalary() + calculateBonus()));
    }
}
