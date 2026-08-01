import {createInterface} from "readline/promises";
import {stdin, stdout} from "process";
import {using} from "./closable";

export type Parser<T> = (input: string) => T | null;

export interface ConsoleInput {
    prompt<T>(
        message: string,
        parser: Parser<T>,
        errorMessage: string,
    ): Promise<T>;

    promptInteger(
        message: string,
        errorMessage?: string,
    ): Promise<number>;

    close(): void;
}

export async function withConsoleInput<R>(
    callback: (consoleInput: ConsoleInput) => void,
) {
    const consoleInput = createConsoleInput();
    await using(consoleInput, callback);
}

export function createConsoleInput(): ConsoleInput {
    const readLine = createInterface({input: stdin, output: stdout});

    async function prompt<T>(
        message: string,
        parser: Parser<T>,
        errorMessage: string,
    ): Promise<T> {
        while (true) {
            const answer = await readLine.question(message);
            const result = parser(answer);

            if (result !== null) {
                return result;
            }

            console.log(errorMessage);
        }
    }

    function promptInteger(
        message: string,
        errorMessage = "Please enter a valid integer.",
    ): Promise<number> {
        return prompt(
            message,
            parseInteger,
            errorMessage,
        );
    }

    return {
        prompt,
        promptInteger,
        close: () => readLine.close(),
    };
}

function parseInteger(input: string): number | null {
    const value = input.trim();

    if (!/^[+-]?\d+$/.test(value)) {
        return null;
    }

    const parsed = Number(value);

    return Number.isSafeInteger(parsed)
        ? parsed
        : null;
}