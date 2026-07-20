import {createInterface} from "readline/promises";
import {stdin as input, stdout as output} from "process";

const qFn = (weight: number, initialTemp: number, finalTemp: number) =>
    weight * (finalTemp - initialTemp) * 4184;
const gToKgFn = (gram: number) => gram / 1000;
const fToCFn = (f: number) => (f - 32) / 1.8;

const readLine = createInterface({input, output});

async function main() {
    const mG = await readLine.question("Enter the amount of water in gram: ");
    const f1 = await readLine.question("Enter the initial temperature in Fahrenheit: ");
    const f2 = await readLine.question("Enter the final temperature in Fahrenheit: ");
    const q = qFn(gToKgFn(Number(mG)), fToCFn(Number(f1)), fToCFn(Number(f2)));
    console.log(`The energy needed is ${q.toExponential(6)}`);
}

main().then();