"use strict";

const expect = require("chai").expect;
const RomanSymbol = require("../js/romansymbol");

describe("roman symbols", () => {
  it(RomanSymbol.symbols().toString(), () => {
    const symbols = RomanSymbol.symbols();

    expect(symbols[0]).to.equal(RomanSymbol.I);
    expect(symbols[1]).to.equal(RomanSymbol.V);
    expect(symbols[2]).to.equal(RomanSymbol.X);
    expect(symbols[3]).to.equal(RomanSymbol.L);
    expect(symbols[4]).to.equal(RomanSymbol.C);
    expect(symbols[5]).to.equal(RomanSymbol.D);
    expect(symbols[6]).to.equal(RomanSymbol.M);
  });

  it("right shift given roman symbol", () => {
    expect(RomanSymbol.rightShift(RomanSymbol.I)).to.equal(RomanSymbol.V);
    expect(RomanSymbol.rightShift(RomanSymbol.D)).to.equal(RomanSymbol.M);
    expect(RomanSymbol.rightShift(RomanSymbol.M)).to.equal(RomanSymbol.I);

    expect(RomanSymbol.rightShift(RomanSymbol.I, 1)).to.equal(RomanSymbol.V);
    expect(RomanSymbol.rightShift(RomanSymbol.D, 1)).to.equal(RomanSymbol.M);
    expect(RomanSymbol.rightShift(RomanSymbol.M, 1)).to.equal(RomanSymbol.I);

    expect(RomanSymbol.rightShift(RomanSymbol.I, 2)).to.equal(RomanSymbol.X);
    expect(RomanSymbol.rightShift(RomanSymbol.D, 2)).to.equal(RomanSymbol.I);
    expect(RomanSymbol.rightShift(RomanSymbol.M, 2)).to.equal(RomanSymbol.V);
  });
});
