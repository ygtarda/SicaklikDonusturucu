package com.sicaklik.app;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public static void launchUI() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sıcaklık Dönüştürücü");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(8, 8, 8, 8); // Kenar boşluklarını biraz artırdım
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // 1. Satır: Label ve Input Alanı
            JLabel label = new JLabel("Celsius Değeri:"); // Yazım hatası düzeltildi
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_END;
            panel.add(label, gbc);

            JTextField input = new JTextField(10);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.LINE_START;
            panel.add(input, gbc);

            // 2. Satır: Dönüştür Butonu (RoundedButton kullanıldı)
            JButton convertBtn = new RoundedButton("Dönüştür (Celsius → Fahrenheit)"); // Yazım hatası düzeltildi ve RoundedButton kullanıldı
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.0;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(convertBtn, gbc);

            // 3. Satır: Sonuç Label'ı
            JLabel result = new JLabel("Sonuç: ");
            result.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(result, gbc);

            convertBtn.addActionListener(e -> {
                try {
                    double c = Double.parseDouble(input.getText());
                    double f = Converter.cToF(c);
                    result.setText(String.format("Sonuç: %.2f °F", f));
                } catch (NumberFormatException ex) { // Daha spesifik hata yakalama
                    result.setText("HATA: Geçerli bir sayı girin!"); // Yazım hatası düzeltildi
                }
            });

            frame.add(panel);
            frame.pack();
            frame.setMinimumSize(frame.getSize());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}