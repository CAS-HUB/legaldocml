package io.legaldocml.module.akn.v3;

import io.legaldocml.akn.AknObject;
import io.legaldocml.io.CoreAttribute;
import io.legaldocml.util.CharArray;
import io.legaldocml.util.CharArrays;
import io.legaldocml.io.XmlWriter;
import io.legaldocml.util.Buffers;
import io.legaldocml.module.AknModule;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
public final class AkomaNtosoModuleV3 implements AknModule {

    private static final String NS_VALUE = "http://docs.oasis-open.org/legaldocml/ns/akn/3.0";
    private static final String NS_PREFIX = "xmlns";

    private static final long NS_VALUE_ADDRESS = Buffers.address(NS_VALUE);
    private static final long NS_PREFIX_ADDRESS = Buffers.address(NS_PREFIX);

    public static final CharArray NAMESPACE_LEGALDOCML = CharArrays.immutable(NS_VALUE);

    public static final AkomaNtosoModuleV3 INSTANCE = new AkomaNtosoModuleV3();

    /**
     * {@inheritDoc}
     */
    @Override
    public CharArray namespace() {
        return NAMESPACE_LEGALDOCML;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeNamespace(XmlWriter writer) throws IOException {
        writer.writeNamespace(NS_PREFIX_ADDRESS,5, NS_VALUE_ADDRESS,48);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Supplier<CoreAttribute> attribute(String name) {
        throw new IllegalStateException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends AknObject> Supplier<T> element(String localName) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getName() + " for [" + NAMESPACE_LEGALDOCML + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getVersion() {
        return 3;
    }

}
