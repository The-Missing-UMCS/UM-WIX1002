interface Closable {
    close(): void | Promise<void>;
}

export async function using<T extends Closable, R>(
    resource: T,
    callback: (resource: T) => R | Promise<R>,
) {
    try {
        return await callback(resource);
    } finally {
        await resource.close();
    }
}