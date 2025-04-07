package mephi.b22901.ae.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class OrcArmyView {
    private JFrame frame;
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    private OrcInfoPanel infoPanel;

    private JComboBox<String> tribeComboBox;
    private JComboBox<String> roleComboBox;
    private JButton createOrcButton;

    
    private Map<String, OrcBuilderFactory> factoryMap;

    public OrcArmyView() {
        initializeFactories();
        initializeGUI();
    }

    private void initializeFactories() {
        factoryMap = new HashMap<>();
        factoryMap.put("Мордор", new MordorOrcBuilderFactory());
        factoryMap.put("Дол Гулдур", new DolGuldurBuilderFactory());
        factoryMap.put("Мглистые Горы", new MistyMountainsOrcBuilderFactory());
    }

    private void initializeGUI() {
        
        frame = new JFrame("Армия Мордора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

       
        root = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(root);
        armyTree = new JTree(treeModel);

        JScrollPane treeScrollPane = new JScrollPane(armyTree);

        
        infoPanel = new OrcInfoPanel();

        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoPanel);
        splitPane.setDividerLocation(300);

        
        createOrcButton = new JButton("Создать нового орка");


        tribeComboBox = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"});
        roleComboBox = new JComboBox<>(new String[]{"Базовый", "Командир", "Разведчик"});

        JPanel controlPanel = new JPanel();
        controlPanel.add(createOrcButton);
        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeComboBox);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleComboBox);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.NORTH);


        createOrcButton.addActionListener(new CreateOrcButtonListener());
        armyTree.addTreeSelectionListener(new TreeSelectionHandler());

        frame.setVisible(true);
    }

    private void addOrcToArmy(Orc orc, String tribe) {
        DefaultMutableTreeNode tribeNode = findTribeNode(tribe);
        if (tribeNode == null) {
            tribeNode = new DefaultMutableTreeNode(tribe);
            root.add(tribeNode);
        }
        tribeNode.add(new DefaultMutableTreeNode(orc));
        treeModel.reload();
    }

    private DefaultMutableTreeNode findTribeNode(String tribe) {
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
            if (node.getUserObject().equals(tribe)) {
                return node;
            }
        }
        return null;
    }

    // Слушатель для кнопки создания орка
    private class CreateOrcButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tribe = (String) tribeComboBox.getSelectedItem();
            String role = (String) roleComboBox.getSelectedItem();

            if (tribe == null || role == null) {
                JOptionPane.showMessageDialog(frame, "Выберите племя и роль.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            OrcBuilderFactory factory = factoryMap.get(tribe);
            if (factory == null) {
                JOptionPane.showMessageDialog(frame, "Фабрика для племени не найдена: " + tribe, "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            OrcBuilder builder = factory.createOrcBuilder();
            OrcDirector director = new OrcDirector(builder);

            Orc newOrc = null;
            if ("Базовый".equals(role)) {
                newOrc = director.createBasicOrk();
            } else if ("Командир".equals(role)) {
                newOrc = director.createLeaderOrk();
            } else if ("Разведчик".equals(role)) {
                newOrc = director.createScoutOrk();
            }

            if (newOrc != null) {
                addOrcToArmy(newOrc, tribe);
            }
        }
    }

    // Слушатель для выбора орка в дереве
    private class TreeSelectionHandler implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Orc) {
                Orc selectedOrc = (Orc) selectedNode.getUserObject();
                infoPanel.displayOrcInfo(selectedOrc);
            }
        }
    }
}