package octopus.advice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import octopus.advice.ErrorCode;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    private final ErrorCode errorCode;
}
