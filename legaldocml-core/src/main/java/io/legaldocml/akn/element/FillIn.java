package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.FillInWidth;
import io.legaldocml.akn.group.ANinline;
import io.legaldocml.util.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.AknElements.FILL_IN;
import static io.legaldocml.akn.util.XmlWriterHelper.writeFillInWidth;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * the element fillIn is an inline element shown as a dotted line or any other typoaphical characteristics to represent
 * a fill-in element in a printed form, that is as ane example of an actual form. It is NOT meant to be used for form
 * elements as in HTML, i.e. as a way to collect input from the reader and deliver to some server-side process.
 *
 * <pre>
 *   <xsd:element name="fillIn">
 * 	   <xsd:complexType mixed="true">
 * 	     <xsd:complexContent>
 * 		   <xsd:extension base="inline">
 * 		     <xsd:attributeGroup ref="fillInWidth"/>
 * 		   <xsd:extension>
 * 	     <xsd:complexContent>
 * 	   <xsd:complexType>
 *   <xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class FillIn extends InlineType implements ANinline, FillInWidth {

    /**
     * Memory address.
     */
    private static final long ADDRESS_FILL_IN = Buffers.address(FILL_IN);

    private static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .putAll(InlineType.ATTRIBUTES)
                .put(AknAttributes.WIDTH, Attributes.biConsumerString(getFieldOffset(FillIn.class, "width")))
                .build();
    }

    private String width;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWidth() {
        return this.width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_FILL_IN, 6);
        writeFillInWidth(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS_FILL_IN, 6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return FILL_IN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<Externalizable, CharArray>> attributes() {
        return ATTRIBUTES;
    }

}