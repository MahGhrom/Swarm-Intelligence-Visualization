package gui;

import core.Room;
import core.Swarm;
import core.SwarmingLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by (serhii.vasylchenko@gmail.com) on 02.09.2016.
 */
public class GUI {

    private JPanel mainPanel;
    private JPanel controlPanel;
    private JButton stopButton;
    private JButton startButton;
    private JLabel label1;
    private JTextField numberOfIndividuals;
    private JPanel drawPanel;
    private JButton pauseButton;

    //Graphics2D gr;
    private SwarmingLoop loop;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Simple swarm visualization");
        mainWindow.setContentPane(new GUI().mainPanel);

        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public GUI() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop = new SwarmingLoop(drawPanel, Integer.parseInt(numberOfIndividuals.getText()));
                Thread thread = new Thread(loop);
                thread.start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop.stop();
                loop = null;
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop.pause();
            }
        });
    }
}
