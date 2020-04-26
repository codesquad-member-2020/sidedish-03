package kr.codesquad.sidedish.business.wrapper;

import kr.codesquad.sidedish.common.error.exception.WrongMoneyDataException;

import java.text.NumberFormat;

public final class Money {
    private final long money; // 외국 통화를 지원하지 않아서 long 사용

    private Money(Long value) {
        validateValue(value);
        this.money = value;
    }

    // 정적 팩토리 메소드 사용[Effective Java Item. 1]
    public static Money valueOf(Long value) {
        return new Money(value);
    }

    public String format() {
        return NumberFormat.getNumberInstance().format(money);
    }

    private void validateValue(Long money) {
        if (money == null || money < 0) { // null 데이터를 검증하기 위함
            throw new WrongMoneyDataException();
        }
    }
}
