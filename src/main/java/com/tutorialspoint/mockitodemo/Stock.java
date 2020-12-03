package com.tutorialspoint.mockitodemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 銘柄に関するクラス
 */
@AllArgsConstructor
@Data
public class Stock {
    private String stockId;
    private String name;
    private int quantity;
}

