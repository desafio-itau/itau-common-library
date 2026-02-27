package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;

public class ServicoIndisponivelException extends BaseException {
    public ServicoIndisponivelException(Constants errorConstant) {
        super(errorConstant);
    }
    
    public ServicoIndisponivelException(Constants errorConstant, Throwable cause) {
        super(errorConstant, cause);
    }
}
