package com.niksviatkin.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgageModelTest {

    @Test
    public void testCalculateMonthlyPayment() {
        MortgageModel model = new MortgageModel(425000, 3.5, 30, "monthly", 416.67, 20000, 100, 125, 50);
        double monthlyPayment = model.calculateMonthlyPayment();
        assertEquals(2511, monthlyPayment, 1);
    }

    @Test
    public void testCalculateTotalRepaymentDuration() {
        MortgageModel model = new MortgageModel(425000, 3.5, 30, "monthly", 416.67, 20000, 100, 125, 50);
        int totalRepaymentDuration = model.calculateTotalRepaymentDuration();
        assertEquals(360, totalRepaymentDuration);
    }

}
