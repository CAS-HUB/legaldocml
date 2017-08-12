package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.EidRef;
import io.legaldocml.akn.type.PlacementType;

/**
 * These attributes are used by notes, both authorial and editorial. The marker is the string to be used as a marker of
 * the note, the placement is the position where the note should be placed, and placementBase is the eId of the element
 * respect to which the note should be placed near.
 *
 * <pre>
 *   &lt;xsd:attributeGroup name="notes"&gt;
 * 	   &lt;xsd:attribute name="marker" type="xsd:string"/&gt;
 * 	   &lt;xsd:attribute name="placement" type="placementType"/&gt;
 * 	   &lt;xsd:attribute name="placementBase" type="eIdRef"/&gt;
 *   &lt;xsd:attributeGroup&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */

public interface Notes extends AknObject {

    /**
     * Attribute name "marker".
     */
    String ATTRIBUTE_MARKER = "marker";
    /**
     * Attribute name "placement".
     */
    String ATTRIBUTE_PLACEMENT = "placement";
    /**
     * Attribute name "placementBase".
     */
    String ATTRIBUTE_PLACEMENT_BASE = "placementBase";

    String getMarker();

    void setMarker(String marker);

    PlacementType getPlacement();

    void setPlacement(PlacementType placement);

    EidRef getPlacementBase();

    void setPlacementBase(EidRef placementBase);
}