export function isArmstrongNumber(number) {
    const digits = Array.from(number.toString()).map(Number);

    const sum = digits
        .map(n => Math.pow(n, digits.length))
        .reduce((a, b) => a + b, 0);

    return sum === number;
}