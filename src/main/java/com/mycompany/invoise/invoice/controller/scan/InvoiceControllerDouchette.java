package com.mycompany.invoise.invoice.controller.scan;

import com.mycompany.invoise.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


    @Override
    public String createInvoice(Invoice invoice) {

        //Scanner scanner = new Scanner(System.in);
        //String customerName = "Virgini Galactic";
        invoice = new  Invoice();
        Customer customer = new Customer("Virgini Galactic");
        invoice.setCustomer(customer);
        invoiceService.create(invoice);
        return  null;
    }
}
