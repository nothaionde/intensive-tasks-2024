package com.walking.intensive.chapter1.task4;

import java.util.Arrays;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {

    private static final int PRECISION = 1;

    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 0;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0) {
            return solveLinearEquation(b, c);
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            return solveWithTwoRoots(a, b, discriminant);
        } else if (discriminant == 0) {
            return solveWithOneRoot(a, b);
        } else {
            return "Количество решений: 0.";
        }
    }

    private static String solveLinearEquation(double b, double c) {
        if (b == 0) {
            return (c == 0) ? "Бесконечное множество решений." : "Количество решений: 0.";
        }
        double root = normalizeRoot(-c / b);
        return String.format("Количество решений: 1. Корень: %s", formatWithPrecision(root));
    }

    private static String solveWithTwoRoots(double a, double b, double discriminant) {
        double rootOne = normalizeRoot((-b - Math.sqrt(discriminant)) / (2 * a));
        double rootTwo = normalizeRoot((-b + Math.sqrt(discriminant)) / (2 * a));
        double[] roots = {rootOne, rootTwo};
        Arrays.sort(roots);
        return String.format("Количество решений: 2. Корни: %s;%s",
                formatWithPrecision(roots[0]), formatWithPrecision(roots[1]));
    }

    private static String solveWithOneRoot(double a, double b) {
        double root = normalizeRoot(-b / (2 * a));
        return String.format("Количество решений: 1. Корень: %s", formatWithPrecision(root));
    }

    private static double normalizeRoot(double root) {
        return root == -0.0 ? 0.0 : root;
    }

    private static String formatWithPrecision(double value) {
        return String.format("%." + PRECISION + "f", value);
    }
}