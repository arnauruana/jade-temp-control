/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 * @author igomez
 */
public class CyclicBehaviourAgent extends Agent {

    public class HelloWorldCyclicBehaviour extends CyclicBehaviour {
        String message;
        int count_chocula;

        public HelloWorldCyclicBehaviour() {

        }

        public void onStart() {
            this.message = "Agent " + myAgent + " with HelloWorldCyclicBehaviour in action!!" + count_chocula;
            count_chocula = 0;
        }

        public int onEnd() {
            System.out.println("I have done " + count_chocula + " iterations");
            return count_chocula;
        }

        public void action() {
            System.out.println(this.message + count_chocula);
            ++count_chocula;
        }

    }

    protected void setup() {

        HelloWorldCyclicBehaviour b = new HelloWorldCyclicBehaviour();
        this.addBehaviour(b);
    }
}
