"use strict";

const chai = require("chai");
const sinon = require("sinon");
const sinonChai = require("sinon-chai");
const Ticker = require("../js/ticker.js");

const expect = chai.expect;
chai.use(sinonChai);

describe("ticker", () => {
  it("increments light bar after 60 ticks", () => {
    const spy = sinon.spy();
    const sut = new Ticker(60);
    sut.lightbar = { increment: spy };

    for (let i = 0; i < 59; i++) {
      sut.tick();
    }

    expect(spy).to.not.have.been.called;

    sut.tick();
    expect(spy).to.have.been.calledOnce;
  });
});
