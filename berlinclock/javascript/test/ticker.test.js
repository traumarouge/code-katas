"use strict";

import { Ticker } from "../js/ticker.js";

describe("ticker", () => {
  it("increments light bar after 60 ticks", () => {
    const spy = jest.fn();
    const sut = new Ticker(60);
    sut.lightbar = { increment: spy };

    for (let i = 0; i < 59; i++) {
      sut.tick();
    }

    expect(spy).not.toHaveBeenCalled();

    sut.tick();
    expect(spy).toHaveBeenCalled();
  });
});
