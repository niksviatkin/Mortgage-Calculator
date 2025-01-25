package com.niksviatkin.controller;

import com.niksviatkin.model.MortgageModel;
import com.niksviatkin.view.MortgageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

public class MortgageController {
    private MortgageModel model;
    private MortgageView view;

    public MortgageController(MortgageView view) {
        this.view = view;

        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double loanAmount = parseDouble(view.getLoanAmount(), "Loan Amount");
                double interestRate = parseDouble(view.getInterestRate(), "Interest Rate");
                int terms = parseInt(view.getNumberOfTerms(), "Number of Terms");
                String compoundingInterval = view.getCompoundingInterval();
                double propertyTaxPerMonth = parseDoubleOrDefault(view.getPropertyTax(), 0);
                double downPayment = parseDoubleOrDefault(view.getDownPayment(), 0);
                double homeownersInsurancePerMonth = parseDoubleOrDefault(view.getHomeownersInsurance(), 0);
                double pmiPerMonth = parseDoubleOrDefault(view.getPMI(), 0);
                double hoaFeesPerMonth = parseDoubleOrDefault(view.getHOAFees(), 0);

                model = new MortgageModel(loanAmount, interestRate, terms, compoundingInterval, propertyTaxPerMonth, downPayment, homeownersInsurancePerMonth, pmiPerMonth, hoaFeesPerMonth);

                double monthlyPayment = model.calculateMonthlyPayment();
                int totalRepaymentDuration = model.calculateTotalRepaymentDuration();

                view.setResult(String.format("Monthly Payment: %.2f\nTotal Repayment Duration: %d months", monthlyPayment, totalRepaymentDuration));
            } catch (NumberFormatException | ParseException ex) {
                view.showError("Invalid input. Please enter valid numbers.");
            } catch (IllegalArgumentException ex) {
                view.showError(ex.getMessage());
            } catch (Exception ex) {
                view.showError("An unexpected error occurred: " + ex.getMessage());
            }
        }

        private double parseDouble(String value, String fieldName) throws ParseException {
            if (value.isEmpty()) {
                throw new IllegalArgumentException("The field " + fieldName + " cannot be empty.");
            }
            try {
                Number number = NumberFormat.getNumberInstance(java.util.Locale.US).parse(value);
                return number.doubleValue();
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid input for " + fieldName + ". Please enter a valid number.");
            }
        }

        private int parseInt(String value, String fieldName) {
            if (value.isEmpty()) {
                throw new IllegalArgumentException("The field " + fieldName + " cannot be empty.");
            }
            try {
                return Integer.parseInt(value.replace(",", ""));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input for " + fieldName + ". Please enter a valid integer.");
            }
        }

        private double parseDoubleOrDefault(String value, double defaultValue) {
            if (value.isEmpty()) {
                return defaultValue;
            }
            try {
                Number number = NumberFormat.getNumberInstance(java.util.Locale.US).parse(value);
                return number.doubleValue();
            } catch (ParseException e) {
                return defaultValue;
            }
        }
    }
}