package com.br.investimentos.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
}
