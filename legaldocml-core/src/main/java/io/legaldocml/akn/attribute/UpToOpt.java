package io.legaldocml.akn.attribute;

/**
 * The attribute upTo is used in range-based elements to specify the eId of the ending element of the range.
 * <p/>
 * <pre>
 *   <xsd:attributeGroup name="upTo">
 * 	   <xsd:attribute name="upTo" type="eIdRef"/>
 *   </xsd:attributeGroup>
 * </pre>
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface UpToOpt extends UpTo {

}