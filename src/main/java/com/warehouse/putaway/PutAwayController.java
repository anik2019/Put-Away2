package com.warehouse.putaway;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.warehouse.putaway.config.BeanConfig;
import com.warehouse.putaway.dto.ProductDTO;
import com.warehouse.putaway.service.PutawayService;

@RefreshScope
@RestController
@ConfigurationProperties
public class PutAwayController {
	
	@Autowired
    private BeanConfig appConfig;

	/*
	 * @Value("${sharedattribute: default attribute - Config Server is not working..pelase check}"
	 * ) private String sharedattribute;
	 * 
	 * @Value("${env: default env - Config Server is not working..pelase check}")
	 * private String env;
	 * 
	 * @Value("${configclientname: default configclientname - Config Server is not working..pelase check}"
	 * ) private String configclientname;
	 * 
	 * @GetMapping("/message") String getMessage() {
	 * //+" "+this.env+" "+this.configclientname; return this.sharedattribute; }
	 * 
	 * Feign Client code
	 * 
	 * final RestClient restClient;
	 */

	/*
	 * @Autowired public PutAwayController(RestClient restClient) { this.restClient
	 * = restClient; }
	 * 
	 * @GetMapping("/empname") public String getDeptEmpName() { return
	 * restClient.getEmpName(); }
	 */

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PutawayService putawayService;

	/*
	 * @RequestMapping(value = "/template/products") public String getProductList()
	 * { HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<String> entity = new HttpEntity<String>(headers);
	 * 
	 * return restTemplate.exchange("http://localhost:8080/products",
	 * HttpMethod.GET, entity, String.class).getBody(); }
	 */

	/*
	 * @PostMapping("/productlist") public void getProductList(@RequestBody
	 * List<String> names) { HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * //HttpEntity<String> entity = new HttpEntity<String>(headers);
	 * 
	 * @SuppressWarnings("unchecked") List<ProductDTO> productList =
	 * (List<ProductDTO>)
	 * restTemplate.postForObject("http://localhost:8080/multiplBarCodeSsearch",
	 * names, ProductDTO.class);//("http://localhost:8080/products",
	 * HttpMethod.POST, entity, ProductDTO.class).getBody();
	 * System.out.println(productList); }
	 */

	@PostMapping("/productlist")
	public ResponseEntity<?> getProductList(@RequestBody List<String> barcodes) {

		final String url = appConfig.getSearchProductListUrl();
		
		List<ProductDTO> prodDetails = new ArrayList<ProductDTO>();
		prodDetails = putawayService.getProductList(url, barcodes);
		
		return new ResponseEntity<>(prodDetails, HttpStatus.OK);

	}

	@PostMapping("/insertProducts")
	public ResponseEntity<?> insertProducts(@RequestBody List<ProductDTO> pdtoList) {
		
		final String url = appConfig.getInsertProducts();
		putawayService.insertProducts(url, pdtoList);

		return new ResponseEntity<>("Put away completed", HttpStatus.OK);
	}

	@PostMapping("/productsDeleteForPickup")	
	public ResponseEntity<?> productsDeleteForPickup(@RequestBody List<String> names){
		// log.info("Bar Code List : {}",listOfBarcode);

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/productsDeleteForPickup";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * List<String> names = new ArrayList<String>(); names.add("B123");
		 */

		ResponseEntity<String> result = restTemplate.postForEntity(uri, names, String.class);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
