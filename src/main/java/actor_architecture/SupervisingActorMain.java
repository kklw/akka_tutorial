package actor_architecture;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/*
Failure information is propagated to the parent, which then decides how to
handle the exception caused by the child actor. In this way, parents act as supervisors
for their children.
The default supervisor strategy is to stop and restart the child.
 */
public class SupervisingActorMain {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("helloakka");

        ActorRef supervisingActor = system.actorOf(Props.create(SupervisingActor.class), "supervising-actor");
        supervisingActor.tell("failChild", ActorRef.noSender());
    }
}
