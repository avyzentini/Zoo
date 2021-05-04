package com.unipi.avyzentini;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class view_all extends JFrame {
    private JPanel view_panel;
    private JTextField search_text;
    private JButton edit_id;
    private JButton delete_id;
    private JButton search_b;
    List<Animal> get_data = new ArrayList<>();



    public view_all(){
        setTitle("View All Animals");
        setPreferredSize(new Dimension(900,700));
        setResizable(false);
        setContentPane(view_panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        //List<Animal> animalList = myDeserialize("zoo.ser");
        String[] col = {"ID","Name","Class","Weight","Age"};

        JList l = new JList(col);
        add(l);

        /*StringBuilder builder = new StringBuilder();
        for (Animal s: animalList){
            builder.append("Name: ").append(s.getName()).append(",").append(s.getAnim_class()).append(",").append(s.getWeight()).append(",").append(s.getAge()).append("\n");
        }
        JOptionPane.showMessageDialog(view_all.this,builder.toString()); */


    }
    static java.util.List<Animal> myDeserialize(String fileName){
        java.util.List<Animal> animals= new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream o = new ObjectInputStream(f);
            animals = (List<Animal>) o.readObject();
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animals;
    }
}

