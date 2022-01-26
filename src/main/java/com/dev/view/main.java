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
    private String localPath = "";
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
                        JOptionPane.showMessageDialog(null, "Please select a file to convert...");
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
                        JOptionPane.showMessageDialog(null, "Please select a file to convert...");
                    }
                }
                //System.out.println(link);
                txtSelectPath.setText(link);
                localPath = link;
            }
        });
        extractFileButton.addActionListener(new ActionListener() {
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
                        JOptionPane.showMessageDialog(null, "Please select folder and enter filename to save...");
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
                        JOptionPane.showMessageDialog(null, "Please select folder and enter filename to save...");
                    }
                }
                //System.out.println(link);
                //txtSelectPath.setText(link);
//                String path = txtSelectPath.getText();
                String pathFileInput = localPath;
                //Create a PdfDocument instance
                PdfDocument pdf = new PdfDocument();
                //Load a PDF file
                pdf.loadFromFile(pathFileInput);
                //Save to .docx file
                String pathFileOutPut = link;
                pdf.saveToFile( pathFileOutPut +".docx", FileFormat.DOCX);
                pdf.close();
                JOptionPane.showMessageDialog(null,"Convert Successfully");
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   System.exit(0);
            }
        });
    }
    public void setInit(){
        MainView.setPreferredSize(new Dimension(500,200));
        MainView.setMinimumSize(new Dimension(500,200));
//        add(MainView);
//        setSize(1400, 800);
//        setTitle("Manager tickets System");
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.setLocationRelativeTo(null); // set center frame
//        this.setResizable(false); // not allow zoom frame

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My tool");
        frame.setContentPane(new main().MainView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
