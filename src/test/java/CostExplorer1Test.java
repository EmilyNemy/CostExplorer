import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CostExplorer1Test {
    @Test
    public void testCalculateMonthlyCost(){
        RegularMonthlyCostStrategy regularMonthlyCostStrategy = new RegularMonthlyCostStrategy();
        CostExplorer1 costExplorer = new CostExplorer1(regularMonthlyCostStrategy);

        List<Double> expectedMonthly = Arrays.asList(9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99,9.99, 9.99, 9.99, 9.99);
        LocalDate localDate = LocalDate.of(2022, 1, 1);
        Assertions.assertEquals(expectedMonthly, costExplorer.getMonthlyCost(PricingPlan.BASIC, localDate));
    }

    @Test
    public void testCalculateTrialPeriodCost(){
        TrialMonthCostStrategy trialMonthCostStrategy = new TrialMonthCostStrategy();
        CostExplorer1 costExplorer1 = new CostExplorer1(trialMonthCostStrategy);

        LocalDate localDate = LocalDate.of(2022, 1, 1);
        Assertions.assertEquals(List.of(0.0), costExplorer1.getMonthlyCost(PricingPlan.TRIAL, localDate));
    }
}
