package simpleerpinventory.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simpleerpinventory.domain.*;
import simpleerpinventory.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryUpdated extends AbstractEvent {

    private String name;
    private Integer quantity;

    public InventoryUpdated(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
