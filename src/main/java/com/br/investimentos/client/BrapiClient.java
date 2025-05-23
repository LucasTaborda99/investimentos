package com.br.investimentos.client;

import com.br.investimentos.client.clientDto.StockApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brapiClient", url = "https://brapi.dev/api")
public interface BrapiClient {

    @GetMapping("/quote/{ticker}")
    StockApiResponse getStock(@PathVariable("ticker") String ticker);

}
