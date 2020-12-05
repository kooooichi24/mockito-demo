package com.tutorialspoint.mockitodemo;

/**
 * 四則演算の実装クラス。
 */
public interface CalculatorService {

    /**
     * 2つの値を加算するメソッド。
     *
     * @param input1 値1
     * @param input2 値2
     * @return 値1と値2を加算した値
     */
    public double add(double input1, double input2);

    /**
     * 2つの値を減算するメソッド。
     *
     * @param input1 値1
     * @param input2 値2
     * @return 値1から値2を減算した値
     */
    public double subtract(double input1, double input2);

    /**
     * 2つの値を乗算するメソッド。
     *
     * @param input1 値1
     * @param input2 値2
     * @return 値1と値2を乗算した値
     */
    public double multiply(double input1, double input2);

    /**
     * 2つの値を除算するメソッド。
     *
     * @param input1 値1
     * @param input2 値2
     * @return 値1から値2を除算した値
     */
    public double divide(double input1, double input2);

}
