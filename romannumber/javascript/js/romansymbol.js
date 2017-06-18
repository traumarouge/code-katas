"use strict";

class RomanSymbol {
  constructor(name, number) {
    this.name = name;
    this.number = number;
  }

  toString() {
    return this.name;
  }
}

RomanSymbol.I = new RomanSymbol("I", 1);
RomanSymbol.V = new RomanSymbol("V", 5);
RomanSymbol.X = new RomanSymbol("X", 10);
RomanSymbol.L = new RomanSymbol("L", 50);
RomanSymbol.C = new RomanSymbol("C", 100);
RomanSymbol.D = new RomanSymbol("D", 500);
RomanSymbol.M = new RomanSymbol("M", 1000);

RomanSymbol.symbols = function() {
  return [
    RomanSymbol.I,
    RomanSymbol.V,
    RomanSymbol.X,
    RomanSymbol.L,
    RomanSymbol.C,
    RomanSymbol.D,
    RomanSymbol.M
  ];
};

RomanSymbol.rightShift = function(romanSymbol, n) {
  const symbols = this.symbols();
  const shift = !n || n < 0 ? 1 : n;
  const index = symbols.indexOf(romanSymbol);

  return symbols[(index + shift) % symbols.length];
};

module.exports = RomanSymbol;
