package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.For;
import io.legaldocml.akn.attribute.RefersOpt;
import io.legaldocml.akn.attribute.ShowOpt;
import io.legaldocml.akn.type.EidRef;
import io.legaldocml.akn.type.ListReferenceRef;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerListReferenceRef;
import static io.legaldocml.akn.element.Attributes.biConsumerString;
import static io.legaldocml.akn.util.XmlWriterHelper.writeFor;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRefers;
import static io.legaldocml.akn.util.XmlWriterHelper.writeShow;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element implicitReference contains a legal reference to a document that is not explicitly mentioned in the
 * content of the document.
 * <p/>
 * <pre>
 *   <xsd:element name="implicitReference" type="anyOtherType">
 * 	   <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="anyOtherType">
 *           <xsd:attribute name="for" type="eIdRef"/>
 *           <xsd:attributeGroup ref="refers"/>
 *           <xsd:attributeGroup ref="showopt"/>
 *         </xsd:extension>
 *       </xsd:complexContent>
 *     </xsd:complexType>
 *   </xsd:element>
 * <pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class ImplicitReference extends AnyOtherType implements RefersOpt, ShowOpt, For, OtherReferencesElement {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "implicitReference";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(AnyOtherType.ATTRIBUTES)
                .put(RefersOpt.ATTRIBUTE, biConsumerListReferenceRef(getFieldOffset(ImplicitReference.class, "refersTo")))
                .put(ShowOpt.ATTRIBUTE_SHOW_AS, biConsumerString(getFieldOffset(ImplicitReference.class, "showAs")))
                .put(ShowOpt.ATTRIBUTE_SHORT_FORM, biConsumerString(getFieldOffset(ImplicitReference.class, "shortForm")))
                .put(For.ATTRIBUTE, biConsumerString(getFieldOffset(ImplicitReference.class, "for_")))
                .build();
    }

    private ListReferenceRef refersTo;
    private String showAs;
    private String shortForm;
    private EidRef for_;

    public EidRef getFor() {
        return this.for_;
    }

    public void setFor(EidRef for_) {
        this.for_ = for_;
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
    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

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
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 17);
        writeRefers(writer, this);
        writeShow(writer, this);
        writeFor(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS, 17);
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