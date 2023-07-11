package ch.zhaw.easyTax.repositories;

import ch.zhaw.easyTax.entities.TaxConsultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxConsultantRepository extends JpaRepository<TaxConsultant, Long> {

}
