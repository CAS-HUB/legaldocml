package io.legaldocml.business.builder.group;

import io.legaldocml.akn.container.ANhierContainer;
import io.legaldocml.business.builder.support.ArticleSupport;
import io.legaldocml.business.builder.support.ChapterSupport;
import io.legaldocml.business.builder.support.ListSupport;
import io.legaldocml.business.builder.support.ParagraphSupport;
import io.legaldocml.business.builder.support.PointSupport;
import io.legaldocml.business.builder.support.SectionSupport;
import io.legaldocml.business.builder.support.SubSectionSupport;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface ANhierBuilder<T extends ANhierContainer> extends ChapterSupport<T>, SectionSupport<T>, ParagraphSupport<T>,
        ArticleSupport<T>, SubSectionSupport<T>, ListSupport<T>, PointSupport<T> {

}