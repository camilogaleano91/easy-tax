package ch.zhaw.easyTax.customer.service;
import ch.zhaw.easyTax.customer.model.Customer;
import ch.zhaw.easyTax.taxConsultant.model.TaxConsultant;
import ch.zhaw.easyTax.customer.dto.ConsultantCustomerDTO;
import ch.zhaw.easyTax.customer.repository.CustomerRepository;
import ch.zhaw.easyTax.user.service.BaseUserService;
import ch.zhaw.easyTax.taxConsultant.service.TaxConsultantService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CustomerService implements BaseUserService<Customer> {

    private final CustomerRepository customerRepository;
    private final TaxConsultantService taxConsultantService;

    public CustomerService(CustomerRepository customerRepository, TaxConsultantService taxConsultantService) {
        this.customerRepository = customerRepository;
        this.taxConsultantService = taxConsultantService;
    }

    @Override
    public List<Customer> getAllUsers() {
        List<Customer> customers = customerRepository.findAll();
        if (!customers.isEmpty()) {
            return customers;
        }
        return null;
    }

    @Override
    public Customer getUserById(Long id) throws NoSuchElementException {
        return customerRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("No Customer found with that id");
        });
    }

    @Override
    public Customer addUser(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer saveUser(Customer customer) {
        return customerRepository.save(customer);
    }

    public TaxConsultant addConsultantCustomerCooperation(ConsultantCustomerDTO consultantCustomerDTO) {
        try {
            Customer customer = this.getUserById(consultantCustomerDTO.getCustomerId());
            if (customer.getTaxConsultant() == null) {
                TaxConsultant taxConsultant = taxConsultantService.getUserById(consultantCustomerDTO.getTaxConsultantId());
                boolean consulting = taxConsultant.getCustomers().stream().anyMatch((customer1) -> customer == customer1);
                if (!consulting) {
                    customer.setTaxConsultant(taxConsultant);
                    taxConsultant.addCustomer(customer);
                    taxConsultantService.saveUser(taxConsultant);
                    return taxConsultant;
                }
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    public Optional<Customer> isAlreadyLiked(Long customerId, Long taxConsultantId) {
        return customerRepository.findByAlreadyLiked(customerId, taxConsultantId);
    }

}
