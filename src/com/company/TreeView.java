package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class TreeView extends JFrame {
    public File file;
    private Tree A;
    private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private final JPanel But = new JPanel();
    private final JPanel panel1 = new JPanel();
    private final JPanel test_scond_panel = new JPanel();

    public TreeView(File A){
        super("Tree");
        file = A;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
        But.setLayout(new BoxLayout(But, BoxLayout.Y_AXIS));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        test_scond_panel.setLayout(new BoxLayout(test_scond_panel, BoxLayout.X_AXIS));
        addButton("Build", panel1);
        addButton("Test", test_scond_panel);
        this.setBounds(400, 150, 600, 400);
        this.setContentPane(createSplitPane());
    }
    public JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        addMenuItem("File", fileMenu);
        fileMenu.add(new JSeparator());
        addMenuItem("Exit", fileMenu);
        return fileMenu;

    }
    public void addMenuItem (String caption, Container container){
        JMenuItem Item = new JMenuItem(caption);
        Item.setActionCommand(caption);
        Item.addActionListener(new ButtonEventListener());
        container.add(Item);
    }
    public JSplitPane createSplitPane() {
        JSplitPane A = new JSplitPane();
        A.setOneTouchExpandable(true);
        A.setDividerLocation(350);
        A.setRightComponent(panel1);
        A.setLeftComponent(But);
        return A;
    }
    private void addPerButton(int caption, Container container) {
        JButton button = new JButton(A.Persons.get(caption).Name);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(String.valueOf(caption));
        button.addActionListener(new PersonListener());
        container.add(button);
    }

    class ButtonEventListener  implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("Build")) {
                A = new Tree(file);
                for (int i = 1; i < A.Persons.size()+1; i++){
                    addPerButton(i, But);
                }
                But.revalidate();
                But.repaint();
            }
            if(command.equals("File")) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if(ret == JFileChooser.APPROVE_OPTION) {
                    file = fileopen.getSelectedFile();
                    dispose();
                    new TreeView(file).setVisible(true);
                }
            }
            if(command.equals("Exit")){
                System.exit(0);
            }
        }
    }

    class PersonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            int Command = Integer.parseInt(command);
            PersonInfo message = new PersonInfo(A.FindPerson(Command));
            JOptionPane.showConfirmDialog(null,
                    message.message,
                    "Output",
                    JOptionPane.DEFAULT_OPTION);

        }
    }
    private void addButton(String caption, Container container)
    {
        JButton button = new JButton(caption);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(caption);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }
}
