package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;


public interface MonthlyCostStrategy {
    List<Double> calculateMonthlyCost(PricingPlan pricingPlan, LocalDate subscriptionDate);
}
