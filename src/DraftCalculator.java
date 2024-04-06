public class DraftCalculator {

    public double provideEstimate(int totalDebt, double FEE_RATE) {

        //Setting estimate to 60%
        return (totalDebt * 0.6) + (totalDebt*FEE_RATE);
    }


    public double provideMonthlyDraft(double estimate) {

        // Max program length set to 48 months
        double monthlyDraft = estimate / 48;


        return Math.max(monthlyDraft, 250);
    }

    public double provideProgramLength(double monthlyDraft, double estimate){
        return Math.ceil(estimate/monthlyDraft);

    }

}
