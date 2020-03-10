/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 * @author igomez
 */
public class TickerBehaviourAgent extends Agent {
    public class HelloWorldTickerBehaviour extends TickerBehaviour {
        String message;
        int count_chocula;

        public HelloWorldTickerBehaviour(Agent a, long period) {
            super(a, period);
        }

        public void onStart() {
            this.message = "Agent " + myAgent + " with HelloWorldTickerBehaviour in action!!";
            count_chocula = 0;
        }

        public int onEnd() {
            System.out.println("I have done " + count_chocula + " iterations");
            return count_chocula;
        }

        public void onTick() {
            System.out.println(this.message + count_chocula);
            ++count_chocula;
        }

    }

    protected void setup() {

        HelloWorldTickerBehaviour b = new HelloWorldTickerBehaviour(this, 3000);
        this.addBehaviour(b);
    }


}
