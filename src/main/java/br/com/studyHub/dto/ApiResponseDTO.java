package br.com.studyHub.dto;

public record ApiResponseDTO<T>(
        String message,
        T data
) {
}
