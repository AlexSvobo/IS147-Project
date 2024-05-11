/**
 * Represents a specific type of creditor extending CreditorEntity.
 */
public class Creditor extends CreditorEntity {
    private final double debtAmount;

    /**
     * Constructor for Creditor.
     *
     * @param name       The name of the creditor.
     * @param debtAmount The amount of debt for the creditor.
     */
    public Creditor(String name, double debtAmount) {
        super(name);
        this.debtAmount = debtAmount;

    }

    /**
     * Get the debt amount of the creditor.
     *
     * @return The debt amount of the creditor.
     */
    public double getDebtAmount() {
        return debtAmount;
    }
}
