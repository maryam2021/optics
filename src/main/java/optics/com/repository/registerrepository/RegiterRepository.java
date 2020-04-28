package optics.com.repository.registerrepository;

import optics.com.domain.register.Register;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegiterRepository extends CrudRepository<Register, String> {

    @Transactional
    @Modifying
    @Query("delete from confirmation_token c where c.confirmationToken = ?1")
    void deleteConfirmationToken(@Param("tokenId") String tokenId);


    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
