const random = Math.random();

const min = 1;
const max = 50;
const range = max - min + 1;

// Approach 1: Use three separate constants
const value1 = Math.floor(Math.random() * range + min);
const value2 = Math.floor(Math.random() * range + min);
const value3 = Math.floor(Math.random() * range + min);
const sum1 = value1 + value2 + value3;
const average1 = sum1 / 3;

console.log(`[${value1},${value2},${value3}]`);
console.log(`Sum: ${sum1}`);
console.log(`Average: ${average1.toFixed(2)}`);

// Approach 2: Use iteration with arrays
const arr2 = [];
for (let i = 0; i < 3; i++) {
    arr2.push(Math.floor(Math.random() * range + min));
}
const sum2 = arr2.reduce((a, b) => a + b);
const average2 = sum2 / arr2.length;
console.log(arr2);
console.log(`Sum: ${sum2}`);
console.log(`Average: ${average2.toFixed(2)}`);

// Approach 3: Use iteration with arrays and function method
const randomFn = () => Math.floor(Math.random() * range + min);

const arr3 = Array.from({length: 3}, (_, index) => randomFn())
const sum3 = arr3.reduce((a, b) => a + b);
const average3 = sum3 / arr3.length;
console.log(arr3);
console.log(`Sum: ${sum3}`);
console.log(`Average: ${average3.toFixed(2)}`);

