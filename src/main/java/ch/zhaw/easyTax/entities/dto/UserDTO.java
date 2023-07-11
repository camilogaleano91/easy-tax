package ch.zhaw.easyTax.entities.dto;

import ch.zhaw.easyTax.entities.Customer;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {


        private Long id;
        @NotBlank(message = "first name must not be empty!")
        private String firstName;
        @NotBlank(message = "last name must not be empty!")
        private String lastName;

        public UserDTO() {}

        public UserDTO(Customer customer) {
            this.id = customer.getId();
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

    public String getLastName() {
        return lastName;
    }
}
