class Creditor extends CreditorEntity {

    private String name;
    private double debtAmount;
    private double settlementPercentage;

    public Creditor(String name, double debtAmount) {
        this.name = name;
        this.debtAmount = debtAmount;

    }

    public double getDebtAmount() {
        return debtAmount;
    }

    public String getName(){
        return name;
    }
}
