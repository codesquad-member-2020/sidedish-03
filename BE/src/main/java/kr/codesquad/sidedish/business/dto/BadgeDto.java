package kr.codesquad.sidedish.business.dto;

public class BadgeDto {
    private final String name;
    private final String color;

    public BadgeDto(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "BadgeDto{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }
}
