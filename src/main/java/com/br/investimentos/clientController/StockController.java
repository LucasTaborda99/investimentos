package com.br.investimentos.clientController;

import com.br.investimentos.client.clientDto.StockResponseDto;
import com.br.investimentos.clientService.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Operation(summary = "Get stock data", description = "Returns stock price and market changes")
    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "404", description = "Stock not found")
    @GetMapping("/{ticker}")
    public StockResponseDto getStock(@PathVariable String ticker) {
        return stockService.getStockData(ticker);
    }

}
