package kr.codesquad.sidedish.common.error.exception;

import kr.codesquad.sidedish.common.error.ErrorCode;

public class DishNotFoundException extends EntityNotFoundException {

    public DishNotFoundException() {
        super(ErrorCode.DISH_NOT_FOUND);
    }

    public DishNotFoundException(String message) {
        super(message, ErrorCode.DISH_NOT_FOUND);
    }

}
