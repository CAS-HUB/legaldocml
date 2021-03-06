package io.legaldocml.akn.element;

import io.legaldocml.akn.group.ANtitleInline;
import io.legaldocml.akn.visitor.AknVisitor;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.util.Buffers;

import java.io.IOException;

import static io.legaldocml.akn.AknElements.DOC_AUTHORITY;

/**
 * The element docAuthority is an inline element within preface to identify the string used by the document detailing
 * the Auhtority to which the document was submitted.
 *
 * <pre>
 *   <xsd:element name="docAuthority" type="inline"/>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class DocAuthority extends InlineType implements ANtitleInline {

    /**
     * Memory address.
     */
    private static final long ADDRESS_DOC_AUTHORITY = Buffers.address(DOC_AUTHORITY);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_DOC_AUTHORITY, 12);
        super.write(writer);
        writer.writeEnd(ADDRESS_DOC_AUTHORITY, 12);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return DOC_AUTHORITY;
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