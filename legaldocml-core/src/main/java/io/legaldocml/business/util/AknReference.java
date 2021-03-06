package io.legaldocml.business.util;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.AkomaNtoso;
import io.legaldocml.akn.DocumentType;
import io.legaldocml.akn.attribute.Link;
import io.legaldocml.akn.attribute.Refers;
import io.legaldocml.akn.attribute.Role;
import io.legaldocml.akn.element.RefItem;
import io.legaldocml.akn.element.ReferenceType;
import io.legaldocml.akn.element.References;
import io.legaldocml.akn.element.TLCRole;
import io.legaldocml.akn.group.TLC;
import io.legaldocml.akn.type.AgentRef;
import io.legaldocml.akn.type.ListReferenceRefs;
import io.legaldocml.akn.util.Metas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class AknReference implements BiConsumer<AknObject, AkomaNtoso<? extends DocumentType>> {

    /**
     * SLF4J Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AknReference.class);

    protected AknReference() {
    }

    public static <T extends ReferenceType & RefItem> AknReference refersTo(AgentRef source, T refersTo) {
        return new AknReference() {
            @Override
            public void accept(AknObject object, AkomaNtoso<? extends DocumentType> akn) {

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("reference with source[{}] from [{}] refersTo [{}]",source, object, refersTo);
                }

                if (!(object instanceof Refers)) {
                    throw new AknReferenceException("Not a instance of Refers [" + object + "]");
                }

                ((Refers)object).setRefersTo(ListReferenceRefs.make(refersTo.getEid().toReferenceRef()));

                References ref = Metas.references(akn.getDocumentType().getMeta(),source);

                Optional<RefItem> op = ref.getRefItems().stream()
                        .filter( t -> t.equals(refersTo))
                        .findFirst();

                if (!op.isPresent()) {
                    ref.add(refersTo);
                }

            }
        };
    }

    public static AknReference as(AgentRef source, TLCRole role) {
        return new AknReference() {
            @Override
            public void accept(AknObject object, AkomaNtoso<? extends DocumentType> akn) {

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("reference with source[{}] from [{}] as [{}]",source, object, role);
                }

                if (!(object instanceof Role)) {
                    throw new AknReferenceException("Not a instance of Role [" + object + "]");
                }


                ((Role)object).setAs(role.getEid().toRoleRef());

                References ref = Metas.references(akn.getDocumentType().getMeta(),source);

                Optional<RefItem> op = ref.getRefItems().stream()
                        .filter( t -> t.equals(role))
                        .findFirst();

                if (!op.isPresent()) {
                    ref.add(role);
                }
            }
        };
    }

    public static AknReference href(AgentRef source, TLC tlc) {
        return new AknReference() {
            @Override
            public void accept(AknObject object, AkomaNtoso<? extends DocumentType> akn) {

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("reference with source [{}] from [{}] as [{}]",source, object, tlc);
                }

                if (!(object instanceof Link)) {
                    throw new AknReferenceException("Not a instance of Role [" + object + "]");
                }

                ((Link)object).setHref(tlc.getEid().toUri());

                References ref = Metas.references(akn.getDocumentType().getMeta(),source);

                Optional<RefItem> op = ref.getRefItems().stream()
                        .filter( t -> t.equals(tlc))
                        .findFirst();


                if (!op.isPresent()) {
                    ref.add(tlc);
                }

            }
        };
    }


}
