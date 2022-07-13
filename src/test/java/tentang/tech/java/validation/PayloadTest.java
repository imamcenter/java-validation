package tentang.tech.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import tentang.tech.java.validation.group.CreditCardPaymentGroup;
import tentang.tech.java.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest {
  @Test
  void testPayload() {
    Payment payment = new Payment();
    payment.setOrderId("0001");
    payment.setAmount(20_000L);
    payment.setCreditCard("31111");

    Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
    for (ConstraintViolation<Payment> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());

      Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
      for (Class<? extends Payload> payloadClass : payload) {
        if (payloadClass == EmailErrorPayload.class){
          EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
          emailErrorPayload.sendEmail(violation);
        }
      }
      System.out.println("=========");

    }
  }

}
