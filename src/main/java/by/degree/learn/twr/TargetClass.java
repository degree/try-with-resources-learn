package by.degree.learn.twr;

import java.io.IOException;
import java.io.Writer;

class TargetClass extends AbstractTargetClass {
    TargetClass(Writer writer) {
        super(writer);
    }

    @Override
    void doSmth() {
        try (Writer w = writer) {
            w.write("Hello, World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
