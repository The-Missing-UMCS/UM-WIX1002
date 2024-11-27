package com.umwix1002.solution.lab.lab9.l9q1.shape;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ShapeBuilders {
    public static Rectangle rectangle(double width, double height) {
        return (Rectangle) proxy(new Rectangle(width, height));
    }

    public static Square square(double side) {
        return (Square) proxy(new Square(side));
    }

    public static Circle circle(double radius) {
        return (Circle) proxy(new Circle(radius));
    }

    private static Shape proxy(Shape shape) {
        return (Shape) Proxy.newProxyInstance(
                shape.getClass().getClassLoader(),
                shape.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    String[] ignoredMethods = {"setArea", "setPerimeter"};
                    boolean isSetter = method.getName().startsWith("set");
                    boolean isIgnored = Arrays.asList(ignoredMethods).contains(method.getName());

                    Object result = method.invoke(shape, args);

                    if (isSetter && !isIgnored) {
                        MethodHandle computeHandle = MethodHandles.lookup()
                                .findVirtual(shape.getClass(), "compute", MethodType.methodType(void.class));
                        computeHandle.invoke(shape);
                    }

                    return result;
                }
        );
    }
}
