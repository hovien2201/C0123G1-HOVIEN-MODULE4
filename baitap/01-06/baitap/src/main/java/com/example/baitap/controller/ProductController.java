package com.example.baitap.controller;

import com.example.baitap.model.Product;
import com.example.baitap.service.ICartService;
import com.example.baitap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product,Integer> addSession(){
        return new HashMap<>();
    }

    @GetMapping("/")
    public String showShop(Model model) {
        model.addAttribute("products",iProductService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, @ModelAttribute("cart") Map<Product,Integer> cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (action.equals("show")) {
            iCartService.addProduct(productOptional.get(),cart);
            return "redirect:/cart";
        }
        if (action.equals("remove")) {
            iCartService.removeProduct(productOptional.get(),cart);
            return "redirect:/cart";
        }

        iCartService.addProduct(productOptional.get(),cart);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Product product = iProductService.findByIdP(id);
        model.addAttribute("product",product);
        return "view";
    }


    @GetMapping("/cart")
    public String showCart (@SessionAttribute("cart") Map<Product,Integer> cart ,Model model){
        model.addAttribute("totalItems",iCartService.countItemQuantity(cart));
        model.addAttribute("totalProduct",iCartService.countProductQuantity(cart));
        model.addAttribute("countTotal",iCartService.countTotalPayment(cart));
        model.addAttribute("cart",cart);
        return "cart";
    }
}
