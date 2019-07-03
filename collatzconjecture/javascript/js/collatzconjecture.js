export function calculateSteps(number) {
    if (!Number.isInteger(number) || number <= 0) {
        throw new Error("Invalid argument")
    }

    let n = number;
    let steps = 0;

    while (n != 1) {
        n = n % 2 === 0 ? n / 2 : n * 3 + 1;
        steps++;
    }

    return steps;
}