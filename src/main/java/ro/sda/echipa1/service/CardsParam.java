package ro.sda.echipa1.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.sda.echipa1.entities.Hotel;
@Builder
@Getter
@Setter
public class CardsParam {

    private Hotel hotel;
}

