package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.EventRefRef;

/**
 * The start and end attributes are used to specify events that mark the beginning and the end of a time interval. Both
 * are references to eventRef elements in the lifecycle element.
 *
 * <pre>
 *   &lt;xsd:attributeGroup name="interval"&gt;
 *     &lt;xsd:attribute name="start" type="eventRefRef"/&gt;
 *     &lt;xsd:attribute name="end" type="eventRefRef"/&gt;
 *   &lt;xsd:attributeGroup&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface Interval extends AknObject {

    /**
     * Attribute name "start".
     */
    String ATTRIBUTE_START = "start";

    /**
     * Attribute name "end".
     */
    String ATTRIBUTE_END = "end";

    EventRefRef getStart();

    void setStart(EventRefRef number);

    EventRefRef getEnd();

    void setEnd(EventRefRef number);

}