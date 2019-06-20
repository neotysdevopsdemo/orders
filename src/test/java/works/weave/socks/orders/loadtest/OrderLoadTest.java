package works.weave.socks.orders.loadtest;

import com.neotys.testing.framework.BaseNeoLoadDesign;
import com.neotys.testing.framework.NeoLoadTest;

public class OrderLoadTest extends NeoLoadTest {
    @Override
    protected BaseNeoLoadDesign design() {
        return new TestingDesign();
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

        createSimpleConstantLoadScenario("Order_Load","Orders",600,49,10);
        createSimpleConstantIterationScenario("DynatraceSanityCheck","BasicCheckTesting",15,1,0);
        createSanityCheckScenario();
    }
}
