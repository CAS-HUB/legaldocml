package io.legaldocml.io;

import io.legaldocml.util.CharArray;

import java.io.IOException;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface Attribute {

    void write(XmlWriter writer) throws IOException;

    void read(XmlReader reader, CharArray value);
}
