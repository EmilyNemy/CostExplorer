package org.example;

import java.time.LocalDate;
import java.util.List;

public class TrialMonthCostStrategy implements MonthlyCostStrategy{

    @Override
    public List<Double> calculateMonthlyCost(PricingPlan pricingPlan, LocalDate subscriptionDate) {
        return List.of(0.0);
    }
}
