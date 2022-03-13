package com.example.doanthuctap.controller.admin;

import com.example.doanthuctap.converter.ProductConverter;
import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.repository.ProductRepository;
import com.example.doanthuctap.service.implement.CategoryService;
import com.example.doanthuctap.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {


    private ProductService productService;
    private CategoryService categoryService;

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    public ProductController(ProductService productService,CategoryService categoryService ) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list-product")
    public String showTable(Model theModel) {
        List<ProductDTO> listProduct = productService.listProduct();
        theModel.addAttribute("listProduct", listProduct);
        return "admin/fragments/product";
    }

    @GetMapping("/insert")
    public String formAddProduct(Model model) {
        ProductDTO productDTO = new ProductDTO();
        List<CategoryDTO> list = categoryService.listCategory();
        model.addAttribute("product", productDTO);
        model.addAttribute("listcategory", list);
        return "admin/fragments/product-insert";
    }

    @PostMapping("/insert")
    public String addProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, Errors errors,
                             @RequestParam("productImage") MultipartFile fileProductImage,
                             @RequestParam("imgName") String imgName) throws IOException {
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/fragments/product-insert";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            productDTO.setCreatedAt(formatter.format(date));
            String imageUUID;
            if(!fileProductImage.isEmpty()){
                imageUUID = fileProductImage.getOriginalFilename();
                Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                Files.write(fileNameAndPath, fileProductImage.getBytes());
            }else {
                imageUUID = "noimage.png";
            }//save image
            productDTO.setImage(imageUUID);
            productService.save(productDTO);
        }
        return "redirect:/admin/product/list-product";
    }

    @GetMapping("/delete")
    public String deleteProductById(@RequestParam("id") int id){
        ProductDTO productDTO = productService.getProductById(id);
        productDTO.setDelete(true);
        productService.save(productDTO);
        return "redirect:/admin/product/list-product";
    }

    @GetMapping("update")
    public String formUpdateProduct(@RequestParam("id") int id, Model theModel){
        ProductDTO productDTO = productService.getProductById(id);
        List<CategoryDTO> list = categoryService.listCategory();
        theModel.addAttribute("product", productDTO);
        theModel.addAttribute("listcategory", list);
        theModel.addAttribute("productImage", uploadDir);
        return "admin/fragments/product-update";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, Errors errors,
                             @RequestParam("productImage") MultipartFile fileProductImage,
                             @RequestParam("imgName") String imgName) throws IOException {
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/fragments/product-update";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            productDTO.setUpdatedAt(formatter.format(date));
            String imageUUID;
            if(!fileProductImage.isEmpty()){
                imageUUID = fileProductImage.getOriginalFilename();
                Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                Files.write(fileNameAndPath, fileProductImage.getBytes());
            }else {
                imageUUID = imgName;
            }//save image
            productDTO.setImage(imageUUID);
            productService.save(productDTO);
        }
        return "redirect:/admin/product/list-product";
    }
}
