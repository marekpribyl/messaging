package cz.board.sandbox.messaging;

import cz.board.sandbox.messaging.rule.DeliveryRule;

public class MessageEnvelope {

    private final Object payload;

    private final DeliveryRule deliveryRule;

    public MessageEnvelope(Object payload, DeliveryRule deliveryRule) {
        this.payload = payload;
        this.deliveryRule = deliveryRule;
    }

}
