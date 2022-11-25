package es.ull.patrones.trafficLight;

import es.ull.patrones.state.OnGreen;
import es.ull.patrones.state.OnOrange;
import es.ull.patrones.state.OnRed;
import es.ull.patrones.state.State;

import javax.swing.*;

public class TrafficLight {

    State state;

    JLabel image = new JLabel();

    public TrafficLight(JLabel vertical) {
        this.image = vertical;
        setState(new OnGreen());
    }

    public void setState(State state) {
        this.state = state;
        this.state.setTrafficLights(this);
    }

    public State getState() {
        return state;
    }


    public ImageIcon nextState() {
        return this.state.nextState();
    }

}
