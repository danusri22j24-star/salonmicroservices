package com.danu.service;

import com.danu.domain.PaymentMethod;
import com.danu.model.PaymentOrder;
import com.danu.payload.dto.BookingDTO;
import com.danu.payload.dto.UserDTO;
import com.danu.payload.response.PaymentLinkResponse;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO userDTO,
                                    BookingDTO booking,
                                    PaymentMethod paymentMethod) throws RazorpayException, StripeException;

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO user,
                                          Long amount,
                                          Long orderId) throws RazorpayException;

    String createStripePaymentLink(UserDTO user,
                                   Long amount,
                                   Long orderId) throws StripeException;

    Boolean proceedPayment(PaymentOrder paymentOrder,
                           String paymentId,
                           String paymentLinkId ) throws RazorpayException;

}
