package br.estacio.campos.estacao.oae.dto.enums;

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private Integer day;

    private DayOfWeek(Integer day) {
        this.day = day;
    }

    public Integer getDay(){
        return day;
    }

    public static DayOfWeek valueOf(int day)
    {
        for (DayOfWeek value : DayOfWeek.values()) {
            if(value.getDay() == day) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid DayOfWeek day");
    }
}
