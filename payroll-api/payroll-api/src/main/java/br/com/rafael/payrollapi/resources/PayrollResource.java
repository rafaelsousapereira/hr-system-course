package br.com.rafael.payrollapi.resources;

import br.com.rafael.payrollapi.domain.Payroll;
import br.com.rafael.payrollapi.domain.User;
import br.com.rafael.payrollapi.feignClient.UserFeign;
import br.com.rafael.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    private final PayrollService service;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayments(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(service.getPayment(workerId, payment));
    }
}
