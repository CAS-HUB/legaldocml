package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.For;
import io.legaldocml.akn.attribute.Quote;
import io.legaldocml.akn.type.EidRef;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerEidRef;
import static io.legaldocml.akn.element.Attributes.biConsumerString;
import static io.legaldocml.akn.util.XmlWriterHelper.writeFor;
import static io.legaldocml.akn.util.XmlWriterHelper.writeQuote;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * the element quotedStructure is a subFlow element containing a full structure proposed as an insertion or a
 * replacement. Attribute quote is used to specify the quote character used in the original; no quote attribute implies
 * that the quote is left in the text; quote="" implies that there is no quote character. Attribute for is used in a
 * mmod or rmod to point to the eId of the corresponding ref element.
 * <p/>
 * <pre>
 *   <xsd:element name="quotedStructure">
 *     <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="subFlowStructure">
 *           <xsd:attributeGroup ref="quote"/>
 *           <xsd:attributeGroup ref="for"/>
 *         </xsd:extension>
 *       </xsd:complexContent>
 *     </xsd:complexType>
 *   </xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class QuotedStructureV3 extends SubFlowStructure implements QuotedStructure, For, Quote {

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(SubFlowStructure.ATTRIBUTES)
                .put(For.ATTRIBUTE, biConsumerEidRef(getFieldOffset(QuotedStructureV3.class, "_for")))
                .put(Quote.ATTRIBUTE_STARTQUOTE, biConsumerString(getFieldOffset(QuotedStructureV3.class, "startQuote")))
                .put(Quote.ATTRIBUTE_ENDQUOTE, biConsumerString(getFieldOffset(QuotedStructureV3.class, "endQuote")))
                .put(Quote.ATTRIBUTE_INLINEQUOTE, biConsumerString(getFieldOffset(QuotedStructureV3.class, "inlineQuote")))
                .build();

    }

    private EidRef _for;
    private String startQuote;
    private String endQuote;
    private String inlineQuote;

    /**
     * {@inheritDoc}
     */
    @Override
    public EidRef getFor() {
        return this._for;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFor(EidRef _for) {
        this._for = _for;
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
        writer.writeStart(ADDRESS, 15);
        writeFor(writer, this);
        writeQuote(writer, this);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }
}