package io.legaldocml.akn.element;

import io.legaldocml.akn.group.ANtitleInline;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * The element docType is an inline element within preface to identify the string used by the document for its own type.
 *
 * <pre>
 * 	 &lt;xsd:element name="docType" type="inline"/&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class DocType extends InlineType implements ANtitleInline {

    /**
     * XML Tag element name.
     */
    public static final String ELEMENT = "docType";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 7);
        super.write(writer);
        writer.writeEnd(ADDRESS, 7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

}