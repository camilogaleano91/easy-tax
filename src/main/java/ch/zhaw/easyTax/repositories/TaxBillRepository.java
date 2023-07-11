package ch.zhaw.easyTax.repositories;

import ch.zhaw.easyTax.entities.TaxBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxBillRepository extends JpaRepository<TaxBill, Long> {

}
