"use strict";

import { CircularBuffer, EmptyBufferReadError } from "../js/circularbuffer";

describe("Circular Buffer", () => {
    const sut = new CircularBuffer(3);

    test("reading from empty buffer throws exception", () => {
        expect(() => sut.read()).toThrow(EmptyBufferReadError);
    });

    test("single element written to buffer can be read", () => {
        sut.write(23);

        expect(sut.read()).toEqual(23);
    });

    test("elements written to buffer can be read only once", () => {
        sut.write(23);

        expect(sut.read()).toEqual(23);
        expect(() => sut.read()).toThrow(EmptyBufferReadError);
    });

    test("reading from buffer removes oldest element", () => {
        sut.write(23);
        sut.write(42);

        expect(sut.read()).toEqual(23);
        expect(sut.read()).toEqual(42);
    });

    test("overwriting element makes next element oldest", () => {
        sut.write(1);
        sut.write(2);
        sut.write(3);

        sut.write(4); // writing to full buffer

        expect(sut.buffer.length === 3);

        expect(sut.read()).toEqual(2);
        expect(sut.read()).toEqual(3);
        expect(sut.read()).toEqual(4);
    });
});