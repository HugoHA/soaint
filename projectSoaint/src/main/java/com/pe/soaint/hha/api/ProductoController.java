package com.pe.soaint.hha.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pe.soaint.hha.entity.Producto;
import com.pe.soaint.hha.repository.ProductoRepository;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	private static final Logger LOG = LogManager.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Producto> productos = productoRepository.findAll();
		LOG.info("Estos son los productos -->"+productos);
		LOG.error("Estos son los productos -->"+productos);
		LOG.warn("---------------------->");
		return productos.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(productos);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto, HttpServletResponse response) {
		Producto creaProducto = productoRepository.save(producto);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(creaProducto.getIdproducto()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(creaProducto);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Producto> buscarPorCodigo(@PathVariable Long codigo) {
		
		Optional<Producto> producto = productoRepository.findById(codigo);
		return producto.isPresent()?new ResponseEntity<>(producto.get(),HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long codigo) {
		productoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Producto> actualizar(@PathVariable Long codigo, @Valid @RequestBody Producto producto) {
					
        Producto productoActualizar=productoRepository.findById(codigo).map(product -> {
            product.setNombre(producto.getNombre());
            product.setPrecio(producto.getPrecio());
            return productoRepository.save(product);
        }).orElseGet(() -> {
            producto.setIdproducto(codigo);
            return productoRepository.save(producto);
        });
        
        return ResponseEntity.ok(productoActualizar);
		
	}

}
