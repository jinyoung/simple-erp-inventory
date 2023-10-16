package simpleerpinventory.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateInventoryCommand {

    private String name;
    private Integer quantity;
}
