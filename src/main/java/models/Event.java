package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString

public class Event {
    String title;
    String type;
    int breaks;
    int wage;

}
