package io.legaldocml.business.util;

import com.google.common.collect.ImmutableMap;
import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.attribute.Id;
import io.legaldocml.akn.element.Alinea;
import io.legaldocml.akn.element.AmendmentBody;
import io.legaldocml.akn.element.Article;
import io.legaldocml.akn.element.Attachment;
import io.legaldocml.akn.element.BlockList;
import io.legaldocml.akn.element.Body;
import io.legaldocml.akn.element.Chapter;
import io.legaldocml.akn.element.Citation;
import io.legaldocml.akn.element.Citations;
import io.legaldocml.akn.element.Clause;
import io.legaldocml.akn.element.Component;
import io.legaldocml.akn.element.ComponentRef;
import io.legaldocml.akn.element.Components;
import io.legaldocml.akn.element.DebateBody;
import io.legaldocml.akn.element.DebateSection;
import io.legaldocml.akn.element.Division;
import io.legaldocml.akn.element.DocumentRef;
import io.legaldocml.akn.element.EventRef;
import io.legaldocml.akn.element.Intro;
import io.legaldocml.akn.element.JudgmentBody;
import io.legaldocml.akn.element.List;
import io.legaldocml.akn.element.ListIntroduction;
import io.legaldocml.akn.element.ListWrapUp;
import io.legaldocml.akn.element.MainBody;
import io.legaldocml.akn.element.Paragraph;
import io.legaldocml.akn.element.QuotedStructure;
import io.legaldocml.akn.element.QuotedText;
import io.legaldocml.akn.element.Recital;
import io.legaldocml.akn.element.Recitals;
import io.legaldocml.akn.element.Section;
import io.legaldocml.akn.element.SubChapter;
import io.legaldocml.akn.element.SubClause;
import io.legaldocml.akn.element.SubDivision;
import io.legaldocml.akn.element.SubParagraph;
import io.legaldocml.akn.element.SubSection;
import io.legaldocml.akn.element.TemporalGroup;
import io.legaldocml.akn.element.WrapUp;
import io.legaldocml.akn.type.NoWhiteSpace;
import io.legaldocml.akn.util.NoWhiteSpaceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see <a href="http://docs.oasis-open.org/legaldocml/akn-nc/v1.0/akn-nc-v1.0.html">Syntax for eId and wId attributes</a>
 * Most elements in the Akoma Ntoso XML vocabulary allow two optional attributes, called eId and wId. They are optional for compliance level 1, and are required for compliance levels 2 and above.
 * The syntax for these attributes is identical and is built in the exact same way, but are based on different elements:
 * <ul>
 * <li>for the eId attribute, the reference element is the one in the current Expression</li>
 * <li>for the wId attribute, the reference element is the one in the master Expression, as specified in section 5.4.</li>
 * </ul>
 * The generic syntax for these attributes is the following:
 * <table>
 * <tr><td>[prefix “__”] element_ref [“_”number]</td></tr>
 * </table>
 * <p>
 * <ul>
 * <li>prefix is a (possibly empty) string providing uniqueness to the remaining part of the identifier, and it is based on the context in which the element appears;</li>
 * <li>element_ref is a (required) identifier of the type of the element;</li>
 * <li>number is a (possibly empty) representation of the numbering of the element within its context.</li>
 * </ul>
 */
public class IdHelper {

    /**
     * SLF4J Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdHelper.class);

    private static final ImmutableMap<Class<? extends AknObject>, String> ELEMENTS_REFS;

    static {
        ELEMENTS_REFS = ImmutableMap.<Class<? extends AknObject>, String>builder()
                .put(Body.class,"body")

                .put(Alinea.class,"al")
                .put(AmendmentBody.class,"body")
                .put(Article.class,"art")
                .put(Attachment.class,"att")
                .put(BlockList.class,"list")
                .put(Chapter.class,"chp")
                .put(Citation.class,"cit")
                .put(Citations.class,"cits")
                .put(Clause.class,"cl")
                .put(Component.class,"cmp")
                .put(Components.class,"cmpnts")
                .put(ComponentRef.class,"cref")
                .put(DebateBody.class,"body")
                .put(DebateSection.class,"dbsect")
                .put(Division.class,"dvs")
                .put(DocumentRef.class,"dref")
                .put(EventRef.class,"eref")
                .put(JudgmentBody.class,"body")
                .put(Intro.class,"intro")
                .put(List.class,"list")
                .put(ListIntroduction.class,"intro")
                .put(ListWrapUp.class,"wrap")
                .put(MainBody.class,"body")
                .put(Paragraph.class,"para")
                .put(QuotedStructure.class,"qstr")
                .put(QuotedText.class,"qtext")
                .put(Recital.class,"rec")
                .put(Recitals.class,"recs")
                .put(Section.class,"sec")
                .put(SubChapter.class,"subchp")
                .put(SubClause.class,"subcl")
                .put(SubDivision.class,"subdvs")
                .put(SubParagraph.class,"subpara")
                .put(SubSection.class,"subsec")
                .put(TemporalGroup.class,"tmpg")
                .put(WrapUp.class,"wrapup")
                .build();

    }

    public static <T extends AknObject> String getElementRef(Class<T> clazz) {
        return ELEMENTS_REFS.get(clazz);
    }

    public static NoWhiteSpace eid(Id parent, Id object, int number) {
        NoWhiteSpaceBuilder builder = new NoWhiteSpaceBuilder();
        if (parent.getEid() != null) {
            builder.append(parent.getEid());
            builder.appendPrefixSeparator();
        }

        String ref = ELEMENTS_REFS.get(object.getClass());

        if (ref != null) {
            builder.append(ref);
            builder.appendSeparator();
            builder.append(number);
        }

        return builder.build();
    }

}
