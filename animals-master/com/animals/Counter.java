package com.animals;

import java.io.Closeable;
import java.io.IOException;

public class Counter implements Closeable {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void close() throws IOException {
        if (value == 0) {
            throw new IOException("");
        }
    }
}
