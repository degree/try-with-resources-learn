package by.degree.learn.twr;

import java.io.Writer;

abstract class AbstractTargetClass {
    final Writer writer;

    public AbstractTargetClass(Writer writer) {
        this.writer = writer;
    }

    abstract void doSmth();
}
