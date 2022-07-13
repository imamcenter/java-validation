package tentang.tech.java.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import tentang.tech.java.validation.group.CreditCardPaymentGroup;
import tentang.tech.java.validation.group.VirtualAccountPaymentGroup;
import tentang.tech.java.validation.payload.EmailErrorPayload;

public class Payment {

  @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "order id can not blank")
  private String orderId;

  @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000, max = 1_000_000_000L, message = "amount must beetwen 10.000 and 100.000.000")
  @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "amount can not null")
  private Long amount;

  @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "invalid credit card number", payload = {EmailErrorPayload.class})
  @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can not blank")
  private String creditCard;

  @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account must not blank")
  private String virtualAccount;

  @Valid
  @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class}, message = "customer can not null")
  @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
  @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
  private Customer customer;


  @Override
  public String toString() {
    return "Payment{" +
        "orderId='" + orderId + '\'' +
        ", amount=" + amount +
        ", creditCard='" + creditCard + '\'' +
        ", virtualAccount='" + virtualAccount + '\'' +
        ", customer=" + customer +
        '}';
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getVirtualAccount() {
    return virtualAccount;
  }

  public void setVirtualAccount(String virtualAccount) {
    this.virtualAccount = virtualAccount;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
  }
}
