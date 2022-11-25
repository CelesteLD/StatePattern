package es.ull.patrones.giu;

import es.ull.patrones.state.State;
import es.ull.patrones.trafficLight.TrafficLight;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;

import java.util.Timer;


public class TrafficLightGIU {

    JLabel jLabel1, vertical, jLabel5, jLabel6;
    JFrame frame = new JFrame();
    TrafficLight trafficLightsVertical;

    public TrafficLightGIU() throws UnsupportedAudioFileException, IOException {
        initialize();
        action();
    }

    public void initialize() {
        frame.setTitle("TrafficLight - StatePattern ");
        this.frame.setLocationRelativeTo(null);

        //setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        frame.setBounds(0, 0, 640, 610);
        frame.setBackground(new Color(250, 250, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vertical = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel1 = new JLabel();

        jLabel5.setIcon(new ImageIcon("imagen/coche2.png"));
        jLabel6.setIcon(new ImageIcon("imagen/coche3.png"));
        jLabel1.setIcon(new ImageIcon("imagen/fondo.jpg"));
        vertical.setBounds(380, 350, 40, 70);
        jLabel1.setBounds(0, 0, 627, 570);

        vertical.setIcon(new ImageIcon("imagen/rojo1.png"));

        trafficLightsVertical = new TrafficLight(vertical);

        frame.add(vertical);
        frame.add(jLabel5);
        frame.add(jLabel6);
        frame.add(jLabel1);
        frame.setVisible(true);
    }

    public void action() throws UnsupportedAudioFileException, IOException {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                vertical.setIcon(trafficLightsVertical.nextState());;
                move(trafficLightsVertical.getState());
            }
        }, 0, trafficLightsVertical.getState().getTime());

    }

    public void move(State state) {
        int positionCar1 = 700, positionCar2 = 500, positionCar3 = 500, positionCar4 = 700;

        if (state.getClass().getSimpleName().equals("OnRed")) {

            for (int i = 0; i < 70; i++) {

                jLabel5.setBounds(320, positionCar2, 50, 120);
                jLabel6.setBounds(260, positionCar3, 50, 110);
                positionCar2 = positionCar2 - 2;
                positionCar3 = positionCar3 - 2;
                try {
                    Thread.sleep(10);
                } catch (Exception x) { }
            }
        } else if (state.getClass().getSimpleName().equals("OnOrange")) {
            positionCar2 = 360;
            positionCar3 = 360;
            for (int i = 0; i < 300; i++) {

                jLabel5.setBounds(320, positionCar2, 50, 120);
                jLabel6.setBounds(260, positionCar3, 50, 110);
                positionCar1 = positionCar1 - 9;
                positionCar2 = positionCar2 - 3;
                positionCar3 = positionCar3 - 2;

                try {
                    Thread.sleep(10);
                } catch (Exception x) {
                }
            }
        } else if (state.getClass().getSimpleName().equals("OnGreen")) {
            positionCar2 = 500;
            positionCar3 = 500;
            for (int i = 0; i < 300; i++) {

                jLabel5.setBounds(320, positionCar2, 50, 120);
                jLabel6.setBounds(260, positionCar3, 50, 110);
                positionCar1 = positionCar1 - 9;
                positionCar2 = positionCar2 - 3;
                positionCar3 = positionCar3 - 2;

                try {
                    Thread.sleep(10);
                } catch (Exception x) {  }
            }
        }
    }
}
