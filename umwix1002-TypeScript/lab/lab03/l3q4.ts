function l3q4Main() {
    const [p1, p2] = [rollDice(), rollDice()];
    console.log(`p1's score is ${p1}`);
    console.log(`p2's score is ${p2}`);
    const winner = p1 === p2
        ? "NIL"
        : p1 > p2
            ? "p1"
            : "p2";

    console.log(`The winner is ${winner}`);
}

function rollDice() {
    const min = 1;
    const max = 6;
    const range = max - min + 1;
    return Math.floor(Math.random() * range) + min;
}

l3q4Main();
