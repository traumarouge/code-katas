"use strict";

export class CircularBuffer {

    constructor(size) {
        this._readPointer = 0;
        this._writePointer = 0;
        this.buffer = new Array(size).fill(null);
        Object.seal(this.buffer);
    }

    read() {
        if (this.buffer[this._readPointer] === null) {
            throw new EmptyBufferReadError();
        }

        const element = this.buffer[this._readPointer];
        this.buffer[this._readPointer] = null;
        this._incrementReadPointer();

        return element;
    }

    write(element) {
        if (this.buffer[this._writePointer] !== null) {
            this._incrementReadPointer();
        }

        this.buffer[this._writePointer] = element;
        this._incrementWritePointer();
    }

    _incrementReadPointer() {
        this._readPointer = (this._readPointer + 1) % this.buffer.length;
    }

    _incrementWritePointer() {
        this._writePointer = (this._writePointer + 1) % this.buffer.length;
    }
}

export class EmptyBufferReadError extends Error {
    constructor(...args) {
        super(...args)
    }
}