package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Modifiers;
import io.legaldocml.akn.attribute.Pos;
import io.legaldocml.akn.attribute.UpTo;
import io.legaldocml.akn.attribute.UpToOpt;
import io.legaldocml.akn.type.EidRef;
import io.legaldocml.akn.type.PosType;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerEidRef;
import static io.legaldocml.akn.element.Attributes.biConsumerEnum;
import static io.legaldocml.akn.util.XmlWriterHelper.*;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The complex type argumentType defines the empty content model and the list of attributes for metadata elements in the
 * analysis section.
 *
 * <pre>
 *   &lt;xsd:complexType name="argumentType"&gt;
 *     &lt;xsd:complexContent&gt;
 *       &lt;xsd:extension base="anyOtherType"&gt;
 *         &lt;xsd:attributeGroup ref="pos"/&gt;
 *         &lt;xsd:attributeGroup ref="modifiers"/&gt;
 *         &lt;xsd:attributeGroup ref="upToOpt"/&gt;
 *       &lt;xsd:extension&gt;
 *     &lt;xsd:complexContent&gt;
 *   &lt;xsd:complexType&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class ArgumentType extends AnyOtherType implements Pos, Modifiers, UpToOpt {

    protected static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {

        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .putAll(AnyOtherType.ATTRIBUTES)
                .put(Pos.ATTRIBUTE, biConsumerEnum(getFieldOffset(ArgumentType.class, "pos"), PosType.class))
                .put(UpTo.ATTRIBUTE, biConsumerEidRef(getFieldOffset(ArgumentType.class, "upTo")))
                .put(Modifiers.ATTRIBUTE_EXCLUSION, biConsumerEidRef(getFieldOffset(ArgumentType.class, "exclusion")))
                .put(Modifiers.ATTRIBUTE_INCOMPLETE, biConsumerEidRef(getFieldOffset(ArgumentType.class, "incomplete")))
                .build();
    }

    // Pos
    private PosType pos;

    private EidRef upTo;

    private Boolean exclusion;

    private Boolean incomplete;

    /**
     * {@inheritDoc}
     */
    public final PosType getPos() {
        return this.pos;
    }

    /**
     * {@inheritDoc}
     */
    public final void setPos(PosType posType) {
        this.pos = posType;
    }

    public final EidRef getUpTo() {
        return this.upTo;
    }

    public final void setUpTo(EidRef upTo) {
        this.upTo = upTo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getExclusion() {
        return this.exclusion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getIncomplete() {
        return this.incomplete;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIncomplete(Boolean incomplete) {
        this.incomplete = incomplete;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        super.write(writer);
        writeUpTo(writer, this);
        writePos(writer, this);
        writeModifiers(writer, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }
}