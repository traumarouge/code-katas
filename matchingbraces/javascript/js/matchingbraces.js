export class BracesMatcher {

    constructor() {
        this.opening = ["{", "[", "("];
        this.closing = ["}", "]", ")"];
        this.pairs = ["{}", "[]", "()"];
    }

    matches(input) {
        const stack = [];

        const match = c => {
            const e = stack.pop();
            if (e === undefined) return false;

            return this.pairs.includes(e + c)
        }

        for (const c of input) {
            if (this.opening.includes(c)) {
                stack.push(c);
            } else if (this.closing.includes(c)) {
                if (!match(c)) return false;
            }
        }

        return stack.length === 0;
    }
}