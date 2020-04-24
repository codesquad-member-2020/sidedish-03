package kr.codesquad.sidedish.common.error.exception;

import kr.codesquad.sidedish.common.error.ErrorCode;

public class FoodTypeNotFoundException extends EntityNotFoundException {

    public FoodTypeNotFoundException() {
        super(ErrorCode.FOOD_TYPE_NOT_FOUND);
    }

    public FoodTypeNotFoundException(String message) {
        super(message, ErrorCode.FOOD_TYPE_NOT_FOUND);
    }
}
