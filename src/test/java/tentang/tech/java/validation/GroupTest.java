package tentang.tech.java.validation;

import org.junit.jupiter.api.Test;
import tentang.tech.java.validation.group.CreditCardPaymentGroup;
import tentang.tech.java.validation.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest {
  @Test
  void testCreditCardGroup(){
    Payment payment = new Payment();
    payment.setCreditCard("123");
    payment.setOrderId("0001");
    payment.setAmount(10_000L);

    validateWithGroups(payment, CreditCardPaymentGroup.class);
  }

  @Test
  void testVirtualAccountGroup(){
    Payment payment = new Payment();
    payment.setVirtualAccount("");
    payment.setOrderId("0001");
    payment.setAmount(10_000L);

    validateWithGroups(payment, VirtualAccountPaymentGroup.class);
  }
}
