package org.capgemini.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.capgemini.exception.ResourceNotFoundException;
import org.capgemini.model.CateringOrderingNonveg;
import org.capgemini.repository.CateringNonvegRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CateringNonvegController {
	
	@Autowired
	private CateringNonvegRepositiry caterRepo;
	
	//get catering ordering Nonveg information
	@GetMapping("/cateringorderingNonveg")
	public List<CateringOrderingNonveg>getCateringOrders(){
		return this.caterRepo.findAll();//fetch all order details
	}
	
	//save catering ordering Nonveg information
	@PostMapping("/cateringorderingNonveg")
	public CateringOrderingNonveg createCateringOrder(@RequestBody CateringOrderingNonveg caterorder) {
		return this.caterRepo.save(caterorder);//store the order
	}
	//cancel the Catering Order
		@DeleteMapping("/cateringorderingNonveg/{orderId}")
		public Map<String, Boolean> deleteCater(@PathVariable(value="orderId")Long orderId)
				throws ResourceNotFoundException{
			CateringOrderingNonveg cater = caterRepo.findById(orderId)
					.orElseThrow(( ) -> new ResourceNotFoundException
							("No Such Order is found by the id :: "+ orderId));//if id not found exception is thrown
			this.caterRepo.delete(cater);
			Map<String,Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;//cancel order successful
		}

}
