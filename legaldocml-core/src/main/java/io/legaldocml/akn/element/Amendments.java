package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.akn.util.XmlReaderHelper;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * The complex type Amendments is a list of all the amendment elements that can be used on a document analysis.
 *
 * <pre>
 *   &lt;xsd:complexType name="Amendments"&gt;
 * 	   &lt;xsd:choice minOccurs="1" maxOccurs="unbounded"&gt;
 * 	     &lt;xsd:element ref="textualMod" /&gt;
 * 		 &lt;xsd:element ref="meaningMod" /&gt;
 * 		 &lt;xsd:element ref="scopeMod" /&gt;
 * 		 &lt;xsd:element ref="forceMod" /&gt;
 * 		 &lt;xsd:element ref="efficacyMod" /&gt;
 * 		 &lt;xsd:element ref="legalSystemMod" /&gt;
 * 	   &lt;xsd:choice&gt;
 *   &lt;xsd:complexType&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class Amendments implements AknObject {

    private static final ImmutableMap<String, Supplier<AmendmentsElement>> ELEMS;

    static {
        ELEMS = ImmutableMap.<String, Supplier<AmendmentsElement>>builder()
                .put(TextualMod.ELEMENT, TextualMod::new)
                .put(MeaningMod.ELEMENT, MeaningMod::new)
                .put(ScopeMod.ELEMENT, ScopeMod::new)
                .put(ForceMod.ELEMENT, ForceMod::new)
                .put(EfficacyMod.ELEMENT, EfficacyMod::new)
                .put(LegalSystemMod.ELEMENT, LegalSystemMod::new)
                .build();
    }

    // Mandatory (min 1).
    private final AknList<AmendmentsElement> elements = new AknList<AmendmentsElement>(new AmendmentsElement[4]);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        this.elements.write(writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        XmlReaderHelper.read(reader, elements, ELEMS);
    }


}