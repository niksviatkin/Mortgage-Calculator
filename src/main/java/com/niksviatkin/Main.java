package com.niksviatkin;

import com.niksviatkin.controller.MortgageController;
import com.niksviatkin.view.MortgageView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MortgageView view = new MortgageView();
            MortgageController controller = new MortgageController(view);
            view.setVisible(true);
        });
    }
}