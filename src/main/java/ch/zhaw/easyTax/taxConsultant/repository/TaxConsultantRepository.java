package ch.zhaw.easyTax.taxConsultant.repository;

import ch.zhaw.easyTax.taxConsultant.model.TaxConsultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxConsultantRepository extends JpaRepository<TaxConsultant, Long> {

}
