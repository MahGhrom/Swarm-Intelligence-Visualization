package gui;

import core.Room;
import core.Swarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

/**
 * Created by Ghrom on 02.09.2016.
 */
public class GUI {

    private JPanel MainPanel;
    private JPanel ControlPanel;
    private JButton StopButton;
    private JButton StartButton;
    private JLabel Label1;
    private JTextField NumberOfIndividuals;
    private JPanel DrawPanel;

    private boolean inProcess = false;
    Graphics2D gr;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Simple swarm visualization");
        mainWindow.setContentPane(new GUI().MainPanel);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public GUI() {
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Room room = new Room();
                Swarm swarm = new Swarm();
                int swarmSize = Integer.parseInt(NumberOfIndividuals.getText());

                Vector<Integer> dimensions = new Vector<>();
                dimensions.add(DrawPanel.getWidth());
                dimensions.add(DrawPanel.getHeight());
                room.initRoom(dimensions);
                swarm.initSwarm(room, swarmSize);
                inProcess = true;
                while (inProcess) {
                    //Drawing
                    int x;
                    int y;
                    for (int i = 0; i < swarmSize; i++) {
                        x = swarm.getSwarmMembers().get(i).getPosition().get(0).intValue();
                        y = swarm.getSwarmMembers().get(i).getPosition().get(1).intValue();
                        gr.draw(new Ellipse2D.Double(x, y, 5, 5));
                    }
                    try {
                        Thread.sleep(50);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    swarm.doSwarming();
                }
            }
        });
        StopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inProcess = false;
            }
        });
    }
}
