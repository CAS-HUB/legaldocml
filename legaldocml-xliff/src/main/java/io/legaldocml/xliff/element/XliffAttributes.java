package io.legaldocml.xliff.element;

import io.legaldocml.io.AttributeConsumer;
import io.legaldocml.io.AttributeGetterSetter;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.xliff.attribute.Id;
import io.legaldocml.xliff.attribute.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static io.legaldocml.unsafe.UnsafeString.getChars;
import static io.legaldocml.util.Buffers.address;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class XliffAttributes {

    /**
     * SLF4J.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(XliffAttributes.class);

    private XliffAttributes() {
    }

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.CanResegment}
     */
    public static final String CAN_RESEGMENT = "canResegment";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.Id}
     */
    public static final String ID = "id";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.element.Skeleton}
     */
    public static final String HREF = "href";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.Name}
     */
    public static final String NAME = "name";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.Version}
     */
    public static final String VERSION = "version";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.SrcLang}
     */
    public static final String SRC_LANG = "srcLang";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.element.Segment}
     */
    public static final String STATE = "state";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.element.Segment}
     */
    public static final String SUB_STATE = "subState";

    /**
     * CoreAttribute for {@link io.legaldocml.xliff.attribute.TrgLang}
     */
    public static final String TRG_LANG = "trgLang";

    /*
    static void read(XmlReader reader, XliffObject xliffObject) {
        reader.forEach(xliffObject, (channelReader, object, name, value, prefixNS) -> {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("set ({},{},{},{})", object, name, value, prefixNS);
            }

            //BiConsumer<Externalizable, CharArray> bic = object.attributes().get(name.toString());

            //if (bic != null) {
            //    bic.accept(object, value);
            //} else {
            //    throw new RuntimeException(xliffObject.getClass().getSimpleName() + " -> CoreAttribute [" + name + "] not supported ! [" + value + "]");
           // }


        });
    }*/

    public static final AttributeConsumer<XliffObject> ATTRIBUTE_CONSUMER = (channelReader, xliffObject, name, value, prefixNS) -> {

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("consume attribute ({},{},{},{})", xliffObject, name, value, prefixNS);
        }

        AttributeGetterSetter<XliffObject> ags = xliffObject.attributes().get(name.toString());

        if (ags == null) {
            //TODO
            throw new RuntimeException("");
        }

        ags.accept(xliffObject, value);
    };

    private static final long ADDRESS_ID = address(ID);
    private static final long ADDRESS_NAME = address(NAME);


    public static void write(XmlWriter writer, Id id) throws IOException {
        if (id.getId() == null) {

        } else {
            writer.writeAttribute(XliffAttributes.ADDRESS_ID, 2, getChars(id.getId()));
        }
    }

    public static void write(XmlWriter writer, Name name) throws IOException {
        if (name.getName() == null) {

        } else {
            writer.writeAttribute(XliffAttributes.ADDRESS_NAME, 4, getChars(name.getName()));
        }
    }
}
