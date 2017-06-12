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
public class TargetClassTest extends AbstractTargetClassTest {

    @Before
    public void setUp() throws Exception {
        target = new TargetClass(writer);
    }

}
