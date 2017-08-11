package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Id;
import io.legaldocml.akn.type.NoWhiteSpace;
import io.legaldocml.io.CharArray;
import io.legaldocml.io.XmlReader;
import io.legaldocml.util.ToStringBuilder;

import java.util.function.BiConsumer;

import static io.legaldocml.akn.element.Attributes.biConsumerNoWhiteSpace;
import static io.legaldocml.unsafe.UnsafeHelper.getFieldOffset;

abstract class AbstractId implements AknObject, Id {

    protected static final ImmutableMap<String, BiConsumer<AknObject, CharArray>> ATTRIBUTES;

    static {
        ATTRIBUTES = ImmutableMap.<String, BiConsumer<AknObject, CharArray>>builder()
                .put(ATTRIBUTE_ID, biConsumerNoWhiteSpace(getFieldOffset(AbstractId.class, "eid")))
                .put(ATTRIBUTE_EVOLVING_ID, biConsumerNoWhiteSpace(getFieldOffset(AbstractId.class, "wid")))
                .put(ATTRIBUTE_EID, biConsumerNoWhiteSpace(ATTRIBUTE_EID,getFieldOffset(AbstractId.class, "eid")))
                .put(ATTRIBUTE_WID, biConsumerNoWhiteSpace(getFieldOffset(AbstractId.class, "wid")))
                .put(ATTRIBUTE_GUID, biConsumerNoWhiteSpace(getFieldOffset(AbstractId.class, "guid")))
                .build();
    }

    /**
     * Attribute "id" for v2 or "eid" for "v3".
     */
    private NoWhiteSpace eid;

    /**
     * Attribute "evolvingId" for v2 or "wid" for "v3".
     */
    private NoWhiteSpace wid;


    private NoWhiteSpace guid;

    /**
     * {@inheritDoc}
     */
    public final String getId() {
        if (this.eid == null) {
            return null;
        }
        return this.eid.toString();
    }

    /**
     * {@inheritDoc}
     */
    public final void setId(String id) {
        this.eid = new NoWhiteSpace(id);
    }

    /**
     * {@inheritDoc}
     */
    public final String getEvolvingId() {
        if (this.wid == null) {
            return null;
        }
        return this.wid.toString();
    }

    /**
     * {@inheritDoc}
     */
    public final void setEvolvingId(String evolvingId) {
        this.wid = new NoWhiteSpace(evolvingId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NoWhiteSpace getEid() {
        return this.eid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEid(NoWhiteSpace eid) {
        this.eid = eid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NoWhiteSpace getWid() {
        return this.wid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWid(NoWhiteSpace wid) {
        this.wid = wid;
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
    public ImmutableMap<String, BiConsumer<AknObject, CharArray>> attributes() {
        return ATTRIBUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, false);
        builder.append(ATTRIBUTE_EID, this.eid);
        builder.append(ATTRIBUTE_WID, this.wid);
        toString(builder);
        return builder.toString();
    }

    protected void toString(ToStringBuilder builder) {
    }

}