package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.LawyerAtts;
import io.legaldocml.akn.group.ANheaderInline;
import io.legaldocml.akn.type.AgentRef;
import io.legaldocml.akn.type.RoleRef;
import io.legaldocml.io.AttributeGetterSetter;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.util.Buffers;

import java.io.IOException;

import static io.legaldocml.akn.AknElements.LAWYER;
import static io.legaldocml.akn.element.Attributes.attributeGetterSetter4RoleRef;
import static io.legaldocml.akn.util.XmlWriterHelper.writeLawyerAtts;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element lawyer is an inline element within judgments to identify where the document defines one of the lawyers,
 * his/her role, which party it represents, and the other lawyer, if any, this lawyer received the power delegation of
 * power in some role.
 * <p>
 * <pre>
 * 	 <xsd:element name="lawyer">
 * 	   <xsd:complexType mixed="true">
 *       <xsd:complexContent>
 *         <xsd:extension base="inlinereqreq">
 *           <xsd:attributeGroup ref="lawyerAtts"/>
 *         <xsd:extension>
 *       <xsd:complexContent>
 *     <xsd:complexType>
 *   <xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Lawyer extends InlineReqReqType implements LawyerAtts, ANheaderInline {

    /**
     * Memory address.
     */
    private static final long ADDRESS_LAWYER = Buffers.address(LAWYER);

    private static final ImmutableMap<String, AttributeGetterSetter<AknObject>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, AttributeGetterSetter<AknObject>>builder()
                .putAll(InlineReqReqType.ATTRIBUTES)
                .put(AknAttributes.AS, attributeGetterSetter4RoleRef(AknAttributes.AS, getFieldOffset(Lawyer.class, "as")))
                .put(AknAttributes.FOR, attributeGetterSetter4RoleRef(AknAttributes.FOR, getFieldOffset(Lawyer.class, "_for")))
                .put(AknAttributes.EMPOWERED_BY, attributeGetterSetter4RoleRef(AknAttributes.EMPOWERED_BY, getFieldOffset(Lawyer.class, "empoweredBy")))
                .build();
    }

    private RoleRef as;
    private AgentRef _for;
    private AgentRef empoweredBy;

    /**
     * {@inheritDoc}
     */
    @Override
    public AgentRef getFor() {
        return this._for;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFor(AgentRef for_) {
        this._for = for_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgentRef getEmpoweredBy() {
        return this.empoweredBy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEmpoweredBy(AgentRef empoweredBy) {
        this.empoweredBy = empoweredBy;
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
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_LAWYER, 6);
        writeLawyerAtts(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS_LAWYER, 6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return LAWYER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, AttributeGetterSetter<AknObject>> attributes() {
        return ATTRIBUTES;
    }
}