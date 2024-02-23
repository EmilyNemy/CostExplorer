package org.example;

public enum PricingPlan {
    TRIAL(0),BASIC(9.99), STANDARD(49.99), PREMIUM(249.99);

    final double monthlyCost;

    PricingPlan(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }

}
