package ro.sda.echipa1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Event {

    private String title;
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

}
