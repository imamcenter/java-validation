package tentang.tech.java.validation;

import jakarta.validation.GroupSequence;
import org.junit.jupiter.api.Test;
import tentang.tech.java.validation.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest {
  @Test
  void testGroupSequence() {
    Payment payment = new Payment();

    validateWithGroups(payment, PaymentGroup.class);
  }

}
