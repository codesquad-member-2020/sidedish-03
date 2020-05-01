package kr.codesquad.sidedish.common.error.exception;

import kr.codesquad.sidedish.common.error.ErrorCode;

public class WrongMoneyDataException extends BusinessException {
    public WrongMoneyDataException() {
        super(ErrorCode.WRONG_MONEY_DATA);
    }

    public WrongMoneyDataException(String message) {
        super(message, ErrorCode.WRONG_MONEY_DATA);
    }
}
