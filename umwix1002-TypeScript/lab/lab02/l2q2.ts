function l2q2Main() {
    const p = 500_000;
    const d = 100_000;
    const r = 8;
    const y = 5;

    const m = (p - d) * (1 + r * y / 100) / (y * 12);
    console.log(m)
}

l2q2Main();
