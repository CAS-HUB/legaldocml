package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.LinkOpt;
import io.legaldocml.akn.attribute.Quote;
import io.legaldocml.akn.group.ANinline;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.util.Uri;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.AknElements.EMBEDDED_STRUCTURE;
import static io.legaldocml.akn.element.Attributes.biConsumerString;
import static io.legaldocml.akn.element.Attributes.biConsumerUri;
import static io.legaldocml.akn.util.XmlWriterHelper.writeLinkOpt;
import static io.legaldocml.akn.util.XmlWriterHelper.writeQuote;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * the element embeddedStructure is a subFlow element containing a full structure used as an extract from another
 * document or position. Attribute quote is used to specify the quote character used in the original; no quote attribute
 * implies that the quote is left in the text; quote="" implies that there is no quote character.
 *
 * <pre>
 *   <xsd:element name="embeddedStructure">
 * 	   <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="subFlowStructure">
 *           <xsd:attributeGroup ref="quote"/>
 *           <xsd:attributeGroup ref="linkopt"/>
 *         </xsd:extension>
 *       </xsd:complexContent>
 *     </xsd:complexType>
 * 	 </xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class EmbeddedStructure extends SubFlowStructure implements LinkOpt, Quote, ANinline{

    /**
     * Memory address.
     */
    private static final long ADDRESS_EMBEDDED_STRUCTURE = Buffers.address(EMBEDDED_STRUCTURE);


    private static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .putAll(SubFlowStructure.ATTRIBUTES)
                .put(AknAttributes.HREF, biConsumerUri(getFieldOffset(EmbeddedStructure.class, "href")))
                .put(AknAttributes.START_QUOTE, biConsumerString(getFieldOffset(EmbeddedStructure.class, "startQuote")))
                .put(AknAttributes.END_QUOTE, biConsumerString(getFieldOffset(EmbeddedStructure.class, "endQuote")))
                .put(AknAttributes.INLINE_QUOTE, biConsumerString(getFieldOffset(EmbeddedStructure.class, "inlineQuote")))
                .build();
    }

    private Uri href;
    private String startQuote;
    private String endQuote;
    private String inlineQuote;

    /**
     * {@inheritDoc}
     */
    @Override
    public Uri getHref() {
        return href;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHref(Uri href) {
        this.href = href;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStartQuote() {
        return startQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartQuote(String startQuote) {
        this.startQuote = startQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEndQuote() {
        return endQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEndQuote(String endQuote) {
        this.endQuote = endQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInlineQuote() {
        return inlineQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInlineQuote(String inlineQuote) {
        this.inlineQuote = inlineQuote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_EMBEDDED_STRUCTURE, 17);
        writeLinkOpt(writer, this);
        writeQuote(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS_EMBEDDED_STRUCTURE, 17);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return EMBEDDED_STRUCTURE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<Externalizable, CharArray>> attributes() {
        return ATTRIBUTES;
    }
}