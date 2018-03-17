"use strict";

import { format, parse } from "../js/romannumber.js";

describe("format numbers", () => {
  test("1 up to 10", () => {
    expect(format(1)).toBe("I");
    expect(format(2)).toBe("II");
    expect(format(3)).toBe("III");
    expect(format(4)).toBe("IV");
    expect(format(5)).toBe("V");
    expect(format(6)).toBe("VI");
    expect(format(7)).toBe("VII");
    expect(format(8)).toBe("VIII");
    expect(format(9)).toBe("IX");
    expect(format(10)).toBe("X");
  });

  test("some more numbers", () => {
    expect(format(20)).toBe("XX");
    expect(format(30)).toBe("XXX");
    expect(format(40)).toBe("XL");
    expect(format(44)).toBe("XLIV");
    expect(format(49)).toBe("XLIX");
    expect(format(50)).toBe("L");
    expect(format(54)).toBe("LIV");
    expect(format(59)).toBe("LIX");
    expect(format(100)).toBe("C");
    expect(format(499)).toBe("CDXCIX");
    expect(format(500)).toBe("D");
    expect(format(1000)).toBe("M");
    expect(format(3999)).toBe("MMMCMXCIX");
  });
});

describe("parse roman numbers", () => {
  test("I up to X", () => {
    expect(parse("I")).toBe(1);
    expect(parse("II")).toBe(2);
    expect(parse("III")).toBe(3);
    expect(parse("IV")).toBe(4);
    expect(parse("V")).toBe(5);
    expect(parse("VI")).toBe(6);
    expect(parse("VII")).toBe(7);
    expect(parse("VIII")).toBe(8);
    expect(parse("IX")).toBe(9);
    expect(parse("X")).toBe(10);
  });

  test("some more roman numbers", () => {
    expect(parse("XX")).toBe(20);
    expect(parse("XXX")).toBe(30);
    expect(parse("XL")).toBe(40);
    expect(parse("XLIV")).toBe(44);
    expect(parse("XLIX")).toBe(49);
    expect(parse("L")).toBe(50);
    expect(parse("LIV")).toBe(54);
    expect(parse("LIX")).toBe(59);
    expect(parse("C")).toBe(100);
    expect(parse("CDXCIX")).toBe(499);
    expect(parse("D")).toBe(500);
    expect(parse("M")).toBe(1000);
    expect(parse("MMMCMXCIX")).toBe(3999);
  });

  test("reject an invalid roman number", () => {
    expect(() => parse("")).toThrow(Error);
    expect(() => parse("XO")).toThrow(Error);
    expect(() => parse("VIV")).toThrow(Error);
    expect(() => parse("IXI")).toThrow(Error);
    expect(() => parse("VIIII")).toThrow(Error);
    expect(() => parse("XIXI")).toThrow(Error);
    expect(() => parse("IC")).toThrow(Error);
    expect(() => parse("VVI")).toThrow(Error);
    expect(() => parse("LL")).toThrow(Error);
  });
});
