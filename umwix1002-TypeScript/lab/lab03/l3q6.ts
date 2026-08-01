import {createConsoleInput} from "../utils/console-input";

type CoordinatePoint = [x: number, y: number]

async function l3q6Main() {
    const consoleInput = createConsoleInput();

    const radius = await consoleInput.promptInteger("Enter the radius of the circle: ");
    const x = await consoleInput.promptInteger("Enter the coordinate point (x): ");
    const y = await consoleInput.promptInteger("Enter the coordinate point (y): ");

    const center: CoordinatePoint = [0, 0]
    const distance = Math.hypot(x - center[0], y - center[1]);
    const position =
        distance === radius
            ? "on"
            : distance > radius
                ? "outside"
                : "inside";

    console.log(`The point is ${position} the circle centered at (${center[0]}, ${center[1]})`);
}

l3q6Main().catch(console.error);