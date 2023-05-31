package com.example.bai1.controller;

import com.example.bai1.model.Book;
import com.example.bai1.model.Code;
import com.example.bai1.service.IBookService;
import com.example.bai1.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICodeService iCodeService;

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("bookList", iBookService.getAll());
        return "index";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam("id") Integer id, RedirectAttributes attributes,Model model) {
        Book book = iBookService.findById(id);
        boolean check = iBookService.save(book);
        if (check == false) {
            model.addAttribute("mess","out of books");
            return "error";
        } else {
            boolean flag;
            int codeName = 0;
            do {
                codeName = ThreadLocalRandom.current().nextInt(10000, 99999);
                flag = iCodeService.checkCodeName(codeName);
            } while (flag);
            Code code = new Code(codeName, true, book);
            iCodeService.save(code);
            attributes.addFlashAttribute("mess", "Your book return code is:" + codeName);
            return "redirect:/";
        }
    }

    @PostMapping("/giveback")
    public String giveBack(@RequestParam("codeName") Integer codeName, RedirectAttributes attributes,Model model) {
        boolean check = iCodeService.checkCodeName(codeName);
        if (check == false) {
            model.addAttribute("mess","wrong code");
            return "error";
        } else {
            Code code = iCodeService.findByCodeName(codeName);
            code.setStatus(false);
            iCodeService.save(code);
            Book book = iBookService.findById(code.getBook().getId());
            int quantity = book.getQuantity() + 1;
            book.setQuantity(quantity);
            iBookService.saveBook(book);
            attributes.addFlashAttribute("mess", "return book: "+book.getName()+" successfully");
            return "redirect:/";
        }
    }
    @GetMapping("/list")
    public String getAllCode(Model model){
        List<Code> codeList=iCodeService.findAll();
        model.addAttribute("codeList",codeList);
        return "list";
    }
    @ExceptionHandler(Exception.class)
    public String error(){
        return "error";
    }
}
