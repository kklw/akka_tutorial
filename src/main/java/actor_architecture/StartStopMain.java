package actor_architecture;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/*
The actor lifecycle
When we stopped actor 'first', it stopped its child actor, second, before stopping itself.

* */

public class StartStopMain {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("helloakka");

        ActorRef first = system.actorOf(Props.create(StartStopActor1.class), "first");
        first.tell("stop", ActorRef.noSender());
    }
}
