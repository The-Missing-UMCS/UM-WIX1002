import {createConsoleInput} from "../utils/console-input";

async function l3q5Main() {
    const consoleInput = createConsoleInput();

    const variables = ["a", "b", "c", "d", "e", "f"] as const;
    const values: number[] = [];

    for (const name of variables) {
        values.push(await consoleInput.promptInteger(`Enter ${name}: `));
    }

    const [a, b, c, d, e, f] = values;

    const determinant = a * d - b * c;
    if (determinant === 0) {
        console.log(`The equation has no solution.`);
        return;
    }
    const x = (e * d - b * f) / determinant;
    const y = (a * f - e * c) / determinant;
    console.log(`x=${x} y=${y}`);
}

l3q5Main().catch((err) => {
    console.error(err);
    process.exit(1);
})
