"use strict";

const expect = require("chai").expect;
const calculator = require("../js/stringcalculator");

describe("string calculator", () => {
  it("handles empty string", () => {
    expect(calculator.add("")).to.equal(0);
  });

  it("handles string containing one number", () => {
    expect(calculator.add("0")).to.equal(0);
    expect(calculator.add("1")).to.equal(1);
  });

  it("handles string containing two numbers", () => {
    expect(calculator.add("1,1")).to.equal(2);
    expect(calculator.add("2,3")).to.equal(5);
  });

  it("handles string containing five numbers", () => {
    expect(calculator.add("1,1,1,1,1")).to.equal(5);
    expect(calculator.add("1,2,3,4,5")).to.equal(15);
  });

  it("handles newline char between numbers", () => {
    expect(calculator.add("\n23")).to.equal(23);
    expect(calculator.add("1\n2,3")).to.equal(6);
    expect(calculator.add("1\n2\n3")).to.equal(6);
  });

  it("supports configurable number delimiter", () => {
    expect(calculator.add("//;\n1")).to.equal(1);
    expect(calculator.add("//;\n1;2")).to.equal(3);
    expect(calculator.add("//;\n1\n2")).to.equal(3);
    expect(calculator.add("//;\n1\n2;3")).to.equal(6);
  });

  it("rejects and reports negative numbers", () => {
    expect(() => calculator.add("-1")).to.throw(Error, "-1");
    expect(() => calculator.add("-1,-2")).to.throw(Error, "-1,-2");
    expect(() => calculator.add("-1,2,-3,4")).to.throw(Error, "-1,-3");
  });
});
