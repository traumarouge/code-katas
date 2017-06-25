"use strict";

const chai = require("chai");
const sinon = require("sinon");
const sinonChai = require("sinon-chai");
const Lightbar = require("../js/lightbar.js");

const expect = chai.expect;
chai.use(sinonChai);

describe("lightbar", () => {
  it("incrementing light bar changes its state", () => {
    const sut = new Lightbar(2);
    expect(sut.lights()).to.eql([false, false]);

    sut.increment();
    expect(sut.lights()).to.eql([true, false]);

    sut.increment();
    expect(sut.lights()).to.eql([true, true]);

    sut.increment();
    expect(sut.lights()).to.eql([false, false]);
  });

  it("light bar overflow increments next light bar", () => {
    const spy = sinon.spy();
    const sut = new Lightbar(4);
    sut.next = { increment: spy };

    for (let i = 0; i < 4; i++) {
      sut.increment();
    }

    expect(spy).to.not.have.been.called;

    sut.increment();
    expect(spy).to.have.been.calledOnce;
  });
});
