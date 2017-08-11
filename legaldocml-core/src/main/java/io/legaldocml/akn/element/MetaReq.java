package io.legaldocml.akn.element;

import io.legaldocml.akn.attribute.Core;
import io.legaldocml.io.Attribute;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The complex type metareq defines the content model and attributes shared by all metadata elements. Here the eId
 * attribute is required.
 * <p>
 * <pre>
 *   <xsd:complexType name="markerreq"/>
 *     <xsd:attributeGroup ref="core"/>
 *     <xsd:attributeGroup ref="idreq"/>
 *   </xsd:complexType>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class MetaReq extends IdReqImpl implements Core {

    private java.util.List<Attribute> attributes;

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Attribute attribute) {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        this.attributes.add(attribute);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        super.write(writer);
        if (this.attributes != null) {
            for (int i = 0, n = this.attributes.size(); i < n; i++) {
                this.attributes.get(i).write(writer);
            }
        }
    }

}