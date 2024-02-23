import org.example.CostExplorer;
import org.example.PricingPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CostExplorerTest {
    @Test
    public void testCalculateMonthlyCost(){
        LocalDate subscriptionDate = LocalDate.of(2022, 1,1);
        CostExplorer costExplorer = new CostExplorer(subscriptionDate);

        List<Double> expectedMonthly = Arrays.asList(9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99,9.99, 9.99, 9.99, 9.99);
        Assertions.assertEquals(expectedMonthly, costExplorer.getMonthlyCost(PricingPlan.BASIC));
    }

    @Test
    public void testCalculateMonthlyCostFromMiddleOfYear(){
        LocalDate subscriptionDate = LocalDate.of(2022, 2,1);
        CostExplorer costExplorer = new CostExplorer(subscriptionDate);

        List<Double> monthlyCost = Arrays.asList(0.0, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99,9.99, 9.99, 9.99, 9.99);
        Assertions.assertEquals(monthlyCost, costExplorer.getMonthlyCost(PricingPlan.BASIC));
    }

//    @Test
//    public void testMiddleMonthCostIsForOnlyForRemainingDays(){
//        LocalDate subscriptionDate = LocalDate.of(2022, 3, 15);
//        org.example.CostExplorer costExplorer = new org.example.CostExplorer(subscriptionDate);
//
//        List<Double> monthlyCost = Arrays.asList(0.0, 0.0, 3.32, 9.99, 9.99, 9.99, 9.99, 9.99,9.99, 9.99, 9.99, 9.99);
//        Assertions.assertEquals(monthlyCost, costExplorer.getMonthlyCost(org.example.PricingPlan.BASIC));
//    }

    @Test
    public void testCalculateAnnualCost(){
        LocalDate subscriptionDate = LocalDate.of(2022, 1, 1);
        CostExplorer costExplorer = new CostExplorer(subscriptionDate);

        double expectedAnnualCost = 119.88;
        Assertions.assertEquals(expectedAnnualCost, costExplorer.getAnnualCost(PricingPlan.BASIC));
    }

    @Test
    public void testCalculateAnnualCostWithSubscriptionInMiddleOfYear(){
        LocalDate subscriptionDate = LocalDate.of(2022, 5, 1);
        CostExplorer costExplorer = new CostExplorer(subscriptionDate);

        double expectedAnnualCost = 79.92;
        Assertions.assertEquals(expectedAnnualCost, costExplorer.getAnnualCost(PricingPlan.BASIC));
    }

    @Test
    public void testCalculateCostForTrial(){
        LocalDate subscriptionDate = LocalDate.of(2022, 1,1);
        CostExplorer costExplorer = new CostExplorer(subscriptionDate);

        Assertions.assertEquals(List.of(0.0), costExplorer.getMonthlyCost(PricingPlan.TRIAL));
    }
}
