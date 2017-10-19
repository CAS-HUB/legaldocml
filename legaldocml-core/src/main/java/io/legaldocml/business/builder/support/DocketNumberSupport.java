package io.legaldocml.business.builder.support;

import io.legaldocml.akn.container.ANtitleInlineContainer;
import io.legaldocml.akn.element.DocketNumber;
import io.legaldocml.business.builder.element.InlineTypeBuilder;
import io.legaldocml.business.util.AknReference;
import io.legaldocml.business.util.AknReferenceHelper;

import java.util.function.Consumer;


/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface DocketNumberSupport<T extends ANtitleInlineContainer> extends SupportBuilder<T> {

    default InlineTypeBuilder<DocketNumber> docketNumber(AknReference... refs) {
        return docketNumber(null, refs);
    }

    default InlineTypeBuilder<DocketNumber> docketNumber(Consumer<DocketNumber> consumer, AknReference... refs) {
        DocketNumber docketNumber = new DocketNumber();
        parent().add(docketNumber);
        AknReferenceHelper.apply(businessBuilder().getAkomaNtoso(), docketNumber, refs);
        if (consumer != null) {
            consumer.accept(docketNumber);
        }
        return new InlineTypeBuilder<>(businessBuilder(), docketNumber);
    }


}
