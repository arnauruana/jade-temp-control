/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 * @author igomez
 */
public class WakerBehaviourAgent extends Agent {

    public class HelloWorldWakerBehaviour extends WakerBehaviour {
        String message;
        int count_chocula;

        public HelloWorldWakerBehaviour(Agent a, long timeout) {
            super(a, timeout);
        }

        public void onStart() {
            this.message = "Agent " + myAgent + " with HelloWorldWakerBehaviour in action!!";
            count_chocula = 0;
        }

        public int onEnd() {
            System.out.println("I have done " + count_chocula + " iterations");
            return count_chocula;
        }

        public void onWake() {
            System.out.println(this.message + count_chocula);
            ++count_chocula;
        }

    }

    protected void setup() {

        HelloWorldWakerBehaviour b = new HelloWorldWakerBehaviour(this, 3000);
        this.addBehaviour(b);
    }

}
