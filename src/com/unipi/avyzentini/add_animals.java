package com.unipi.avyzentini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class add_animals extends JFrame {

    private JPanel add_panel;
    private JTextField id_text;
    private JTextField name_text;
    private JTextField class_text;
    private JTextField weight_text;
    private JTextField age_text;
    private JButton save_button;
    private JButton cancel_button;
    List<Animal> get_data = new ArrayList<>();


    public add_animals(){
        setTitle("Add Animals");
        setPreferredSize(new Dimension(500,500));
        setResizable(false);
        setContentPane(add_panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        get_data = myDeserialize("zoo.ser");




        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = id_text.getText().toLowerCase();
                String name = name_text.getText().toLowerCase();
                String anim_class= class_text.getText().toLowerCase();
                String weight = weight_text.getText();
                String age= age_text.getText();
                boolean isID= get_data.stream().anyMatch(animal -> animal.getId().equals(id));
                boolean isName= get_data.stream().anyMatch(animal -> animal.getName().equals(name));
                if (isID || isName){
                    JOptionPane.showMessageDialog(add_animals.this,"An animal with the same Name or ID already exists!");
                }else {
                    get_data.add(new Animal(id, name, anim_class, weight, age));
                    mySerialize(get_data, "zoo.ser");
                }
                id_text.setText("");
                name_text.setText("");
                class_text.setText("");
                weight_text.setText("");
                age_text.setText("");
            }
        });
    }
    static void mySerialize(List<Animal> animals,String fileName){
        try{
            FileOutputStream f =new FileOutputStream(fileName);
            ObjectOutputStream o=new ObjectOutputStream(f);
            o.writeObject(animals);
            o.close();
            f.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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

        }
        return animals;
    }

}
class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // do not write a header, but reset:
        // this line added after another question
        // showed a problem with the original
        reset();
    }

}

