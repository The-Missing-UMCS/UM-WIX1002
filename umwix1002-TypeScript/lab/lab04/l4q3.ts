import {createConsoleInput} from "../utils/console-input";

async function l4q3Main(): Promise<void> {
    const consoleInput = createConsoleInput();

    const scores: number[] = [];

    while (true) {
        const score = await consoleInput.promptInteger("Enter a score [negative score to quit]: ");
        if (score < 0) {
            break;
        }
        scores.push(score);
    }

    if (scores.length === 0) {
        console.log("No scores entered.");
        return;
    }

    let sum: number = 0;
    let sumOfSquares: number = 0;
    let min: number = Infinity;
    let max: number = -Infinity;

    for (const score of scores) {
        sum += score;
        sumOfSquares += score * score;
        min = Math.min(min, score);
        max = Math.max(max, score);
    }

    const average: number = sum / scores.length;
    const variance: number = (sumOfSquares - sum * sum / scores.length) / (scores.length - 1);
    const standardDeviation: number = Math.sqrt(variance);

    console.log(`Sum: ${sum}`);
    console.log(`Min: ${min}`);
    console.log(`Max: ${max}`);
    console.log(`Average: ${average}`);
    console.log(`Standard Deviation: ${standardDeviation}`);
}

l4q3Main()
    .then(() => process.exit(0))
    .catch((error: unknown) => {
        console.error(error);
        process.exit(1);
    })