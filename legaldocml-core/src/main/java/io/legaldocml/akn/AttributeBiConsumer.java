package io.legaldocml.akn;

import io.legaldocml.util.CharArray;
import io.legaldocml.io.Externalizable;

import java.util.function.BiConsumer;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public abstract class AttributeBiConsumer implements BiConsumer<Externalizable, CharArray> {

    private final String name;

    public AttributeBiConsumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
