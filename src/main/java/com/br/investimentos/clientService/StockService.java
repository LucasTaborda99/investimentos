package com.br.investimentos.clientService;

import com.br.investimentos.client.BrapiClient;
import com.br.investimentos.client.clientDto.StockAnalysisResponseDto;
import com.br.investimentos.client.clientDto.StockApiResponse;
import com.br.investimentos.client.clientDto.StockResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    private final BrapiClient brapiClient;

    @Value("${openrouter.api.key}")
    private String openRouterApiKey;

    public StockService(BrapiClient brapiClient) {
        this.brapiClient = brapiClient;
    }

    public StockResponseDto getStockData(String ticker) {
        StockApiResponse response = brapiClient.getStock(ticker);
        return response.results().stream().findFirst().orElse(null);
    }

    public StockAnalysisResponseDto getStockAnalysis(String ticker) {
        StockResponseDto stock = getStockData(ticker);

        if (stock == null) return null;

        String prompt = buildPrompt(stock);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openRouterApiKey);

        String model = "mistralai/mistral-7b-instruct";

        String body = String.format("""
        {
          "model": "%s",
          "messages": [
            { "role": "user", "content": "%s" }
          ]
        }
        """, model, prompt.replace("\"", "\\\""));

        HttpEntity<String> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://openrouter.ai/api/v1/chat/completions", request, String.class
        );

        String analysis = extractTextFromResponse(response.getBody());

        return new StockAnalysisResponseDto(
                stock.symbol(),
                stock.regularMarketPrice(),
                stock.regularMarketChangePercent(),
                analysis
        );
    }

    private String buildPrompt(StockResponseDto stock) {
        return String.format("""
        The stock %s is currently priced at R$ %.2f, with a daily change of %.2f%%.
        Provide a short analysis indicating whether it is a good moment to buy, sell, or hold.
        Also, classify the investment risk as Low, Medium, or High, all of this in Portuguese, and at the end say that it is not a recommendation.
        """, stock.symbol(), stock.regularMarketPrice(), stock.regularMarketChangePercent());
    }

    private String extractTextFromResponse(String responseBody) {
        try {
            int index = responseBody.indexOf("\"content\":\"") + 11;
            int end = responseBody.indexOf("\"", index);
            return responseBody.substring(index, end).replace("\\n", "\n");
        } catch (Exception e) {
            return "Error processing AI response.";
        }
    }
}
