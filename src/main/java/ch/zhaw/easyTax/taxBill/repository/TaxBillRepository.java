package ch.zhaw.easyTax.taxBill.repository;

import ch.zhaw.easyTax.taxBill.model.TaxBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxBillRepository extends JpaRepository<TaxBill, Long> {

}
