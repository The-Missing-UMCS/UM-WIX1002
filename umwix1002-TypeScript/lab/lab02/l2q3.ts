import { createRandom, Random } from "../utils/random";

interface Statistics {
    values: number[],
    sum: number,
    average: number
}

function l2q3Main() {
    const random = createRandom();
    const min = 1;
    const max = 50;

    _approach1(random, min, max);
    _approach2(random, min, max);
    _approach3(random, min, max);
    _approach4(random, min, max);
}

function _approach1(random: Random, min: number, max: number) {
    const value1 = random.nextInteger(min, max + 1);
    const value2 = random.nextInteger(min, max + 1);
    const value3 = random.nextInteger(min, max + 1);

    const sum = value1 + value2 + value3;
    const average = sum / 3;

    _logStatistics({
        values: [value1, value2, value3],
        sum,
        average
    } satisfies Statistics);
}

function _approach2(random: Random, min: number, max: number) {
    const values = [
        random.nextInteger(min, max + 1),
        random.nextInteger(min, max + 1),
        random.nextInteger(min, max + 1)
    ];

    const statistics: Statistics = {
        values,
        sum: values[0] + values[1] + values[2],
        average: (values[0] + values[1] + values[2]) / 3
    };

    _logStatistics(statistics);
}

function _approach3(random: Random, min: number, max: number) {
    const values: number[] = [];

    for (let i = 0; i < 3; i++) {
        values.push(random.nextInteger(min, max + 1));
    }

    const sum = values.reduce((a, b) => a + b);
    const average = sum / values.length;

    _logStatistics({ values, sum, average });
}

function _approach4(random: Random, min: number, max: number) {
    const randomFn = () => random.nextInteger(min, max + 1);

    const values = Array.from({ length: 3 }, () => randomFn());
    const sum = values.reduce((a, b) => a + b);
    const average = sum / values.length;

    _logStatistics({ values, sum, average });
}

function _logStatistics(statistics: Statistics) {
    console.log(`${statistics.values}`);
    console.log(`Sum: ${statistics.sum}`);
    console.log(`Average: ${statistics.average.toFixed(2)}`);
}

l2q3Main();