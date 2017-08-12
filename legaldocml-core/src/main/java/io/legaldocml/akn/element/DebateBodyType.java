package io.legaldocml.akn.element;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.group.SpeechSection;
import io.legaldocml.akn.util.AknList;
import io.legaldocml.akn.util.XmlReaderHelper;
import io.legaldocml.akn.visitor.AknVisitor;
import io.legaldocml.io.XmlReader;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * The type debateBodyType specifies a content model of the main hierarchy of a debate.
 *
 * <pre>
 *   &lt;xsd:complexType name="debateBodyType"&gt;
 *     &lt;xsd:sequence minOccurs="1" maxOccurs="unbounded"&gt;
 * 	     &lt;xsd:group ref="speechSection"/&gt;
 * 	   &lt;xsd:sequence&gt;
 * 	   &lt;xsd:attributeGroup ref="coreopt"/&gt;
 *   &lt;xsd:complexType&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class DebateBodyType extends CoreOptImpl {

    private static final ImmutableMap<String, Supplier<SpeechSection>> ELEMS;

    static {
        ELEMS = ImmutableMap.<String, Supplier<SpeechSection>>builder()
                .putAll(Groups.convertSuper(Groups.speechSection()))
                .build();
    }


    // Mandatory (min 1).
    private final AknList<SpeechSection> sections = new AknList<>(new SpeechSection[4]);

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        this.sections.write(writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(XmlReader reader) {
        Attributes.read(reader, this);
        XmlReaderHelper.read(reader, sections, ELEMS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(AknVisitor visitor) {
        this.sections.accept(visitor);
    }

}