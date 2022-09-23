package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class MainFrame extends JFrame {
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "text files", "txt");
    public File file;
    private final JPanel panel2 = new JPanel();
    JPasswordField Password = new JPasswordField();


    public MainFrame() {
        super("Main menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField UserName = new JTextField(15);
        JPasswordField Password = new JPasswordField(15);
        addButton("Выбрать файл", panel2);
        //panel2.add(UserName);
        //panel2.add(Password);
        //Password.addKeyListener(new TextListener());
        //UserName.addKeyListener(new TextListener());
        this.setContentPane(panel2);
        this.setBounds(400, 150, 300, 100);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Выбрать файл")) {
                JFileChooser fileopen = new JFileChooser();
                fileopen.setFileFilter(filter);
                int ret = fileopen.showDialog(null, "Открыть файл");
                if(ret == JFileChooser.APPROVE_OPTION) {
                    file = fileopen.getSelectedFile();
                    dispose();
                    new TreeView(file).setVisible(true);
                }
            }
            if(command.equals("Выход")) {
                System.exit(0);
            }

        }

    }

    class TextListener extends KeyAdapter{
        public void keyPressed( KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                Password.requestFocusInWindow();
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

    private JButton addButton(String caption){
        JButton button = new JButton(caption);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(caption);
        button.addActionListener(new ButtonEventListener());

        return  button;
    }
}
