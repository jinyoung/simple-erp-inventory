package simpleerpinventory.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simpleerpinventory.domain.*;
import simpleerpinventory.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryDeleted extends AbstractEvent {

    private String id;

    public InventoryDeleted(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
