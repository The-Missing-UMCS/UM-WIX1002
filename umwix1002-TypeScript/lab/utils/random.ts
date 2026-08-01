export interface Random {
    nextNumber(origin?: number, bound?: number): number;
    nextInteger(origin?: number, bound?: number): number;
}

export function createRandom(): Random {
    return {
        nextNumber(origin?: number, bound?: number): number {
            const min = origin ?? Number.MIN_SAFE_INTEGER;
            const max = bound ?? Number.MAX_SAFE_INTEGER;

            if (min >= max) {
                throw new RangeError("origin must be less than bound.");
            }

            return Math.random() * (max - min) + min;
        },

        nextInteger(origin?: number, bound?: number): number {
            return Math.floor(this.nextNumber(origin, bound))
        }
    };
}