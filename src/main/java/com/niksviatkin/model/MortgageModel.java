package com.niksviatkin.model;

public class MortgageModel {
    private double loanAmount;
    private double annualInterestRate;
    private int numberOfTerms;
    private String compoundingInterval;
    private double propertyTaxPerMonth;
    private double downPayment;
    private double homeownersInsurancePerMonth;
    private double pmiPerMonth;
    private double hoaFeesPerMonth;

    public MortgageModel(double loanAmount, double annualInterestRate, int numberOfTerms, String compoundingInterval, double propertyTaxPerMonth, double downPayment, double homeownersInsurancePerMonth, double pmiPerMonth, double hoaFeesPerMonth) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfTerms = numberOfTerms;
        this.compoundingInterval = compoundingInterval;
        this.propertyTaxPerMonth = propertyTaxPerMonth;
        this.downPayment = downPayment;
        this.homeownersInsurancePerMonth = homeownersInsurancePerMonth;
        this.pmiPerMonth = pmiPerMonth;
        this.hoaFeesPerMonth = hoaFeesPerMonth;
    }

    public double calculateMonthlyPayment() {
        double rate = annualInterestRate / 100;
        int n = getCompoundingFrequency();
        double compoundedRate = Math.pow(1 + rate / n, n / 12.0) - 1;
        int totalPayments = numberOfTerms * 12;
        double principal = loanAmount - downPayment;
        double basePayment = (principal * compoundedRate) / (1 - Math.pow(1 + compoundedRate, -totalPayments));
        double additionalCosts = propertyTaxPerMonth + homeownersInsurancePerMonth + pmiPerMonth + hoaFeesPerMonth;
        return basePayment + additionalCosts;
    }

    public int calculateTotalRepaymentDuration() {
        return numberOfTerms * 12; // in months
    }

    public double calculateCompoundedInterest() {
        double rate = annualInterestRate / 100;
        int n = getCompoundingFrequency();
        double totalAmount = loanAmount * Math.pow(1 + (rate / n), n * numberOfTerms);
        return totalAmount - (loanAmount - downPayment);
    }

    private int getCompoundingFrequency() {
        switch (compoundingInterval.toLowerCase()) {
            case "monthly":
                return 12;
            case "weekly":
                return 52;
            case "daily":
                return 365;
            case "continually":
                return Integer.MAX_VALUE; // Represents continuous compounding
            default:
                throw new IllegalArgumentException("Invalid compounding interval");
        }
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfTerms(int numberOfTerms) {
        this.numberOfTerms = numberOfTerms;
    }

    public void setCompoundingInterval(String compoundingInterval) {
        this.compoundingInterval = compoundingInterval;
    }

    public void setPropertyTaxPerMonth(double propertyTaxPerMonth) {
        this.propertyTaxPerMonth = propertyTaxPerMonth;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public void setHomeownersInsurancePerMonth(double homeownersInsurancePerMonth) {
        this.homeownersInsurancePerMonth = homeownersInsurancePerMonth;
    }

    public void setPmiPerMonth(double pmiPerMonth) {
        this.pmiPerMonth = pmiPerMonth;
    }

    public void setHoaFeesPerMonth(double hoaFeesPerMonth) {
        this.hoaFeesPerMonth = hoaFeesPerMonth;
    }
}