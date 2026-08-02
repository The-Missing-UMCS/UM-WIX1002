import {createConsoleInput} from "../utils/console-input";

function sumOfTriangularNumber(n: number): number {
    if (n <= 0) {
        return 0;
    }
    let total = 0;
    for(let i = 0; i <= n; i++) {
        total += triangularNumber(i);
    }
    return total;
}

function triangularNumber(index: number): number {
    if(index <= 0) {
        return 0;
    }
    let total = 0;
    for(let i = 1; i <= index; i++) {
        total += i;
    }
    return total;
}

async function l4q2Main(): Promise<void> {
    const consoleInput = createConsoleInput();

    const n  = await consoleInput.promptInteger("Enter an integer n: ")
    const result: number = sumOfTriangularNumber(n);
    console.log(`The sum of Triangular Number for ${n} is ${result}`);
}

l4q2Main().catch(error => {
    console.error(error)
    process.exit(1);
})

