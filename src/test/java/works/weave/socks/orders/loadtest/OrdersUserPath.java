package works.weave.socks.orders.loadtest;

import com.google.common.collect.ImmutableList;
import com.neotys.neoload.model.repository.*;
import com.neotys.neoload.model.v3.project.server.Server;
import com.neotys.neoload.model.v3.project.userpath.Container;
import com.neotys.neoload.model.v3.project.userpath.ImmutableRequest;
import com.neotys.neoload.model.v3.project.userpath.ThinkTime;
import com.neotys.neoload.model.v3.project.variable.Variable;
import com.neotys.testing.framework.BaseNeoLoadDesign;
import com.neotys.testing.framework.BaseNeoLoadUserPath;

import java.util.List;
import java.util.Optional;

import static com.neotys.testing.framework.utils.NeoLoadHelper.variabilize;
import static java.util.Collections.emptyList;


public class OrdersUserPath extends BaseNeoLoadUserPath {
    public OrdersUserPath(BaseNeoLoadDesign design) {
        super(design);
    }

    @Override
    public com.neotys.neoload.model.v3.project.userpath.UserPath createVirtualUser(BaseNeoLoadDesign baseNeoLoadDesign) {
        final Server server = baseNeoLoadDesign.getServerByName("carts_host");
        final Variable constantpath= baseNeoLoadDesign.getVariableByName("orderPath");



        final ImmutableRequest getRequest = getBuilder(server, variabilize(constantpath), emptyList(),emptyList(),Optional.empty()).build();

        final ThinkTime delay = thinkTime(250);
        final Container actionsContainer = actionsContainerBuilder()
                .addSteps(container("Orders",Optional.empty(), getRequest, delay))
                .build();

        return userPathBuilder("Orders")
                .actions(actionsContainer)
                .build();
    }
}
