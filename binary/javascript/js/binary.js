export function toBinary(number) {
    if (!Number.isInteger(number) || number < 0)
        throw new Error("argument must be positive int");

    if (number === 0) return "0";

    let binary = "";

    while (number > 0) {
        binary = (number % 2) + binary;
        number = Math.floor(number / 2);
    }

    return binary;
}


export function expandToBytes(binary) {
    if (!binary || [...binary].some(b => !isBit(b)))
        throw new Error("argument must be valid binary");

    const zeros = "0".repeat((8 - binary.length % 8) % 8);

    return zeros + binary;
}

export function onesComplement(binary) {
    if (!binary || [...binary].some(b => !isBit(b))
        || !isByteAligned(binary)) {
        throw new Error("argument must be byte aligned");
    }

    let oc = "";

    for (const b of binary) {
        oc += (b === "0" ? "1" : "0");
    }

    return oc;
}

export function twosComplement(binary) {
    const oc = onesComplement(binary);
    const tcReversed = [];

    [...oc].reverse().reduce((carry, b) => {
        if (carry === "1") {
            if (b === "1") {
                tcReversed.push("0");
                return "1";
            } else {
                tcReversed.push("1");
                return "0";
            }
        } else {
            tcReversed.push(b);
            return "0";
        }
    }, "1");

    return tcReversed.reverse().join("");
}

const isBit = symbol => symbol === "0" || symbol === "1";
const isByteAligned = binary => binary.length % 8 === 0;