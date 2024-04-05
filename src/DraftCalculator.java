public class DraftCalculator {

    public double provideEstimate(int totalDebt, double FEE_RATE) {

        //Setting estimate to 60%
        return (totalDebt * 0.6) + (totalDebt+FEE_RATE);
    }


    public int provideMonthlyDraft(int estimate) {

        // Max program length set to 48 months
        int monthlyDraft = estimate / 48;


        return Math.max(monthlyDraft, 250);
    }


}
