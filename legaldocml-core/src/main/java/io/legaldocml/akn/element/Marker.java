package io.legaldocml.akn.element;

import io.legaldocml.io.impl.Buffers;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * the element marker is a generic element for a marker. It can be placed in a block instead of any of the other
 * markers. The attribute name is required and gives a name to the element.
 * <p/>
 * <pre>
 *   <xsd:element name="marker">
 *     <xsd:complexType>
 *       <xsd:complexContent>
 *         <xsd:extension base="markerreq">
 *           <xsd:attributeGroup ref="name"/>
 *         </xsd:extension>
 *       </xsd:complexContent>
 *     </xsd:complexType>
 *   </xsd:element>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class Marker extends MarkerReq {

    /**
     * XML tag element name.
     */
    public static final String ELEMENT = "marker";

    /**
     * Memory address.
     */
    private static final long ADDRESS = Buffers.address(ELEMENT);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writer.writeStart(ADDRESS, 6);
        super.write(writer);
        writer.writeEnd(ADDRESS, 6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return ELEMENT;
    }

}