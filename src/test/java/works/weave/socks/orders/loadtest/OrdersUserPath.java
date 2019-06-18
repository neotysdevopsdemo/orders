package works.weave.socks.orders.loadtest;

import com.google.common.collect.ImmutableList;
import com.neotys.neoload.model.repository.*;
import com.neotys.testing.framework.BaseNeoLoadDesign;
import com.neotys.testing.framework.BaseNeoLoadUserPath;

import java.util.List;

import static java.util.Collections.emptyList;


public class OrdersUserPath extends BaseNeoLoadUserPath {
    public OrdersUserPath(BaseNeoLoadDesign design) {
        super(design);
    }

    @Override
    public UserPath createVirtualUser(BaseNeoLoadDesign baseNeoLoadDesign) {
        final Server server = baseNeoLoadDesign.getServerByName("Carts_Server");
        final ConstantVariable constantpath= (ConstantVariable) baseNeoLoadDesign.getVariableByName("orderPath");


        final List<Header> headerList= ImmutableList.of(
                header("Cache-Control","no-cache"),
                header("Content-Type","application/json"),
                header("json","true")
        );
        final Request getRequest = getBuilder(server, variabilize(constantpath), emptyList(),emptyList(),emptyList()).build();

        final Delay delay = thinkTime(250);
        final ImmutableContainerForMulti actionsContainer = actionsContainerBuilder()
                .addChilds(container("Orders", getRequest, delay))
                .build();

        return userPathBuilder("Orders")
                .actionsContainer(actionsContainer)
                .build();
    }
}
