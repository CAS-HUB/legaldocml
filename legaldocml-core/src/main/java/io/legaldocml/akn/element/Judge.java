package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Role;
import io.legaldocml.akn.group.ANheaderInline;
import io.legaldocml.akn.type.RoleRef;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.io.impl.Buffers;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerRoleRef;
import static io.legaldocml.akn.util.XmlWriterHelper.writeRole;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element judge is an inline element within judgments to identify where the document defines one of the judges, and
 * his/her role.
 *
 * <pre>
 * 	 &lt;xsd:element name="judge"&gt;
 * 	   &lt;xsd:complexType mixed="true"&gt;
 *       &lt;xsd:complexContent&gt;
 *         &lt;xsd:extension base="inlinereqreq"&gt;
 *           &lt;xsd:attributeGroup ref="role"/&gt;
 *         &lt;xsd:extension&gt;
 *       &lt;xsd:complexContent&gt;
 *     &lt;xsd:complexType&gt;
 *   &lt;xsd:element&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Judge extends InlineReqReqType implements Role, ANheaderInline {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "judge";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    private static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(InlineReqReqType.ATTRIBUTES)
                .put(Role.ATTRIBUTE, biConsumerRoleRef(getFieldOffset(Judge.class, "as")))
                .build();
    }

    private RoleRef as;

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
        writer.writeStart(ADDRESS, 5);
        writeRole(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS, 5);
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