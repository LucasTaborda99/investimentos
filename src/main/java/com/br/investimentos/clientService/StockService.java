package com.br.investimentos.clientService;

import com.br.investimentos.client.BrapiClient;
import com.br.investimentos.client.clientDto.StockApiResponse;
import com.br.investimentos.client.clientDto.StockResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final BrapiClient brapiClient;

    public StockService(BrapiClient brapiClient) {
        this.brapiClient = brapiClient;
    }

    public StockResponseDto getStockData(String ticker) {
        StockApiResponse response = brapiClient.getStock(ticker);
        return response.results().stream().findFirst().orElse(null);
    }
}
