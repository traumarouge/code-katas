"use strict";

import { RomanSymbol } from "../js/romansymbol.js";

describe("roman symbols", () => {
  test(RomanSymbol.symbols().toString(), () => {
    const symbols = RomanSymbol.symbols();

    expect(symbols[0]).toBe(RomanSymbol.I);
    expect(symbols[1]).toBe(RomanSymbol.V);
    expect(symbols[2]).toBe(RomanSymbol.X);
    expect(symbols[3]).toBe(RomanSymbol.L);
    expect(symbols[4]).toBe(RomanSymbol.C);
    expect(symbols[5]).toBe(RomanSymbol.D);
    expect(symbols[6]).toBe(RomanSymbol.M);
  });

  test("right shift given roman symbol", () => {
    expect(RomanSymbol.rightShift(RomanSymbol.I)).toBe(RomanSymbol.V);
    expect(RomanSymbol.rightShift(RomanSymbol.D)).toBe(RomanSymbol.M);
    expect(RomanSymbol.rightShift(RomanSymbol.M)).toBe(RomanSymbol.I);

    expect(RomanSymbol.rightShift(RomanSymbol.I, 1)).toBe(RomanSymbol.V);
    expect(RomanSymbol.rightShift(RomanSymbol.D, 1)).toBe(RomanSymbol.M);
    expect(RomanSymbol.rightShift(RomanSymbol.M, 1)).toBe(RomanSymbol.I);

    expect(RomanSymbol.rightShift(RomanSymbol.I, 2)).toBe(RomanSymbol.X);
    expect(RomanSymbol.rightShift(RomanSymbol.D, 2)).toBe(RomanSymbol.I);
    expect(RomanSymbol.rightShift(RomanSymbol.M, 2)).toBe(RomanSymbol.V);
  });
});
