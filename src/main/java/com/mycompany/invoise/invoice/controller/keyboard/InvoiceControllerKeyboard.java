package com.mycompany.invoise.invoice.controller.keyboard;

import com.mycompany.invoise.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public String createInvoice(Invoice invoice){

        //Scanner scanner = new Scanner(System.in);
        String customerName = "SpaceX";
        invoice = new  Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);
        invoiceService.create(invoice);
        return null;

    }
}
