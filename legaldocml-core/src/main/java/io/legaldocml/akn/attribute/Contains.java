package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.type.VersionType;

/**
 * The attribute contains is used in the root of document types to indicate whether the document is original or modified
 * wrt the orignal version.
 *
 * <pre>
 * 	&lt;xsd:attributeGroup name="contains"&gt;
 * 		&lt;xsd:attribute name="contains" type="versionType" default="originalVersion"/&gt;
 * 	&lt;xsd:attributeGroup&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface Contains extends AknObject {

    /**
     * Attribute name.
     */
    String ATTRIBUTE = "contains";

    VersionType getContains();

    void setContains(VersionType versionType);

}