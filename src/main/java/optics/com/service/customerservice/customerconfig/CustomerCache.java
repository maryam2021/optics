package optics.com.service.customerservice.customerconfig;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import optics.com.domain.register.Register;
import optics.com.service.customerservice.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class CustomerCache {
    private final LoadingCache<String, Optional<Register>> employeeLoadingCache;
    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerCache() {
        employeeLoadingCache = CacheBuilder.newBuilder().expireAfterWrite(24L, TimeUnit.HOURS).build(employeeCacheLoader());
    }


    public Optional<Register> getEmployee(UserDetails userDetails, boolean refreshCache) throws Exception {
        Optional<Register> user;
        try {
            if (refreshCache) {
                employeeLoadingCache.refresh(userDetails.getUsername());
            }
            user = employeeLoadingCache.get(userDetails.getUsername());
        } catch (ExecutionException e) {
            throw new RuntimeException("Registerd User not found");
        }
        return user;
    }


    private CacheLoader<String, Optional<Register>> employeeCacheLoader() {
        return new CacheLoader<String, Optional<Register>>() {
            @Override
            public Optional<Register> load(String username) throws Exception {
                return customerService.findByEmail(username);
            }
        };
    }
}
