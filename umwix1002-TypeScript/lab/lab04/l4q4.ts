import {withConsoleInput} from "../utils/console-input";


async function l4q4(): Promise<void> {
    // DEFINE CONSTANTS
    const DAYS_PER_WEEK = 7;
    const CELL_WIDTH = 5;

    const WEEKDAY_HEADERS = [
        "SUN",
        "MON",
        "TUE",
        "WED",
        "THU",
        "FRI",
        "SAT",
    ] as const;

    const COMMON_YEAR_MONTH_LENGTHS: (28 | 29 | 30 | 31)[] = [
        31, // January
        28, // February,
        31, // March
        30, // April
        31, // May
        30, // June
        31, // July
        31, // August
        30, // September
        31, // October
        30, // November
        31 // December
    ] as const;

    enum Month {
        May = 4,
        August = 7
    }

    function parseInteger(input: string, minimum: number, maximum: number = Number.MAX_SAFE_INTEGER): number | null {
        const trimmedInput = input.trim();

        if (!/^\d+$/.test(trimmedInput)) {
            return null;
        }

        const value = Number(trimmedInput);

        return Number.isSafeInteger(value) && value >= minimum && value <= maximum
            ? value : null;
    }

    function isLeapYear(year: number): boolean {
        return year % 400 === 0 || (year % 4 === 0 && year % 100 !== 0);
    }


    function getMonthLengths(year: number): number[] {
        const monthLengths = [...COMMON_YEAR_MONTH_LENGTHS];
        if (isLeapYear(year)) {
            monthLengths[1] = 29;
        }
        return monthLengths;
    }

    function getFirstWeekdayOfMonth(
        firstWeekdayOfYear: number,
        month: Month,
        monthLengths: readonly number[]
    ): number {
        const daysBeforeMonth = monthLengths
            .slice(0, month)
            .reduce((total, days) => total + days, 0);

        return (firstWeekdayOfYear + daysBeforeMonth) % DAYS_PER_WEEK;
    }

    function formatCalendar(
        numberOfDays: number,
        firstWeekday: number,
    ): string {
        const header = WEEKDAY_HEADERS
            .map((weekday) => weekday.padEnd(CELL_WIDTH))
            .join("")
            .trimEnd();

        const cells = [
            ...Array<string>(firstWeekday).fill(""),
            ...Array.from(
                {length: numberOfDays},
                (_, index) => String(index + 1)
            ),
        ];

        const weeks: string[] = [];

        for (let index = 0; index < cells.length; index += DAYS_PER_WEEK) {
            const week = cells
                .slice(index, index + DAYS_PER_WEEK)
                .map((day) => day.padStart(3).padEnd(CELL_WIDTH))
                .join("")
                .trimEnd();
            weeks.push(week);
        }

        return [header, ...weeks].join("\n")
    }

    async function main() {
        await withConsoleInput(async consoleInput => {
            const year = await consoleInput.prompt(
                "Enter the year: ",
                (input: string) => parseInteger(input, 0),
                "Please enter a valid year."
            )

            const firstWeekdayOfYear = await consoleInput.prompt(
                "Enter the first day of the year " +
                "(0 for Sunday, 1 for Monday, ..., 6 for Saturday): ",
                (input: string) => parseInteger(input, 0, 6),
                "Please enter a number from 0 to 6.",
            );

            const monthLengths = getMonthLengths(year);

            const monthsToPrint = [Month.May, Month.August] as const;

            const calendars = monthsToPrint.map((month: Month) => {
                const firstWeekday = getFirstWeekdayOfMonth(
                    firstWeekdayOfYear,
                    month,
                    monthLengths
                );
                return formatCalendar(monthLengths[month], firstWeekday);
            });

            console.log(calendars.join("\n\n"));
        })
    }

    await main()
}

l4q4()
    .then(() => process.exit(0))
    .catch((err) => {
        console.error(err);
        process.exit(1);
    })
