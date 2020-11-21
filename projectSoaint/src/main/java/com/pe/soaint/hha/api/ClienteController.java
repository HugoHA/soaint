package com.pe.soaint.hha.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pe.soaint.hha.services.ClienteService;


@Controller
@RequestMapping(value = "cliente")
public class ClienteController {
	
	 private static final Logger log = LogManager.getLogger(ClienteController.class);

	    @Autowired
	    ClienteService clienteService;
	    




	

}
