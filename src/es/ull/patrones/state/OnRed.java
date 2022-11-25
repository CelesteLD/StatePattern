package es.ull.patrones.state;

import es.ull.patrones.trafficLight.TrafficLight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;

public class OnRed implements State {

    TrafficLight trafficLight;

    private long time = 10000;

    private AudioInputStream sound;

    private Clip clip;

    public OnRed() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/red.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public ImageIcon nextState() {
        //System.out.println("Changing to Orange");
        clip.close();
        trafficLight.setState(new OnOrange());
        return new ImageIcon("imagen/amarillo1.png");
    }

    @Override
    public void setTrafficLights(TrafficLight trafficLights) {
        this.trafficLight = trafficLights;
    }

    @Override
    public long getTime() {
        return time;
    }
}
