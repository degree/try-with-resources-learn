package by.degree.learn.twr;

import org.easymock.Mock;
import org.easymock.MockType;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;

import static org.easymock.EasyMock.*;

abstract public class AbstractTargetClassTest {

    @Mock(type = MockType.STRICT)
    Writer writer;

    AbstractTargetClass target;

    @Test
    public void doSmth() throws Exception {
        writer.write("Hello, World");
        expectLastCall().once();

        writer.close();
        expectLastCall().once();

        replay(writer);

        target.doSmth();

        verify(writer);
    }

    @Test
    public void doSmthAndHitIOException() throws Exception {
        final IOException e1 = createStrictMock(IOException.class);
        e1.printStackTrace();
        expectLastCall().once();

        writer.write("Hello, World");
        expectLastCall().andThrow(e1);

        writer.close();
        expectLastCall().once();

        replay(writer, e1);

        target.doSmth();

        verify(writer, e1);
    }

    @Test
    public void doSmthAndHitIOExceptionAndSuppressed() throws Exception {
        final IOException e1 = createNiceMock(IOException.class);

        e1.printStackTrace();
        expectLastCall().once();

        writer.write("Hello, World");
        expectLastCall().andThrow(e1);

        writer.close();
        expectLastCall().andThrow(new IOException());

        replay(writer, e1);

        target.doSmth();

        verify(writer, e1);
    }
}
