"use strict";

const expect = require("chai").expect;
const BerlinClock = require("../js/berlinclock.js");

describe("berlinclock", () => {
  it("lights shown before any ticks represent 00:00", () => {
    const sut = new BerlinClock();
    expect(sut.toString()).to.be.equal("-----------------------");
  });

  it("lights shown after 50000 ticks represent 13:53", () => {
    const sut = new BerlinClock();
    sut.triggerTicks(50000);
    expect(sut.toString()).to.be.equal("HH--hhh-MMMMMMMMMM-mmm-");
  });

  it("clock can be initialized using constructor args", () => {
    const sut = new BerlinClock(13, 53);
    expect(sut.toString()).to.be.equal("HH--hhh-MMMMMMMMMM-mmm-");
  });
});
