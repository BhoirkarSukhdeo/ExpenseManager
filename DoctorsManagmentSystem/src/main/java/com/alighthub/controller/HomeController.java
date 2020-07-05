package com.alighthub.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.dms.model.Admin;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.service.ServiceDMS;
import com.cjc.cong.GeneratePdfReport;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
/*
 * 
 * @author Ravindra Sonawane
 * @page HomeController
 * @time 08/09/2019 - 9.05 PM
 * @purpose To controller all activities
 * 
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value="admin")
public class HomeController {
	  @Autowired
	   ServiceDMS servicedms;
	  
	   private static String TITLE = null;
	    public static final String PDF_EXTENSION = ".pdf";

	    @Autowired 
	    private JavaMailSender sender;
	    
	    File f=null;
	    //static Admin ad=null;
	    	
	// Admin can add all data
	
	@PostMapping(value="/add")
	public String addData(@RequestBody Admin admin)
	{
		System.out.println("Admin post maping method");
		servicedms.addData(admin);
		return "Data Inserted";

	}
	
	//Admin can get all data by using user name and password
	
	@GetMapping(value="/log/{loginuname}/{loginpassword}")
	public Admin log(@PathVariable String loginuname,@PathVariable String loginpassword)
	{    
		
		 
		return servicedms.displayAdmin(loginuname, loginpassword);
		
	}
	
	
	// get Admin Data by Id
	
	@GetMapping(value = "/edit/{adminId}")
	public Admin editAdminData(@PathVariable int adminId)
	{
		return servicedms.editAdminData(adminId);
	}
	
	@PatchMapping(value = "/update")
	public String upadateAdminData(@RequestBody Admin admin)
	{  
		servicedms.upadateAdminData(admin);
		return "update Data Successfully";
	}
	
	@GetMapping(value = "/serch/{adminFname}/{adminLname}")
	public List<Admin> findByAdminFnameOrAdminLname(@PathVariable String adminFname,@PathVariable String adminLname)
	{
		System.out.println(adminFname+"\t"+adminLname);
		return servicedms.findByAdminFnameOrAdminLname(adminFname, adminLname);
	}
	
	@GetMapping(value = "/getuname/{loginuname}")
	public Login getLoginUname(@PathVariable String loginuname)
	{
		return servicedms.getLoginUname(loginuname);
	}
	@GetMapping(value = "/getloguname/{loginuname}")
	public Admin findByLoginuname(@PathVariable String loginuname)
	{
		return servicedms.findByLoginuname(loginuname);
	}
	
  //@RequestMapping(value = "/pdfreport/{uname}", method = RequestMethod.GET, produces =MediaType.APPLICATION_PDF_VALUE) 
  public Admin citiesReport(String uname) throws MessagingException 
	{
	  System.out.println(uname);
	  
	Admin ad=servicedms.findByLoginuname(uname);
	
	 System.out.println("gggggg"+ad.getAdminEmail());
	 System.out.println(ad.getAdminFname());
		
	    System.out.println("mail sending");
		   TITLE=ad.getLogin().getLoginuname();
		System.out.println("mail sending2");
		Document document = new Document();
	       try
	       {
	    	   f= new File(TITLE + PDF_EXTENSION);
	          PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
	          document.open();
	          
	        //Set attributes here
	          
	          document.add(new Paragraph("Hello"+ad.getAdminFname()+" Your Data In PDF Form."));
	               
	          PdfPTable table1 = new PdfPTable(13); 
	          table1.setWidthPercentage(100);
	     	 // table1.setWidths(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
	     	 
	     	  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	     	  
	     	  PdfPCell hcell;
	     	  hcell = new PdfPCell(new Phrase("Id", headFont));
	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     	  table1.addCell(hcell);
	     	  
	     	  hcell = new PdfPCell(new Phrase(" First Name", headFont));
	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     	  table1.addCell(hcell);
	     	  
	     	  hcell = new PdfPCell(new Phrase("Last Name", headFont));
	     	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	     	  table1.addCell(hcell);
	     	  
	     	  hcell = new PdfPCell(new Phrase("Email", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Gender", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	     	  
	    	  hcell = new PdfPCell(new Phrase("Mobile No.", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Status", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Area", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("City", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("State", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Pincode", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Username", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Password", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	    	  hcell = new PdfPCell(new Phrase("Login Type", headFont));
	    	  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  table1.addCell(hcell);
	    	  
	     	  //for (City city : cities) {
	     	  
	     	  PdfPCell cell;
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAdminId()));
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     	  table1.addCell(cell);
	     	  
	     	  System.out.println(ad.getAdminId()+"100");
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAdminFname())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	     	  
	     	  System.out.println(ad.getAdminFname()+"200");
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAdminLname())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	    	  
	    	  cell = new PdfPCell(new Phrase(ad.getAdminEmail())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAdminGender())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	    	  
	    	  cell = new PdfPCell(new Phrase(ad.getAdminMobileNo())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAdminStatus())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	    	  
	    	  cell = new PdfPCell(new Phrase(ad.getAddress().getAddressArea())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAddress().getAddressCity())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	     	  
	    	  cell = new PdfPCell(new Phrase(ad.getAddress().getAddressState())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	     	  
	     	  cell = new PdfPCell(new Phrase(ad.getAddress().getAddressPincode())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	     	  
	    	  
	    	  cell = new PdfPCell(new Phrase(ad.getLogin().getLoginuname())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	    	  
	     	  cell = new PdfPCell(new Phrase(ad.getLogin().getLoginpassword())); 
	    	  cell.setPaddingLeft(5);
	    	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	    	  table1.addCell(cell);
	   	     
	    	  cell = new PdfPCell(new Phrase(ad.getLogin().getLoginType())); 
	     	  cell.setPaddingLeft(5);
	     	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	     	  table1.addCell(cell);
	    	  
	     	  
	     	  
	     	  //}
	     	  
	     	  
	     	 document.add(table1);
	          
	          
	          
	          
	          document.close();
	          writer.close();
	       } catch (DocumentException e)
	       {
	          e.printStackTrace();
	       } catch (FileNotFoundException e)
	       {
	          e.printStackTrace();
	       }
	       
		return ad;
		
	}
	
	  // Mail Sending Code
	@GetMapping("/getmap/{loginuname}")
	 public String addTrainee(@PathVariable String loginuname) throws MessagingException
	  {
	  System.out.println(loginuname);
	    System.out.println("Enter");
	    
	    //pdf generator method
		Admin add= citiesReport(loginuname);
		
		
	 // TODO Auto-generated method stub
	  
	  //SimpleMailMessage mail1=new SimpleMailMessage();
	  
	  MimeMessage msg=sender.createMimeMessage();
	  
	  MimeMessageHelper mail=new MimeMessageHelper(msg,true); 
	  try 
	  {
		  System.out.println(add.getAdminEmail());
		  String mail1="jaybhoirkar95@gmail.com";
		  String mail2="navnath.bhoirkar15@gmail.com";
	 // mail.setTo(mail1);
	  mail.setTo(new String[] {mail1,mail2});
	  //mail.setFrom("jaybhoirkar95@gmail.com"); 
	  mail.setSubject("SpringBoot Mail");
	  mail.setText("Welcome to my company Alighthub Tech Consultancy");
	  
	  
	  //ClassPathResource file=new ClassPathResource("E:\\SpringBootWorkspace\\PdfGenerator\\"+f); 
	  
	  FileSystemResource file=new FileSystemResource("E:\\SpringBootWorkspace\\DoctorsManagmentSystem\\"+f);
	  mail.addAttachment(file.getFilename(),file); }

	  
	  
	 catch (MessagingException me) 
	  {
		 // * TODO: handle exception
	 System.out.println(me.getMessage()); 
	 }
	  sender.send(msg); 
	
	  return "mail send successfully";
	  }

	@GetMapping("/getggg/{loginuname}")
	public Admin getAdm(@PathVariable String loginuname)
	{
		return servicedms.findByLoginuname(loginuname);
	}
	
	
	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee()
	{
		return servicedms.getAllEmployee();
	}
	
	@GetMapping(value = "getStudCount")
	public long getStudentCount()
	{
		return servicedms.getEmpCount();
		
	}
	
	@GetMapping(value = "getNurseCount")
	public long getNurseCount()
	{
		return servicedms.getEmpCount();
		
	}
	@GetMapping(value = "getDoctCount")
	public long getDoctorCount()
	{
		return servicedms.getEmpCount();
		
	}
	@GetMapping(value = "getEmpCount")
	public long getEmployeeCount()
	{
		return servicedms.getEmpCount();
		
	}
	@PutMapping(value = "updateEmployee")
	public String updateEmployee(@RequestBody Employee employee)
	{ 
		System.out.println("update Employee Called");
		servicedms.updateEmployee(employee);
		return "update Successfully";
	}
	
	@GetMapping(value = "getempdata/{loginuname}/{loginpassword}")
	public Employee getEmployeeData(@PathVariable String loginuname ,@PathVariable String loginpassword)
	{
		return servicedms.getEmployeeData(loginuname,loginpassword);
	}
	@DeleteMapping(value = "/delEmployee/{employeeId}")
	public List<Employee> deleteEmployee(@PathVariable int employeeId)
	{
		return servicedms.deleteEmployee(employeeId);
	}
	

}
