"use strict";

const expect = require("chai").expect;
const romanNumber = require("../js/romannumber");

describe("format numbers", () => {
  it("1 up to 10", () => {
    expect(romanNumber.format(1)).to.equal("I");
    expect(romanNumber.format(2)).to.equal("II");
    expect(romanNumber.format(3)).to.equal("III");
    expect(romanNumber.format(4)).to.equal("IV");
    expect(romanNumber.format(5)).to.equal("V");
    expect(romanNumber.format(6)).to.equal("VI");
    expect(romanNumber.format(7)).to.equal("VII");
    expect(romanNumber.format(8)).to.equal("VIII");
    expect(romanNumber.format(9)).to.equal("IX");
    expect(romanNumber.format(10)).to.equal("X");
  });

  it("some more numbers", () => {
    expect(romanNumber.format(20)).to.equal("XX");
    expect(romanNumber.format(30)).to.equal("XXX");
    expect(romanNumber.format(40)).to.equal("XL");
    expect(romanNumber.format(44)).to.equal("XLIV");
    expect(romanNumber.format(49)).to.equal("XLIX");
    expect(romanNumber.format(50)).to.equal("L");
    expect(romanNumber.format(54)).to.equal("LIV");
    expect(romanNumber.format(59)).to.equal("LIX");
    expect(romanNumber.format(100)).to.equal("C");
    expect(romanNumber.format(499)).to.equal("CDXCIX");
    expect(romanNumber.format(500)).to.equal("D");
    expect(romanNumber.format(1000)).to.equal("M");
    expect(romanNumber.format(3999)).to.equal("MMMCMXCIX");
  });
});

describe("parse roman numbers", () => {
  it("I up to X", () => {
    expect(romanNumber.parse("I")).to.equal(1);
    expect(romanNumber.parse("II")).to.equal(2);
    expect(romanNumber.parse("III")).to.equal(3);
    expect(romanNumber.parse("IV")).to.equal(4);
    expect(romanNumber.parse("V")).to.equal(5);
    expect(romanNumber.parse("VI")).to.equal(6);
    expect(romanNumber.parse("VII")).to.equal(7);
    expect(romanNumber.parse("VIII")).to.equal(8);
    expect(romanNumber.parse("IX")).to.equal(9);
    expect(romanNumber.parse("X")).to.equal(10);
  });

  it("some more roman numbers", () => {
    expect(romanNumber.parse("XX")).to.equal(20);
    expect(romanNumber.parse("XXX")).to.equal(30);
    expect(romanNumber.parse("XL")).to.equal(40);
    expect(romanNumber.parse("XLIV")).to.equal(44);
    expect(romanNumber.parse("XLIX")).to.equal(49);
    expect(romanNumber.parse("L")).to.equal(50);
    expect(romanNumber.parse("LIV")).to.equal(54);
    expect(romanNumber.parse("LIX")).to.equal(59);
    expect(romanNumber.parse("C")).to.equal(100);
    expect(romanNumber.parse("CDXCIX")).to.equal(499);
    expect(romanNumber.parse("D")).to.equal(500);
    expect(romanNumber.parse("M")).to.equal(1000);
    expect(romanNumber.parse("MMMCMXCIX")).to.equal(3999);
  });

  it("reject an invalid roman number", () => {
    expect(() => romanNumber.parse("")).to.throw(Error);
    expect(() => romanNumber.parse("XO")).to.throw(Error);
    expect(() => romanNumber.parse("VIV")).to.throw(Error);
    expect(() => romanNumber.parse("IXI")).to.throw(Error);
    expect(() => romanNumber.parse("VIIII")).to.throw(Error);
    expect(() => romanNumber.parse("XIXI")).to.throw(Error);
    expect(() => romanNumber.parse("IC")).to.throw(Error);
    expect(() => romanNumber.parse("VVI")).to.throw(Error);
    expect(() => romanNumber.parse("LL")).to.throw(Error);
  });
});
