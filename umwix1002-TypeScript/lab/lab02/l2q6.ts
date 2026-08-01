import {withConsoleInput} from "../utils/console-input";

async function l2q5Main() {
    const qFn = (weight: number, initialTemp: number, finalTemp: number) =>
        weight * (finalTemp - initialTemp) * 4184;
    const gToKgFn = (gram: number) => gram / 1000;
    const fToCFn = (f: number) => (f - 32) / 1.8;

    await withConsoleInput(async consoleInput => {
        const mG = await consoleInput.promptInteger("Enter the amount of water in gram: ");
        const f1 = await consoleInput.promptInteger("Enter the initial temperature in Fahrenheit: ");
        const f2 = await consoleInput.promptInteger("Enter the final temperature in Fahrenheit: ");
        const q = qFn(gToKgFn(Number(mG)), fToCFn(Number(f1)), fToCFn(Number(f2)));
        console.log(`The energy needed is ${q.toExponential(6)}`);
    })
}

l2q5Main().catch(error => {
    console.error(error);
    process.exit(1);
});
