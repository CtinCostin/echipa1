package ro.sda.echipa1.service;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.Date;

@Builder
@Getter
@Setter
public class CalculationParameters {
    private int numberOfDays;
    private double price4Adult;
    private double price4Kid;
    private int numberOfAdults;
    private int numberOfKids;
    private Date departureDate;

}
