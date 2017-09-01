package io.legaldocml.business.builder;

import io.legaldocml.akn.attribute.Id;
import io.legaldocml.akn.container.BlockElementsContainer;
import io.legaldocml.akn.element.Table;
import io.legaldocml.business.builder.support.BlockListSupport;
import io.legaldocml.business.builder.support.ForeignSupport;
import io.legaldocml.business.builder.support.PSupport;
import io.legaldocml.business.util.EidFactory;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public class BlocksBuilder<T extends BlockElementsContainer> extends BusinessPartBuilder implements PSupport<T>, ForeignSupport<T>, BlockListSupport<T> {

    private final Id parent;
    private final T container;

    public BlocksBuilder(BusinessBuilder businessBuilder, Id parent, T container) {
        super(businessBuilder);
        this.parent = parent;
        this.container = container;
    }

    public BlocksBuilder<T> eid(String number) {
        EidFactory.makeAndFill(this.parent, this.container, number);
        return this;
    }

    public TableBuilder table() {
        Table table = new Table();
        this.container.add(table);
        return new TableBuilder(getBusinessBuilder(), table);
    }

    @Override
    public T getParent() {
        return container;
    }
}
