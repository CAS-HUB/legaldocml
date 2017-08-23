package io.legaldocml.akn.element;

import io.legaldocml.akn.group.HTMLinline;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * The element u is an HTML element and is used in Akoma Ntoso as in HTML, for the underline style (an inline).
 *
 * <pre>
 * 	 <xsd:element name="u" type="inline"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class U extends InlineType implements HTMLinline {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "u";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 1);
        super.write(writer);
        writer.writeEnd(ADDRESS, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

}