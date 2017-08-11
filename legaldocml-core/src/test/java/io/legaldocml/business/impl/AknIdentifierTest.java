package io.legaldocml.business.impl;

import io.legaldocml.akn.AkomaNtoso;
import io.legaldocml.akn.element.Amendment;
import io.legaldocml.business.AknIdentifier;
import io.legaldocml.business.AknIdentifierException;
import io.legaldocml.business.impl.DefaultAknIdentifier;
import org.junit.Assert;
import org.junit.Test;

public class AknIdentifierTest {

    @Test
    public void applyTest() {

        AknIdentifier identifier = new DefaultAknIdentifier("work001", "expression002", "manifestation003", "/");
        AkomaNtoso<Amendment> akn = new AkomaNtoso<>();
        akn.setDocumentType(new Amendment());

        identifier.apply(akn);

        Assert.assertEquals("work001", akn.getDocumentType().getMeta().getIdentification().getFRBRWork().getFRBRthis().getValue());
        Assert.assertEquals("work001/expression002", akn.getDocumentType().getMeta().getIdentification().getFRBRExpression().getFRBRthis().getValue());
        Assert.assertEquals("work001/expression002/manifestation003", akn.getDocumentType().getMeta().getIdentification().getFRBRManifestation().getFRBRthis().getValue());
    }

    @Test
    public void consistentTest() {

        AkomaNtoso<Amendment> akn = new AkomaNtoso<>();
        akn.setDocumentType(new Amendment());

        AknIdentifier identifier = new DefaultAknIdentifier("work001", "expression002", "manifestation003", "/");
        identifier.apply(akn);

        AknIdentifier.consistent(akn);

        akn.getDocumentType().getMeta().getIdentification().getFRBRExpression().getFRBRthis().setValue("toto");

        try {
            AknIdentifier.consistent(akn);
            Assert.fail();
        } catch (AknIdentifierException cause) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void extractTest() {

        AkomaNtoso<Amendment> akn = new AkomaNtoso<>();
        akn.setDocumentType(new Amendment());

        AknIdentifier identifier = new DefaultAknIdentifier("work001", "expression002", "manifestation003", "/");
        identifier.apply(akn);

        AknIdentifier id = AknIdentifier.extract(akn);

        Assert.assertEquals("work001", id.work());
        Assert.assertEquals("work001/expression002", id.expression());
        Assert.assertEquals("expression002", id.expressionPart());
        Assert.assertEquals("work001/expression002/manifestation003", id.manifestation());
        Assert.assertEquals("manifestation003", id.manifestationPart());

    }

    @Test
    public void isEmptyTest() {

        AkomaNtoso<Amendment> akn = new AkomaNtoso<>();
        akn.setDocumentType(new Amendment());

        Assert.assertTrue(AknIdentifier.isEmpty(akn));

        new DefaultAknIdentifier("work001", "expression002", "manifestation003", "/").apply(akn);

        Assert.assertFalse(AknIdentifier.isEmpty(akn));
    }

}
