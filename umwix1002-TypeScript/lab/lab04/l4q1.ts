import {createConsoleInput} from "../utils/console-input";

async function l4q1Main() {
    const consoleInput = createConsoleInput();

    const integer = await consoleInput.promptInteger("Enter an Integer: ");
    logFactors(getFactorsV1(integer));
    logFactors(getFactorsV2(integer));
    logFactors(getFactorsV3(integer));
}

function getFactorsV1(integer: number): number[] {
    const factors: number[] = []
    for (let i = 1; i <= integer; i++) {
        if (integer % i === 0) {
            factors.push(i);
        }
    }
    return factors;
}

function getFactorsV2(integer: number) {
    const smallerFactors: number[] = []
    const largerFactors: number[] = []

    const limit = Math.floor(Math.sqrt(integer))

    for (let i = 1; i <= limit; i++) {
        if (integer % i !== 0) {
            continue;
        }
        smallerFactors.push(i);

        const pair = integer / i;
        if (pair !== i) {
            largerFactors.push(i);
        }
    }
    return [...smallerFactors, ...largerFactors.reverse()];
}

function getFactorsV3(integer: number): number[] {
    const factors: number[] = []

    const limit = Math.floor(Math.sqrt(integer))

    for (let i = 1; i <= limit; i++) {
        if (integer % i === 0) {
            factors.push(i);
        }
    }

    const size = factors.length
    for (let i = size - 1; i >= 0; i--) {
        const pair = integer /  factors[i];

        if (pair !== i) {
            factors.push(pair);
        }
    }

    return factors;
}

function logFactors(factors: readonly number[]) {
    console.log(`The factors are: ${factors}`);
}

l4q1Main().catch((err) => {
    console.error(err);
    process.exit(1);
})