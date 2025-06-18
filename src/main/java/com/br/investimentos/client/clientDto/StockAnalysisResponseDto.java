package com.br.investimentos.client.clientDto;

public record StockAnalysisResponseDto(
        String symbol,
        double price,
        double changePercent,
        String analysis
    ){}
