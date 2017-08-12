package io.legaldocml.akn.attribute;

/**
 * These attributes identify the element in an absolute manner. In elements using this attribute definition the eId
 * attribute is required whenever the Akoma Ntoso naming Convention is used. The wId is used to mark the identifier that
 * the structure used to have in the original version, and is only needed when a renumbering occurred.
 *
 * <pre>
 *   &lt;xsd:attributeGroup name="idreq"&gt;
 *     &lt;xsd:attribute name="eId" type="noWhiteSpace"/&gt;
 *     &lt;xsd:attribute name="wId" type="noWhiteSpace"/&gt;
 *     &lt;xsd:attribute name="GUID" type="noWhiteSpace"/&gt;
 *   &lt;xsd:attributeGroup&gt;
 * </pre>
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface IdReq extends Id {

}

