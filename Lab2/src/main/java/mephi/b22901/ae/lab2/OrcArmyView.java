
package mephi.b22901.ae.lab2;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
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

    public OrcArmyView() {
        initializeGUI();
    }
    
    private void initializeGUI() {
        // Создаем основное окно
        frame = new JFrame("Армия Мордора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Корневой узел дерева
        root = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(root);
        armyTree = new JTree(treeModel);
       
        JScrollPane treeScrollPane = new JScrollPane(armyTree);

        // Создаем панель информации об орке
        infoPanel = new OrcInfoPanel();

        // Разделяем окно на две части: дерево и панель информации
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoPanel);
        splitPane.setDividerLocation(300);
        
        // Добавляем элементы выбора племени и роли
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
        frame.setVisible(true);

        
    }
    
    public void addCreateOrcListener(java.awt.event.ActionListener listener) {
        createOrcButton.addActionListener(listener);
    }

    public void addTreeSelectionListener(javax.swing.event.TreeSelectionListener listener) {
        armyTree.addTreeSelectionListener(listener);
    }

    public String getSelectedTribe() {
        return (String) tribeComboBox.getSelectedItem();
    }

    public String getSelectedRole() {
        return (String) roleComboBox.getSelectedItem();
    }
    
    public Orc getSelectedOrc() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
        if (selectedNode != null && selectedNode.getUserObject() instanceof Orc) {
            return (Orc) selectedNode.getUserObject();
        }
        return null;
    }

    public void displayOrcInfo(Orc orc) {
        infoPanel.displayOrcInfo(orc);
    }

    public void addOrcToArmy(Orc orc, String tribe) {
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
    
   
    
    
    
}
