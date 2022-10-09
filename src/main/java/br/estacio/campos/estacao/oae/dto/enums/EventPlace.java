package br.estacio.campos.estacao.oae.dto.enums;

public enum EventPlace {
    NOT_DEFINED(0),
    PRESENTIAL(1),
    ONLINE(2);

    private int place;

    private EventPlace(int place) {
        this.place = place;
    }

    public int getPlace(){
        return place;
    }

    public static EventPlace valueOf(int place)
    {
        for (EventPlace value : EventPlace.values()) {
            if(value.getPlace() == place) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid EventPlace place");
    }
}
