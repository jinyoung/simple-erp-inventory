package simpleerpinventory.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simpleerpinventory.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @RequestMapping(
        value = "inventories/{id}//inventories/{id}",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Inventory updateInventory(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateInventoryCommand updateInventoryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /inventory/updateInventory  called #####");
        Optional<Inventory> optionalInventory = inventoryRepository.findById(
            id
        );

        optionalInventory.orElseThrow(() -> new Exception("No Entity Found"));
        Inventory inventory = optionalInventory.get();
        inventory.updateInventory(updateInventoryCommand);

        inventoryRepository.save(inventory);
        return inventory;
    }
}
//>>> Clean Arch / Inbound Adaptor
