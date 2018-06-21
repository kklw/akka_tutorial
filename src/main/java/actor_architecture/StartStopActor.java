package actor_architecture;
import akka.actor.AbstractActor;
import akka.actor.Props;

class StartStopActor1 extends AbstractActor {
    @Override
    public void preStart() {
        System.out.println("first started");
        getContext().actorOf(Props.create(StartStopActor2.class), "second");
    }

    @Override
    public void postStop() {
        System.out.println("first stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("stop", s -> {
                    getContext().stop(getSelf());
                })
                .build();
    }
}
class StartStopActor2 extends AbstractActor {
    @Override
    public void preStart() {
        System.out.println("second started");
    }

    @Override
    public void postStop() {
        System.out.println("second stopped");
    }

    // Actor.emptyBehavior is a useful placeholder when we don't
    // want to handle any messages in the actor.
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}