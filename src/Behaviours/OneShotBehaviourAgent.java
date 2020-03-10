/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 * @author igomez
 */
public class OneShotBehaviourAgent extends Agent {

    public class HelloWorldOneShotBehaviour extends OneShotBehaviour {
        String message;
        int count_chocula;

        public HelloWorldOneShotBehaviour() {

        }

        public void onStart() {
            this.message = "Agent " + myAgent + " with HelloWorldOneShotBehaviour in action!!";
            count_chocula = 0;
        }

        public int onEnd() {
            System.out.println("I have done " + count_chocula + " iterations");
            return count_chocula;
        }

        public void action() {
            System.out.println(this.message + count_chocula);
        }

    }

    protected void setup() {

        HelloWorldOneShotBehaviour b = new HelloWorldOneShotBehaviour();
        this.addBehaviour(b);
    }
}
