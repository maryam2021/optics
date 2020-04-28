package optics.com.service.customerservice.customerconfig;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import optics.com.domain.register.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerContext {

    @Autowired
    private CustomerCache customerCache;



    public Optional<Register> getCurrentEmployee(boolean refreshCache) {
        try {
            return customerCache.getEmployee((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(), refreshCache);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
