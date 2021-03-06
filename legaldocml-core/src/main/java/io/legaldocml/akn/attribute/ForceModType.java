package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.ForceMods;

/**
 * ```xml
 * <xsd:attributeGroup name="forceModType">
 *   <xsd:attribute name="type" type="ForceMods" use="required"/>
 * </xsd:attributeGroup>
 * ```
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface ForceModType extends AknObject {

    ForceMods getType();

    void setType(ForceMods type);
}