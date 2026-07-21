package br.com.studyHub.dto;

public record ApiResponse<T>(
        String message,
        T data
) {
}
