import {createRandom} from "../utils/random";

async function l4q5(): Promise<void> {

    const random = createRandom();

    function rollDice() {
        return random.nextInteger(1, 6 + 1);
    }

    async function main(): Promise<void> {
        let isP1Turn: boolean = Math.random() > 0.5;
        let p1: number = 0, p2: number = 0;
        while (Math.max(p1, p2) < 100) {
            const diceValue = rollDice();
            if (isP1Turn) {
                p1 += diceValue;
            } else {
                p2 += diceValue;
            }
            console.log(`${isP1Turn ? "P1" : "P2"} rolled ${diceValue}. Current value: ${isP1Turn ? p1 : p2}`);
            // Player with diceValue=6 can roll dice again
            if (diceValue !== 6) {
                isP1Turn = !isP1Turn;
            }
        }
        console.log(`${p1 > p2 ? "P1" : "P2"} win.`)
    }

    await main();
}

l4q5()
    .then(() => process.exit(0))
    .catch(error => {
        console.error(error);
        process.exit(1);
    })