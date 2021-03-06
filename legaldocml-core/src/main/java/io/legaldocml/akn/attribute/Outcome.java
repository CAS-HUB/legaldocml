package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.ConceptRef;

/**
 * The attribute outcome is used to identify the outcome of a step in a workflow. It is a reference to a TLCConcept
 * element in the references section.
 *
 * ```xml
 * <xsd:attributeGroup name="outcome">
 *   <xsd:attribute name="outcome" type="conceptRef"/>
 * </xsd:attributeGroup>
 * ```
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface Outcome extends AknObject {

    ConceptRef getOutcome();

    void setOutcome(ConceptRef outcome);

}