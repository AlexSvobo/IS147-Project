public class DraftCalculator {

    /**
     * Calculates the estimate including fees based on total debt and fee rate.
     *
     * @param totalDebt The total debt amount.
     * @param FEE_RATE  The fee rate as a decimal (e.g., 0.25 for 25%).
     * @return The estimated amount including fees.
     */
    public double provideEstimate(int totalDebt, double FEE_RATE) {

        //Setting estimate to 60%
        return (totalDebt * 0.6) + (totalDebt*FEE_RATE);
    }

    /**
     * Calculates the monthly draft amount based on the estimate.
     *
     * @param estimate The estimated amount including fees.
     * @return The monthly draft amount.
     */
    public double provideMonthlyDraft(double estimate) {

        // Max program length set to 48 months
        double monthlyDraft = estimate / 48;


        return Math.max(monthlyDraft, 250);
    }

    /**
     * Calculates the program length based on the monthly draft and estimate.
     *
     * @param monthlyDraft The monthly draft amount.
     * @param estimate     The estimated amount including fees.
     * @return The program length in months.
     */
    public double provideProgramLength(double monthlyDraft, double estimate){
        return Math.ceil(estimate/monthlyDraft);

    }

}
