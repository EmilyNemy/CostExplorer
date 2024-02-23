package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CostExplorer {
    private final LocalDate subscriptionDate;

    public CostExplorer(LocalDate subscriptionDate){
        this.subscriptionDate = subscriptionDate;
    }

    public List<Double> getMonthlyCost(PricingPlan pricingPlan) {
        if (pricingPlan.monthlyCost == 0){
            return List.of(0.0);
        }
        //TODO: WHY YearMonth
        /*
        * It is immutable and thread-safe, allowing for safe concurrent access in multi-threaded environments.
        * It supports various operations such as addition and subtraction of months,
        * comparison with other YearMonth instances, and conversion to LocalDate, Year, or Month.
        * Does not include day and time
        * */
        YearMonth startMonth = YearMonth.from(subscriptionDate);
        YearMonth firstMonth = YearMonth.of(subscriptionDate.getYear(), Month.JANUARY);
        YearMonth endMonth = YearMonth.of(subscriptionDate.getYear(), Month.DECEMBER);

        // TODO: where to store the prices for the month
        List<Double> monthlyCostList = new ArrayList<>();

        // TODO: When we care about where to start from
        for(; !firstMonth.isAfter(endMonth); firstMonth = firstMonth.plusMonths(1)){
            double monthlyCost = (firstMonth.isBefore(startMonth)) ? 0.0 :  pricingPlan.monthlyCost;
            monthlyCostList.add(monthlyCost);
        }
        //TODO: Note - This is for when we do not care where unit year starts from

        //  First get the monthly cost for 12 months only.
//        YearMonth currentMonth = YearMonth.from(subscriptionDate);
//        for(int i = 0; i < 12; i++){
//            double monthly = pricingPlan.monthlyCost;
//            monthlyCostList.add(monthly);
//            currentMonth = currentMonth.plusMonths(1);
//        }

        return monthlyCostList;
    }

// TODO Alternative
public List<Double> calculateMonthlyCost(PricingPlan pricingPlan) {
    List<PricingPlan> pricingPlans = Arrays.asList();
    LocalDate firstMonth = LocalDate.of(subscriptionDate.getYear(), 1, 1);
    LocalDate lastMonth = LocalDate.of(subscriptionDate.getYear(), 12, 31);

    List<Double> monthlyCost = new ArrayList<>();
    for(; !firstMonth.isAfter(lastMonth); firstMonth = firstMonth.plusMonths(1)){
        double cost = (firstMonth.isBefore(subscriptionDate)) ? 0.0 : pricingPlan.monthlyCost;
        monthlyCost.add(cost);
    }

    return monthlyCost;
}

    public double getAnnualCost(PricingPlan pricingPlan) {
        List<Double> monthlyCost = getMonthlyCost(pricingPlan);
        return monthlyCost.stream().mapToDouble(Double::doubleValue).sum();
    }


    // TODO: Use this only if a subscription in the middle of the month reduces cost to only the days of usage
//    private double getPricingPlanCost(LocalDate subscriptionDate, PricingPlan pricingPlan){
//
//        if(subscriptionDate.getDayOfMonth() != 1) {
//        // if we consider the day the subscription was made.
//            int daysInMonth = 30; // or we can use yearMonth.lengthOfMonth();
//            int daysRemaining = daysInMonth - subscriptionDate.getDayOfMonth() + 1;
//            return pricingPlan.monthlyCost * (daysRemaining/ (double) daysInMonth);
//        }
//        return pricingPlan.monthlyCost;
//    }
}
