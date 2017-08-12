package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Actor;
import io.legaldocml.akn.attribute.Agent;
import io.legaldocml.akn.attribute.Date;
import io.legaldocml.akn.attribute.Outcome;
import io.legaldocml.akn.attribute.Role;
import io.legaldocml.akn.type.AgentRef;
import io.legaldocml.akn.type.ConceptRef;
import io.legaldocml.akn.type.RoleRef;
import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerAgentRef;
import static io.legaldocml.akn.element.Attributes.biConsumerConceptRef;
import static io.legaldocml.akn.element.Attributes.biConsumerDateTime;
import static io.legaldocml.akn.element.Attributes.biConsumerRoleRef;
import static io.legaldocml.akn.element.Attributes.biConsumerString;
import static io.legaldocml.akn.util.XmlWriterHelper.writeActor;
import static io.legaldocml.akn.util.XmlWriterHelper.writeAgent;
import static io.legaldocml.akn.util.XmlWriterHelper.writeDate;
import static io.legaldocml.akn.util.XmlWriterHelper.writeOutcome;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRole;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element step is a metadata element specifying facts about a workflow step occurred to the document. For each
 * event, a date, a type, an agent (and the corresponding role) that generated the action must be referenced. The
 * outcome, too, can be specified.
 *
 * <pre>
 *   &lt;xsd:element name="step"&gt;
 * 	   &lt;xsd:complexType&gt;
 * 	     &lt;xsd:complexContent&gt;
 * 		   &lt;xsd:extension base="anyOtherType"&gt;
 * 		     &lt;xsd:attributeGroup ref="date"/&gt;
 * 			 &lt;xsd:attributeGroup ref="agent"/&gt;
 * 			 &lt;xsd:attributeGroup ref="actor"/&gt;
 * 		 	 &lt;xsd:attributeGroup ref="role"/&gt;
 * 		 	 &lt;xsd:attributeGroup ref="outcome"/&gt;
 * 		   &lt;xsd:extension&gt;
 * 	     &lt;xsd:complexContent&gt;
 * 	   &lt;xsd:complexType&gt;
 *   &lt;xsd:element&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Step extends AnyOtherType implements Role, Date, Outcome, Actor, Agent {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "step";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(AnyOtherType.ATTRIBUTES)
                .put(Date.ATTRIBUTE, biConsumerDateTime(getFieldOffset(Step.class, "date")))
                .put(Role.ATTRIBUTE, biConsumerRoleRef(getFieldOffset(Step.class, "as")))
                .put(Outcome.ATTRIBUTE, biConsumerConceptRef(getFieldOffset(Step.class, "outcome")))
                .put(Actor.ATTRIBUTE, biConsumerString(getFieldOffset(Step.class, "actor")))
                .put(Agent.ATTRIBUTE, biConsumerAgentRef(getFieldOffset(Step.class, "by")))
                .build();
    }

    private RoleRef as;
    private OffsetDateTime date;
    private ConceptRef outcome;
    private String actor;
    private AgentRef by;

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime getDate() {
        return this.date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRef getAs() {
        return this.as;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAs(RoleRef as) {
        this.as = as;
    }

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
    public String getActor() {
        return this.actor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public AgentRef getBy() {
        return this.by;
    }

    @Override
    public void setBy(AgentRef by) {
        this.by = by;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        super.read(reader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 4);
        writeDate(writer, this);
        writeOutcome(writer, this);
        writeActor(writer, this);
        writeRole(writer, this);
        if (writer.getVersion() > 2) {
            writeAgent(writer, this);
        }
        super.write(writer);
        writer.writeEnd(ADDRESS, 4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

    @Override
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }
}