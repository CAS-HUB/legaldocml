package io.legaldocml.akn.attribute;

import io.legaldocml.akn.AknObject;

/**
 * These attributes are used to specify that table cells span more than one row or one column, exactly as in HTML.
 *
 * ```xml
 * <xsd:attributeGroup name="cellattrs">
 *   <xsd:attribute name="rowspan" type="xsd:integer" default="1"/>
 * 	 <xsd:attribute name="colspan" type="xsd:integer" default="1"/>
 * </xsd:attributeGroup>
 * ```
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface CellAttrs extends AknObject {

    Integer getRowSpan();

    void setRowSpan(Integer rowspan);

    Integer getColSpan();

    void setColSpan(Integer colspan);

}