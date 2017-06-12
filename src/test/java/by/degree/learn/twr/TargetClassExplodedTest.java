package by.degree.learn.twr;

import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class TargetClassExplodedTest extends AbstractTargetClassTest {

    @Before
    public void setUp() throws Exception {
        target = new TargetClassExploded(writer);
    }

}
