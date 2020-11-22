package com.mycompany.invoise.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class InvoiceControllerWeb {

   // @Autowired
    //private InvoiceServiceInterface invoiceService;
    //public InvoiceServiceInterface getInvoiceService() {
    //return invoiceService;
   // }

   // public void setInvoiceService(InvoiceServiceInterface invoiceService) {
      //  this.invoiceService = invoiceService;
   // }

/*
   @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {

            if(results.hasErrors()){
                return "invoice-create-form";
            }


            Invoice invoice = new Invoice();
            Customer customer = new Customer(invoiceForm.getCustomerName());
            invoice.setCustomer(customer);
            Address address = new Address(invoiceForm.getStreetName(),invoiceForm.getStreetNumber(),invoiceForm.getCity(),invoiceForm.getZipCode(),invoiceForm.getCountry());
            customer.setAddress(address);
               invoice.setOrderNumber(invoiceForm.getOrderNumber());
            invoiceService.create(invoice);
            return "invoice-created";
    }

*/
/*

    @RequestMapping("/home")
    public ModelAndView displayHome (){
        System.out.println("le controleur à été invoqué par la methode displayHome");
       // List<Invoice> invoices = invoiceService.getInvoiceList();
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);
        System.out.println(mv);
        return mv;
    }


    @RequestMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number){
        System.out.println("la methode displayInvoice a été invoqué!!");
        //List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices", invoices);
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice",invoiceService.getInvoiceById(number));
        return mv;
    }
*/




    @GetMapping("/home")
   // @RequestMapping("/invoice")
    public  String displayHome (Model model){
        System.out.println("le controleur à été invoqué par la methode displayHome");
        // List<Invoice> invoices = invoiceService.getInvoiceList();
       // model.addAttribute("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);

        return "invoice-home";
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
*/


}
