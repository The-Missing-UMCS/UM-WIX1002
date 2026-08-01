function l3q2Main() {
    const intToWord = ["zero", "one", "two", "three", "four", "five"];

    const randNum = Math.floor(Math.random() * intToWord.length);

    console.log(`${randNum} is ${intToWord[randNum]}`);
}

