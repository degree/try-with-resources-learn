package by.degree.learn.twr;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.Writer;

import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class TargetClassTest {


    @Mock
    private Writer writer;
    private TargetClass targetClass;

    @Before
    public void setUp() throws Exception {
        writer = createStrictMock(Writer.class);
        targetClass = new TargetClass(writer);
    }

    @Test
    public void doSmth() throws Exception {
        writer.write("Hello, World");
        expectLastCall().once();

        writer.close();
        expectLastCall().once();

        replay(writer);

        targetClass.doSmth();

        verify(writer);
    }

}
