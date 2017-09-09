package io.legaldocml.akn.element;

import io.legaldocml.akn.visitor.AknVisitor;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

/**
 * The group ManifProperties lists the properties that are characteristics of the FRBR Manifestation level.
 *
 * <pre>
 *   <xsd:group name="ManifProperties">
 * 	   <xsd:sequence>
 *       <xsd:element ref="FRBRportion" minOccurs="0" maxOccurs="1"/>
 *       <xsd:element ref="FRBRformat" minOccurs="0" maxOccurs="1"/>
 *     <xsd:sequence>
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class ManifProperties extends CoreProperties {

    // Optional.
    private FRBRformat format;

    // Optional.
    private FRBRportion portion;

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        super.write(writer);
        if (this.format != null) {
            this.format.write(writer);
        }
        if (this.portion != null) {
            this.portion.write(writer);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        super.read(reader);

        if (reader.getQName().equalsLocalName(FRBRformat.ELEMENT)) {
            this.format = new FRBRformat();
            this.format.read(reader);
            reader.nextStartOrEndElement();
        }

        if (reader.getQName().equalsLocalName(FRBRportion.ELEMENT)) {
            this.portion = new FRBRportion();
            this.portion.read(reader);
            reader.nextStartOrEndElement();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(AknVisitor visitor) {
       super.accept(visitor);
       if (this.format != null) {
           this.format.accept(visitor);
       }
       if (this.portion != null) {
           this.portion.accept(visitor);
       }
    }

}