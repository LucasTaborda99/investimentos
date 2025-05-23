package com.br.investimentos.client.clientDto;

import java.util.List;

public record StockResponseDto(String symbol, double regularMarketPrice, double regularMarketChangePercent) {}
