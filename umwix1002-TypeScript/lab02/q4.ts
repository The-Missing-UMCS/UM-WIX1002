import {createInterface} from "readline/promises";
import {stdin as input, stdout as output} from "process";

const readLine = createInterface({input, output});

async function main() {
    const secondsToRead = await readLine.question("Enter the number of seconds: ");
    const totalSeconds = Number(secondsToRead);

    const seconds = Math.floor(totalSeconds % 60);
    const hours = Math.floor(totalSeconds / 3600);
    // Convert seconds -> minutes, then modulus it.
    const minutes = Math.floor((totalSeconds / 60) % 60);

    console.log(`${secondsToRead} seconds is ${hours} hours, ${minutes} minutes and ${seconds} seconds`);
}

main().then()
