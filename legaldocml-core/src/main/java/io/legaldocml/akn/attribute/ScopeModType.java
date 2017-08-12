package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.ScopeMods;

/**
 * <pre>
 * 	 &lt;xsd:attributeGroup name="scopeModType"&gt;
 * 	   &lt;xsd:attribute name="type" type="ScopeMods" use="required"/&gt;
 * 	 &lt;xsd:attributeGroup&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface ScopeModType extends AknObject {

    /**
     * Attribute name.
     */
    String ATTRIBUTE = Type.ATTRIBUTE;

    ScopeMods getType();

    void setType(ScopeMods type);
}