"use strict";

import { BerlinClock } from "../js/berlinclock.js";

describe("berlinclock", () => {
  test("lights shown before any ticks represent 00:00", () => {
    const sut = new BerlinClock();
    expect(sut.toString()).toBe("-----------------------");
  });

  test("lights shown after 50000 ticks represent 13:53", () => {
    const sut = new BerlinClock();
    sut.triggerTicks(50000);
    expect(sut.toString()).toBe("HH--hhh-MMMMMMMMMM-mmm-");
  });

  test("clock can be initialized using constructor args", () => {
    const sut = new BerlinClock(13, 53);
    expect(sut.toString()).toBe("HH--hhh-MMMMMMMMMM-mmm-");
  });
});
