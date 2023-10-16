package simpleerpinventory.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simpleerpinventory.domain.*;
import simpleerpinventory.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryCreated extends AbstractEvent {

    private String name;
    private Integer quantity;

    public InventoryCreated(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryCreated() {
        super();
    }
}
//>>> DDD / Domain Event
