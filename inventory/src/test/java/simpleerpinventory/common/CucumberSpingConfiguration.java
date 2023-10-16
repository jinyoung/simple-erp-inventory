package simpleerpinventory.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import simpleerpinventory.InventoryApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { InventoryApplication.class })
public class CucumberSpingConfiguration {}
