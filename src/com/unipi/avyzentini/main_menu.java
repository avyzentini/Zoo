package com.unipi.avyzentini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static com.unipi.avyzentini.add_animals.myDeserialize;


public class main_menu extends JFrame {
    private JPanel panel1;
    private JButton add;
    private JButton exit;
    private JButton view;
    List<Animal> get_data = new ArrayList<>();

    public main_menu() {
        setTitle("Zoo");
        setPreferredSize(new Dimension(500,400));
        setResizable(false);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);




        exit.addActionListener(e -> System.exit(0));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new add_animals();
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                get_data = myDeserialize("zoo.ser");
                if (get_data.isEmpty()) {
                    JOptionPane.showMessageDialog(main_menu.this,"Insert animals to the Zoo");

                }else {
                    new view_all();
                    dispose();
                }
            }
        });
    }



}
