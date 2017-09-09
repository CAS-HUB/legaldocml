package io.legaldocml.akn.element;


import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.RangeOpt;
import io.legaldocml.akn.attribute.RefersOpt;
import io.legaldocml.akn.attribute.ShowOpt;
import io.legaldocml.akn.type.EidRef;
import io.legaldocml.akn.type.ListReferenceRef;
import io.legaldocml.akn.visitor.AknVisitor;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerEidRef;
import static io.legaldocml.akn.element.Attributes.biConsumerListReferenceRef;
import static io.legaldocml.akn.element.Attributes.biConsumerString;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRange;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRefers;
import static io.legaldocml.akn.util.XmlWriterHelper.writeShow;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element FRBRportion is the metadata property containing the eId of the portion contained in a manifestation-level
 * portion. If the portion contains an interval of elements, the range attributes specifies the first and last one.
 * <p>
 * <pre>
 *   <xsd:element name="FRBRportion">
 *     <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="metaopt">
 *           <xsd:attributeGroup ref="refers"/>
 *           <xsd:attributeGroup ref="showopt"/>
 *           <xsd:attributeGroup ref="rangeOpt"/>
 *         </xsd:extension>
 *       </xsd:complexContent>
 *     </xsd:complexType>
 *   </xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class FRBRportion extends MetaOpt implements RefersOpt, ShowOpt, RangeOpt {

    /**
     * XML Tag element name.
     */
    public static final String ELEMENT = "FRBRportion";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .putAll(MetaOpt.ATTRIBUTES)
                .put(AknAttributes.REFERS_TO, biConsumerListReferenceRef(getFieldOffset(FRBRportion.class, "refersTo")))
                .put(AknAttributes.SHOW_AS, biConsumerString(getFieldOffset(FRBRportion.class, "showAs")))
                .put(AknAttributes.SHORT_FORM, biConsumerString(getFieldOffset(FRBRportion.class, "shortForm")))
                .put(AknAttributes.UP_TO, biConsumerEidRef(getFieldOffset(FRBRportion.class, "upTo")))
                .put(AknAttributes.FROM, biConsumerEidRef(getFieldOffset(FRBRportion.class, "from")))
                .build();
    }

    private ListReferenceRef refersTo;
    private String showAs;
    private String shortForm;
    private EidRef from;
    private EidRef upTo;

    /**
     * {@inheritDoc}
     */
    @Override
    public ListReferenceRef getRefersTo() {
        return this.refersTo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShowAs() {
        return this.showAs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRefersTo(ListReferenceRef refersTo) {
        this.refersTo = refersTo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowAs(String showAs) {
        this.showAs = showAs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShortForm() {
        return this.shortForm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EidRef getFrom() {
        return this.from;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFrom(EidRef eidRef) {
        this.from = from;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EidRef getUpTo() {
        return this.upTo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUpTo(EidRef upTo) {
        this.upTo = upTo;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 11);
        writeRefers(writer, this);
        writeShow(writer, this);
        writeRange(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS, 11);
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
    public ImmutableMap<String, BiConsumer<Externalizable, CharArray>> attributes() {
        return ATTRIBUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(AknVisitor visitor) {
        visitor.visit(this);
    }

}