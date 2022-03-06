package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ProductService service; 

	//@Autowired 
	//private StudentRepository studentRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	@RequestMapping("/products")
	public ModelAndView viewHomePage(Model model) {
		ModelAndView model1 = new ModelAndView();
		List<Product> listProducts = service.listAll();
	
		model1.addObject("listProducts", listProducts);;
		model1.setViewName("index");
		return model1;
	}
	
	@RequestMapping("/google")
	public ModelAndView viewHomePage1(Model model) {
		ModelAndView model1 = new ModelAndView();
		
		model1.setViewName("form");
		return model1;
	}
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	 
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
	
	
	/* @RequestMapping("/submission")
	public ModelAndView submitData(@RequestParam("studentName") String name , @RequestParam("studentHobby") String hobby) {
	ModelAndView model1 = new ModelAndView();
	System.out.println(name+"----------"+hobby);
	
	Student student = new Student();
	student.setHobby(hobby);
	student.setName(name);
	
    studentRepository.save(student);
    System.out.println("Student value saved");
	model1.setViewName("index");
	return model1;
	}*/
	
	@RequestMapping("/submission")
	public ModelAndView submitData(@RequestParam("registerName") String name , @RequestParam("registerPhonenumber") long phonenumber) {
		ModelAndView model1 = new ModelAndView();
		System.out.println(name+"---------"+phonenumber);
		
		Register register = new Register();
		register.setName(name);
		register.setNumber(phonenumber);
		
		registerRepository.save(register);
		System.out.println("Registration successfull");
		model1.setViewName("index");
		return model1;
	}
}

