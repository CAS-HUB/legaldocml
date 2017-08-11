package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Source;
import io.legaldocml.akn.type.AgentRef;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerAgentRef;
import static io.legaldocml.akn.util.XmlWriterHelper.writeSource;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * <pre>
 *   <xsd:element name="analysis">
 *     <xsd:complexType>
 *       <xsd:sequence>
 *         <xsd:element ref="activeModifications" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="passiveModifications" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="restrictions" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="judicial" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="parliamentary" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="mappings" minOccurs="0" maxOccurs="1"/>
 *         <xsd:element ref="otherReferences" minOccurs="0" maxOccurs="unbounded"/>
 *         <xsd:element ref="otherAnalysis" minOccurs="0" maxOccurs="unbounded"/>
 *        </xsd:sequence>
 *        <xsd:attributeGroup ref="source" />
 *     </xsd:complexType>
 *   </xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Analysis implements Source {

    /**
     * Xml element name.
     */
    public static final String ELEMENT = "analysis";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .put(Source.ATTRIBUTE, biConsumerAgentRef(getFieldOffset(Analysis.class, "source")))
                .build();
    }

    private AgentRef source;

    private ActiveModifications activeModifications;
    private PassiveModifications passiveModifications;
    private Restrictions restrictions;
    private Judicial judicial;
    private Parliamentary parliamentary;
    private Mappings mappings;
    private AknList<OtherReferences> otherReferences;
    private AknList<OtherAnalysis> otherAnalysis;

    /**
     * {@inheritDoc}
     */
    public AgentRef getSource() {
        return this.source;
    }

    /**
     * {@inheritDoc}
     */
    public void setSource(AgentRef source) {
        this.source = source;
    }

    public ActiveModifications getActiveModifications() {
        return this.activeModifications;
    }

    public void setActiveModifications(ActiveModifications activeModifications) {
        this.activeModifications = activeModifications;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 8);
        writeSource(writer, this);

        if (this.activeModifications != null) {
            this.activeModifications.write(writer);
        }

        if (this.passiveModifications != null) {
            this.passiveModifications.write(writer);
        }

        if (this.restrictions != null) {
            this.restrictions.write(writer);
        }

        if (this.judicial != null) {
            this.judicial.write(writer);
        }

        if (this.parliamentary != null) {
            this.parliamentary.write(writer);
        }

        if (this.mappings != null) {
            this.mappings.write(writer);
        }

        if (this.otherReferences != null && this.otherReferences.size() > 0) {
            this.otherReferences.write(writer);
        }

        if (this.otherAnalysis != null && this.otherAnalysis.size() > 0) {
            this.otherAnalysis.write(writer);
        }

        writer.writeEnd(ADDRESS, 8);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        Attributes.read(reader, this);
        reader.nextStartOrEndElement();

        if (reader.getQName().equalsLocalName(ActiveModifications.ELEMENT)) {
            this.activeModifications = new ActiveModifications();
            this.activeModifications.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(PassiveModifications.ELEMENT)) {
            this.passiveModifications = new PassiveModifications();
            this.passiveModifications.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(Restrictions.ELEMENT)) {
            this.restrictions = new Restrictions();
            this.restrictions.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(Judicial.ELEMENT)) {
            this.judicial = new Judicial();
            this.judicial.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(Parliamentary.ELEMENT)) {
            this.parliamentary = new Parliamentary();
            this.parliamentary.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(Mappings.ELEMENT)) {
            this.mappings = new Mappings();
            this.mappings.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(OtherReferences.ELEMENT)) {
            OtherReferences otherReferences;
            this.otherReferences = new AknList<>(new OtherReferences[4]);
            do {
                otherReferences = new OtherReferences();
                otherReferences.read(reader);
                this.otherReferences.add(otherReferences);
                reader.nextStartOrEndElement();
            } while (reader.getQName().equalsLocalName(OtherReferences.ELEMENT));
        }

        if (reader.getQName().equalsLocalName(OtherAnalysis.ELEMENT)) {
            OtherAnalysis otherAnalysis;
            this.otherAnalysis = new AknList<>(new OtherAnalysis[4]);
            do {
                otherAnalysis = new OtherAnalysis();
                otherAnalysis.read(reader);
                this.otherAnalysis.add(otherAnalysis);
                reader.nextStartOrEndElement();
            } while (reader.getQName().equalsLocalName(OtherAnalysis.ELEMENT));
        }

    }

    /**
     * {@inheritDoc}
     */
    public String name() {
        return ELEMENT;
    }

}