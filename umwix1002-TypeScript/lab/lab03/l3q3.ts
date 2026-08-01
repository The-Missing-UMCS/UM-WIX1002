import {createConsoleInput} from "../utils/console-input";

type CommissionTier = Readonly<{
    maximumSales: number;
    rate: number
}>

const commissionTiers = [
    {maximumSales: 100, rate: 0.05},
    {maximumSales: 500, rate: 0.075},
    {maximumSales: 1_000, rate: 0.1},
    {maximumSales: Number.POSITIVE_INFINITY, rate: 0.125},
] as const satisfies readonly CommissionTier[]

type CommissionRate = (typeof commissionTiers)[number]["rate"];

function getCommissionRate(sales: number): CommissionRate {
    const tier = commissionTiers.find(
        ({maximumSales}) => sales <= maximumSales,
    );
    if (!tier) {
        throw new Error(`No commission rate found for sales: ${sales}`);
    }
    return tier.rate;
}

async function l3q3Main() {
    const consoleInput = createConsoleInput();
    const sales = await consoleInput.promptInteger("Enter sales: ")
    const commission = sales * getCommissionRate(sales);
    console.log(`Commission ${commission.toFixed(2)}`);
}

l3q3Main().catch((err) => {
    console.error(err);
    process.exit(1);
})
