package io.legaldocml.akn.element;

import io.legaldocml.akn.attribute.IdReq;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;

import static io.legaldocml.akn.util.XmlWriterHelper.writeIdReq;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class IdReqImpl extends AbstractId implements IdReq {

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(XmlWriter writer) throws IOException {
        writeIdReq(writer, this);
    }

}