package com.app.controllers;

import javax.mail.*;
import javax.mail.internet.*;
import com.app.pojos.AlumniDetail;
import com.app.pojos.AdminDetail;
import com.app.pojos.UserDetail;
import com.app.service.UserService;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class HomePageController {

	@Autowired
	@Qualifier("user_service")
	private UserService service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndexForm(Model map) {
		System.out.println("show index form ");
		// invoke service layer method to add cust details
		map.addAttribute("gallaryModel", new UserDetail());
		return "index";
	}

	@RequestMapping(value = "/gallary", method = RequestMethod.GET)
	public String showGallaryForm(Model map) {
		System.out.println("show gallary form ");
		// invoke service layer method to add cust details
		// map.addAttribute("gallaryModel", new UserDetail());
		map.addAttribute("loginModel", new UserDetail());
		return "gallary";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContactForm(Model map) {
		System.out.println("show contact form ");
		// invoke service layer method to add cust details
		// map.addAttribute("gallaryModel", new UserDetail());
		return "contact";
	}

	/**
	 * This opens form for user detail
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/registerUserInfo", method = RequestMethod.GET)
	public String showRegFormForUserGet(Model map) {
		System.out.println("show registerUserInfo form ");
		// invoke service layer method to add cust details
		map.addAttribute("userModel", new UserDetail());
		return "register";
	}

	/**
	 * Saves user fill data in session and get redirected to alumni form
	 *
	 * @param user
	 * @param res
	 * @param request
	 * @param map
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/registerUserInfo", method = RequestMethod.POST)
	public String processUserInfoPost(@Valid @ModelAttribute("userModel") UserDetail user, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		if (res.hasErrors()) {
			System.out.println("register P.L errs " + user + "\n" + res.getAllErrors());
			return "index";
		}
		try {
			// invoke service layer method for updation
			// Save user detail data in session
			HttpSession session = request.getSession(false);
			session.setAttribute("userModel", user);
			attr.addAttribute("status", "user info processing");
			// redirect after post pattern -- redirected to cust list page.
			System.out.println("in process reg form success");

			switch (user.getLoginType()) {
			case "Alumni":
				return "redirect:/user/registerAlumniInfo";
			case "Admin":
				return "redirect:/user/registerAdminInfo";
			default:
				return "index";
			}

		} catch (Exception e) {
			System.out.println("in process reg formin excep " + user);
			System.out.println("in process reg form " + e.getMessage());
			return "index";
		}
	}

	/**
	 * This opens AlumniDetails form
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/registerAlumniInfo", method = RequestMethod.GET)
	public String showAlumniFormGet(Model map) {
		System.out.println("show alumni form ");
		// invoke service layer method to add cust details
		map.addAttribute("alumniModel", new AlumniDetail());
		return "registerAlumniInfo";
	}

	/**
	 * This saves data of user detail and alumni detail
	 *
	 * @param alumni
	 * @param res
	 * @param hs
	 * @param map
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/registerAlumniInfo", method = RequestMethod.POST)
	public String processFinalUserAndAlumniInfoPost(@Valid @ModelAttribute("alumniModel") AlumniDetail alumni,
			BindingResult res, HttpServletRequest request, Model map, RedirectAttributes attr) {
		if (res.hasErrors()) {
			System.out.println("register P.L errs " + alumni + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("register : no p.l errs");
		try {
			// invoke service layer method for updation
			HttpSession session = request.getSession(false);
			// get user model object from session which came from ui
			UserDetail userDetail = (UserDetail) session.getAttribute("userModel");

			alumni.setAlumniEmail(userDetail.getUserEmail());
			alumni.setUserEmail(userDetail.getUserEmail());
			alumni.setUserAddr(userDetail.getUserAddr());
			alumni.setUserFname(userDetail.getUserFname());
			alumni.setUserLname(userDetail.getUserLname());
			alumni.setUserMobile(userDetail.getUserMobile());
			alumni.setUserPassword(userDetail.getUserPassword());
			alumni.setLoginType(userDetail.getLoginType());
			alumni.setUserCity(userDetail.getUserCity());
			alumni.setUserCountry(userDetail.getUserCountry());
			alumni.setUserState(userDetail.getUserState());
			alumni.setUserDob(userDetail.getUserDob());

			AlumniDetail alumniDetailFromDb = service.registerAlumni(alumni);
			System.out.println("service.registerUser" + alumniDetailFromDb);

			attr.addAttribute("status", "User Registered Successfully");
			session.removeAttribute("userModel");
			// redirect after post pattern -- redirected to cust list page.
			System.out.println("in process reg form success");
			return "redirect:/user/index";
		} catch (Exception e) {
			System.out.println("in process reg formin excep " + alumni);
			e.printStackTrace();
			System.out.println("in process reg form " + e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "/registerAdminInfo", method = RequestMethod.GET)
	public String showRegFormForAdminGet(Model map) {
		System.out.println("show reg form ");
		// invoke service layer method to add cust details
		map.addAttribute("adminModel", new AdminDetail());
		return "registerAdminInfo";
	}

	@RequestMapping(value = "/registerAdminInfo", method = RequestMethod.POST)
	public String processFinalUserAndAdminInfoPost(@Valid @ModelAttribute("adminModel") AdminDetail admin,
			BindingResult res, HttpServletRequest request, Model map, RedirectAttributes attr) {
		if (res.hasErrors()) {
			System.out.println("register admin P.L errs " + admin + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("register : no p.l errs");
		try {
			// invoke service layer method for updation
			HttpSession session = request.getSession(false);
			// get user model object from session which came from ui
			UserDetail userDetail = (UserDetail) session.getAttribute("userModel");
			admin.setAdminEmail(userDetail.getUserEmail());
			admin.setUserEmail(userDetail.getUserEmail());
			admin.setUserAddr(userDetail.getUserAddr());
			admin.setUserFname(userDetail.getUserFname());
			admin.setUserLname(userDetail.getUserLname());
			admin.setUserMobile(userDetail.getUserMobile());
			admin.setUserCity(userDetail.getUserCity());
			admin.setUserCountry(userDetail.getUserCountry());
			admin.setUserState(userDetail.getUserState());
			admin.setUserDob(userDetail.getUserDob());
			admin.setUserPassword(userDetail.getUserPassword());
			admin.setLoginType(userDetail.getLoginType());

			AdminDetail adminDetailFromDb = service.registerAdmin(admin);
			System.out.println("service.registerUser" + adminDetailFromDb);

			attr.addAttribute("status", "User Registered Successfully");
			session.removeAttribute("userModel");
			// redirect after post pattern -- redirected to cust list page.
			System.out.println("in process reg form success");
			return "redirect:/user/index";

		} catch (Exception e) {
			System.out.println("in process reg admin formin excep " + admin);
			e.printStackTrace();
			System.out.println("in process reg form " + e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model map) {
		// Model --- map of model attributes
		System.out.println("in show login form " + map);
		// create empty DTO(model) instance & add it modl atter map
		// Model API --- public void addAttribute(String attrName,Object val);
		map.addAttribute("loginModel", new UserDetail());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(@Valid @ModelAttribute("loginModel") UserDetail c, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		System.out.println("in process reg form " + c + "-----");
		HttpSession session = request.getSession(false);

		// chk for p.l errs
		if (res.hasFieldErrors("userEmail") || res.hasFieldErrors("userPassword")) {
			// p.l errs
			System.out.println("login P.L errs " + c + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("no p .l errs");
		// use service layer bean for validation
		UserDetail details = service.validateUser(c.getUserEmail(), c.getUserPassword());
		System.out.println("user detail in login" + details);
		if (details == null) {
			attr.addAttribute("status", "Enter Correct Email and Password or Register");
			return "redirect:/user/index";
		}
		System.out.println(details);
		switch (details.getLoginType()) {
		case "Alumni":
			if (details.isApproveStatus()) {
				AlumniDetail alumniDetail = null;
				alumniDetail = service.getAlumniDetails(details.getUserId());
				map.addAttribute("loggedInUserInfo", alumniDetail);
				map.addAttribute("status", "Logged in Successfully");
				System.out.println(alumniDetail + "alumniDetail");
				session.setAttribute("loggedInUserInfo", alumniDetail);//
				session.setAttribute("userId", details.getUserId());
				return "redirect:/alumni/alumni_dashboard";
			} else {
				attr.addAttribute("status", "Your request is not aprooved contact administrator");
				return "redirect:/user/index";
			}
		case "Admin":
			if (details.isApproveStatus()) {
				AdminDetail adminDetail = null;
				adminDetail = service.getAdminDetails(details.getUserId());
				System.out.println(adminDetail + "adminDetail");
				map.addAttribute("loggedInUserInfo", adminDetail);
				map.addAttribute("status", "Logged in Successfully");
				session.setAttribute("loggedInUserInfo", adminDetail);//
				session.setAttribute("userId", details.getUserId());
				return "redirect:/admin/admin_dashboard";
			} else {
				attr.addAttribute("status", "Your request is not aprooved contact administrator");
				return "redirect:/user/index";
			}
		default:
			// return "index";
		}

		return "redirect:/user/index";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String showForgotpass(Model map) {
		System.out.println("show alumni_dashboard form ");
		// invoke service layer method to add cust details
		map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "forgotpassword";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String proccessForgotpass(@Valid @ModelAttribute("userModel") UserDetail user, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		System.out.println("show forgotpassword form ");
		UserDetail togetdata = service.getUserDetails(user.getUserEmail());

		String mailContent = "Your UserId is:" + togetdata.getUserEmail() + "\n\nYour Password is:"
				+ togetdata.getUserPassword();
		if (togetdata.getUserEmail() != null) { // Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");// 587 465
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("farmsmartandroid@gmail.com", "agricultural");// change
					// accordingly
				}
			});

			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("farmsmartandroid@gmail.com"));// change
				// accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(togetdata.getUserEmail()));
				message.setSubject("Regarding Forgot Password");
				message.setText(mailContent);

				// send message
				Transport.send(message);

				System.out.println("message sent successfully");
				attr.addAttribute("status","Password will be sent to your email within 5 min");
				return "index";
			} catch (MessagingException e) {
				System.out.println("mail excep " + e.getMessage());
				attr.addAttribute("status","Error");
				return "redirect:/user/index";
			}
			
		} else // if record is not present for given email id
		{
			System.out.println("message not sent successfully");
			attr.addAttribute("status","Please enter correct email to get password");
		}

		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		attr.addAttribute("status", "Please enter correct email to get password");
		return "redirect:/user/index";

	}

	@RequestMapping(value = "/forgotuname", method = RequestMethod.GET)
	public String showForgotuname(Model map) {
		System.out.println("show alumni_dashboard form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "forgotuname";
	}
}
