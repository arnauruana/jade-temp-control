package behaviour;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import java.lang.Integer;
import java.util.Random;


/**
 * @author Arnau Ruana | @arnauruana
 */
public class TickerBehaviourAgent extends Agent
{
    public class Thermometer extends TickerBehaviour
    {
        private Random rand = new Random();

        public Thermometer(Agent agent, int period)
        {
            super(agent, period);
        }

        public void onStart()
        {
            System.out.println("[THERMOMETER]\tinitialized");
        }

        public void onTick()
        {
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("thermostat", AID.ISLOCALNAME));
            msg.setContent(Integer.toString(this.rand.nextInt(41) - 10));
            send(msg);
        }

        public int onEnd()
        {
            System.out.println("[THERMOMETER]\tfinalized");
            return 0;
        }
    }

    protected void setup()
    {
        Thermometer t = new Thermometer(this, 10000);
        this.addBehaviour(t);
    }
}
