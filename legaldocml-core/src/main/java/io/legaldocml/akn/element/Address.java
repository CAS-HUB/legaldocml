package io.legaldocml.akn.element;

import io.legaldocml.akn.group.SpeechSection;
import io.legaldocml.akn.visitor.AknVisitor;
import io.legaldocml.util.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

import static io.legaldocml.akn.AknElements.ADDRESS;

/**
 * This element is a structural container for parts of a debates that are relevant to addresses.
 *
 * <pre>
 *  <xsd:element name="address" type="althierarchy"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Address extends AltHierarchy implements SpeechSection {

    /**
     * Memory address.
     */
    private static final long ADDRESS_ADDRESS = Buffers.address(ADDRESS);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_ADDRESS, 7);
        super.write(writer);
        writer.writeEnd(ADDRESS_ADDRESS, 7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(AknVisitor visitor) {
        if (visitor.visitEnter(this)) {
            super.accept(visitor);
            visitor.visitLeave(this);
        }
    }

}