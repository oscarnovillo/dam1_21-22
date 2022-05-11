package modelo.error;

import lombok.Data;

@Data
public class ErrorONo<T,R> {

    public final T data;

    public final R error;

}
