package com.tutorialspoint.mockitodemo;

import java.util.List;
import lombok.Data;


/**
 * ポートフォリオを表現するクラス。
 */
@Data
public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    /**
     * ポートフォリオの合計金額を返す関数。
     *
     * @return marketValue ポートフォリオの合計金額は、銘柄*株数 の総和
     */
    public double getMarketValue() {
        double marketValue = 0;

        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
