package graphics;

import entities.House;
import entities.Smurf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationCard extends JFrame {

    private House house;
    private Smurf smurf;
    JLabel type;
    JLabel resourceNumber;


    public InformationCard(House house, Smurf smurf)
    {
        this.house = house;
        this.smurf = smurf;

        setPreferredSize(new Dimension(200,400));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        type = new JLabel(house.getType());
        add(type, gbc);

        resourceNumber = new JLabel(String.valueOf(house.getResourceCounter()));
        gbc.gridy = 1;
        add(resourceNumber,gbc);


        JButton collect = new JButton("Collect");
        collect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resources = house.getResourceCounter();
                smurf.setCarryResources(smurf.getCarryResources() + resources);
                house.setResourceCounter(0);
                revalidate();
            }
        });
        gbc.gridy = 2;
        add(collect,gbc);

        JButton button  = new JButton("Back");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gbc.gridy = 3;
        add(button,gbc);




        pack();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);






    }


}
