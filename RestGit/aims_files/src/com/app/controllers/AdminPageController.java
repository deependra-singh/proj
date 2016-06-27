package com.app.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.AlumniDetail;

import com.app.pojos.EventsDetail;
import com.app.pojos.AdminDetail;

import com.app.pojos.PostDetail;
import com.app.pojos.UserDetail;
import com.app.pojos.VacanciesDetail;
import com.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

	@Autowired
	@Qualifier("user_service")
	private UserService service;

	@RequestMapping(value = "/admin_dashboard", method = RequestMethod.GET)
	public String showgAdminDashboard(Model map) {
		System.out.println("show admin_dashboard form ");
		// invoke service layer method to add cust details
		List<EventsDetail> allEvents = service.listAllEvents();
		map.addAttribute("allevents_detail", allEvents);

		List<PostDetail> allPost = service.listPosts();
		List<VacanciesDetail> allVacancies = service.listAllVacancies();
		map.addAttribute("allVacancies_detail", allVacancies);
		map.addAttribute("allposts_detail", allPost);

		map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto admin_dashboard form ");
		return "admin_dashboard";
	}

	@RequestMapping(value = "/admin_approvals", method = RequestMethod.GET)
	public String showgAdminApprovals(Model map) {
		System.out.println("show admin_approvals form ");
		// invoke service layer method to add cust details
		List<AlumniDetail> allAlumniUnapproved = service.getAllUnAproovedAlumnis();
		// List<VacanciesDetail> allVacancies = service.listAllVacancies();
		// map.addAttribute("allVacancies_detail", allVacancies);
		List<VacanciesDetail> allVacancyUnapproved = service.getAllUnAproovedVacancies();
		map.addAttribute("allVacancy_Unapproved", allVacancyUnapproved);

		List<PostDetail> allPostUnapproved = service.getAllUnAproovedPost();
		map.addAttribute("allPost_Unapproved", allPostUnapproved);

		List<AdminDetail> allAdminUnapproved = service.getAllUnAproovedAdmin();
		map.addAttribute("allAdmin_Unapproved", allAdminUnapproved);

		map.addAttribute("allAlumni_Unapproved", allAlumniUnapproved);
		map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto admin_approvals form ");
		return "admin_approvals";
	}

	@RequestMapping(value = "/admin_unapprove/{userId}", method = RequestMethod.GET)
	public String showgAdminUnapprove(@PathVariable Long userId, Model map, HttpSession hs, RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			AlumniDetail alumni = service.getAlumniDetails(userId);
			String sts = service.deleteAlumni(alumni);
			attr.addAttribute("status", "Alumni not approved");
			attr.addAttribute("message", sts);
			sendMail("Your request for Alumni registration is not approved ,for any queries contact administrator",
					alumni.getUserEmail());
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Alumni unapproval failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_admin_approve/{userId}", method = RequestMethod.GET)
	public String showgAdminReqApprove(@PathVariable Long userId, Model map, HttpSession hs, RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			AdminDetail admin = service.getAdminDetails(userId);

			System.out.println("set to be approved :" + admin);
			admin.setApproveStatus(true);
			admin.setUserApproveStatus(1);
			System.out.println("made approved :" + admin);
			System.out.println("Approve success" + service.updateAdmin(admin));
			attr.addAttribute("status", " Admin Approved Successfully");
			sendMail("Your request for Admin registration is approved ,for any queries contact administrator",
					admin.getUserEmail());
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Alumni approval failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_admin_unapprove/{userId}", method = RequestMethod.GET)
	public String showgAdminReqUnapprove(@PathVariable Long userId, Model map, HttpSession hs,
			RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			AdminDetail admin = service.getAdminDetails(userId);
			String sts = service.deleteAdmin(admin);
			attr.addAttribute("status", "Admin not approved");
			attr.addAttribute("message", sts);
			sendMail("Your request for Admin registration is not approved ,for any queries contact administrator",
					admin.getUserEmail());
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Admin unapproval failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_approve/{userId}", method = RequestMethod.GET)
	public String showgAdminApprove(@PathVariable Long userId, Model map, HttpSession hs, RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			AlumniDetail alumni = service.getAlumniDetails(userId);
			System.out.println("set to be approved :" + alumni);
			alumni.setUserApproveStatus(1);
			alumni.setApproveStatus(true);
			System.out.println("made approved :" + alumni);
			System.out.println("Approve success" + service.updateAlumni(alumni));
			sendMail("Your request for Alumni registration is approved ,for any queries contact administrator",
					alumni.getUserEmail());
			attr.addAttribute("status", "Alumni Approved Successfully");
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Alumni approval failed : " + e.getMessage());
		}
		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_post_unapprove/{postId}", method = RequestMethod.GET)
	public String showgAdminPostUnapprove(@PathVariable int postId, Model map, HttpSession hs,
			RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			PostDetail post = service.getPostDetails(postId);
			String sts = service.deleteAPost(post);
			attr.addAttribute("status", "Post not approved");
			attr.addAttribute("message", sts);
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Alumni unapproval failed : " + e.getMessage());
		}
		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_post_approve/{postId}", method = RequestMethod.GET)
	public String showgAdminPostApprove(@PathVariable int postId, Model map, HttpSession hs, RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			PostDetail post = service.getPostDetails(postId);
			System.out.println("set to be approved :" + post);
			post.setApproveStatus(true);
			System.out.println("made approved :" + post);
			System.out.println("Approve success" + service.updatePost(post));
			attr.addAttribute("status", " Post Approved Successfully");
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "Alumni approval failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_vacancy_unapprove/{vacancyId}", method = RequestMethod.GET)
	public String showgAdminVacancyUnapprove(@PathVariable int vacancyId, Model map, HttpSession hs,
			RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			VacanciesDetail vacancy = service.getVacancyDetails(vacancyId);
			String sts = service.deleteVacancy(vacancy);
			attr.addAttribute("status", "Vacancy not approved");
			attr.addAttribute("message", sts);
		} catch (Exception e) {
			System.out.println("err in admin_vacancy_unapprove controller " + e);
			attr.addAttribute("status", "admin_vacancy_unapprove failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_vacancy_approve/{vacancyId}", method = RequestMethod.GET)
	public String showgAdminVacancyApprove(@PathVariable int vacancyId, Model map, HttpSession hs,
			RedirectAttributes attr) {
		System.out.println("show admin_unapprove form ");

		try {
			VacanciesDetail vacancy = service.getVacancyDetails(vacancyId);

			System.out.println("set to be approved :" + vacancy);
			vacancy.setApproveStatus(true);
			System.out.println("made approved :" + vacancy);
			System.out.println("Approve success" + service.updateVacancy(vacancy));
			attr.addAttribute("status", "Vacancy Approved Successfully");
		} catch (Exception e) {
			System.out.println("err in unaproove controller " + e);
			attr.addAttribute("status", "admin_vacancy_approve failed : " + e.getMessage());
		}

		return "redirect:/admin/admin_approvals";
	}

	@RequestMapping(value = "/admin_gallary", method = RequestMethod.GET)
	public String showAdminGallary(Model map) {
		System.out.println("show admin_gallary form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "admin_gallary";
	}

	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public String showAdminPage(Model map) {
		System.out.println("show admin_page form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto admin_page form ");
		return "admin_page";
	}

	/**
	 * Shows for for adding message(post)
	 *
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin_post_add", method = RequestMethod.GET)
	public String showAdminPostAdd(Model map, HttpServletRequest request) {
		System.out.println("show admin_post_add form ");
		map.addAttribute("postModel", new PostDetail());
		System.out.println("in admin_post_add form ");
		return "admin_post_add";
	}

	@RequestMapping(value = "/admin_post_add", method = RequestMethod.POST)
	public String processAdminPostAdd(@Valid @ModelAttribute("postModel") PostDetail post, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		if (res.hasErrors()) {
			System.out.println("admin_post_add P.L errs " + post + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("admin_post_add : no p.l errs");
		try {
			HttpSession session = request.getSession(false);
			UserDetail userDetail = (UserDetail) session.getAttribute("loggedInUserInfo");
			post.setPostSendDate(new Timestamp(new java.util.Date().getTime()));
			post.setPostFromName(userDetail.getUserEmail());
			post.setUserDetail(userDetail);
			post.setApproveStatus(true);
			post = service.addPost(post);
			attr.addAttribute("status", "Post Added Successfully");
			
			return "redirect:/admin/admin_post";
		} catch (Exception e) {
			System.out.println("in process post formin excep " + post);
			System.out.println("in process reg form " + e.getMessage());
			attr.addAttribute("status", "Post Add Failed");
			
			return "admin_post";
		}
	}

	@RequestMapping(value = "/admin_post", method = RequestMethod.GET)
	public String showAdminPost(Model map, HttpSession hs) {
		System.out.println("show admin_post form ");
		AdminDetail us = (AdminDetail) hs.getAttribute("loggedInUserInfo");

		List<EventsDetail> userEvents = service.listEventDetail(us);
		map.addAttribute("userEvents_detail", userEvents);

		List<VacanciesDetail> userVacancies1 = service.listVacanciesDetail(us);
		map.addAttribute("userVacancies_detail", userVacancies1);

		List<PostDetail> userpost = service.listUserPosts(us.getUserEmail());
		map.addAttribute("userposts_detail", userpost);

		return "admin_post";
	}

	@RequestMapping(value = "/admin_profile_userinfo_edit", method = RequestMethod.GET)
	public String showadmin_profile_edit(Model map, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		map.addAttribute("valid_user", session.getAttribute("loggedInUserInfo"));
		return "admin_profile_edit";
	}

	@RequestMapping(value = "/admin_profile_edit", method = RequestMethod.POST)
	public String processProfileEditForm(@Valid @ModelAttribute("userModel") UserDetail userModel, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		HttpSession session = request.getSession(false);
		if (res.hasErrors()) {
			System.out.println("admin_profile_edit P.L errs " + userModel + "\n" + res.getAllErrors());
			return "admin_profile";
		}
		System.out.println("admin_profile_edit : no p.l errs");
		try {
			AdminDetail admindetail = (AdminDetail) session.getAttribute("loggedInUserInfo");
			// invoke service layer method for updation
			admindetail.setUserAddr(userModel.getUserAddr());
			admindetail.setUserFname(userModel.getUserFname());
			admindetail.setUserLname(userModel.getUserLname());
			admindetail.setUserMobile(userModel.getUserMobile());
			admindetail.setUserCity(userModel.getUserCity());
			admindetail.setUserCountry(userModel.getUserCountry());
			admindetail.setUserState(userModel.getUserState());
			admindetail.setUserDob(userModel.getUserDob());
			System.out.println("user after next button click from form" + admindetail);

			session.setAttribute("modifiedUserDetailInfo", admindetail);

			map.addAttribute("valid_admin", session.getAttribute("loggedInUserInfo"));
			System.out.println("in process reg form success");
			attr.addAttribute("status","Profile Updated Successfully");
			return "admin_profile_edit1";
		} catch (Exception e) {
			System.out.println("in process reg form " + e.getMessage());
			attr.addAttribute("status","Profile Update Failed");
			return "admin_profile";
		}
	}

	@RequestMapping(value = "/admin_profile_edit1", method = RequestMethod.POST)
	public String processAdminProfileEdit1Form1(@Valid @ModelAttribute("adminModel") AdminDetail adminModel,
			BindingResult res, HttpServletRequest request, Model map, RedirectAttributes attr) {
		HttpSession session = request.getSession(false);
		if (res.hasErrors()) {
			System.out.println("update P.L errs " + adminModel + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("update : no p.l errs");
		try {
			AdminDetail adminDetailToBeModified = (AdminDetail) session.getAttribute("modifiedUserDetailInfo");
			adminDetailToBeModified.setAdminDesignation(adminModel.getAdminDesignation());
			adminDetailToBeModified.setAdminEmpCode(adminModel.getAdminEmpCode());
			adminDetailToBeModified.setAdminYearOfAppointment(adminModel.getAdminYearOfAppointment());
			adminDetailToBeModified.setAdminYearOfRelease(adminModel.getAdminYearOfRelease());
			AdminDetail adminDetail = service.updateAdmin(adminDetailToBeModified);
			session.setAttribute("loggedInUserInfo", adminDetail);//
			session.setAttribute("userId", adminDetail.getUserId());
			attr.addAttribute("status", "Profile Updated Successfully");
			// redirect after post pattern -- redirected to cust list page.
			System.out.println("in process reg form success");
			return "redirect:/admin/admin_profile";
		} catch (Exception e) {
			System.out.println("exception in admin_profile_edit1 post method " + adminModel + "\n" + e.getMessage());
			e.printStackTrace();
			return "admin_profile";
		}
	}

	@RequestMapping(value = "/admin_profile", method = RequestMethod.GET)
	public String showAdminProfile(Model map, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		map.addAttribute("valid_user", session.getAttribute("loggedInUserInfo"));
		System.out.println("show admin_profile form ");
		return "admin_profile";
	}

	@RequestMapping(value = "/admin_vacancies_add", method = RequestMethod.GET)
	public String showAdminVacanciesAdd(Model map) {
		System.out.println("show admin_vacancies_add form ");
		map.addAttribute("vacancyModel1", new VacanciesDetail());
		return "admin_vacancies_add";
	}

	@RequestMapping(value = "/admin_vacancies_add", method = RequestMethod.POST)
	public String processAddVacancies(@Valid @ModelAttribute("vacancyModel1") VacanciesDetail vacancyModel1,
			BindingResult result, Model map,RedirectAttributes attr, HttpServletRequest request) {
		System.out.println("show admin_vacancies_add form ");

		if (result.hasErrors()) {
			System.out.println("errors in admin_vacancies_add suibmit" + result);
			return "index";
		}
		System.out.println("vacancyDetails-->" + vacancyModel1);
		HttpSession session = request.getSession(false);
		UserDetail userDetail = (UserDetail) session.getAttribute("loggedInUserInfo");
		vacancyModel1.setVacancyCreateDate(new Timestamp(new java.util.Date().getTime()));
		vacancyModel1.setUserDetail(userDetail);
		vacancyModel1.setApproveStatus(true);
		service.addVacanciesDetail(vacancyModel1);
		attr.addAttribute("status", "Vacancy Added Successfully");
		return "redirect:/admin/admin_post";
	}

	@RequestMapping(value = "/admin_event_add", method = RequestMethod.GET)
	public String showAdminEventAdd(Model map) {
		System.out.println("show admin_event_add form ");
		map.addAttribute("eventModel", new EventsDetail());
		return "admin_event_add";
	}

	@RequestMapping(value = "/admin_event_add", method = RequestMethod.POST)
	public String processAddEventsDetail(@Valid @ModelAttribute("eventModel") EventsDetail eventModel,
			BindingResult result, Model map,RedirectAttributes attr, HttpServletRequest request) {
		System.out.println("show admin_event_add form ");

		if (result.hasErrors()) {
			System.out.println("errors in admin_event_add suibmit" + result);
			return "index";
		}
		System.out.println("vacancyDetails-->" + eventModel);
		HttpSession session = request.getSession(false);
		UserDetail userDetail = (UserDetail) session.getAttribute("loggedInUserInfo");

		eventModel.setUserDetail(userDetail);
		eventModel.setApproveStatus(false);

		service.addEventDetail(eventModel);
		attr.addAttribute("status","Event Added Successfully");
		return "redirect:/admin/admin_post";
	}

	@RequestMapping(value = "/admin_event_edit/{eventId}", method = RequestMethod.GET)
	public String showgAlumniEventEdit(@PathVariable int eventId, Model map, HttpSession hs) {
		System.out.println("show admin_event_edit form ");
		// invoke service layer method to add cust details
		EventsDetail event = service.getEventDetails(eventId);
		hs.setAttribute("eventData", event);
		map.addAttribute("eventModel", event);
		return "admin_event_edit";
	}

	@RequestMapping(value = "/admin_event_edit/{eventId}", method = RequestMethod.POST)
	public String processEventUpdateForm(@Valid @ModelAttribute("userModel") EventsDetail event, BindingResult res,
			HttpSession hs, Model map, RedirectAttributes attr) {

		System.out.println("in process update form " + event);
		if (res.hasErrors()) {
			System.out.println("admin_vacancies_edit P.L errs ");
			return "admin_event_edit";
		}
		System.out.println("admin_vacancies_edit : no p.l errs");
		try {

			EventsDetail eventSession = (EventsDetail) hs.getAttribute("eventData");
			// invoke service layer method for updation
			eventSession.setApproveStatus(true);
			eventSession.setEventDate(event.getEventDate());
			eventSession.setEventDescription(event.getEventDescription());
			eventSession.setEventName(event.getEventName());
			eventSession.setEventVenue(event.getEventVenue());

			hs.setAttribute("valid_event", service.updateEvent(eventSession));
			// added flash attribute
			attr.addAttribute("status", "Event Updated Successfully");
			// redirect after post pattern
			return "redirect:/admin/admin_post";
		} catch (Exception e) {
			res.rejectValue("email", "code", e.getMessage());
			return "admin_event_edit";
		}

		/*
		 * System.out.println("process_update " + cust);
		 * service.updateCustomer(cust); // redirect after post pattern return
		 * "redirect:/cust/list";
		 */
	}

	@RequestMapping(value = "/admin_vacancies_edit/{vacancyId}", method = RequestMethod.GET)
	public String showgAlumniVacanciesEdit(@PathVariable int vacancyId, Model map, HttpSession hs) {
		System.out.println("show admin_vacancies_edit form ");
		// invoke service layer method to add cust details
		VacanciesDetail vacancy = service.getVacancyDetails(vacancyId);
		hs.setAttribute("vacancyData", vacancy);
		// map.addAttribute("userModel", new UserDetail());//
		// System.out.println("in process goto gallary form " );
		map.addAttribute("userModel", vacancy);
		return "admin_vacancies_edit";
	}

	@RequestMapping(value = "/admin_vacancies_edit/{vacancyId}", method = RequestMethod.POST)
	public String processUpdateForm(@Valid @ModelAttribute("userModel") VacanciesDetail vacancy, BindingResult res,
			HttpSession hs, Model map, RedirectAttributes attr) {

		System.out.println("in process update form " + vacancy);
		if (res.hasErrors()) {
			System.out.println("admin_vacancies_edit P.L errs ");
			return "admin_vacancies_edit";
		}
		System.out.println("admin_vacancies_edit : no p.l errs");
		try {

			VacanciesDetail vacancySession = (VacanciesDetail) hs.getAttribute("vacancyData");
			// invoke service layer method for updation
			vacancySession.setApproveStatus(true);
			vacancySession.setVacancyCategory((vacancy.getVacancyCategory()));
			vacancySession.setVacancyCompany(vacancy.getVacancyCompany());
			vacancySession.setVacancyPosition(vacancy.getVacancyPosition());
			vacancySession.setVacancyDescription(vacancy.getVacancyDescription());
			vacancySession.setVacancyRequirements(vacancy.getVacancyRequirements());
			vacancySession.setVacancyLocation(vacancy.getVacancyLocation());
			vacancySession.setVacancyReqexp(vacancy.getVacancyReqexp());
			vacancySession.setVacancyExpiryDate(vacancy.getVacancyExpiryDate());
			vacancySession.setVacancyContact(vacancy.getVacancyContact());
			vacancySession.setVacancyDesignation(vacancy.getVacancyDesignation());
			vacancySession.setVacancyEmail(vacancy.getVacancyEmail());
			vacancySession.setVacancyPhone(vacancy.getVacancyPhone());

			hs.setAttribute("valid_cust", service.updateVacancy(vacancySession));
			// added flash attribute
			attr.addAttribute("status", "Vacancy Updated Successfully");
			// redirect after post pattern
			return "redirect:/admin/admin_post";
		} catch (Exception e) {
			res.rejectValue("email", "code", e.getMessage());
			return "admin_vacancies_edit";
		}

		/*
		 * System.out.println("process_update " + cust);
		 * service.updateCustomer(cust); // redirect after post pattern return
		 * "redirect:/cust/list";
		 */
	}

	@RequestMapping(value = "/admin_vacancies", method = RequestMethod.GET)
	public String showAdminVacancies(Model map, HttpSession hs) {
		UserDetail us = (UserDetail) hs.getAttribute("loggedInUserInfo");
		List<VacanciesDetail> userVacancies1 = service.listVacanciesDetail(us);
		List<VacanciesDetail> allVacancies1 = service.listAllVacancies();
		map.addAttribute("allVacancies_detail", allVacancies1);
		map.addAttribute("userVacancies_detail", userVacancies1);

		System.out.println("show admin_vacancies form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "admin_vacancies";
	}

	@RequestMapping(value = "/admin_contact", method = RequestMethod.GET)
	public String showAdminContact(Model map) {
		System.out.println("show admin_contact form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "admin_contact";
	}

	@RequestMapping(value = "/admin_logout", method = RequestMethod.GET)
	public String showAdminLogout(Model map, HttpSession hs) {
		System.out.println("show admin_logout form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());

		hs.invalidate();
		System.out.println("in process goto gallary form ");
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/admin_search", method = RequestMethod.GET)
	public String showAlumniSearch(Model map, HttpSession hs) {
		// AlumniDetail us = (AlumniDetail) hs.getAttribute("loggedInUserInfo");
		map.addAttribute("userModel", new AlumniDetail());

		return "admin_search";
	}

	@RequestMapping(value = "/admin_search", method = RequestMethod.POST)
	public String processalumni_search(@Valid @ModelAttribute("userModel") AlumniDetail userModel, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr, HttpSession hs) {

		if (res.hasErrors()) {
			System.out.println("update P.L errs " + userModel + "\n" + res.getAllErrors());
			return "admin_search";
		}
		System.out.println("update : no p.l errs");
		try {

			List<AlumniDetail> searchedUser = service.search(userModel.getUserFname(), userModel.getUserLname());

			if (searchedUser.isEmpty()) {
				map.addAttribute("Status", "No matching data found");
				return "admin_search";
			}
			attr.addAttribute("status", "Matching data found");
			map.addAttribute("search", searchedUser);
			System.out.println("in process search form success");
			return "admin_search";
		} catch (Exception e) {
			e.printStackTrace();
			return "admin_search";
		}
	}

	// **************code for search*************
	@RequestMapping(value = "alumni_profile_search/{id}", method = RequestMethod.POST)
	public String showSearchProfile(@PathVariable long id, Model map, HttpServletRequest request) {

		map.addAttribute("valid_user", request.getAttribute("searchUser"));
		map.addAttribute("valid_user", request.getAttribute("searchAlumniInfo"));
		return "alumni_profile_search";
	}

	// **************code for search*************
	@RequestMapping(value = "alumni_profile_search/{id}", method = RequestMethod.GET)
	public String showalumni_profile_search(@PathVariable long id, Model map, HttpServletRequest request) {
		AlumniDetail showUser = service.getAlumniDetails(id);
		map.addAttribute("valid_user", showUser);
		System.out.println("show alumni_dashboard form ");
		return "alumni_profile_search";
	}

	public void sendMail(String msg, String email) {
		String mailContent = msg;
		if (email != null) { // Get the session object
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				message.setSubject("Regarding Alumni Registration");
				message.setText(mailContent);

				// send message
				Transport.send(message);

				System.out.println("message sent successfully");
				// return "index";
			} catch (MessagingException e) {
				System.out.println("mail excep " + e.getMessage());
				// return "gallary";
			}

		} else // if record is not present for given email id
		{
			System.out.println("message not sent successfully");
		}
	}

}
