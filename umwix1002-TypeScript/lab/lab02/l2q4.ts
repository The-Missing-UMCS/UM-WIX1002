import {withConsoleInput} from "../utils/console-input";

async function l2q4Main() {
    await withConsoleInput(async consoleInput => {
        const totalSeconds = await consoleInput.promptInteger("Enter the number of seconds: ");

        const hours = Math.floor(totalSeconds / 3600);
        const minutes = Math.floor((totalSeconds / 60) % 60);
        const seconds = Math.floor(totalSeconds % 60);

        console.log(`${totalSeconds} seconds is ${hours} hours, ${minutes} minutes and ${seconds} seconds`);
    })
}

l2q4Main().catch((error) => {
    console.error(error);
    process.exit(1);
});
