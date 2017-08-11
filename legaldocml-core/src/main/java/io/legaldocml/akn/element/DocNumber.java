package io.legaldocml.akn.element;

import io.legaldocml.akn.group.ANtitleInline;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * The element docNumber is an inline element within preface to identify the string used by the document for its own
 * number.
 * <p/>
 * <p>
 * <pre>
 * 	 <xsd:element name="docNumber" type="inline"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class DocNumber extends InlineType implements ANtitleInline {

    /**
     * Xml Element Name.
     */
    public static final String ELEMENT = "docNumber";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 9);
        super.write(writer);
        writer.writeEnd(ADDRESS, 9);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

}