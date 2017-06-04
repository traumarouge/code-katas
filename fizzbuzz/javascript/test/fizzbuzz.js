const expect = require("chai").expect;
const fizzbuzz = require("../js/fizzbuzz");

describe("say numbers", () => {
  it("1 up to 10", () => {
    expect(fizzbuzz.say(1)).to.equal("1");
    expect(fizzbuzz.say(2)).to.equal("2");
    expect(fizzbuzz.say(3)).to.equal("fizz");

    expect(fizzbuzz.say(4)).to.equal("4");
    expect(fizzbuzz.say(5)).to.equal("buzz");
    expect(fizzbuzz.say(6)).to.equal("fizz");

    expect(fizzbuzz.say(7)).to.equal("7");
    expect(fizzbuzz.say(8)).to.equal("8");
    expect(fizzbuzz.say(9)).to.equal("fizz");

    expect(fizzbuzz.say(10)).to.equal("buzz");
  });
});

describe("fizz numbers from 1 up to 50", () => {
  const numbers = [3, 6, 9, 12, 18, 21, 24, 27, 33, 36, 39, 42, 48];

  it(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz.say(number)).to.equal("fizz");
    });
  });
});

describe("buzz numbers from 1 up to 50", () => {
  const numbers = [5, 10, 20, 25, 35, 40, 50];

  it(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz.say(number)).to.equal("buzz");
    });
  });
});

describe("fizzbuzz numbers from 1 up to 50", () => {
  const numbers = [15, 30, 45];

  it(numbers.toString(), () => {
    numbers.forEach(number => {
      expect(fizzbuzz.say(number)).to.equal("fizzbuzz");
    });
  });
});

describe("given number must not be less than 1", () => {
  it("throws RangeError", () => {
    expect(() => fizzbuzz.say(0)).to.throw(RangeError);
  });
});

describe("given number must be integer", () => {
  it("throws TypeError", () => {
    expect(() => fizzbuzz.say(1.5)).to.throw(TypeError);
    expect(() => fizzbuzz.say("2")).to.throw(TypeError);
  });
});
