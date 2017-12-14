package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknAttributes;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Id;
import io.legaldocml.akn.type.NoWhiteSpace;
import io.legaldocml.io.AttributeGetterSetter;
import io.legaldocml.io.XmlReader;
import io.legaldocml.util.ToStringBuilder;

import static io.legaldocml.akn.element.Attributes.biConsumerNoWhiteSpace;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

public abstract class AbstractId implements AknObject, Id {

    protected static final ImmutableMap<String, AttributeGetterSetter<AknObject>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, AttributeGetterSetter<AknObject>>builder()
                .put(AknAttributes.ID, biConsumerNoWhiteSpace(AknAttributes.ID, getFieldOffset(AbstractId.class, "eId")))
                .put(AknAttributes.EVOLVING_ID, biConsumerNoWhiteSpace(AknAttributes.EVOLVING_ID, getFieldOffset(AbstractId.class, "wId")))
                .put(AknAttributes.EID, biConsumerNoWhiteSpace(AknAttributes.EID, getFieldOffset(AbstractId.class, "eId")))
                .put(AknAttributes.WID, biConsumerNoWhiteSpace(AknAttributes.WID, getFieldOffset(AbstractId.class, "wId")))
                .put(AknAttributes.GUID, biConsumerNoWhiteSpace(AknAttributes.GUID, getFieldOffset(AbstractId.class, "guid")))
                .build();
    }

    /**
     * Attribute "id" for v2 or "eId" for "v3".
     */
    private NoWhiteSpace eId;

    /**
     * Attribute "evolvingId" for v2 or "wid" for "v3".
     */
    private NoWhiteSpace wId;


    private NoWhiteSpace guid;

    /**
     * {@inheritDoc}
     */
    public final String getId() {
        if (this.eId == null) {
            return null;
        }
        return this.eId.toString();
    }

    /**
     * {@inheritDoc}
     */
    public final void setId(String id) {
        this.eId = NoWhiteSpace.valueOf(id);
    }

    /**
     * {@inheritDoc}
     */
    public final String getEvolvingId() {
        if (this.wId == null) {
            return null;
        }
        return this.wId.toString();
    }

    /**
     * {@inheritDoc}
     */
    public final void setEvolvingId(String evolvingId) {
        this.wId = NoWhiteSpace.valueOf(evolvingId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NoWhiteSpace getEid() {
        return this.eId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEid(NoWhiteSpace eId) {
        this.eId = eId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NoWhiteSpace getWid() {
        return this.wId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWid(NoWhiteSpace wId) {
        this.wId = wId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NoWhiteSpace getGUID() {
        return this.guid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGUID(NoWhiteSpace guid) {
        this.guid = guid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        Attributes.read(reader, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableMap<String, AttributeGetterSetter<AknObject>> attributes() {
        return ATTRIBUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, false);
        builder.append(AknAttributes.EID, this.eId);
        builder.append(AknAttributes.WID, this.wId);
        toString(builder);
        return builder.toString();
    }

    protected void toString(ToStringBuilder builder) {
    }

}