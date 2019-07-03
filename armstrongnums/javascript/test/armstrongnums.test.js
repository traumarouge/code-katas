import { isArmstrongNumber } from "../js/armstrongnums.js";

describe("is armstrong number", () => {
    const numbers = [5, 153, 9474, 9926315];

    test(numbers.toString(), () => {
        numbers.forEach(number => {
            expect(isArmstrongNumber(number)).toBeTruthy();
        });
    });
});

describe("is not armstrong number", () => {
    const numbers = [10, 100, 9475, 9926314];

    test(numbers.toString(), () => {
        numbers.forEach(number => {
            expect(isArmstrongNumber(number)).toBeFalsy();
        });
    });
});