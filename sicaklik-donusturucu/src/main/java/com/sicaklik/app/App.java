package com.sicaklik.app;

public class App {
    public static void main(String[] args) {
        // 1. TEMA YÜKLEMESİ: Tema, herhangi bir Swing penceresi
        // (SplashScreen dahil) oluşturulmadan ÖNCE uygulanmalıdır.
        ThemeManager.apply();

        // 2. AÇILIŞ EKRANI
        SplashScreen.showSplash();

        // 3. ANA PENCERE
        MainWindow.launchUI();
    }
}