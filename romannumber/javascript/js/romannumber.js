"use strict";

import { RomanSymbol } from "./romansymbol.js";

export function format(number) {
  if (!Number.isInteger(number) || number < 1 || number > 3999) {
    throw new Error();
  }

  const romanNumbers = [];
  number
    .toString()
    .split("")
    .reverse()
    .forEach((digit, index) => {
      romanNumbers.push(romanNumber(digit, index));
    });

  return romanNumbers.reverse().join("");
}

function romanNumber(decimalDigit, index) {
  let digit = Number(decimalDigit);
  let less5 = true;

  if (digit >= 5 && digit <= 9) {
    digit -= 5;
    less5 = false;
  }

  const romanSymbol = RomanSymbol.symbols()[index * 2];
  let str = "-";

  if (!less5) {
    str = RomanSymbol.rightShift(romanSymbol).toString();
  }

  for (let i = 0; i < digit; i++) {
    str += romanSymbol;
  }

  const replacementSymbol = less5
    ? RomanSymbol.rightShift(romanSymbol)
    : RomanSymbol.rightShift(romanSymbol, 2);

  str = collapse(str, replacementSymbol);

  return str.replace(/-/g, "");
}

function collapse(romanNumber, replacementSymbol) {
  return romanNumber.length <= 4
    ? romanNumber
    : romanNumber.substring(4) + replacementSymbol;
}

export function parse(romanNumber) {
  var romanSymbols = [];
  romanNumber.split("").forEach(it => {
    romanSymbols.push(RomanSymbol[it]);
  });

  let number = decimalNumber(romanSymbols);
  if (format(number) !== romanNumber) {
    throw new Error();
  }

  return number;
}

function decimalNumber(romanSymbols) {
  const numbers = [];
  let lastRomanSymbol = null;
  let sum = 0;

  romanSymbols.reverse().forEach(it => {
    if (lastRomanSymbol && it.number < lastRomanSymbol.number) {
      sum -= it.number;
      numbers.push(sum);
      sum = 0;
    } else {
      sum += it.number;
    }

    lastRomanSymbol = it;
  });

  numbers.push(sum);

  return numbers.reduce((a, b) => a + b, 0);
}
