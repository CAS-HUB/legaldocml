package io.legaldocml.akn.element;

import io.legaldocml.akn.group.ANhier;
import io.legaldocml.util.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

import static io.legaldocml.akn.AknElements.SUB_SECTION;

/**
 * This element is a hierarchical container called "subsection" either explicitly or due to the local tradition.
 *
 * <pre>
 *   <xsd:element name="subsection" type="hierarchy"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Subsection extends Hierarchy implements ANhier {

    /**
     * Memory address.
     */
    private static final long ADDRESS_SUB_SECTION = Buffers.address(SUB_SECTION);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_SUB_SECTION, 10);
        super.write(writer);
        writer.writeEnd(ADDRESS_SUB_SECTION, 10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return SUB_SECTION;
    }

}
