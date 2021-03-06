package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.ResultType;
import io.legaldocml.io.AttributeGetterSetter;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.util.Buffers;

import java.io.IOException;

import static io.legaldocml.akn.AknAttributes.TYPE;
import static io.legaldocml.akn.AknElements.RESULT;
import static io.legaldocml.akn.element.Attributes.attributeGetterSetter4Enum;
import static io.legaldocml.akn.util.XmlWriterHelper.writeResultType;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

/**
 * The element result is a metadata element specifying the overall result of the judgment.
 * <p>
 * <pre>
 *   <xsd:element name="result" type="anyOtherType">
 * 	   <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="anyOtherType">
 *           <xsd:attributeGroup ref="resultType"/>
 *         <xsd:extension>
 *       <xsd:complexContent>
 *     <xsd:complexType>
 *   <xsd:element>
 * <pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Result extends AnyOtherType implements io.legaldocml.akn.attribute.ResultType {

    /**
     * Memory address.
     */
    private static final long ADDRESS_RESULT = Buffers.address(RESULT);

    private static final ImmutableMap<String, AttributeGetterSetter<AknObject>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, AttributeGetterSetter<AknObject>>builder()
                .putAll(AnyOtherType.ATTRIBUTES)
                .put(TYPE, attributeGetterSetter4Enum(TYPE, getFieldOffset(Result.class, "type"), ResultType.class))
                .build();
    }

    private ResultType type;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(ResultType type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultType getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS_RESULT, 6);
        writeResultType(writer, this);
        super.write(writer);
        writer.writeEnd(ADDRESS_RESULT, 6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return RESULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, AttributeGetterSetter<AknObject>> attributes() {
        return ATTRIBUTES;
    }

}