package br.jvprojetos17.payrollapi.rest;

import br.jvprojetos17.payrollapi.domain.Payroll;
import br.jvprojetos17.payrollapi.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayroolRest {

    @Autowired
    private PayrollService payrollService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long userId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(payrollService.getPayment(userId, payment));
    }
}
