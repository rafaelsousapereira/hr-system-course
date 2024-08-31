package br.com.rafael.payrollapi.services;

import br.com.rafael.payrollapi.domain.Payroll;
import br.com.rafael.payrollapi.feignClient.UserFeign;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class PayrollService {

    private final UserFeign feign;
    private final Environment env;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on {}", env.getProperty("local.server.port") + " port");
        try {
            var user = feign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                    user.getName(),
                    payroll.getDescription(),
                    payroll.getHourlyPrice(),
                    user.getHourlyPrice(),
                    user.getHourlyPrice() * payroll.getWorkedHours()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception", ex);
        }

        return null;
    }
}
