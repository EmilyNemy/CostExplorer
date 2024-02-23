package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class RegularMonthlyCostStrategy implements MonthlyCostStrategy{
    @Override
    public List<Double> calculateMonthlyCost(PricingPlan pricingPlan, LocalDate subscriptionDate){
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
            double monthlyCost = (firstMonth.isBefore(YearMonth.from(subscriptionDate))) ? 0.0 :  pricingPlan.monthlyCost;
            monthlyCostList.add(monthlyCost);
        }
        
        return monthlyCostList;
    }
}



//  TODO: Note - This is for when we do not care where unit year starts from
//  First get the monthly cost for 12 months only.
//        YearMonth currentMonth = YearMonth.from(subscriptionDate);
//        for(int i = 0; i < 12; i++){
//            double monthly = pricingPlan.monthlyCost;
//            monthlyCostList.add(monthly);
//            currentMonth = currentMonth.plusMonths(1);
//        }