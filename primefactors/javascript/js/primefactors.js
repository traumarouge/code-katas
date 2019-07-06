"use strict";

export function factors(number) {
    const factors = [];
    let n = number;

    for (let i = 2; i <= number; i++) {
        while (n % i === 0) {
            factors.push(i);
            n /= i;
        }

        if (n === 1) return factors;
    }

    return factors;
}