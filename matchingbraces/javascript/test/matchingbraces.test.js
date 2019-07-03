import { BracesMatcher } from "../js/matchingbraces.js";

describe("matching braces", () => {
    const sut = new BracesMatcher();

    test("input matches", () => {
        expect(sut.matches("")).toBeTruthy();
        expect(sut.matches("{}")).toBeTruthy();
        expect(sut.matches("{}{}")).toBeTruthy();
        expect(sut.matches("{{}}")).toBeTruthy();
        expect(sut.matches("{}[]")).toBeTruthy();
        expect(sut.matches("{[]}()")).toBeTruthy();
        expect(sut.matches("([]{})")).toBeTruthy();
        expect(sut.matches("[([]{})]()")).toBeTruthy();
        expect(sut.matches("([{}({}[])])")).toBeTruthy();
    });

    test("input does not match", () => {
        expect(sut.matches("{")).toBeFalsy();
        expect(sut.matches("}")).toBeFalsy();
        expect(sut.matches("}{")).toBeFalsy();
        expect(sut.matches("{{")).toBeFalsy();
        expect(sut.matches("([]{)}")).toBeFalsy();
        expect(sut.matches("[([]{)}]()")).toBeFalsy();
        expect(sut.matches("([{}({}[])})")).toBeFalsy();
    });
});