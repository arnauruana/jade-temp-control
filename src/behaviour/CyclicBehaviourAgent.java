package behaviour;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.lang.Integer;
import java.lang.String;


/**
 * @author Arnau Ruana | @arnauruana
 */
public class CyclicBehaviourAgent extends Agent
{
    public class Thermostat extends CyclicBehaviour
    {
        private static final int TEMP_MAX = 25;
        private static final int TEMP_MIN = 15;

        public Thermostat() {}

        public void onStart()
        {
            System.out.println("[THERMOSTAT]\tinitialized");
        }

        public void action()
        {
            ACLMessage msg = receive();

            if (msg != null)
            {
                String out;
                int temp = Integer.parseInt(msg.getContent());

                if (temp < this.TEMP_MIN)
                {
                    out = "heating on";
                }
                else if (temp > this.TEMP_MAX)
                {
                    out = "refrigeration on";
                }
                else
                {
                    out = "suitable temperature";
                }
                System.out.println("[THERMOSTAT]\t" + out + " (" + temp + "°C)");
            }
            else
            {
                block();
            }
        }

        public int onEnd()
        {
            System.out.println("[THERMOSTAT]\tfinalized");
            return 0;
        }
    }

    protected void setup()
    {
        Thermostat t = new Thermostat();
        this.addBehaviour(t);
    }
}
