package com.dev.view;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;

public class main extends JFrame{
    private JPanel MainView;
    private JTextField txtSelectPath;
    private JButton extractFileButton;
    private JButton cancelButton;
    private JButton selectFileButton;

    public main() {
    setInit();
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String com = e.getActionCommand();
                txtSelectPath.setText("");
                String link = "";
                if (com.equals("save")) {
                    // create an object of JFileChooser class
                    JFileChooser jFC = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    // invoke the showsSaveDialog function to show the save dialog
                    int confirm = jFC.showSaveDialog(null);
                    // if the user selects a file
                    if (confirm == JFileChooser.APPROVE_OPTION) {
                        // set the label to the path of the selected file
                        link = jFC.getSelectedFile().getAbsolutePath();
                    } // if the user cancelled the operation
                    else {
                        //l.setText("the user cancelled the operation");
                        JOptionPane.showMessageDialog(null, "You don't select file");
                    }
                } // if the user presses the open dialog show the open dialog
                else {
                    // create an object of JFileChooser class
                    JFileChooser jFC = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    // invoke the showsOpenDialog function to show the save dialog
                    int confirm = jFC.showOpenDialog(null);
                    // if the user selects a file
                    if (confirm == JFileChooser.APPROVE_OPTION) {
                        // set the label to the path of the selected file
                        //l.setText(j.getSelectedFile().getAbsolutePath());
                        link = jFC.getSelectedFile().getAbsolutePath();
                    } // if the user cancelled the operation
                    else {
                        //l.setText("the user cancelled the operation");
                        JOptionPane.showMessageDialog(null, "You don't select file");
                    }
                }
                //System.out.println(link);
                txtSelectPath.setText(link);
            }
        });
        extractFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = txtSelectPath.getText();
                //Create a PdfDocument instance
                PdfDocument pdf = new PdfDocument();
                //Load a PDF file
                pdf.loadFromFile(path);
                //Save to .docx file
                pdf.saveToFile("ToWord.docx", FileFormat.DOCX);
                pdf.close();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void setInit(){
        MainView.setPreferredSize(new Dimension(500,200));
        MainView.setMinimumSize(new Dimension(500,200));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My tool");
        frame.setContentPane(new main().MainView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
