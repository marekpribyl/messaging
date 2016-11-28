package cz.board.sandbox.messaging.rule;

import java.time.LocalDateTime;

public interface DeliveryRule {

    boolean canDeliverAt(LocalDateTime instant);

    //decide: LocalDateTime nextDeliveryInstant();

}
