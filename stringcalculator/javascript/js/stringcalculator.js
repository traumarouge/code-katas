"use strict";

exports.add = function(str) {
  let delimiter = ",";
  let lines = str.split("\n");
  if (/^\/\/./.test(lines[0])) {
    delimiter = lines.shift()[2];
  }

  let numbers = lines.join(delimiter).split(delimiter);
  let negatives = numbers.filter(it => Number(it) < 0);
  if (negatives.length) {
    throw new Error(negatives);
  }

  return numbers.map(it => Number(it)).reduce((a, b) => a + b, 0);
};
