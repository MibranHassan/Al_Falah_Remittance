package org.example;

public class EncapsulationClass {
    private int cnic;
    public String first_Name;

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic_No) {
        this.cnic = cnic_No;
    }

    protected void check_protected(){
        System.out.println("This is protected Method");
    }

    public static void main(String[] args) {
        EncapsulationClass private_access = new EncapsulationClass();
        private_access.setCnic(12345);
        private_access.first_Name = "Mibran";
        System.out.println("Private:"+" "+private_access.cnic);
        System.out.println("Public:"+" "+private_access.first_Name);
        private_access.check_protected();

    }
}
