
package mephi.b22901.ae.lab2;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class OrcArmyApp {
    private JFrame frame;
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    private OrcInfoPanel infoPanel;

    public OrcArmyApp() {
        initializeGUI();
        initializeArmy();
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
        armyTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.getUserObject() instanceof Orc) {
                    Orc selectedOrc = (Orc) selectedNode.getUserObject();
                    infoPanel.displayOrcInfo(selectedOrc);
                }
            }
        });
        
        JScrollPane treeScrollPane = new JScrollPane(armyTree);

        // Создаем панель информации об орке
        infoPanel = new OrcInfoPanel();

        // Разделяем окно на две части: дерево и панель информации
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoPanel);
        splitPane.setDividerLocation(300);

        frame.add(splitPane);
        frame.setVisible(true);
        
    }
    
    private void initializeArmy() {
        // Получаем племена и фабрики
        String[] tribes = ArmyFactoryManager.getTribes();
        OrcBuilderFactory[] factories = ArmyFactoryManager.createFactories();

        // Создаем армию орков
        List<Orc> army = ArmyFactoryManager.createArmy(factories, tribes);

        // Добавляем орков в дерево
        for (Orc orc : army) {
            String tribe = orc.getRole(); // Используем роль как племя
            addOrcToArmy(orc, tribe);
        }
    }
    
    // Метод для добавления орка в дерево
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
