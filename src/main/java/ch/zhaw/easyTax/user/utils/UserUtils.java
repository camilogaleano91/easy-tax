package ch.zhaw.easyTax.user.utils;

import ch.zhaw.easyTax.taxConsultant.model.Popularity;
import ch.zhaw.easyTax.taxConsultant.model.TaxConsultant;
import ch.zhaw.easyTax.taxConsultant.service.TaxConsultantService;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    private final TaxConsultantService taxConsultantService;

    public UserUtils(TaxConsultantService taxConsultantService) {
        this.taxConsultantService = taxConsultantService;
    }

    public void setPopularity(TaxConsultant taxConsultant) {
        int likesSum = taxConsultant.getCustomerLikesCount();

        if (likesSum <= Popularity.LOW.getLevelOfPop()) {
            taxConsultant.setPopularity(Popularity.LOW);
        }
        if (likesSum > Popularity.LOW.getLevelOfPop() && likesSum <= Popularity.MEDIUM.getLevelOfPop()) {
            taxConsultant.setPopularity(Popularity.MEDIUM);
        }
        else {
            taxConsultant.setPopularity(Popularity.HIGH);
        }
        taxConsultantService.saveUser(taxConsultant);
    }
}
