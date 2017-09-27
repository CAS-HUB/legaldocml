package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.Core;
import io.legaldocml.akn.attribute.IdReq;
import io.legaldocml.akn.attribute.LinkOpt;
import io.legaldocml.akn.attribute.Outcome;
import io.legaldocml.akn.attribute.RefersOpt;
import io.legaldocml.akn.type.ConceptRef;
import io.legaldocml.akn.type.ListReferenceRef;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.akn.util.XmlReaderHelper;
import io.legaldocml.util.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.util.Uri;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static io.legaldocml.akn.AknElements.COUNT;
import static io.legaldocml.akn.AknElements.QUORUM;
import static io.legaldocml.akn.element.Attributes.biConsumerConceptRef;
import static io.legaldocml.akn.element.Attributes.biConsumerListReferenceRef;
import static io.legaldocml.akn.element.Attributes.biConsumerUri;
import static io.legaldocml.akn.util.XmlWriterHelper.writeLinkOpt;
import static io.legaldocml.akn.util.XmlWriterHelper.writeOutcome;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRefers;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;


/**
 * The complex type parliamentaryAnalysisType lists all the properties associated to elements in the parliamentary
 * analysis.
 *
 * <pre>
 *   <xsd:complexType name="parliamentaryAnalysisType">
 * 	   <xsd:choice minOccurs="1" maxOccurs="unbounded">
 * 	     <xsd:element ref="quorum"/>
 * 		 <xsd:element ref="count"/>
 * 	   </xsd:choice>
 * 	   <xsd:attributeGroup ref="core"/>
 * 	   <xsd:attributeGroup ref="idreq"/>
 * 	   <xsd:attributeGroup ref="outcome"/>
 * 	   <xsd:attributeGroup ref="refers"/>
 * 	   <xsd:attributeGroup ref="linkopt"/>
 *   </xsd:complexType>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class ParliamentaryAnalysisType extends AbstractId implements Core, IdReq, RefersOpt, LinkOpt, Outcome {

    protected static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    private static final ImmutableMap<String, Supplier<ParliamentaryAnalysisTypeElement>> ELEMS;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .putAll(AbstractId.ATTRIBUTES)
                .put(AknAttributes.REFERS_TO, biConsumerListReferenceRef(getFieldOffset(ParliamentaryAnalysisType.class, "refersTo")))
                .put(AknAttributes.HREF, biConsumerUri(getFieldOffset(ParliamentaryAnalysisType.class, "href")))
                .put(AknAttributes.OUTCOME, biConsumerConceptRef(getFieldOffset(ParliamentaryAnalysisType.class, "outcome")))
                .build();

        ELEMS = ImmutableMap.<String, Supplier<ParliamentaryAnalysisTypeElement>>builder()
                .put(QUORUM, Quorum::new)
                .put(COUNT, Count::new)
                .build();
    }


    // Mandatory (min 1).
    private final AknList<ParliamentaryAnalysisTypeElement> elements = new AknList<>(new ParliamentaryAnalysisTypeElement[4]);

    // Optional
    private ListReferenceRef refersTo;

    // Optional
    private ConceptRef outcome;

    // Optional
    private Uri href;

    /**
     * {@inheritDoc}
     */
    @Override
    public ConceptRef getOutcome() {
        return this.outcome;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOutcome(ConceptRef outcome) {
        this.outcome = outcome;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Uri getHref() {
        return this.href;
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
    public ListReferenceRef getRefersTo() {
        return this.refersTo;
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
    public void write(XmlWriter writer) throws IOException {
        IdReq.super.write(writer);
        Core.super.write(writer);
        writeLinkOpt(writer, this);
        writeRefers(writer, this);
        writeOutcome(writer, this);
        this.elements.write(writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        super.read(reader);
        XmlReaderHelper.read(reader, this.elements, ELEMS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<Externalizable, CharArray>> attributes() {
        return ATTRIBUTES;
    }
}