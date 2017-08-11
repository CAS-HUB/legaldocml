package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Core;
import io.legaldocml.akn.attribute.Enactment;
import io.legaldocml.akn.attribute.Modifiers;
import io.legaldocml.akn.attribute.Period;
import io.legaldocml.akn.attribute.RefersOpt;
import io.legaldocml.akn.type.ListReferenceRef;
import io.legaldocml.akn.type.StatusType;
import io.legaldocml.akn.type.TemporalGroupRef;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerBoolean;
import static io.legaldocml.akn.element.Attributes.biConsumerEnum;
import static io.legaldocml.akn.element.Attributes.biConsumerListReferenceRef;
import static io.legaldocml.akn.element.Attributes.biConsumerTemporalGroupRef;
import static io.legaldocml.akn.util.XmlWriterHelper.writeEnactment;
import static io.legaldocml.akn.util.XmlWriterHelper.writeModifiers;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRefers;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The complex type modificationType lists all the properties associated to modification elements.
 * <p/>
 * <p>
 * <pre>
 *   <xsd:complexType name="modificationType">
 * 	   <xsd:sequence>
 * 	     <xsd:element ref="source" minOccurs="1" maxOccurs="unbounded" />
 * 		 <xsd:element ref="destination" minOccurs="1" maxOccurs="unbounded" />
 * 		 <xsd:element ref="force" minOccurs="0" maxOccurs="1" />
 * 		 <xsd:element ref="efficacy" minOccurs="0" maxOccurs="1" />
 * 		 <xsd:element ref="application" minOccurs="0" maxOccurs="1" />
 * 		 <xsd:element ref="duration" minOccurs="0" maxOccurs="1" />
 * 		 <xsd:element ref="condition" minOccurs="0" maxOccurs="1" />
 *     </xsd:sequence>
 * 	   <xsd:attributeGroup ref="core"/>
 * 	   <xsd:attributeGroup ref="idreq" />
 * 	   <xsd:attributeGroup ref="enactment" />
 * 	   <xsd:attributeGroup ref="modifiers" />
 * 	   <xsd:attributeGroup ref="refers" />
 *   </xsd:complexType>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class ModificationType extends IdReqImpl implements Core, Enactment, Modifiers, RefersOpt {

    protected static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {

        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(IdReqImpl.ATTRIBUTES)
                .put(Enactment.ATTRIBUTE, biConsumerEnum(getFieldOffset(ModificationType.class, "statusType"), StatusType.class))
                .put(Period.ATTRIBUTE, biConsumerTemporalGroupRef(getFieldOffset(ModificationType.class, "period")))
                .put(RefersOpt.ATTRIBUTE, biConsumerListReferenceRef(getFieldOffset(ModificationType.class, "refersTo")))
                .put(Modifiers.ATTRIBUTE_EXCLUSION, biConsumerBoolean(getFieldOffset(ModificationType.class, "exclusion")))
                .put(Modifiers.ATTRIBUTE_INCOMPLETE, biConsumerBoolean(getFieldOffset(ModificationType.class, "incomplete")))
                .build();
    }

    // enactment
    private TemporalGroupRef period;
    private StatusType statusType;
    // RefersOpt
    private ListReferenceRef refersTo;
    // Modifiers
    private Boolean exclusion;
    private Boolean incomplete;


    private final AknList<Source> sources = new AknList<Source>(new Source[2]);
    private final AknList<Destination> destinations = new AknList<Destination>(new Destination[2]);

    private Force force;
    private Efficacy efficacy;
    private Application application;
    private Duration duration;
    private Condition condition;

    /**
     * {@inheritDoc}
     */
    @Override
    public TemporalGroupRef getPeriod() {
        return this.period;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPeriod(TemporalGroupRef period) {
        this.period = period;
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
    public StatusType getStatus() {
        return this.statusType;
    }

    /**
     * {@inheritDoc}
     */
    public void setStatus(StatusType status) {
        this.statusType = status;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean getExclusion() {
        return this.exclusion;
    }

    /**
     * {@inheritDoc}
     */
    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean getIncomplete() {
        return this.incomplete;
    }

    /**
     * {@inheritDoc}
     */
    public void setIncomplete(Boolean incomplete) {
        this.incomplete = incomplete;
    }

    public void addSource(Source source) {
        this.sources.add(source);
    }

    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        super.write(writer);
        writeRefers(writer, this);
        writeEnactment(writer, this);
        writeModifiers(writer, this);
        this.sources.write(writer);
        this.destinations.write(writer);
        if (this.force != null) {
            this.force.write(writer);
        }
        if (this.efficacy != null) {
            this.efficacy.write(writer);
        }
        if (this.application != null) {
            this.application.write(writer);
        }
        if (this.duration != null) {
            this.duration.write(writer);
        }
        if (this.condition != null) {
            this.condition.write(writer);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        super.read(reader);

        reader.nextStartOrEndElement();

        if (reader.getQName().equalsLocalName(Source.ELEMENT)) {
            Source source;
            do {
                source = new Source();
                source.read(reader);
                this.sources.add(source);
                reader.nextStartOrEndElement();
            } while (reader.getQName().equalsLocalName(Source.ELEMENT));
        }

        if (reader.getQName().equalsLocalName(Destination.ELEMENT)) {
            Destination destination;
            do {
                destination = new Destination();
                destination.read(reader);
                this.destinations.add(destination);
                reader.nextStartOrEndElement();
            } while (reader.getQName().equalsLocalName(Destination.ELEMENT));
        }

        if (reader.getQName().equalsLocalName(Force.ELEMENT)) {
            this.force = new Force();
            this.force.read(reader);
        }
        if (reader.getQName().equalsLocalName(Efficacy.ELEMENT)) {
            this.efficacy = new Efficacy();
            this.efficacy.read(reader);
        }
        if (reader.getQName().equalsLocalName(Application.ELEMENT)) {
            this.application = new Application();
            this.application.read(reader);
        }
        if (reader.getQName().equalsLocalName(Duration.ELEMENT)) {
            this.duration = new Duration();
            this.duration.read(reader);
        }
        if (reader.getQName().equalsLocalName(Condition.ELEMENT)) {
            this.condition = new Condition();
            this.condition.read(reader);
        }
    }

    @Override
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }

    //	/** {@inheritDoc} */
//	public void readExternal(Input in) throws IOException {
//		in.read(this);
//		in.nextStartOrEndElement();
//
//		// handle source
//		Source source;
//		while (Source.ELEMENT_SOURCE == in.getLocalName()) {
//			source = new Source();
//			source.readExternal(in);
//			_sources.add(source);
//			in.nextStartOrEndElement();
//		}
//
//		// handle destination
//		Destination destination;
//		while (Destination.ELEMENT_DESTINATION == in.getLocalName()) {
//			destination = new Destination();
//			destination.readExternal(in);
//			_destinations.add(destination);
//			in.nextStartOrEndElement();
//		}
//
//		if (Duration.ELEMENT_DURATION == in.getLocalName()) {
//			_duration = new Duration();
//			_duration.readExternal(in);
//		}
//	}

}