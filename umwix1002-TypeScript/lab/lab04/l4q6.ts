import {createRandom, Random} from "../utils/random";

async function l4q6(): Promise<void> {

    function splitDigitsV1(value: number): string {
        const digits: number[] = [];
        let remainingValue = value;

        while (remainingValue > 0) {
            const lastDigit = remainingValue % 10;

            digits.push(lastDigit);
            remainingValue = Math.floor(remainingValue / 10);
        }

        return digits.reverse().join(",");
    }

    function splitDigitsV2(value: number): string {
        return String(value)
            .split("")
            .join(",")
    }

    async function main(): Promise<void> {
        const random: Random = createRandom();

        const randomValue: number = random.nextInteger(0);

        console.log(`Random Value: ${randomValue}, Digits: ${splitDigitsV1(randomValue)}`);
        console.log(`Random Value: ${randomValue}, Digits: ${splitDigitsV2(randomValue)}`);
    }

    await main();
}

l4q6()
    .then(() => process.exit(0))
    .catch((error: unknown) => {
        console.error(error);
        process.exit(1);
    });