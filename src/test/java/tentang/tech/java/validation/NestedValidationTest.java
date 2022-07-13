package tentang.tech.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

  private Validator validator;
  private ValidatorFactory validatorFactory;

  @BeforeEach
  void setUp() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @AfterEach
  void tearDown() {
    validatorFactory.close();
  }

  @Test
  void testNested() {
    Person person = new Person();
    person.setFirstname("imam");
    person.setLastname("ahmad");

    Address address = new Address();
    person.setAddress(address);
    Set<ConstraintViolation<Person>> violations = validator.validate(person);


    for (ConstraintViolation<Person> violation : violations) {
      System.out.println("Message: " + violation.getMessage());
      System.out.println("Constrains: " + violation.getConstraintDescriptor().getAnnotation());
      System.out.println("Bean: " + violation.getLeafBean());
      System.out.println("Invalid Value: " + violation.getInvalidValue());
      System.out.println("Path: " + violation.getPropertyPath());
    }
  }
}
