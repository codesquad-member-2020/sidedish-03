package kr.codesquad.sidedish.common.error.exception;

import kr.codesquad.sidedish.common.error.ErrorCode;

public class CategoryNotFoundException extends EntityNotFoundException {

    public CategoryNotFoundException() {
        super(ErrorCode.CATEGORY_NOT_FOUND);
    }

    public CategoryNotFoundException(String message) {
        super(message, ErrorCode.CATEGORY_NOT_FOUND);
    }

}
