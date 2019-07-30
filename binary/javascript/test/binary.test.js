import { toBinary, expandToBytes, onesComplement, twosComplement }
    from "../js/binary.js"

describe("toBinary", () => {
    test("converts to binary", () => {
        expect(toBinary(0)).toEqual("0");
        expect(toBinary(1)).toEqual("1");
        expect(toBinary(2)).toEqual("10");
        expect(toBinary(3)).toEqual("11");
        expect(toBinary(12)).toEqual("1100");
        expect(toBinary(15)).toEqual("1111");
        expect(toBinary(16)).toEqual("10000");
        expect(toBinary(127)).toEqual("1111111");
        expect(toBinary(128)).toEqual("10000000");
        expect(toBinary(255)).toEqual("11111111");
        expect(toBinary(256)).toEqual("100000000");
    });

    test("argument must be positive integer", () => {
        const errorMsg = /^argument must be positive int$/;

        expect(() => toBinary(-1)).toThrowError(errorMsg);
        expect(() => toBinary(3.14)).toThrowError(errorMsg);
    });
});


describe("expandToBytes", () => {
    test("expands to byte", () => {
        expect(expandToBytes("0")).toEqual("00000000");
        expect(expandToBytes("1")).toEqual("00000001");
        expect(expandToBytes("10")).toEqual("00000010");
        expect(expandToBytes("11")).toEqual("00000011");
        expect(expandToBytes("1100")).toEqual("00001100");
        expect(expandToBytes("1111")).toEqual("00001111");
        expect(expandToBytes("10000")).toEqual("00010000");
        expect(expandToBytes("1111111")).toEqual("01111111");
        expect(expandToBytes("10000000")).toEqual("10000000");
        expect(expandToBytes("11111111")).toEqual("11111111");
    });

    test("expands to bytes", () => {
        expect(expandToBytes("100000000")).toEqual("0000000100000000");
    });

    test("argument must be binary", () => {
        const errorMsg = /^argument must be valid binary$/;

        expect(() => expandToBytes("")).toThrowError(errorMsg);
        expect(() => expandToBytes(" ")).toThrowError(errorMsg);
        expect(() => expandToBytes("x")).toThrowError(errorMsg);
        expect(() => expandToBytes("2")).toThrowError(errorMsg);
        expect(() => expandToBytes("0000 11")).toThrowError(errorMsg);
    });
});

describe("onesComplement", () => {
    test("converts byte to ones complement", () => {
        expect(onesComplement("00000000")).toEqual("11111111");
        expect(onesComplement("00000001")).toEqual("11111110");
        expect(onesComplement("00000010")).toEqual("11111101");
        expect(onesComplement("00000011")).toEqual("11111100");
        expect(onesComplement("00001100")).toEqual("11110011");
        expect(onesComplement("00001111")).toEqual("11110000");
        expect(onesComplement("00010000")).toEqual("11101111");
        expect(onesComplement("01111111")).toEqual("10000000");
        expect(onesComplement("10000000")).toEqual("01111111");
        expect(onesComplement("11111111")).toEqual("00000000");
    });

    test("converts bytes to ones complement", () => {
        expect(onesComplement("0000000100000000")).toEqual("1111111011111111");
    });

    test("argument must be bytes", () => {
        const errorMsg = /^argument must be byte aligned$/;

        expect(() => onesComplement("")).toThrowError(errorMsg);
        expect(() => onesComplement(" ")).toThrowError(errorMsg);
        expect(() => onesComplement("x")).toThrowError(errorMsg);
        expect(() => onesComplement("2")).toThrowError(errorMsg);
        expect(() => onesComplement("0000 11")).toThrowError(errorMsg);
        expect(() => onesComplement("0000111")).toThrowError(errorMsg);
        expect(() => onesComplement("00001112")).toThrowError(errorMsg);
        expect(() => onesComplement("000011110")).toThrowError(errorMsg);
    });
});

describe("twosComplement", () => {
    test("converts byte to twos complement", () => {
        expect(twosComplement("00000000")).toEqual("00000000");
        expect(twosComplement("00000001")).toEqual("11111111");
        expect(twosComplement("00000010")).toEqual("11111110");
        expect(twosComplement("00000011")).toEqual("11111101");
        expect(twosComplement("00001100")).toEqual("11110100");
        expect(twosComplement("00001111")).toEqual("11110001");
        expect(twosComplement("00010000")).toEqual("11110000");
        expect(twosComplement("01111111")).toEqual("10000001");
        expect(twosComplement("10000000")).toEqual("10000000");
        expect(twosComplement("11111111")).toEqual("00000001");
    });

    test("converts bytes to twos complement", () => {
        expect(twosComplement("0000000100000000")).toEqual("1111111100000000");
    });

    test("argument must be bytes", () => {
        const errorMsg = /^argument must be byte aligned$/;

        expect(() => twosComplement("")).toThrowError(errorMsg);
        expect(() => twosComplement(" ")).toThrowError(errorMsg);
        expect(() => twosComplement("x")).toThrowError(errorMsg);
        expect(() => twosComplement("2")).toThrowError(errorMsg);
        expect(() => twosComplement("0000 11")).toThrowError(errorMsg);
        expect(() => twosComplement("0000111")).toThrowError(errorMsg);
        expect(() => twosComplement("00001112")).toThrowError(errorMsg);
        expect(() => twosComplement("000011110")).toThrowError(errorMsg);
    });
});