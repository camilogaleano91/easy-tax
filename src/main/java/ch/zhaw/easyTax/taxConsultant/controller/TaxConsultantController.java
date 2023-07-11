package ch.zhaw.easyTax.taxConsultant.controller;

import ch.zhaw.easyTax.user.controller.BaseUserController;
import ch.zhaw.easyTax.taxConsultant.model.TaxConsultant;
import ch.zhaw.easyTax.user.dto.UserDTO;
import ch.zhaw.easyTax.taxConsultant.service.TaxConsultantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "api/v1/tax-consultants")
public class TaxConsultantController implements BaseUserController<TaxConsultant, UserDTO> {

    private final TaxConsultantService taxConsultantService;

    public TaxConsultantController(TaxConsultantService taxConsultantService) {
        this.taxConsultantService = taxConsultantService;
    }

    @Override
    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        List<TaxConsultant> taxConsultants = taxConsultantService.getAllUsers();
        if (taxConsultants != null) {
            return new ResponseEntity<>(taxConsultants, HttpStatus.OK);
        }
        return new ResponseEntity<>("No TaxConsultant found!", HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<TaxConsultant> getUserById(@PathVariable(value = "id") long id) {
        try {
            return new ResponseEntity<>(taxConsultantService.getUserById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    @PostMapping(value = "/add-taxConsultant")
    public ResponseEntity<String> addUser(@RequestBody @Valid UserDTO userDTO) {
        TaxConsultant taxConsultant = new TaxConsultant();
        taxConsultant.setFirstName(userDTO.getFirstName());
        taxConsultant.setLastName(userDTO.getLastName());
        try {
            taxConsultantService.addUser(taxConsultant);
            return new ResponseEntity<>("Successfully added new Tax Consultant", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Could not add Tax Consultant" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
