package com.example.ecomerce.controller;


import com.example.ecomerce.entity.Producto;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.UsuarioRepository;
import com.example.ecomerce.service.UploadFileService;
import com.example.ecomerce.service.serviceInterface.ProductoService;
import com.example.ecomerce.service.serviceInterface.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOG = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UploadFileService upload;


    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos",productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto,@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        LOG.info("Este es el objeto producto {}",producto);
        Usuario u= usuarioService.findById(Long.parseLong(session.getAttribute("idusuario").toString() )).get();
        producto.setUsuario(u);
        //imagen
        if (producto.getId()==0) { // cuando se crea un producto
            String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }else {

        }

        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Producto producto = new Producto();
        Optional<Producto> opProducto=productoService.byId(id);
        producto=opProducto.get();
        LOG.info("producto buscado: {}",producto);
        model.addAttribute("producto",producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("file") MultipartFile file ) throws IOException {
        Producto p = productoService.byId(producto.getId()).get();
        if (file.isEmpty()) {
            producto.setImagen(p.getImagen());
        } else {
            if (!p.getImagen().equals("default.jpg")) {
                upload.deleteImage(p.getImagen());
            }
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
//        Producto p = new Producto();
//        p=productoService.byId(p.getId()).get();
//
//        if (!p.getImagen().equals("default.jpg")) {
//            upload.deleteImage(p.getImagen());
//        }
        productoService.delete(id);
        return "redirect:/productos";
    }
}
