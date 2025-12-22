package com.example.ecomerce.controller;


import com.example.ecomerce.entity.Producto;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.UsuarioRepository;
import com.example.ecomerce.service.serviceInterface.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOG = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioRepository usuarioRepository;


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
    public String save(Producto producto){
        LOG.info("este es el obj producto {}",producto);
        Usuario usuario=usuarioRepository.findById(1L).get();
        producto.setUsuario(usuario);
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
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
//        Producto p = new Producto();
//        p=productoService.byId(id).get();
//
//        if (!p.getImagen().equals("default.jpg")) {
//            upload.deleteImage(p.getImagen());
//        }
        productoService.delete(id);
        return "redirect:/productos";
    }
}
