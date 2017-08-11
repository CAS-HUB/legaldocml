package io.legaldocml.akn.element;

import io.legaldocml.akn.group.TLC;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;

/**
 * The element TLCOrganization is a metadata reference to the Akoma Ntoso IRI of an ontology instance of the class
 * Organization.
 * <p/>
 * <pre>
 *   <xsd:element name="TLCOrganization" type="referenceType"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class TLCOrganization extends ReferenceType implements TLC {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "TLCOrganization";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 15);
        super.write(writer);
        writer.writeEnd(ADDRESS, 15);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }
}