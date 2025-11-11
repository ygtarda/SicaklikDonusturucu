package com.sicaklik.app;

import javax.swing.*;

public class AboutDialog {

    public static void showDialog() {
        JOptionPane.showMessageDialog(null,
                "Sıcaklık Dönüştürücü\nv1.0",
                "Hakkında",
                JOptionPane.INFORMATION_MESSAGE);
    }
}