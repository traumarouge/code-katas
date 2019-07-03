import { calculateSteps } from "../js/collatzconjecture.js";

describe("collatz conjecture", () => {
    test("calculate steps", () => {
        expect(calculateSteps(1)).toBe(0);
        expect(calculateSteps(2)).toBe(1);
        expect(calculateSteps(16)).toBe(4);
        expect(calculateSteps(12)).toBe(9);
        expect(calculateSteps(1000000)).toBe(152);
    });

    test("number must be positive", () => {
        expect(() => calculateSteps(0)).toThrow(Error);
        expect(() => calculateSteps(-1)).toThrow(Error);
    });
});