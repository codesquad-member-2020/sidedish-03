package kr.codesquad.sidedish.common.error;

public enum ErrorCode {
    // Common
    ENTITY_NOT_FOUND(404, "COM001", " Entity Not Found"),
    INVALID_TYPE_VALUE(400, "COM002", "Wrong Type"),
    INVALID_INPUT_VALUE(400, "COM003", "Wrong InputValue"),
    METHOD_NOT_ALLOWED(405, "COM004", "Change Http Method"),
    INTERNAL_SERVER_ERROR(500, "COM005", "백엔드 개발자라 죄송합니다..."),
    // User
    USER_NOT_FOUND(404, "U001", " 해당 사용자가 존재하지 않습니다."),
    LOGIN_REQUIRED(401, "U002", " 로그인을 해주세요."),
    // Dish
    DISH_NOT_FOUND(404, "D001", " 해당 반찬은 존재하지 않아요!"),
    // FoodType
    FOOD_TYPE_NOT_FOUND(404, "FT001", "해당 음식종류는 존재하지 않아요!"),
    // Category
    CATEGORY_NOT_FOUND(404, "C001", "해당 베스트 반찬 목록은 존재하지 않아요!"),
    // Money
    WRONG_MONEY_DATA(500, "M001", "잘못된 가격 정보가 DB에 존재합니다."),
    ;

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
