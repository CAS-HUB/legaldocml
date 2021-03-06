package io.legaldocml.akn;

import com.google.common.collect.ImmutableMap;

import java.lang.reflect.Field;

/**
 * All default attributes name.
 *
 * Based on the pattern :
 * According to Joshua Bloch, author of "Effective Java":
 * ```
 * The constant interface pattern is a poor use of interfaces.
 * That a class uses some constants internally is an implementation detail.
 * Implementing a constant interface causes this implementation detail to leak into the class's exported API.
 * It is of no consequence to the users of a class that the class implements a constant interface. In fact, it may even
 * confuse them. Worse, it represents a commitment: if in a future release the class is modified so that it no longer
 * needs to use the constants, it still must implement the interface to ensure binary compatibility.
 * If a nonfinal class implements a constant interface all of its subclasses will have their namespaces polluted by the
 * constants in the interface.
 * ```
 *
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
@SuppressWarnings("unchecked")
public final class AknElements {

    private AknElements() {
    }

    private static final ImmutableMap<String, Class<? extends AknObject>> ELEMENTS;

    /**
     * Element for {@link io.legaldocml.akn.AkomaNtoso}
     */
    public static final String AKOMANTOSO = "akomaNtoso";

    static {
        ImmutableMap.Builder<String, Class<? extends AknObject>> builder = ImmutableMap.builder();
        for (Field field : AknElements.class.getDeclaredFields()) {
            if (!String.class.equals(field.getType())) {
                continue;
            }
            try {
                String value = field.get(null).toString();
                if (AKOMANTOSO.equals(value)) {
                    builder.put(value, AkomaNtoso.class);
                } else {
                    //noinspection unchecked
                    builder.put(value, (Class<? extends AknObject>) Class.forName("io.legaldocml.akn.element." + firstLetterUpperCase(value)));
                }
            } catch (Exception cause) {
                throw new IllegalStateException("Failed to get value from field [" + field + "]", cause);
            }
        }

        ELEMENTS = builder.build();
    }

    /**
     * Element for {@link io.legaldocml.akn.element.A}
     */
    public static final String A = "a";

    /**
     * Element for {@link io.legaldocml.akn.element.Abbr}
     */
    public static final String ABBR = "abbr";

    /**
     * Element for {@link io.legaldocml.akn.element.Act}
     */
    public static final String ACT = "act";

    /**
     * Element for {@link io.legaldocml.akn.element.ActiveModifications}
     */
    public static final String ACTIVE_MODIFICATIONS = "activeModifications";

    /**
     * Element for {@link io.legaldocml.akn.element.ActiveRef}
     */
    public static final String ACTIVE_REF = "activeRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Address}
     */
    public static final String ADDRESS = "address";

    /**
     * Element for {@link io.legaldocml.akn.element.Adjournment}
     */
    public static final String ADJOURNMENT = "adjournment";

    /**
     * Element for {@link io.legaldocml.akn.element.AdministrationOfOath}
     */
    public static final String ADMINISTATION_OF_OATH = "administrationOfOath";

    /**
     * Element for {@link io.legaldocml.akn.element.AffectedDocument}
     */
    public static final String AFFECTED_DOCUMENT = "affectedDocument";

    /**
     * Element for {@link io.legaldocml.akn.element.AlternativeReference}
     */
    public static final String ALTERNATIVE_REFERENCE = "alternativeReference";

    /**
     * Element for {@link io.legaldocml.akn.element.Alinea}
     */
    public static final String ALINEA = "alinea";

    /**
     * Element for {@link io.legaldocml.akn.element.Amendment}
     */
    public static final String AMENDMENT = "amendment";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentBody}
     */
    public static final String AMENDMENT_BODY = "amendmentBody";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentContent}
     */
    public static final String AMENDMENT_CONTENT = "amendmentContent";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentHeading}
     */
    public static final String AMENDMENT_HEADING = "amendmentHeading";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentJustification}
     */
    public static final String AMENDMENT_JUSTIFICATION = "amendmentJustification";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentList}
     */
    public static final String AMENDMENT_LIST = "amendmentList";

    /**
     * Element for {@link io.legaldocml.akn.element.AmendmentReference}
     */
    public static final String AMENDMENT_REFERENCE = "amendmentReference";

    /**
     * Element for {@link io.legaldocml.akn.element.Analysis}
     */
    public static final String ANALYSIS = "analysis";

    /**
     * Element for {@link io.legaldocml.akn.element.Answer}
     */
    public static final String ANSWER = "answer";

    /**
     * Element for {@link io.legaldocml.akn.element.Application}
     */
    public static final String APPLICATION = "application";

    /**
     * Element for {@link io.legaldocml.akn.element.Applies}
     */
    public static final String APPLIES = "applies";

    /**
     * Element for {@link io.legaldocml.akn.element.Argument}
     */
    public static final String ARGUMENT = "argument";

    /**
     * Element for {@link io.legaldocml.akn.element.Arguments}
     */
    public static final String ARGUMENTS = "arguments";

    /**
     * Element for {@link io.legaldocml.akn.element.Article}
     */
    public static final String ARTICLE = "article";

    /**
     * Element for {@link io.legaldocml.akn.element.Attachment}
     */
    public static final String ATTACHMENT = "attachment";

    /**
     * Element for {@link io.legaldocml.akn.element.Attachment}
     */
    public static final String ATTACHMENT_OF = "attachmentOf";

    /**
     * Element for :
     * * - {@link io.legaldocml.akn.element.AttachmentsV2}
     * * - {@link io.legaldocml.akn.element.AttachmentsV3}
     */
    public static final String ATTACHMENTS = "attachments";

    /**
     * Element for {@link io.legaldocml.akn.element.AuthorialNote}
     */
    public static final String AUTHORIAL_NOTE = "authorialNote";

    /**
     * Element for {@link io.legaldocml.akn.element.B}
     */
    public static final String B = "b";

    /**
     * Element for {@link io.legaldocml.akn.element.B}
     */
    public static final String BACKGROUND = "background";

    /**
     * Element for {@link io.legaldocml.akn.element.Block}
     */
    public static final String BLOCK = "block";

    /**
     * Element for {@link io.legaldocml.akn.element.BlockContainer}
     */
    public static final String BLOCK_CONTAINER = "blockContainer";

    /**
     * Element for {@link io.legaldocml.akn.element.BlockList}
     */
    public static final String BLOCK_LIST = "blockList";

    /**
     * Element for {@link io.legaldocml.akn.element.Body}
     */
    public static final String BODY = "body";

    /**
     * Element for {@link io.legaldocml.akn.element.Book}
     */
    public static final String BOOK = "book";

    /**
     * Element for {@link io.legaldocml.akn.element.Br}
     */
    public static final String BR = "br";

    /**
     * Element for {@link io.legaldocml.akn.element.Bill}
     */
    public static final String BILL = "bill";

    /**
     * Element for {@link io.legaldocml.akn.element.Caption}
     */
    public static final String CAPTION = "caption";

    /**
     * Element for {@link io.legaldocml.akn.element.Change}
     */
    public static final String CHANGE = "change";

    /**
     * Element for {@link io.legaldocml.akn.element.Chapter}
     */
    public static final String CHAPTER = "chapter";

    /**
     * Element for {@link io.legaldocml.akn.element.Citation}
     */
    public static final String CITATION = "citation";

    /**
     * Element for {@link io.legaldocml.akn.element.Citations}
     */
    public static final String CITATIONS = "citations";

    /**
     * Element for {@link io.legaldocml.akn.element.Classification}
     */
    public static final String CLASSIFICATION = "classification";

    /**
     * Element for {@link io.legaldocml.akn.element.Clause}
     */
    public static final String CLAUSE = "clause";

    /**
     * Element for {@link io.legaldocml.akn.element.Clause}
     */
    public static final String COLLECTION_BODY = "collectionBody";

    /**
     * Element for {@link io.legaldocml.akn.element.Communication}
     */
    public static final String COMMUNICATION = "communication";

    /**
     * Element for {@link io.legaldocml.akn.element.Component}
     */
    public static final String COMPONENT = "component";

    /**
     * Element for {@link io.legaldocml.akn.element.ComponentData}
     */
    public static final String COMPONENT_DATA = "componentData";

    /**
     * Element for {@link io.legaldocml.akn.element.ComponentInfo}
     */
    public static final String COMPONENT_INFO = "componentInfo";

    /**
     * Element for {@link io.legaldocml.akn.element.ComponentRef}
     */
    public static final String COMPONENT_REF = "componentRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Components}
     */
    public static final String COMPONENTS = "components";

    /**
     * Element for {@link io.legaldocml.akn.element.Concept}
     */
    public static final String CONCEPT = "concept";

    /**
     * Element for {@link io.legaldocml.akn.element.Conclusions}
     */
    public static final String CONCLUSIONS = "conclusions";

    /**
     * Element for {@link io.legaldocml.akn.element.Condition}
     */
    public static final String CONDITION = "condition";

    /**
     * Element for {@link io.legaldocml.akn.element.Container}
     */
    public static final String CONTAINER = "container";

    /**
     * Element for {@link io.legaldocml.akn.element.Content}
     */
    public static final String CONTENT = "content";

    /**
     * Element for {@link io.legaldocml.akn.element.Contrasts}
     */
    public static final String CONTRASTS = "contrasts";

    /**
     * Element for {@link io.legaldocml.akn.element.Count}
     */
    public static final String COUNT = "count";

    /**
     * Element for {@link io.legaldocml.akn.element.CourtType}
     */
    public static final String COURT_TYPE = "courtType";

    /**
     * Element for {@link io.legaldocml.akn.element.CoverPage}
     */
    public static final String COVER_PAGE = "coverPage";

    /**
     * Element for {@link io.legaldocml.akn.element.CrossHeading}
     */
    public static final String CROSS_HEADING = "crossHeading";

    /**
     * Element for {@link io.legaldocml.akn.element.Date}
     */
    public static final String DATE = "date";

    /**
     * Element for {@link io.legaldocml.akn.element.Debate}
     */
    public static final String DEBATE = "debate";

    /**
     * Element for {@link io.legaldocml.akn.element.DebateBody}
     */
    public static final String DEBATE_BODY = "debateBody";

    /**
     * Element for {@link io.legaldocml.akn.element.DebateReport}
     */
    public static final String DEBATE_REPORT = "debateReport";

    /**
     * Element for {@link io.legaldocml.akn.element.DebateSection}
     */
    public static final String DEBATE_SECTION = "debateSection";

    /**
     * Element for {@link io.legaldocml.akn.element.Decision}
     */
    public static final String DECISION = "decision";

    /**
     * Element for {@link io.legaldocml.akn.element.DeclarationOfVote}
     */
    public static final String DECLARATION_OF_VOTE = "declarationOfVote";

    /**
     * Element for {@link io.legaldocml.akn.element.Decoration}
     */
    public static final String DECORATION = "decoration";

    /**
     * Element for {@link io.legaldocml.akn.element.Def}
     */
    public static final String DEF = "def";

    /**
     * Element for {@link io.legaldocml.akn.element.Del}
     */
    public static final String DEL = "del";

    /**
     * Element for {@link io.legaldocml.akn.element.Derogates}
     */
    public static final String DEROGATES = "derogates";

    /**
     * Element for {@link io.legaldocml.akn.element.Destination}
     */
    public static final String DESTINATION = "destination";

    /**
     * Element for {@link io.legaldocml.akn.element.DissentsFrom}
     */
    public static final String DISSENTS_FROM = "dissentsFrom";

    /**
     * Element for {@link io.legaldocml.akn.element.Div}
     */
    public static final String DIV = "div";

    /**
     * Element for {@link io.legaldocml.akn.element.Distinguishes}
     */
    public static final String DISTINGUISHES = "distinguishes";

    /**
     * Element for {@link io.legaldocml.akn.element.Division}
     */
    public static final String DIVISION = "division";

    /**
     * Element for {@link io.legaldocml.akn.element.Doc}
     */
    public static final String DOC = "doc";

    /**
     * Element for {@link io.legaldocml.akn.element.DocAuthority}
     */
    public static final String DOC_AUTHORITY = "docAuthority";

    /**
     * Element for {@link io.legaldocml.akn.element.DocCommittee}
     */
    public static final String DOC_COMMITTEE = "docCommittee";

    /**
     * Element for {@link io.legaldocml.akn.element.DocDate}
     */
    public static final String DOC_DATE = "docDate";

    /**
     * Element for {@link io.legaldocml.akn.element.DocIntroducer}
     */
    public static final String DOC_INTRODUCER = "docIntroducer";

    /**
     * Element for {@link io.legaldocml.akn.element.DocJurisdiction}
     */
    public static final String DOC_JURISDICTION = "docJurisdiction";

    /**
     * Element for {@link io.legaldocml.akn.element.DocJurisdiction}
     */
    public static final String DOCKET_NUMBER = "docketNumber";

    /**
     * Element for {@link io.legaldocml.akn.element.DocNumber}
     */
    public static final String DOC_NUMBER = "docNumber";

    /**
     * Element for {@link io.legaldocml.akn.element.DocProponent}
     */
    public static final String DOC_PROPONENT = "docProponent";

    /**
     * Element for {@link io.legaldocml.akn.element.DocPurpose}
     */
    public static final String DOC_PURPOSE = "docPurpose";

    /**
     * Element for {@link io.legaldocml.akn.element.DocStage}
     */
    public static final String DOC_STAGE = "docStage";

    /**
     * Element for {@link io.legaldocml.akn.element.DocStatus}
     */
    public static final String DOC_STATUS = "docStatus";

    /**
     * Element for {@link io.legaldocml.akn.element.DocTitle}
     */
    public static final String DOC_TITLE = "docTitle";

    /**
     * Element for {@link io.legaldocml.akn.element.DocType}
     */
    public static final String DOC_TYPE = "docType";

    /**
     * Element for {@link io.legaldocml.akn.element.DocumentCollection}
     */
    public static final String DOCUMENT_COLLECTION = "documentCollection";

    /**
     * Element for {@link io.legaldocml.akn.element.DocumentRef}
     */
    public static final String DOCUMENT_REF = "documentRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Domain}
     */
    public static final String DOMAIN = "domain";

    /**
     * Element for {@link io.legaldocml.akn.element.Duration}
     */
    public static final String DURATION = "duration";

    /**
     * Element for {@link io.legaldocml.akn.element.Efficacy}
     */
    public static final String EFFICACY = "efficacy";

    /**
     * Element for {@link io.legaldocml.akn.element.EfficacyMod}
     */
    public static final String EFFICACY_MOD = "efficacyMod";

    /**
     * Element for {@link io.legaldocml.akn.element.EmbeddedStructure}
     */
    public static final String EMBEDDED_STRUCTURE = "embeddedStructure";

    /**
     * Element for {@link io.legaldocml.akn.element.EmbeddedText}
     */
    public static final String EMBEDDED_TEXT = "embeddedText";

    /**
     * Element for {@link io.legaldocml.akn.element.Entity}
     */
    public static final String ENTITY = "entity";

    /**
     * Element for {@link io.legaldocml.akn.element.Eol}
     */
    public static final String EOL = "eol";

    /**
     * Element for {@link io.legaldocml.akn.element.Eop}
     */
    public static final String EOP = "eop";

    /**
     * Element for {@link io.legaldocml.akn.element.Event}
     */
    public static final String EVENT = "event";

    /**
     * Element for {@link io.legaldocml.akn.element.EventRef}
     */
    public static final String EVENT_REF = "eventRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Extends}
     */
    public static final String EXTENDS = "extends";

    /**
     * Element for {@link io.legaldocml.akn.element.FillIn}
     */
    public static final String FILL_IN = "fillIn";

    /**
     * Element for {@link io.legaldocml.akn.element.Force}
     */
    public static final String FORCE = "force";

    /**
     * Element for {@link io.legaldocml.akn.element.ForceMod}
     */
    public static final String FORCE_MOD = "forceMod";

    /**
     * Element for {@link io.legaldocml.akn.element.Foreign}
     */
    public static final String FOREIGN = "foreign";

    /**
     * Element for {@link io.legaldocml.akn.element.Formula}
     */
    public static final String FORMULA = "formula";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRalias}
     */
    public static final String FRBR_ALIAS = "FRBRalias";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRauthor}
     */
    public static final String FRBR_AUTHOR = "FRBRauthor";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRauthoritative}
     */
    public static final String FRBR_AUTHORITATIVE = "FRBRauthoritative";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRcountry}
     */
    public static final String FRBR_COUNTRY = "FRBRcountry";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRdate}
     */
    public static final String FRBR_DATE = "FRBRdate";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRExpression}
     */
    public static final String FRBR_EXPRESSION = "FRBRExpression";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRformat}
     */
    public static final String FRBR_FORMAT = "FRBRformat";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRItem}
     */
    public static final String FRBR_ITEM = "FRBRItem";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRlanguage}
     */
    public static final String FRBR_LANGUAGE = "FRBRlanguage";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRManifestation}
     */
    public static final String FRBR_MANIFESTATION = "FRBRManifestation";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRManifestation}
     */
    public static final String FRBR_MASTER_EXPRESSION = "FRBRmasterExpression";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRname}
     */
    public static final String FRBR_NAME = "FRBRname";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRnumber}
     */
    public static final String FRBR_NUMBER = "FRBRnumber";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRportion}
     */
    public static final String FRBR_PORTION = "FRBRportion";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRportion}
     */
    public static final String FRBR_PRESCRIPTIVE = "FRBRprescriptive";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRsubtype}
     */
    public static final String FRBR_SUBTYPE = "FRBRsubtype";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRthis}
     */
    public static final String FRBR_THIS = "FRBRthis";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRtranslation}
     */
    public static final String FRBR_TRANSLATION = "FRBRtranslation";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRuri}
     */
    public static final String FRBR_URI = "FRBRuri";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRversionNumber}
     */
    public static final String FRBR_VERSION_NUMBER = "FRBRversionNumber";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRWork}
     */
    public static final String FRBR_WORK = "FRBRWork";

    /**
     * Element for {@link io.legaldocml.akn.element.FRBRWork}
     */
    public static final String FROM = "from";

    /**
     * Element for {@link io.legaldocml.akn.element.HasAttachment}
     */
    public static final String HAS_ATTACHMENT = "hasAttachment";

    /**
     * Element for {@link io.legaldocml.akn.element.Hcontainer}
     */
    public static final String H_CONTAINER = "hcontainer";

    /**
     * Element for {@link io.legaldocml.akn.element.Header}
     */
    public static final String HEADER = "header";

    /**
     * Element for {@link io.legaldocml.akn.element.Heading}
     */
    public static final String HEADING = "heading";

    /**
     * Element for {@link io.legaldocml.akn.element.I}
     */
    public static final String I = "i";

    /**
     * Element for {@link io.legaldocml.akn.element.Identification}
     */
    public static final String IDENTIFICATION = "identification";

    /**
     * Element for {@link io.legaldocml.akn.element.Img}
     */
    public static final String IMG = "img";

    /**
     * Element for {@link io.legaldocml.akn.element.ImplicitReference}
     */
    public static final String IMPLICIT_REFERENCE = "implicitReference";

    /**
     * Element for {@link io.legaldocml.akn.element.Indent}
     */
    public static final String INDENT = "indent";

    /**
     * Element for {@link io.legaldocml.akn.element.Inline}
     */
    public static final String INLINE = "inline";

    /**
     * Element for {@link io.legaldocml.akn.element.Ins}
     */
    public static final String INS = "ins";

    /**
     * Element for {@link io.legaldocml.akn.element.Interstitial}
     */
    public static final String INTERSTITIAL = "interstitial";

    /**
     * Element for {@link io.legaldocml.akn.element.Intro}
     */
    public static final String INTRO = "intro";

    /**
     * Element for {@link io.legaldocml.akn.element.Introduction}
     */
    public static final String INTRODUCTION = "introduction";

    /**
     * Element for {@link io.legaldocml.akn.element.IsAnalogTo}
     */
    public static final String IS_ANALOG_TO = "isAnalogTo";

    /**
     * Element for {@link io.legaldocml.akn.element.Item}
     */
    public static final String ITEM = "item";

    /**
     * Element for {@link io.legaldocml.akn.element.Judge}
     */
    public static final String JUDGE = "judge";

    /**
     * Element for {@link io.legaldocml.akn.element.Judgment}
     */
    public static final String JUDGMENT = "judgment";

    /**
     * Element for {@link io.legaldocml.akn.element.JudgmentBody}
     */
    public static final String JUDGMENT_BODY = "judgmentBody";

    /**
     * Element for {@link io.legaldocml.akn.element.Judicial}
     */
    public static final String JUDICIAL = "judicial";

    /**
     * Element for {@link io.legaldocml.akn.element.Jurisprudence}
     */
    public static final String JURISPRUDENCE = "jurisprudence";

    /**
     * Element for {@link io.legaldocml.akn.element.Keyword}
     */
    public static final String KEYWORD = "keyword";

    /**
     * Element for {@link io.legaldocml.akn.element.Lawyer}
     */
    public static final String LAWYER = "lawyer";

    /**
     * Element for {@link io.legaldocml.akn.element.LegalSystemMod}
     */
    public static final String LEGAL_SYSTEM_MOD = "legalSystemMod";

    /**
     * Element for {@link io.legaldocml.akn.element.Legislature}
     */
    public static final String LEGISLATURE = "legislature";

    /**
     * Element for {@link io.legaldocml.akn.element.Level}
     */
    public static final String LEVEL = "level";

    /**
     * Element for {@link io.legaldocml.akn.element.Li}
     */
    public static final String LI = "li";

    /**
     * Element for {@link io.legaldocml.akn.element.Lifecycle}
     */
    public static final String LIFECYCLE = "lifecycle";

    /**
     * Element for {@link io.legaldocml.akn.element.Lifecycle}
     */
    public static final String LIST = "list";

    /**
     * Element for {@link io.legaldocml.akn.element.Lifecycle}
     */
    public static final String LIST_INTRODUCTION = "listIntroduction";

    /**
     * Element for {@link io.legaldocml.akn.element.ListWrapUp}
     */
    public static final String LIST_WRAP_UP = "listWrapUp";

    /**
     * Element for {@link io.legaldocml.akn.element.Location}
     */
    public static final String LOCATION = "location";

    /**
     * Element for {@link io.legaldocml.akn.element.LongTitle}
     */
    public static final String LONG_TITLE = "longTitle";

    /**
     * Element for {@link io.legaldocml.akn.element.MainBody}
     */
    public static final String MAIN_BODY = "mainBody";

    /**
     * Element for {@link io.legaldocml.akn.element.Mapping}
     */
    public static final String MAPPING = "mapping";

    /**
     * Element for {@link io.legaldocml.akn.element.Mappings}
     */
    public static final String MAPPINGS = "mappings";

    /**
     * Element for {@link io.legaldocml.akn.element.Marker}
     */
    public static final String MARKER = "marker";

    /**
     * Element for {@link io.legaldocml.akn.element.MeaningMod}
     */
    public static final String MEANING_MOD = "meaningMod";

    /**
     * Element for {@link io.legaldocml.akn.element.Meta}
     */
    public static final String META = "meta";

    /**
     * Element for {@link io.legaldocml.akn.element.MinisterialStatements}
     */
    public static final String MINISTERIAL_STATEMENTS = "ministerialStatements";

    /**
     * Element for {@link io.legaldocml.akn.element.Mmod}
     */
    public static final String MMOD = "mmod";

    /**
     * Element for {@link io.legaldocml.akn.element.Mod}
     */
    public static final String MOD = "mod";

    /**
     * Element for {@link io.legaldocml.akn.element.Motivation}
     */
    public static final String MOTIVATION = "motivation";

    /**
     * Element for {@link io.legaldocml.akn.element.Mref}
     */
    public static final String MREF = "mref";

    /**
     * Element for {@link io.legaldocml.akn.element.Narrative}
     */
    public static final String NARRATIVE = "narrative";

    /**
     * Element for {@link io.legaldocml.akn.element.NationalInterest}
     */
    public static final String NATIONAL_INTEREST = "nationalInterest";

    /**
     * Element for {@link io.legaldocml.akn.element.NeutralCitation}
     */
    public static final String NEUTRAL_CITATION = "neutralCitation";

    /**
     * Element for {@link io.legaldocml.akn.element.New}
     */
    public static final String NEW = "new";

    /**
     * Element for {@link io.legaldocml.akn.element.Note}
     */
    public static final String NOTE = "note";

    /**
     * Element for {@link io.legaldocml.akn.element.NoteRef}
     */
    public static final String NOTE_REF = "noteRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Notes}
     */
    public static final String NOTES = "notes";

    /**
     * Element for {@link io.legaldocml.akn.element.NoticesOfMotion}
     */
    public static final String NOTICES_OF_MOTION = "noticesOfMotion";

    /**
     * Element for {@link io.legaldocml.akn.element.Num}
     */
    public static final String NUM = "num";

    /**
     * Element for {@link io.legaldocml.akn.element.Object}
     */
    public static final String OBJECT = "object";

    /**
     * Element for {@link io.legaldocml.akn.element.OfficialGazette}
     */
    public static final String OFFICIAL_GAZETTE = "officialGazette";

    /**
     * Element for {@link io.legaldocml.akn.element.Ol}
     */
    public static final String OL = "ol";

    /**
     * Element for {@link io.legaldocml.akn.element.Old}
     */
    public static final String OLD = "old";

    /**
     * Element for {@link io.legaldocml.akn.element.Omissis}
     */
    public static final String OMISSIS = "omissis";

    /**
     * Element for {@link io.legaldocml.akn.element.Opinion}
     */
    public static final String OPINION = "opinion";

    /**
     * Element for {@link io.legaldocml.akn.element.OralStatements}
     */
    public static final String ORAL_STATEMENTS = "oralStatements";

    /**
     * Element for {@link io.legaldocml.akn.element.Organization}
     */
    public static final String ORGANIZATION = "organization";

    /**
     * Element for {@link io.legaldocml.akn.element.Original}
     */
    public static final String ORIGINAL = "original";

    /**
     * Element for {@link io.legaldocml.akn.element.Other}
     */
    public static final String OTHER = "other";

    /**
     * Element for {@link io.legaldocml.akn.element.OtherAnalysis}
     */
    public static final String OTHER_ANALYSIS = "otherAnalysis";

    /**
     * Element for {@link io.legaldocml.akn.element.OtherReferences}
     */
    public static final String OTHER_REFERENCES = "otherReferences";

    /**
     * Element for {@link io.legaldocml.akn.element.Outcome}
     */
    public static final String OUTCOME = "outcome";

    /**
     * Element for {@link io.legaldocml.akn.element.Overrules}
     */
    public static final String OVER_RULES = "overrules";

    /**
     * Element for {@link io.legaldocml.akn.element.P}
     */
    public static final String P = "p";

    /**
     * Element for {@link io.legaldocml.akn.element.Papers}
     */
    public static final String PAPERS = "papers";

    /**
     * Element for {@link io.legaldocml.akn.element.Paragraph}
     */
    public static final String PARAGRAPH = "paragraph";

    /**
     * Element for {@link io.legaldocml.akn.element.Part}
     */
    public static final String PART = "part";

    /**
     * Element for {@link io.legaldocml.akn.element.Parliamentary}
     */
    public static final String PARLIAMENTARY = "parliamentary";

    /**
     * Element for {@link io.legaldocml.akn.element.Party}
     */
    public static final String PARTY = "party";

    /**
     * Element for {@link io.legaldocml.akn.element.PassiveModifications}
     */
    public static final String PASSIVE_MODIFICATIONS = "passiveModifications";

    /**
     * Element for {@link io.legaldocml.akn.element.PassiveRef}
     */
    public static final String PASSIVE_REF = "passiveRef";

    /**
     * Element for {@link io.legaldocml.akn.element.Person}
     */
    public static final String PERSON = "person";

    /**
     * Element for {@link io.legaldocml.akn.element.PersonalStatements}
     */
    public static final String PERSONAL_STATEMENTS = "personalStatements";

    /**
     * Element for {@link io.legaldocml.akn.element.Petitions}
     */
    public static final String PETITIONS = "petitions";

    /**
     * Element for {@link io.legaldocml.akn.element.Placeholder}
     */
    public static final String PLACE_HOLDER = "placeholder";

    /**
     * Element for {@link io.legaldocml.akn.element.Point}
     */
    public static final String POINT = "point";

    /**
     * Element for {@link io.legaldocml.akn.element.PointOfOrder}
     */
    public static final String POINT_OF_ORDER = "pointOfOrder";

    /**
     * Element for {@link io.legaldocml.akn.element.Popup}
     */
    public static final String POPUP = "popup";

    /**
     * Element for {@link io.legaldocml.akn.element.Portion}
     */
    public static final String PORTION = "portion";

    /**
     * Element for {@link io.legaldocml.akn.element.PortionBody}
     */
    public static final String PORTION_BODY = "portionBody";

    /**
     * Element for {@link io.legaldocml.akn.element.Prayers}
     */
    public static final String PRAYERS = "prayers";

    /**
     * Element for {@link io.legaldocml.akn.element.Preamble}
     */
    public static final String PREAMBLE = "preamble";

    /**
     * Element for {@link io.legaldocml.akn.element.Preface}
     */
    public static final String PREFACE = "preface";

    /**
     * Element for {@link io.legaldocml.akn.element.Presentation}
     */
    public static final String PRESENTATION = "presentation";

    /**
     * Element for {@link io.legaldocml.akn.element.Preservation}
     */
    public static final String PRESERVATION = "preservation";

    /**
     * Element for {@link io.legaldocml.akn.element.Previous}
     */
    public static final String PREVIOUS = "previous";

    /**
     * Element for {@link io.legaldocml.akn.element.ProceduralMotions}
     */
    public static final String PROCEDURAL_MOTIONS = "proceduralMotions";

    /**
     * Element for {@link io.legaldocml.akn.element.ProceduralMotions}
     */
    public static final String PROCESS = "process";

    /**
     * Element for {@link io.legaldocml.akn.element.Proprietary}
     */
    public static final String PROPRIETARY = "proprietary";

    /**
     * Element for {@link io.legaldocml.akn.element.Proviso}
     */
    public static final String PROVISO = "proviso";

    /**
     * Element for {@link io.legaldocml.akn.element.Publication}
     */
    public static final String PUBLICATION = "publication";

    /**
     * Element for {@link io.legaldocml.akn.element.PutsInQuestion}
     */
    public static final String PUTS_IN_QUESTION = "putsInQuestion";

    /**
     * Element for {@link io.legaldocml.akn.element.Quantity}
     */
    public static final String QUANTITY = "quantity";

    /**
     * Element for {@link io.legaldocml.akn.element.Question}
     */
    public static final String QUESTION = "question";

    /**
     * Element for {@link io.legaldocml.akn.element.Questions}
     */
    public static final String QUESTIONS = "questions";

    /**
     * Element for {@link io.legaldocml.akn.element.Quorum}
     */
    public static final String QUORUM = "quorum";

    /**
     * Element for {@link io.legaldocml.akn.element.QuorumVerification}
     */
    public static final String QUORUM_VERIFICATION = "quorumVerification";

    /**
     * Element for {@link io.legaldocml.akn.element.QuotedStructureV3}
     */
    public static final String QUOTED_STRUCTURE = "quotedStructure";

    /**
     * Element for {@link io.legaldocml.akn.element.QuotedText}
     */
    public static final String QUOTED_TEXT = "quotedText";

    /**
     * Element for {@link io.legaldocml.akn.element.Recital}
     */
    public static final String RECITAL = "recital";

    /**
     * Element for {@link io.legaldocml.akn.element.Recitals}
     */
    public static final String RECITALS = "recitals";

    /**
     * Element for {@link io.legaldocml.akn.element.RecordedTime}
     */
    public static final String RECORDED_TIME = "recordedTime";

    /**
     * Element for {@link io.legaldocml.akn.element.Recount}
     */
    public static final String RECOUNT = "recount";

    /**
     * Element for {@link io.legaldocml.akn.element.Ref}
     */
    public static final String REF = "ref";

    /**
     * Element for {@link io.legaldocml.akn.element.References}
     */
    public static final String REFERENCES = "references";

    /**
     * Element for {@link io.legaldocml.akn.element.RelatedDocument}
     */
    public static final String RELATED_DOCUMENT = "relatedDocument";

    /**
     * Element for {@link io.legaldocml.akn.element.Remark}
     */
    public static final String REMARK = "remark";

    /**
     * Element for {@link io.legaldocml.akn.element.Remedies}
     */
    public static final String REMEDIES = "remedies";

    /**
     * Element for {@link io.legaldocml.akn.element.Resolutions}
     */
    public static final String RESOLUTIONS = "resolutions";

    /**
     * Element for {@link io.legaldocml.akn.element.Restriction}
     */
    public static final String RESTRICTION = "restriction";

    /**
     * Element for {@link io.legaldocml.akn.element.Restrictions}
     */
    public static final String RESTRICTIONS = "restrictions";

    /**
     * Element for {@link io.legaldocml.akn.element.Restricts}
     */
    public static final String RESTRICTS = "restricts";

    /**
     * Element for {@link io.legaldocml.akn.element.Result}
     */
    public static final String RESULT = "result";

    /**
     * Element for {@link io.legaldocml.akn.element.Rmod}
     */
    public static final String RMOD = "rmod";

    /**
     * Element for {@link io.legaldocml.akn.element.Role}
     */
    public static final String ROLE = "role";

    /**
     * Element for {@link io.legaldocml.akn.element.RollCall}
     */
    public static final String ROLL_CALL = "rollCall";

    /**
     * Element for {@link io.legaldocml.akn.element.Rref}
     */
    public static final String RREF = "rref";

    /**
     * Element for {@link io.legaldocml.akn.element.Rule}
     */
    public static final String RULE = "rule";

    /**
     * Element for {@link io.legaldocml.akn.element.Scene}
     */
    public static final String SCENE = "scene";

    /**
     * Element for {@link io.legaldocml.akn.element.ScopeMod}
     */
    public static final String SCOPE_MOD = "scopeMod";

    /**
     * Element for {@link io.legaldocml.akn.element.Section}
     */
    public static final String SECTION = "section";

    /**
     * Element for {@link io.legaldocml.akn.element.Session}
     */
    public static final String SESSION = "session";

    /**
     * Element for {@link io.legaldocml.akn.element.ShortTitle}
     */
    public static final String SHORT_TITLE = "shortTitle";

    /**
     * Element for {@link io.legaldocml.akn.element.Signature}
     */
    public static final String SIGNATURE = "signature";

    /**
     * Element for {@link io.legaldocml.akn.element.Source}
     */
    public static final String SOURCE = "source";

    /**
     * Element for {@link io.legaldocml.akn.element.Span}
     */
    public static final String SPAN = "span";

    /**
     * Element for {@link io.legaldocml.akn.element.Speech}
     */
    public static final String SPEECH = "speech";

    /**
     * Element for {@link io.legaldocml.akn.element.SpeechGroup}
     */
    public static final String SPEECH_GROUP = "speechGroup";

    /**
     * Element for {@link io.legaldocml.akn.element.Statement}
     */
    public static final String STATEMENT = "statement";

    /**
     * Element for {@link io.legaldocml.akn.element.Step}
     */
    public static final String STEP = "step";

    /**
     * Element for {@link io.legaldocml.akn.element.Sub}
     */
    public static final String SUB = "sub";

    /**
     * Element for {@link io.legaldocml.akn.element.Subchapter}
     */
    public static final String SUB_CHAPTER = "subchapter";

    /**
     * Element for {@link io.legaldocml.akn.element.Subclause}
     */
    public static final String SUB_CLAUSE = "subclause";

    /**
     * Element for {@link io.legaldocml.akn.element.Subdivision}
     */
    public static final String SUB_DIVISION = "subdivision";

    /**
     * Element for {@link io.legaldocml.akn.element.SubFlow}
     */
    public static final String SUB_FLOW = "subFlow";

    /**
     * Element for {@link io.legaldocml.akn.element.Subheading}
     */
    public static final String SUB_HEADING = "subheading";

    /**
     * Element for {@link io.legaldocml.akn.element.Sublist}
     */
    public static final String SUB_LIST = "sublist";

    /**
     * Element for {@link io.legaldocml.akn.element.Subparagraph}
     */
    public static final String SUB_PARAGRAPH = "subparagraph";

    /**
     * Element for {@link io.legaldocml.akn.element.Subpart}
     */
    public static final String SUB_PART = "subpart";

    /**
     * Element for {@link io.legaldocml.akn.element.Subsection}
     */
    public static final String SUB_SECTION = "subsection";

    /**
     * Element for {@link io.legaldocml.akn.element.Subtitle}
     */
    public static final String SUB_TITLE = "subtitle";

    /**
     * Element for {@link io.legaldocml.akn.element.Subrule}
     */
    public static final String SUB_RULE = "subrule";

    /**
     * Element for {@link io.legaldocml.akn.element.Summary}
     */
    public static final String SUMMARY = "summary";

    /**
     * Element for {@link io.legaldocml.akn.element.Sup}
     */
    public static final String SUP = "sup";

    /**
     * Element for {@link io.legaldocml.akn.element.Supports}
     */
    public static final String SUPPORTS = "supports";

    /**
     * Element for {@link io.legaldocml.akn.element.Table}
     */
    public static final String TABLE = "table";

    /**
     * Element for {@link io.legaldocml.akn.element.Tblock}
     */
    public static final String TBLOCK = "tblock";

    /**
     * Element for {@link io.legaldocml.akn.element.Td}
     */
    public static final String TD = "td";

    /**
     * Element for {@link io.legaldocml.akn.element.TemporalData}
     */
    public static final String TEMPORAL_DATA = "temporalData";

    /**
     * Element for {@link io.legaldocml.akn.element.TemporalGroup}
     */
    public static final String TEMPORAL_GROUP = "temporalGroup";

    /**
     * Element for {@link io.legaldocml.akn.element.Term}
     */
    public static final String TERM = "term";

    /**
     * Element for {@link io.legaldocml.akn.element.TextualMod}
     */
    public static final String TEXTUAL_MOD = "textualMod";

    /**
     * Element for {@link io.legaldocml.akn.element.Th}
     */
    public static final String TH = "th";

    /**
     * Element for {@link io.legaldocml.akn.element.Time}
     */
    public static final String TIME = "time";

    /**
     * Element for {@link io.legaldocml.akn.element.TimeInterval}
     */
    public static final String TIME_INTERVAL = "timeInterval";

    /**
     * Element for {@link io.legaldocml.akn.element.Title}
     */
    public static final String TITLE = "title";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCConcept}
     */
    public static final String TLC_CONCEPT = "TLCConcept";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCEvent}
     */
    public static final String TLC_EVENT = "TLCEvent";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCLocation}
     */
    public static final String TLC_LOCATION = "TLCLocation";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCObject}
     */
    public static final String TLC_OBJECT = "TLCObject";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCOrganization}
     */
    public static final String TLC_ORGANIZATION = "TLCOrganization";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCPerson}
     */
    public static final String TLC_PERSON = "TLCPerson";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCProcess}
     */
    public static final String TLC_PROCESS = "TLCProcess";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCReference}
     */
    public static final String TLC_REFERENCE = "TLCReference";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCRole}
     */
    public static final String TLC_ROLE = "TLCRole";

    /**
     * Element for {@link io.legaldocml.akn.element.TLCTerm}
     */
    public static final String TLC_TERM = "TLCTerm";

    /**
     * Element for {@link io.legaldocml.akn.element.Toc}
     */
    public static final String TOC = "toc";

    /**
     * Element for {@link io.legaldocml.akn.element.TocItem}
     */
    public static final String TOC_ITEM = "tocItem";

    /**
     * Element for {@link io.legaldocml.akn.element.Tome}
     */
    public static final String TOME = "tome";

    /**
     * Element for {@link io.legaldocml.akn.element.Tr}
     */
    public static final String TR = "tr";

    /**
     * Element for {@link io.legaldocml.akn.element.Transitional}
     */
    public static final String TRANSITIONAL = "transitional";

    /**
     * Element for {@link io.legaldocml.akn.element.U}
     */
    public static final String U = "u";

    /**
     * Element for {@link io.legaldocml.akn.element.Ul}
     */
    public static final String UL = "ul";

    /**
     * Element for {@link io.legaldocml.akn.element.Vote}
     */
    public static final String VOTE = "vote";

    /**
     * Element for {@link io.legaldocml.akn.element.Voting}
     */
    public static final String VOTING = "voting";

    /**
     * Element for {@link io.legaldocml.akn.element.Workflow}
     */
    public static final String WORKFLOW = "workflow";

    /**
     * Element for {@link io.legaldocml.akn.element.Wrap}
     */
    public static final String WRAP = "wrap";

    /**
     * Element for {@link io.legaldocml.akn.element.WrapUp}
     */
    public static final String WRAP_UP = "wrapUp";

    /**
     * Element for {@link io.legaldocml.akn.element.WrittenStatements}
     */
    public static final String WRITTEN_STATEMENTS = "writtenStatements";

    public static boolean exists(String name) {
        return ELEMENTS.containsKey(name);
    }


    public static Class<? extends AknObject> getAknClass(String name) {
        return ELEMENTS.get(name);
    }


    private static String firstLetterUpperCase(String value) {
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toUpperCase(value.charAt(0)));
        if (value.length() > 1) {
            builder.append(value.substring(1));
        }
        return builder.toString();
    }
}
