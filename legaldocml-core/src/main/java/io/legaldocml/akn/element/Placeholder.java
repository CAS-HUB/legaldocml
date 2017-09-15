package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.OriginalText;
import io.legaldocml.akn.group.ANinline;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.AknElements.PLACE_HOLDER;
import static io.legaldocml.akn.util.XmlWriterHelper.writeOriginalText;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * the element placeholder is an inline element containing the text of a computable expression (e.g., '30 days after the
 * publication of this act') that can be replaced editorially with an actual value.
 *
 * <pre>
 *   <xsd:element name="placeholder">
 * 	   <xsd:complexType mixed="true">
 * 	     <xsd:complexContent>
 * 		   <xsd:extension base="inline">
 * 		     <xsd:attributeGroup ref="originalText"/>
 * 		   <xsd:extension>
 * 		 <xsd:complexContent>
 * 	   <xsd:complexType>
 *   <xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Placeholder extends InlineType implements OriginalText, ANinline {

    /**
     * Memory address.
     */
    private static final long ADDRESS_PLACE_HOLDER = Buffers.address(PLACE_HOLDER);

    private static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .putAll(InlineType.ATTRIBUTES)
                .put(AknAttributes.ORIGINAL_TEXT, Attributes.biConsumerUri(getFieldOffset(Placeholder.class, "originalText")))
                .build();
    }

    private String originalText;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOriginalText() {
        return originalText;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_PLACE_HOLDER, 11);
        writeOriginalText(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS_PLACE_HOLDER, 11);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return PLACE_HOLDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<Externalizable, CharArray>> attributes() {
        return ATTRIBUTES;
    }

}