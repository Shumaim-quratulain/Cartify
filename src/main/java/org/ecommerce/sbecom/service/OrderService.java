package org.ecommerce.sbecom.service;

import jakarta.transaction.Transactional;
import org.ecommerce.sbecom.payload.OrderDTO;

public interface OrderService {
    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
