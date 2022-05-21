package com.magaz2.firstMagaz2.controllers;

import com.magaz2.firstMagaz2.Entity.Brand;
import com.magaz2.firstMagaz2.Entity.Order;
import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.Entity.ProductType;
import com.magaz2.firstMagaz2.globalData.ProductDTO;
import com.magaz2.firstMagaz2.service.BrandService;
import com.magaz2.firstMagaz2.service.OrderService;
import com.magaz2.firstMagaz2.service.ProductService;
import com.magaz2.firstMagaz2.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = "C:/Users/79518/Desktop/УЧЕБА/JavaAll/magaz2/firstMagaz2/src/main/resources/static/images";
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

   @Autowired
    BrandService brandService;

   @Autowired
    OrderService orderService;


    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    //Product type
    @GetMapping("/admin/categories")
    public String getCat(Model model){
        Iterable<ProductType> productTypes = productTypeService.getAllproductType();
        model.addAttribute("productTypes",productTypes);
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("type", new ProductType());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("type") ProductType productType){
        productTypeService.addProductType(productType);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Long id){
        productTypeService.removeProductTypeById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Long id, Model model){
        Optional<ProductType> productType = productTypeService.getProductTypeById(id);
        if(productType.isPresent()){
            model.addAttribute("type",productType.get());
            return "categoriesAdd";
        }else
            return "404";
    }
    //Product
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("brands", brandService.getAllBrands());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("image") String image) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setProductType(productTypeService.getProductTypeById(productDTO.getProductTypeId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }else{
            imageUUID = image;
        }
        product.setImage(imageUUID);
        product.setBrand(brandService.getBrandById(productDTO.getBrandId()).get());
        productService.addProduct(product);

        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteproduct(@PathVariable Long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable Long id, Model model){

        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setBrandId(product.getBrand().getId());
        productDTO.setProductTypeId(product.getProductType().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());

        Iterable<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands",brands);
        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("productDTO",productDTO);


        return "productsAdd";
    }

    //Brands
    @GetMapping("/admin/brands")
    public String getBrand(Model model){
            Iterable<Brand> brands = brandService.getAllBrands();
            model.addAttribute("brands",brands);
        return "brands";
    }
    @GetMapping("/admin/brands/add")
    public String getBrandAdd(Model model){
        model.addAttribute("brand",new Brand());
        return "brandsAdd";
    }
    @PostMapping("/admin/brands/add")
    public String postBrandAdd(@ModelAttribute("brand") Brand brand){
        brandService.addBrand(brand);
        return "redirect:/admin/brands";
    }
    @GetMapping("/admin/brands/delete/{id}")
    public String deleteBrand(@PathVariable Long id){
        brandService.removeBrandId(id);
        return "redirect:/admin/brands";
    }
    @GetMapping("/admin/brands/update/{id}")
    public String updateBrand(@PathVariable Long id, Model model){
        Optional<Brand> brand = brandService.getBrandById(id);
        if(brand.isPresent()){
            model.addAttribute("brand",brand.get());
            return "brandsAdd";
        }else
            return "404";
    }
    //Orders
    @GetMapping("/admin/orders")
    public String getOrders(Model model){
        Iterable<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders",orders);
        return "orders";
    }

}



















