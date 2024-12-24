package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {

    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        // Не совсем понял почему треугольник со стороной 1 является некорректным, сторона же 1?
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double semiPerimeter = (a + b + c) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[]{};
        }
        double triangleArea = getAreaByHeron(a, b, c);
        double[] heights = {2 * triangleArea / a, 2 * triangleArea / b, 2 * triangleArea / c};
        Arrays.sort(heights);
        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[]{};
        }
        double[] medians = {Math.sqrt(2 * (b * b + c * c) - a * a) / 2,
                Math.sqrt(2 * (a * a + c * c) - b * b) / 2,
                Math.sqrt(2 * (b * b + a * a) - c * c) / 2
        };
        Arrays.sort(medians);
        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[]{};
        }
        double semiPerimeter = (a + b + c) / 2;
        double[] bisectors = {2 * Math.sqrt(a * b * semiPerimeter * (semiPerimeter - c)) / (a + b),
                2 * Math.sqrt(a * c * semiPerimeter * (semiPerimeter - b)) / (a + c),
                2 * Math.sqrt(c * b * semiPerimeter * (semiPerimeter - a)) / (c + b)
        };
        Arrays.sort(bisectors);
        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[]{};
        }
        double[] angles = {Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c))),
                Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c))),
                Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b))),
        };
        Arrays.sort(angles);
        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double triangleArea = getAreaByHeron(a, b, c);
        double semiPerimeter = (a + b + c) / 2;
        return triangleArea / semiPerimeter;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double triangleArea = getAreaByHeron(a, b, c);
        return a * b * c / (4 * triangleArea);
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double sinA = Math.sqrt(1 - Math.pow(cosA, 2));
        return b * c * sinA / 2;
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }
}
