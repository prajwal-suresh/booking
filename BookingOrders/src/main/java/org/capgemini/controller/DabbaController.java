package org.capgemini.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.capgemini.exception.ResourceNotFoundException;
import org.capgemini.model.DabbaOrdering;
import org.capgemini.repository.DabbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//used to build rest api
@RequestMapping("/api")//mapping web request
public class DabbaController {
	
	@Autowired//used for dependency Injection
	private DabbaRepository dabbaRepo;
	
	//get dabbaorder information
	@GetMapping("dabbaordering")
	public List<DabbaOrdering>getEmployee(){
		return this.dabbaRepo.findAll();//fetch all order details
	}
	
	//save dabbaorder
	@PostMapping("dabbaordering")
	public DabbaOrdering createEmployee(@RequestBody DabbaOrdering dabbaorder) {
		return this.dabbaRepo.save(dabbaorder);//store the order
	}
	
	//cancel the Catering Order
		@DeleteMapping("/dabbaordering/{orderId}")
		public Map<String, Boolean> deleteDabbaorder(@PathVariable(value="orderId")Long orderId)
				throws ResourceNotFoundException{
			DabbaOrdering dabba = dabbaRepo.findById(orderId)
					.orElseThrow(( ) -> new ResourceNotFoundException
							("No Such Order is found by the id :: "+ orderId));//if id not found exception is thrown
			this.dabbaRepo.delete(dabba);
			Map<String,Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;//cancel order successful
		}

}
