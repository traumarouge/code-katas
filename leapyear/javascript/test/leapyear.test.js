import { leapyear } from "../js/leapyear.js";

test("leap year is divisible by 400 or divisible by 4, but not 100", () => {
  // divisible by 400
  expect(leapyear(2000)).toBe(true);
  expect(leapyear(1600)).toBe(true);

  // divisible by 100 but not by 400
  expect(leapyear(1900)).toBe(false);
  expect(leapyear(1800)).toBe(false);

  // divisible by 4
  expect(leapyear(2012)).toBe(true);
  expect(leapyear(2016)).toBe(true);

  // not divisible by 4
  expect(leapyear(2014)).toBe(false);
  expect(leapyear(2015)).toBe(false);
});
