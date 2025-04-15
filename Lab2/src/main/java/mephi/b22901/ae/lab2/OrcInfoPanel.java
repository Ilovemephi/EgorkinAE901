/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.ae.lab2;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author artyom_egorkin
 */
public class OrcInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel roleLabel;
    private JLabel weaponLabel;
    private JLabel armorLabel;
    private JLabel bannerLabel;
    private JProgressBar strengthBar;
    private JProgressBar dexterityBar;
    private JProgressBar iqBar;
    private JProgressBar healthBar;
    
    
    public OrcInfoPanel() {
        // Устанавливаем макет сетки для панели
        setLayout(new GridLayout(9, 2));

        // Имя
        add(new JLabel("Имя:"));
        nameLabel = new JLabel("");
        add(nameLabel);

        // Роль
        add(new JLabel("Роль:"));
        roleLabel = new JLabel("");
        add(roleLabel);

        // Оружие
        add(new JLabel("Оружие:"));
        weaponLabel = new JLabel("");
        add(weaponLabel);
        // Броня
        add(new JLabel("Броня:"));
        armorLabel = new JLabel("");
        add(armorLabel);

        // Знамя
        add(new JLabel("Знамя:"));
        bannerLabel = new JLabel("");
        add(bannerLabel);

        // Сила
        add(new JLabel("Сила:"));
        strengthBar = new JProgressBar(0, 100);
        add(strengthBar);

        // Ловкость
        add(new JLabel("Ловкость:"));
        dexterityBar = new JProgressBar(0, 100);
        add(dexterityBar);

        // Интеллект
        add(new JLabel("Интеллект:"));
        iqBar = new JProgressBar(0, 50);
        add(iqBar);
        
        // Здоровье
        add(new JLabel("Здоровье:"));
        healthBar = new JProgressBar(0, 200);
        add(healthBar);
    }
    
    public void displayOrcInfo(Orc orc) {
        // Обновляем имя
        nameLabel.setText(orc.getName());

        // Обновляем роль
        roleLabel.setText(orc.getRole());

        // Обновляем снаряжение
        weaponLabel.setText(orc.getWeapon() != null ? orc.getWeapon().getName() : "Нет оружия");
        armorLabel.setText(orc.getArmor() != null ? orc.getArmor().getName() : "Нет брони");
        bannerLabel.setText(orc.getBanner() != null ? orc.getBanner().getName() : "Нет знамени");

        // Обновляем характеристики
        strengthBar.setValue(orc.getStrength());
        dexterityBar.setValue(orc.getDexterity());
        iqBar.setValue(orc.getIq());
        healthBar.setValue(orc.getHealth());
    }

    
    
}
