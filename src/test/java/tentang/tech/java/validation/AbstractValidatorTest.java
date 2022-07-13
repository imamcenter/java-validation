package tentang.tech.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {
  protected ValidatorFactory validatorFactory;
  protected Validator validator;

  @BeforeEach
  void setUp() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @AfterEach
  void tearDown() {
    validatorFactory.close();

  }

  void validate(Object o) {
    Set<ConstraintViolation<Object>> violations = validator.validate(o);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println("Message: " + violation.getMessage());
      System.out.println("Path: " + violation.getPropertyPath());
      System.out.println("===============");
    }

  }

  void validateWithGroups(Object o, Class<?>... groups) {
    Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println("Message: " + violation.getMessage());
      System.out.println("Path: " + violation.getPropertyPath());
      System.out.println("===============");
    }
  }
}
