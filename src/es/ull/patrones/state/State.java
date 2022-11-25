package es.ull.patrones.state;

import es.ull.patrones.trafficLight.TrafficLight;

import javax.swing.*;

public interface State {

    /*public void changeToRed();
    public void changeToOrange();
    public void changeToGreen();*/

    public ImageIcon nextState();

    public void setTrafficLights(TrafficLight trafficLights);

    public long getTime();

}
