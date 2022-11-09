package br.jvprojetos17.payrollapi.service;

import br.jvprojetos17.payrollapi.domain.Payrool;
import br.jvprojetos17.payrollapi.exception.ResourceNotFoundException;
import br.jvprojetos17.payrollapi.feignClients.UserFeign;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign userFeign;

    public Payrool getPayment(Long userId, Payrool payrool) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port"));

        try {
            var user = userFeign.findById(userId).getBody();
            if (Objects.nonNull(user)) {
                return new Payrool(
                        user.getName(),
                        payrool.getDescription(),
                        payrool.getHourlyPrice(),
                        payrool.getWorkedHours(),
                        payrool.getWorkedHours() * user.getHourlyPrice()
                );
            }
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Resource not fount!");
        } catch (Exception e) {
            throw new IllegalArgumentException("Argumentos inválidos!");
        }

        return null;

    }

}
