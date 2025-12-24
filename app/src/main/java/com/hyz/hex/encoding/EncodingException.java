package com.hyz.hex.encoding;

import java.io.IOException;

public class EncodingException extends IOException {
    public EncodingException(Throwable cause) {
        super(cause);
    }

    public EncodingException(String message) {
        super(message);
    }
}
