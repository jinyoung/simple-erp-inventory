package simpleerpinventory.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import simpleerpinventory.InventoryApplication;
import simpleerpinventory.domain.InventoryCreated;
import simpleerpinventory.domain.InventoryDeleted;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    private String name;

    private Integer quantity;

    @PostPersist
    public void onPostPersist() {
        InventoryCreated inventoryCreated = new InventoryCreated(this);
        inventoryCreated.publishAfterCommit();

        InventoryDeleted inventoryDeleted = new InventoryDeleted(this);
        inventoryDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateInventory(UpdateInventoryCommand updateInventoryCommand) {
        //implement business logic here:

        InventoryUpdated inventoryUpdated = new InventoryUpdated(this);
        inventoryUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void updateStock(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
