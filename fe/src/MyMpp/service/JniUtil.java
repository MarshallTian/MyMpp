package MyMpp.service;

import com.sun.jdi.InternalException;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 * Created by root on 6/25/15.
 */
public class JniUtil {
    private final static TBinaryProtocol.Factory protocolFactory_ =
            new TBinaryProtocol.Factory();

    public static <T extends TBase<?, ?>> void deserializeThrift(TBinaryProtocol.Factory protocolFactory,
                                                                 T result, byte[] thriftData) {
        TDeserializer deserializer = new TDeserializer(protocolFactory);
        try {
            deserializer.deserialize(result, thriftData);
        } catch (TException e) {
            throw new InternalException(e.getMessage());
        }
    }
}
