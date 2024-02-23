package org.example;

import java.time.LocalDate;
import java.util.List;

public class CostExplorer1 {
    private final MonthlyCostStrategy monthlyCostStrategy;

    public CostExplorer1(MonthlyCostStrategy monthlyCostStrategy) {
        this.monthlyCostStrategy = monthlyCostStrategy;
    }

    public List<Double> getMonthlyCost(PricingPlan pricingPlan, LocalDate subscriptionDate){
        return monthlyCostStrategy.calculateMonthlyCost(pricingPlan, subscriptionDate);
    }

    public double getAnnualCost(PricingPlan pricingPlan, LocalDate subscriptionDate) {
        List<Double> monthlyCost = getMonthlyCost(pricingPlan, subscriptionDate);
        return monthlyCost.stream().mapToDouble(Double::doubleValue).sum();
    }
}
