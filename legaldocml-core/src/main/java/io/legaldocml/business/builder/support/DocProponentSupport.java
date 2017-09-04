package io.legaldocml.business.builder.support;

import io.legaldocml.akn.container.ANtitleInlineContainer;
import io.legaldocml.akn.element.DocProponent;
import io.legaldocml.business.builder.InlineTypeBuilder;
import io.legaldocml.business.util.AknReference;
import io.legaldocml.business.util.AknReferenceHelper;

import java.util.function.Consumer;


/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface DocProponentSupport<T extends ANtitleInlineContainer> extends SupportBuilder<T>  {

    @SuppressWarnings("unchecked")
    default InlineTypeBuilder<DocProponent> docProponent(Consumer<DocProponent> consumer, AknReference... refs) {
        DocProponent docProponent = new DocProponent();
        getParent().add(docProponent);
        AknReferenceHelper.apply(getBusinessBuilder().getAkomaNtoso(), docProponent, refs);
        if (consumer != null) {
            consumer.accept(docProponent);
        }
        return new InlineTypeBuilder<>(getBusinessBuilder(), docProponent);
    }

    default InlineTypeBuilder<DocProponent> docProponent(AknReference... refs) {
        return docProponent( null, refs);
    }

}