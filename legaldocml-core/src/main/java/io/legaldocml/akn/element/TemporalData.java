package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.attribute.Source;
import io.legaldocml.akn.type.AgentRef;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.Externalizable;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.AknElements.TEMPORAL_DATA;
import static io.legaldocml.akn.AknElements.TEMPORAL_GROUP;
import static io.legaldocml.akn.element.Attributes.biConsumerAgentRef;
import static io.legaldocml.akn.util.XmlWriterHelper.writeSource;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;


/**
 * <pre>
 *   <xsd:element name="temporalData">
 *     <xsd:complexType>
 *       <xsd:sequence>
 *         <xsd:element ref="temporalGroup" minOccurs="1" maxOccurs="unbounded"/>
 *       <xsd:sequence>
 *       <xsd:attributeGroup ref="source"/>
 *     <xsd:complexType>
 *   <xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class TemporalData implements Source {

    /**
     * Memory address.
     */
    private static final long ADDRESS_TEMPORAL_DATA = Buffers.address(TEMPORAL_DATA);

    private static final ImmutableMap<String, BiConsumer<Externalizable, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<Externalizable, CharArray>>builder()
                .put(AknAttributes.SOURCE, biConsumerAgentRef(getFieldOffset(TemporalData.class, "source")))
                .build();
    }

    // Mandatory (min 1).
    private final AknList<TemporalGroup> elements = new AknList<>(new TemporalGroup[4]);

    // Mandatory
    private AgentRef source;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_TEMPORAL_DATA, 12);
        writeSource(writer, this);
        this.elements.write(writer);
        writer.writeEnd(ADDRESS_TEMPORAL_DATA, 12);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        Attributes.read(reader, this);
        reader.nextStartOrEndElement();
        if (reader.getQName().equalsLocalName(TEMPORAL_GROUP)) {
            TemporalGroup temporalGroup;
            do {
                temporalGroup = new TemporalGroup();
                temporalGroup.read(reader);
                this.elements.add(temporalGroup);
                reader.nextStartOrEndElement();
            } while (reader.getQName().equalsLocalName(TEMPORAL_GROUP));
        }
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
    public String name() {
        return TEMPORAL_DATA;
    }

}