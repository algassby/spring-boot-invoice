package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;
    @Autowired
    private RestTemplate restTemplate;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice, BindingResult results) {
       System.out.println(invoice);
          return   invoiceService.create(invoice);

    }
/*
    @RequestMapping("/home")
    public  ModelAndView displayHome (){
        System.out.println("le controleur à été invoqué par la methode displayHome");
       // List<Invoice> invoices = invoiceService.getInvoiceList();
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);
        System.out.println(mv);
        return mv;
    }
*/

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        Invoice invoice = invoiceService.getInvoiceById(number);
        final Customer customer = restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(),Customer.class);
        final Address address = restTemplate.getForObject("http://customer-service/address/"+customer.getAddress().getId(),Address.class);
        customer.setAddress(address);
        invoice.setCustomer(customer);
        return invoice;
    }

    @GetMapping
    public  Iterable<Invoice> displayHome (){
        System.out.println(invoiceService.getInvoiceList());
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            //invocation du microservice customer avec son url+son id
            invoice.setCustomer(restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(),Customer.class));
        });
        return  invoices;

    }
    /*
    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number,Model model){
        System.out.println("la methode displayInvoice a été invoqué!!");
        //List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices", invoices);
        model.addAttribute("invoice",invoiceService.getInvoiceById(number));
        return "invoice-details";
    }

    @RequestMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){

        return "invoice-create-form";
    }
    @Override
    public String toString() {
        return "InvoiceControllerWeb{" +
                "invoiceService=" + invoiceService +
                '}';
    }
    /*
  */

}
