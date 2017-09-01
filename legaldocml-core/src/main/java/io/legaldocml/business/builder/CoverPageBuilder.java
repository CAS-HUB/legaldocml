package io.legaldocml.business.builder;

import io.legaldocml.akn.HasCoverPage;
import io.legaldocml.akn.element.CoverPage;
import io.legaldocml.business.builder.support.PSupport;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public class CoverPageBuilder extends BusinessPartBuilder implements PSupport<CoverPage> {

    private final CoverPage coverPage;

    public CoverPageBuilder(BusinessBuilder builder) {
        super(builder);
        if (!(builder.getAkomaNtoso().getDocumentType() instanceof HasCoverPage)) {
            throw new BusinessBuilderException("DocumentType [" + builder.getAkomaNtoso().getDocumentType().getClass().getSimpleName() + "] has no CoverPage");
        }
        this.coverPage = new CoverPage();
        ((HasCoverPage) builder.getAkomaNtoso().getDocumentType()).setCoverPage(coverPage);
    }


    @Override
    public CoverPage getParent() {
        return coverPage;
    }
}