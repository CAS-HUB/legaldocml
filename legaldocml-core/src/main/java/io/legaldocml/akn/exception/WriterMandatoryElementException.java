package io.legaldocml.akn.exception;

import io.legaldocml.LegalDocMlException;
import io.legaldocml.akn.AknObject;
import io.legaldocml.io.QName;
import io.legaldocml.io.XmlReader;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
@SuppressWarnings("serial")
public final class WriterMandatoryElementException extends LegalDocMlException {

    private final String expected;
    private final QName actual;

    public WriterMandatoryElementException(AknObject aknObject, String expected, XmlReader reader) {
        super(buildMsg(aknObject, expected, reader));
        this.actual = reader.getQName();
        this.expected = expected;
    }

    private static String buildMsg(AknObject aknObject, String expected, XmlReader reader) {
        StringBuilder builder = new StringBuilder();
        builder.append("Expected [").append(expected).append("] - ");
        builder.append("Actual [").append(reader.getQName()).append("] - ");
        builder.append("AknObject [").append(aknObject).append("] - ");
        builder.append("XmlReader [").append(reader);
        return builder.toString();
    }

    public String getExpected() {
        return this.expected;
    }

    public QName getActual() {
        return actual;
    }
}
