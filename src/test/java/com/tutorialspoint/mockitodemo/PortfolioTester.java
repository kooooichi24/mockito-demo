package com.tutorialspoint.mockitodemo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Portfolioクラスをテストするためのクラス。
 */
class PortfolioTester {
    Portfolio portfolio;
    StockService stockService;

    public static void main(String[] args) {
        PortfolioTester tester = new PortfolioTester();
        tester.setup();
        System.out.println(tester.testMarketValue() ? "pass" : "fail");
    }

    /**
     * Portfolioクラスをテストするための初期化処理。
     */
    public void setup() {
        // Create a portfolio object which is to be tested
        portfolio = new Portfolio();

        // Create the mock object of stock service
        stockService = mock(StockService.class);

        // set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }

    /**
     * ポートフォリオの合計金額が一致するかテストするクラス。
     *
     * @return true: 一致, false: 不一致
     */
    public boolean testMarketValue() {
        // Creates a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "google", 10);
        Stock microsoftStock = new Stock("2", "microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        // add stocks to the portfolio
        portfolio.setStocks(stocks);

        // mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue == 100500.0;
    }
}