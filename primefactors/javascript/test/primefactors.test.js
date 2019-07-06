"use strict";

import { factors } from "../js/primefactors.js";

describe("prime factors", () => {
    test("factorize", () => {
        expect(factors(1)).toEqual([]);
        expect(factors(2)).toEqual([2]);
        expect(factors(9)).toEqual([3, 3]);
        expect(factors(12)).toEqual([2, 2, 3]);
        expect(factors(901255)).toEqual([5, 17, 23, 461]);
    });
});