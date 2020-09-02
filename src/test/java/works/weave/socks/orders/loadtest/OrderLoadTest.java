package works.weave.socks.orders.loadtest;

import com.neotys.testing.framework.BaseNeoLoadDesign;
import com.neotys.testing.framework.NeoLoadTest;

import java.io.FileNotFoundException;
import java.util.Optional;

public class OrderLoadTest extends NeoLoadTest {
    @Override
    protected BaseNeoLoadDesign design() {
        try {
            return new TestingDesign(Optional.empty());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String projectName() {
        return "Orders_NeoLoad";
    }

    @Override
    public void createComplexPopulation() {

    }

    @Override
    public void createComplexScenario() {

    }

    @Override
    public void execute() {

        try {
            createSimpleConstantLoadScenario("Order_Load","Orders",600,49,10, Optional.empty());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            createSimpleConstantIterationScenario("DynatraceSanityCheck","BasicCheckTesting",15,1,0,Optional.empty());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
