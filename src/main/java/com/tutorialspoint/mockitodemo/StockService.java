package com.tutorialspoint.mockitodemo;

/**
 * 銘柄の実装クラス。
 */
public interface StockService {

    /**
     * 銘柄の価格を取得する関数。
     *
     * @param stock 銘柄のインスタンス
     * @return 価格
     */
    public double getPrice(Stock stock);
}
