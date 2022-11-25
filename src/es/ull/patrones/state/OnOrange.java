package es.ull.patrones.state;

import es.ull.patrones.trafficLight.TrafficLight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;

public class OnOrange implements State {

    TrafficLight trafficLight;

    private AudioInputStream sound;

    private Clip clip;

    private long time = 3000;

    public OnOrange() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/orange.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon nextState() {
        //System.out.println("Changing to green");
        clip.close();
        trafficLight.setState(new OnGreen());
        return new ImageIcon("imagen/verde1.png");
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
