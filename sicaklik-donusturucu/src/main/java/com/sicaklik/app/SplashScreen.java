package com.sicaklik.app;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SplashScreen {

    public static void showSplash() {
        // 1. Kaynaklardaki splash.png görüntüsünü yükle
        URL imageUrl = SplashScreen.class.getResource("/icons/splash.png");
        ImageIcon originalSplashIcon = new ImageIcon(imageUrl);

        // --- GÖRSEL BOYUTUNU KÜÇÜLTME ADIMLARI (Öncekiyle aynı) ---
        Image originalImage = originalSplashIcon.getImage();
        int newWidth = originalImage.getWidth(null) / 2; // Yarı boyuta indir
        int newHeight = originalImage.getHeight(null) / 2;
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon splashIcon = new ImageIcon(resizedImage);
        // ----------------------------------------------------------

        // --- JDialog KULLANARAK KESİN TRANSPARANLIK SAĞLAMA ---
        JDialog splash = new JDialog((Frame)null); // Sahipsiz bir diyalog oluştur
        splash.setUndecorated(true); // Çerçevesiz yap (başlık çubuğu vb. olmaz)
        splash.setBackground(new Color(0, 0, 0, 0)); // Pencerenin kendi arka planını transparan yap

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false); // Paneli transparan yap

        JLabel label = new JLabel(splashIcon);
        label.setOpaque(false); // Etiketi transparan yap
        panel.add(label, BorderLayout.CENTER);

        // Temanın bu panele arka plan çizmesini engelle
        panel.putClientProperty("FlatLaf.style", "background: null");


        splash.setContentPane(panel); // Paneli diyalogun içerik bölgesi yap

        // Diyalogun boyutunu görselin boyutuna ayarla
        splash.setSize(splashIcon.getIconWidth(), splashIcon.getIconHeight());
        splash.setLocationRelativeTo(null); // Ekranın ortasına yerleştir
        splash.setVisible(true);

        try {
            Thread.sleep(2000); // 2 saniye bekle
        } catch(InterruptedException ignored) {}

        splash.dispose(); // Açılış diyalogunu kapat
    }
}

