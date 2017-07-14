const expect = require("chai").expect;
const leapyear = require("../js/leapyear");

describe("leap year", () => {
  it("divisible by 400 or divisible by 4, but not 100", () => {
    // divisible by 400
    expect(leapyear.isLeap(2000)).to.be.true;
    expect(leapyear.isLeap(1600)).to.be.true;

    // divisible by 100 but not by 400
    expect(leapyear.isLeap(1900)).to.be.false;
    expect(leapyear.isLeap(1800)).to.be.false;

    // divisible by 4
    expect(leapyear.isLeap(2012)).to.be.true;
    expect(leapyear.isLeap(2016)).to.be.true;

    // not divisible by 4
    expect(leapyear.isLeap(2014)).to.be.false;
    expect(leapyear.isLeap(2015)).to.be.false;
  });
});
