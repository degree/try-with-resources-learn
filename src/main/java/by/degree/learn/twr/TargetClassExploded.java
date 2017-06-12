package by.degree.learn.twr;

import java.io.IOException;
import java.io.Writer;

class TargetClassExploded extends AbstractTargetClass {
    TargetClassExploded(Writer writer) {
        super(writer);
    }

    void doSmth() {
        // according to http://docs.oracle.com/javase/specs/jls/se8/jls8.pdf
        try {
            final Writer w = writer;
            Throwable primaryException = null;
            try {
                w.write("Hello, World");
            } catch (Throwable t) {
                primaryException = t;
                throw t;
            } finally {
                if (w != null) {
                    if (primaryException != null) {
                        try {
                            w.close();
                        } catch (Throwable suppressedException) {
                            primaryException.addSuppressed(suppressedException);
                        }
                    } else {
                        w.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
