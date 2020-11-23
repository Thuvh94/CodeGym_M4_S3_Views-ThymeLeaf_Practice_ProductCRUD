package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.IProductServiceImpl;

@Controller
public class ProductController {
    private IProductService iProductService = new IProductServiceImpl();
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home","products",iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit","product",iProductService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirect){
            iProductService.update(product.getId(), product);
            redirect.addFlashAttribute("success", "Modified product successfully!");
            return "redirect:/home";
    }

    @GetMapping("/delete")
    public ModelAndView showDeleteForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("delete","product",iProductService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("remove", "Remove product successfully!");
        return "redirect:/home";
    }

    @GetMapping("/create")
    public Model showCreateForm(Model model){
        model.addAttribute("product",new Product());
        return model;
    }

    @PostMapping("/create")
    public String create(Product product,RedirectAttributes redirect){
        iProductService.save(product);
        return "redirect:/home";
    }
    @GetMapping("/view")
    public ModelAndView showView(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("view","product",iProductService.findById(id));
        return modelAndView;
    }
}
