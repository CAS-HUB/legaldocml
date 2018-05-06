package io.legaldocml.module;

import io.legaldocml.akn.AknObject;
import io.legaldocml.io.Attribute;
import io.legaldocml.util.CharArray;
import io.legaldocml.io.XmlWriter;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public interface Module {

    CharArray namespace();

    void writeNamespace(XmlWriter writer) throws IOException;

    Supplier<Attribute> attributes(String name);

    <T> Supplier<T> element(String localName);

}
