package io.legaldocml.akn.element;

import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * The element activeModifications is a metadata container of the active modifications generated by the document.
 * <p/>
 * <pre>
 * 	 <xsd:element name="activeModifications" type="Amendments"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class ActiveModifications extends Amendments {

    /**
     * XML element name.
     */
    public static final String ELEMENT = "activeModifications";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 19);
        super.write(writer);
        writer.writeEnd(ADDRESS, 19);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

}