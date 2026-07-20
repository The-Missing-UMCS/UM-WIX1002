const min = 0;
const max = 10000;
const range = max - min + 1;

const randomNumber = Math.floor(Math.random() * range) + min;

let sumOfDigits = 0;
for(let i = randomNumber; i > 0; i = Math.floor(i / 10)) {
    sumOfDigits += i % 10;
}
console.log(`Value: ${randomNumber}, Sum of Digit: ${sumOfDigits.toFixed(0)}`);