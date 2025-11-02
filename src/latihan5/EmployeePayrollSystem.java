package latihan5;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Persiapan untuk format Rupiah
        Locale indonesia = new Locale("in", "ID");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indonesia);

        // List untuk menyimpan semua karyawan (Polymorphism)
        ArrayList<Employee> employees = new ArrayList<>();

        // ===== SETUP EMPLOYEE DATA =====
        System.out.println("=== EMPLOYEE PAYROLL SYSTEM ===\n");

        // Latihan 1: Create employees
        // - Buat FullTimeEmployee
        FullTimeEmployee john = new FullTimeEmployee("John", "FT001", "IT", 8000000, 2000000);
        employees.add(john);

        // - Buat PartTimeEmployee
        PartTimeEmployee sarah = new PartTimeEmployee("Sarah", "PT002", "HR", 50000, 120);
        employees.add(sarah);

        // - Buat ContractEmployee
        ContractEmployee mike = new ContractEmployee("Mike", "CT003", "Marketing", 15000000, 6);
        employees.add(mike);

        System.out.println(employees.size() + " employees created");

        // Latihan 2: Calculate salaries
        System.out.println("\n=== MONTHLY SALARY CALCULATION ===");

        double johnSalary = john.calculateSalary();
        double sarahSalary = sarah.calculateSalary();
        double mikeSalary = mike.calculateSalary();

        // Ekspektasi Output:
        System.out.println(john.getName() + " (Full-Time): " + currencyFormat.format(johnSalary));
        System.out.println(sarah.getName() + " (Part-Time): " + currencyFormat.format(sarahSalary));
        System.out.println(mike.getName() + " (Contract): " + currencyFormat.format(mikeSalary));

        // Latihan 3: Add bonus
        System.out.println("\n=== SALARY WITH BONUS ===");

        double johnTotal = johnSalary + john.calculateBonus();
        double sarahTotal = sarahSalary + sarah.calculateBonus();
        double mikeTotal = mikeSalary + mike.calculateBonus();

        // Ekspektasi Output:
        System.out.println(john.getName() + " total dengan bonus: " + currencyFormat.format(johnTotal));
        System.out.println(sarah.getName() + " total dengan bonus: " + currencyFormat.format(sarahTotal));
        System.out.println(mike.getName() + " total dengan bonus: " + currencyFormat.format(mikeTotal));

        // Latihan 4: Calculate total payroll
        double totalPayroll = 0;
        for (Employee emp : employees) {
            // Penggunaan Polymorphism: Method calculateSalary() dan calculateBonus()
            // yang dipanggil adalah milik subclass masing-masing.
            totalPayroll += emp.calculateSalary() + emp.calculateBonus();
        }

        System.out.println("\n=== PAYROLL SUMMARY ===");
        System.out.println("Total Payroll: " + currencyFormat.format(totalPayroll));

        // Latihan 5: Generate payslip
        System.out.println("\n=== EMPLOYEE PAYSLIPS ===");

        // Generate payslip untuk setiap employee
        john.generatePayslip();
        System.out.println("-------------------------");
        sarah.generatePayslip();
        System.out.println("-------------------------");
        mike.generatePayslip();
    }

    // Helper method untuk format uang
    public static String formatRupiah(double amount) {
        Locale indonesia = new Locale("in", "ID");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(indonesia);
        return currencyFormat.format(amount);
    }
}
