package com.sicaklik.app;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private int arcWidth = 20;  // Oval kenarın yatay yarıçapı
    private int arcHeight = 20; // Oval kenarın dikey yarıçapı
    private Color buttonColor = new Color(70, 130, 180); // Mavi tonu (SteelBlue)
    private Color textColor = Color.WHITE; // Yazı rengi

    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false); // Butonun odaklandığında oluşan kenarlığı kaldır
        setContentAreaFilled(false); // İçerik alanının varsayılan olarak doldurulmasını engelle
        setOpaque(false); // Şeffaf olmasını sağla
        setForeground(textColor); // Yazı rengini ayarla
    }

    // Oval şekli ve rengi çizen metot
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Butonun arka plan rengini çiz
        g2.setColor(buttonColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));

        // Eğer fare üzerine gelirse veya basılırsa rengi koyulaştır
        if (getModel().isRollover() || getModel().isPressed()) {
            Color darkerColor = buttonColor.darker(); // Mevcut rengin biraz daha koyu hali
            g2.setColor(darkerColor);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));
        }
        g2.dispose();

        // Butonun yazısını ve ikonunu çiz (transparan arka plan üzerinde)
        super.paintComponent(g);
    }

    // Butonun kenarlığını çizmiyoruz, sade olsun
    @Override
    protected void paintBorder(Graphics g) {
        // Boş bırakıldı
    }

    // --- Hata veren getShape() metodu tamamen kaldırıldı ---
    // @Override
    // public Shape getShape() {
    //     return new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
    // }
}