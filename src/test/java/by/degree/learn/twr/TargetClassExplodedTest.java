package by.degree.learn.twr;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.Writer;

import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class TargetClassExplodedTest {

    @Mock
    private Writer writer;

    private TargetClassExploded targetClassExploded;

    @Before
    public void setUp() throws Exception {
        writer = createStrictMock(Writer.class);
        targetClassExploded = new TargetClassExploded(writer);
    }

    @Test
    public void doSmth() throws Exception {
        writer.write("Hello, World");
        expectLastCall().once();

        writer.close();
        expectLastCall().once();

        replay(writer);

        targetClassExploded.doSmth();

        verify(writer);
    }

    @Test
    public void doSmthAndHitIOExceptio() throws Exception {
        writer.write("Hello, World");
        expectLastCall().andThrow(new IOException());

        writer.close();
        expectLastCall().once();

        replay(writer);

        targetClassExploded.doSmth();

        verify(writer);
    }

}
