package br.com.studyHub.handler;

import br.com.studyHub.dto.ExceptionDto;
import br.com.studyHub.dto.SimpleMessageExceptionDto;
import br.com.studyHub.exception.BadRequestException;
import br.com.studyHub.exception.NotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionHandlerController {
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> exceptionFormatArgsInvalidErrors(MethodArgumentNotValidException e) {
        List<ExceptionDto> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ExceptionDto errorDto = new ExceptionDto(message, err.getField());
            dto.add(errorDto);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<SimpleMessageExceptionDto> exceptionFormatBadRequestErrors(BadRequestException e) {
        String message = e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleMessageExceptionDto(message));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SimpleMessageExceptionDto> exceptionFormatNotFoundErrors(NotFoundException e) {
        String message = e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new SimpleMessageExceptionDto(message));
    }


}
