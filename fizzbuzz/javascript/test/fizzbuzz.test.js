import { fizzbuzz } from "../js/fizzbuzz.js";

describe("say numbers", () => {
  test("1 up to 10", () => {
    expect(fizzbuzz(1)).toBe("1");
    expect(fizzbuzz(2)).toBe("2");
    expect(fizzbuzz(3)).toBe("fizz");

    expect(fizzbuzz(4)).toBe("4");
    expect(fizzbuzz(5)).toBe("buzz");
    expect(fizzbuzz(6)).toBe("fizz");

    expect(fizzbuzz(7)).toBe("7");
    expect(fizzbuzz(8)).toBe("8");
    expect(fizzbuzz(9)).toBe("fizz");

    expect(fizzbuzz(10)).toBe("buzz");
  });
});

describe("fizz numbers from 1 up to 50", () => {
  const numbers = [3, 6, 9, 12, 18, 21, 24, 27, 33, 36, 39, 42, 48];

  test(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz(number)).toBe("fizz");
    });
  });
});

describe("buzz numbers from 1 up to 50", () => {
  const numbers = [5, 10, 20, 25, 35, 40, 50];

  test(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz(number)).toBe("buzz");
    });
  });
});

describe("fizzbuzz numbers from 1 up to 50", () => {
  const numbers = [15, 30, 45];

  test(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz(number)).toBe("fizzbuzz");
    });
  });
});

describe("given number must not be less than 1", () => {
  test("throws RangeError", () => {
    expect(() => fizzbuzz(0)).toThrow(RangeError);
  });
});

describe("given number must be integer", () => {
  test("throws TypeError", () => {
    expect(() => fizzbuzz(1.5)).toThrow(TypeError);
    expect(() => fizzbuzz("2")).toThrow(TypeError);
  });
});
