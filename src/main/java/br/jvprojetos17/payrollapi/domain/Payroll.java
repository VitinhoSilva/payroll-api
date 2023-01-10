package br.jvprojetos17.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payroll {

    private String userName;
    private String description;
    private Double workedHours;
    private Double totalPayment;

}
