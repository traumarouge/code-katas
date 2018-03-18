"use strict";

import { Lightbar } from "../js/lightbar.js";

describe("lightbar", () => {
  test("incrementing light bar changes its state", () => {
    const sut = new Lightbar(2);
    expect(sut.lights()).toEqual([false, false]);

    sut.increment();
    expect(sut.lights()).toEqual([true, false]);

    sut.increment();
    expect(sut.lights()).toEqual([true, true]);

    sut.increment();
    expect(sut.lights()).toEqual([false, false]);
  });

  test("light bar overflow increments next light bar", () => {
    const spy = jest.fn();
    const sut = new Lightbar(4);
    sut.next = { increment: spy };

    for (let i = 0; i < 4; i++) {
      sut.increment();
    }

    expect(spy).not.toHaveBeenCalled();

    sut.increment();
    expect(spy).toHaveBeenCalled();
  });
});
