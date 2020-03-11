package behaviours;


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
        public Thermometer(Agent agent, int period)
        {
            super(agent, period);
        }

        public void onStart()
        {
            System.out.println("Initialized agent: thermometer");
        }

        public void onTick()
        {
            Random rand = new Random();
            int temp = rand.nextInt(41) - 10;

            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContent(Integer.toString(temp));
            msg.addReceiver(new AID("thermostat", AID.ISLOCALNAME));

            System.out.println("Send random temperature: " + temp);
            send(msg);
        }

        public int onEnd()
        {
            System.out.println("Finalized agent: thermometer");
            return 0;
        }
    }

    protected void setup()
    {
        Thermometer t = new Thermometer(this, 10000);
        this.addBehaviour(t);
    }
}
