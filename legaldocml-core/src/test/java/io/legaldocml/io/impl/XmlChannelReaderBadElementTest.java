package io.legaldocml.io.impl;

import io.legaldocml.akn.MandatoryElementException;
import io.legaldocml.akn.util.XmlReaderHelper;
import io.legaldocml.test.SonarJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.legaldocml.akn.AknElements.AKOMANTOSO;
import static io.legaldocml.io.impl.XmlChannelReaderHelper.doTest;
import static io.legaldocml.io.impl.XmlChannelReaderHelper.path;
import static org.junit.Assert.assertEquals;

@RunWith(SonarJUnit4ClassRunner.class)
public class XmlChannelReaderBadElementTest {

    @Test
    public void test001BadAkoElement() throws IOException {
        doTest(path("/xml/cdata-001.xml"), reader -> {
            reader.nextStartOrEndElement();
            try {
                XmlReaderHelper.createAkomaNtoso(reader);
                Assert.fail();
            } catch (MandatoryElementException cause) {
                assertEquals(AKOMANTOSO, cause.getExpected());
                assertEquals(new QNameImpl("test".toCharArray(),4,0), cause.getActual());
            }
        });
    }
}
