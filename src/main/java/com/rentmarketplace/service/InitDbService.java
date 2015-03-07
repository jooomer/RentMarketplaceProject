package com.rentmarketplace.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.ProductType;
import com.rentmarketplace.model.entity.Role;
import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.repository.ProductRepository;
import com.rentmarketplace.repository.ProductTypeRepository;
import com.rentmarketplace.repository.RoleRepository;
import com.rentmarketplace.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") != null) {
			return;
		}
		
		// init roles
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		// init first user "admin"
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEmail("admin@rentmarketplace.com");
		userAdmin.setFirstName("Admin First Name");
		userAdmin.setLastName("Admin Last Name");
		userAdmin.setPhone("1234567");
		userAdmin.setAddress("Admin Address");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEnabled(true);
		userAdmin.addRole(roleUser);
		userAdmin.addRole(roleAdmin);
		userRepository.save(userAdmin);

		// init second user "user"
		User userUser = new User();
		userUser.setName("user");
		userUser.setEmail("user@user.com");
		userUser.setFirstName("User First Name");
		userUser.setLastName("User Last Name");
		userUser.setPhone("9876543");
		userUser.setAddress("User address");
		encoder = new BCryptPasswordEncoder();
		userUser.setPassword(encoder.encode("user"));
		userUser.setEnabled(true);
		userUser.addRole(roleUser);
		userRepository.save(userUser);

		// init product types
		ProductType productTypeMobile = new ProductType();
		productTypeMobile.setName("Mobile devices");
		productTypeRepository.save(productTypeMobile);

		ProductType productTypeVelobikes = new ProductType();
		productTypeVelobikes.setName("Velobikes");
		productTypeRepository.save(productTypeVelobikes);

		ProductType productTypeCars = new ProductType();
		productTypeCars.setName("Cars");
		productTypeRepository.save(productTypeCars);

		ProductType productTypeMotobikes = new ProductType();
		productTypeMotobikes.setName("Motobikes");
		productTypeRepository.save(productTypeMotobikes);

		// init products
		Product product1 = new Product();
		product1.setName("Apple iPhone 6 (2014)");
		product1.setDescription("Phone is fully functional. May have signs of light wear which may include a few scratches or minor cosmetic issues. Includes charging accessories. Device will not include SIM card.");
		product1.setUser(userAdmin);
		product1.setProductType(productTypeMobile);
		product1.setPrice(600.);
		product1.setPublishedDate(new Date());
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setName("Cervelo S5 VWD Dura Ace Road Bike 2014");
		product2.setDescription("VWD - more lightweight! The Cervelo S5 highend carbon road bike with FK26 UltraLight fork and 2Position-Aero seatpost. Made to fulfill highest demands.");
		product2.setUser(userAdmin);
		product2.setProductType(productTypeVelobikes);
		product2.setPrice(500.);
		product2.setPublishedDate(new Date());
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setName("Land Rover Discovery Sport");
		product3.setDescription("The Land Rover Discovery Sport is a very impressive car. It has class-leading practicality, a nice interior, exemplary safety credentials and it's really good to drive.");
		product3.setUser(userUser);
		product3.setProductType(productTypeCars);
		product3.setPrice(100000.);
		product3.setPublishedDate(new Date());
		productRepository.save(product3);

		Product product4 = new Product();
		product4.setName("Ducati 1299 Panigale");
		product4.setDescription("Ducati’s superb super-sports flagship blends Italian style, mind-blowing 200bhp performance and racer-like handling and braking with reasonable comfort and outstanding safety features. It’s a magnificent motorbike, albeit a very expensive one.");
		product4.setUser(userUser);
		product4.setProductType(productTypeMotobikes);
		product4.setPrice(30000.);
		product4.setPublishedDate(new Date());
		productRepository.save(product4);

	}

}
