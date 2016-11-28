package cz.board.sandbox.messaging;

public interface CommunicationFacade {

    void dispatch(MessageEnvelope messageEnvelope);

}
