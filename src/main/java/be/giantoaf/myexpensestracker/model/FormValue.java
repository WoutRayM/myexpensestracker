package be.giantoaf.myexpensestracker.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FormValue {

    private String formValueOne;
    private String formValueTwo;

}
