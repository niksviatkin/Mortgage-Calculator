package com.niksviatkin.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MortgageView {
    private JFrame frame;
    private JTextField loanAmountField;
    private JTextField interestRateField;
    private JTextField numberOfTermsField;
    private JTextField propertyTaxField;
    private JTextField downPaymentField;
    private JTextField homeownersInsuranceField;
    private JTextField pmiField;
    private JTextField hoaFeesField;
    private JComboBox<String> compoundingIntervalCombo;
    private JTextArea resultArea;
    private JButton calculateButton;

    public MortgageView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Mortgage Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Loan Amount:"), gbc);
        loanAmountField = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(loanAmountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Interest Rate (%):"), gbc);
        interestRateField = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(interestRateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Number of Terms (years):"), gbc);
        numberOfTermsField = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(numberOfTermsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Compounding Interval:"), gbc);
        String[] intervals = {"Monthly", "Weekly", "Daily", "Continually"};
        compoundingIntervalCombo = new JComboBox<>(intervals);
        gbc.gridx = 1;
        mainPanel.add(compoundingIntervalCombo, gbc);

        JPanel optionalPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        optionalPanel.add(new JLabel("Property Tax:"), gbc);
        propertyTaxField = new JTextField(15);
        gbc.gridx = 1;
        optionalPanel.add(propertyTaxField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        optionalPanel.add(new JLabel("Down Payment:"), gbc);
        downPaymentField = new JTextField(15);
        gbc.gridx = 1;
        optionalPanel.add(downPaymentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        optionalPanel.add(new JLabel("Homeowner's Insurance:"), gbc);
        homeownersInsuranceField = new JTextField(15);
        gbc.gridx = 1;
        optionalPanel.add(homeownersInsuranceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        optionalPanel.add(new JLabel("PMI:"), gbc);
        pmiField = new JTextField(15);
        gbc.gridx = 1;
        optionalPanel.add(pmiField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        optionalPanel.add(new JLabel("HOA Fees:"), gbc);
        hoaFeesField = new JTextField(15);
        gbc.gridx = 1;
        optionalPanel.add(hoaFeesField, gbc);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Main", mainPanel);
        tabbedPane.addTab("Optional", optionalPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        calculateButton = new JButton("Calculate");
        bottomPanel.add(calculateButton, BorderLayout.NORTH);

        resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Results"));
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public String getLoanAmount() {
        return loanAmountField.getText();
    }

    public String getInterestRate() {
        return interestRateField.getText();
    }

    public String getNumberOfTerms() {
        return numberOfTermsField.getText();
    }

    public String getPropertyTax() {
        return propertyTaxField.getText();
    }

    public String getDownPayment() {
        return downPaymentField.getText();
    }

    public String getHomeownersInsurance() {
        return homeownersInsuranceField.getText();
    }

    public String getPMI() {
        return pmiField.getText();
    }

    public String getHOAFees() {
        return hoaFeesField.getText();
    }

    public String getCompoundingInterval() {
        return (String) compoundingIntervalCombo.getSelectedItem();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public void showError(String errorMessage) {
        resultArea.setText("Error: " + errorMessage);
    }
}