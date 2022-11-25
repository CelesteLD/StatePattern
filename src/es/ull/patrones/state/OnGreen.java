package es.ull.patrones.state;

import javax.sound.sampled.AudioInputStream;

import es.ull.patrones.trafficLight.TrafficLight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;

public class OnGreen implements State {

    TrafficLight trafficLight;

    private AudioInputStream sound;

    private Clip clip;

    private long time = 10000;

    public OnGreen() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/green.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon nextState() {
        //System.out.println("Changing to Red");
        clip.close();
        trafficLight.setState(new OnRed());
        return new ImageIcon("imagen/rojo1.png");
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
