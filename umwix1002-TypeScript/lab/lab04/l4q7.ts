import {withConsoleInput} from "../utils/console-input";

async function l4q7(): Promise<void> {

    const CELL_WIDTHS: readonly number[] = [
        12,
        20,
        20,
        20,
        20,
        22,
    ];

    const HEADERS: readonly string[] = [
        "Payment No.",
        "Payment Amount",
        "Principal Paid",
        "Interest Paid",
        "Remaining Balance",
        "Cumulative Interest",
    ];

    interface AmortizationScheduleEntry {
        paymentNumber: number;
        paymentAmount: number;
        principalPaid: number;
        interestPaid: number;
        remainingBalance: number;
        cumulativeInterestPaid: number;
    }

    function formatAmount(value: number, width: number): string {
        return value
            .toFixed(2)
            .padStart(width);
    }

    async function main(): Promise<void> {
        await withConsoleInput(async consoleInput => {
            const loanPrincipal = await consoleInput.promptInteger(
                "Enter loan principal: "
            );

            const annualInterestRatePercent =
                await consoleInput.promptInteger(
                    "Enter annual interest rate (%): "
                );

            const loanTermMonths = await consoleInput.promptInteger(
                "Enter loan term in months: "
            );

            if (loanPrincipal <= 0) {
                throw new Error(
                    "Loan principal must be greater than 0."
                );
            }

            if (annualInterestRatePercent < 0) {
                throw new Error(
                    "Annual interest rate cannot be negative."
                );
            }

            if (loanTermMonths <= 0) {
                throw new Error(
                    "Loan term must be greater than 0 months."
                );
            }

            const monthlyInterestRate =
                annualInterestRatePercent / 12 / 100;

            const regularPaymentAmount =
                monthlyInterestRate === 0
                    ? loanPrincipal / loanTermMonths
                    : (
                        loanPrincipal * monthlyInterestRate
                        / (
                            1 - Math.pow(
                                1 + monthlyInterestRate,
                                -loanTermMonths
                            )
                        )
                    );

            let remainingBalance = loanPrincipal;
            let cumulativeInterestPaid = 0;

            const amortizationSchedule:
                AmortizationScheduleEntry[] = [];

            for (
                let paymentNumber = 1;
                paymentNumber <= loanTermMonths;
                paymentNumber++
            ) {
                const interestPaid =
                    remainingBalance * monthlyInterestRate;

                const principalPaid =
                    paymentNumber === loanTermMonths
                        ? remainingBalance
                        : regularPaymentAmount - interestPaid;

                const paymentAmount =
                    principalPaid + interestPaid;

                remainingBalance = Math.max(
                    0,
                    remainingBalance - principalPaid
                );

                cumulativeInterestPaid += interestPaid;

                amortizationSchedule.push({
                    paymentNumber,
                    paymentAmount,
                    principalPaid,
                    interestPaid,
                    remainingBalance,
                    cumulativeInterestPaid,
                });
            }

            const headerRow = HEADERS
                .map((header, index) =>
                    header.padStart(CELL_WIDTHS[index])
                )
                .join("");

            const tableWidth = CELL_WIDTHS.reduce(
                (total, width) => total + width,
                0
            );

            console.log(headerRow);
            console.log("-".repeat(tableWidth));

            for (const scheduleEntry of amortizationSchedule) {
                const row = [
                    String(scheduleEntry.paymentNumber)
                        .padStart(CELL_WIDTHS[0]),

                    formatAmount(
                        scheduleEntry.paymentAmount,
                        CELL_WIDTHS[1]
                    ),

                    formatAmount(
                        scheduleEntry.principalPaid,
                        CELL_WIDTHS[2]
                    ),

                    formatAmount(
                        scheduleEntry.interestPaid,
                        CELL_WIDTHS[3]
                    ),

                    formatAmount(
                        scheduleEntry.remainingBalance,
                        CELL_WIDTHS[4]
                    ),

                    formatAmount(
                        scheduleEntry.cumulativeInterestPaid,
                        CELL_WIDTHS[5]
                    ),
                ].join("");

                console.log(row);
            }
        });
    }

    await main();
}

l4q7()
    .then(() => process.exit(0))
    .catch((error: unknown) => {
        console.error(
            error instanceof Error
                ? error.message
                : error
        );

        process.exit(1);
    });