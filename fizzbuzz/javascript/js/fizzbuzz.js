exports.say = function(number) {
  check(number);

  if (number % 15 === 0) {
    return "fizzbuzz";
  } else if (number % 3 === 0) {
    return "fizz";
  } else if (number % 5 === 0) {
    return "buzz";
  }

  return number.toString();
};

function check(number) {
  if (!Number.isInteger(number)) {
    throw new TypeError();
  }

  if (number < 1) {
    throw new RangeError();
  }
}
