package by.degree.learn.twr;

import java.io.IOException;
import java.io.Writer;

class TargetClassExploded {
    private final Writer writer;

    TargetClassExploded(Writer writer) {
        this.writer = writer;
    }

    void doSmth() {
        try (Writer w = writer) {
            w.write("Hello, World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
