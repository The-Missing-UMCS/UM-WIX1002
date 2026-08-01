import {withConsoleInput} from "../utils/console-input";

type Operation = (left: number, right: number) => number;

// https://chatgpt.com/c/6a67e4a9-ffec-83ec-8623-f4768c29918b
const operations = {
    "+": (left: number, right: number) => left + right,
    "-": (left: number, right: number) => left - right,
    "*": (left: number, right: number) => left * right,
    "/": (left: number, right: number) => left / right,
} satisfies Record<string, Operation>

type Operator = keyof typeof operations;
type Operands = readonly [left: number, right: number];

function parseOperands(value: string): Operands | null {
    const tokens = value.trim().split(/\s+/);
    if (tokens.length !== 2) {
        return null;
    }
    if (!tokens.every(token => /^[+-]?\d+$/.test(token))) {
        return null;
    }
    const operands = tokens.map(Number);
    if (!operands.every(Number.isSafeInteger)) {
        return null;
    }
    return [operands[0], operands[1]];
}

function parseOperator(value: string): Operator | null {
    const operator = value.trim();
    return Object.hasOwn(operations, operator)
        ? operator as Operator
        : null;
}

async function l3q1Main(): Promise<void> {
    await withConsoleInput(async consoleInput => {
        const [left, right]: Operands = await consoleInput.prompt<Operands>(
            "Enter two integer number: ",
            parseOperands,
            "Please enter exactly two valid integers. "
        );

        const operator: Operator = await consoleInput.prompt<Operator>(
            "Enter an operator (+, -, *, /): ",
            parseOperator,
            "Please enter one of these operators: +, -, *, /."
        );

        if (operator === "/" && right === 0) {
            console.log("Division by zero is not allowed.");
            return;
        }

        const result = operations[operator](left, right);
        console.log(`${left} ${operator} ${right} = ${result}`);
    })
}

l3q1Main().catch(error => {
    console.error(error);
    process.exitCode = 1;
});

