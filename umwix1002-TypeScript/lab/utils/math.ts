function calculateSum(values: number[]): number {
    if (!values || values.length == 0) {
        return 0;
    }
    return values.reduce((total: number, currentValue: number): number => total + currentValue, 0);
}