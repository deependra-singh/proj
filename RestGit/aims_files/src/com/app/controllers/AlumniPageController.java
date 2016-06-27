package com.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.app.pojos.PostDetail;
import com.app.pojos.UserDetail;
import com.app.pojos.VacanciesDetail;
import com.app.service.UserService;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/alumni")
public class AlumniPageController {

	@Autowired
	@Qualifier("user_service")
	private UserService service;

	/***
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/alumni_dashboard", method = RequestMethod.GET)
	public String showgAlumniDashboard(Model map) {
		System.out.println("show alumni_dashboard form ");
		// invoke service layer method to add cust details
		List<EventsDetail> allEvents = service.listAllEvents();
		map.addAttribute("allevents_detail", allEvents);
		List<PostDetail> allpost = service.listPosts();
		List<VacanciesDetail> allVacancies = service.listAllVacancies();
		map.addAttribute("allVacancies_detail", allVacancies);
		map.addAttribute("allposts_detail", allpost);
		map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "alumni_dashboard";
	}

	@RequestMapping(value = "/alumni_gallary", method = RequestMethod.GET)
	public String showAlumniGallary(Model map) {
		System.out.println("show alumni_gallary form "); // invoke service layer
															// method to add
															// cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "alumni_gallary";
	}

	@RequestMapping(value = "/alumni_page", method = RequestMethod.GET)
	public String showAlumniPage(Model map) {
		System.out.println("show alumni_gallary form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto alumni_gallary form ");
		return "alumni_page";
	}

	/**
	 * Shows for for adding message(post)
	 *
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/alumni_post_add", method = RequestMethod.GET)
	public String showAlumniPostAdd(Model map, HttpServletRequest request) {
		System.out.println("show alumni_post_add form ");
		map.addAttribute("postModel", new PostDetail());
		System.out.println("in alumni_post_add ");
		return "alumni_post_add";
	}

	@RequestMapping(value = "/alumni_post_add", method = RequestMethod.POST)
	public String processAlumniPostAdd(@Valid @ModelAttribute("postModel") PostDetail post, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		if (res.hasErrors()) {
			System.out.println("alumni_post_add P.L errs " + post + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("alumni_post_add : no p.l errs");
		try {
			HttpSession session = request.getSession(false);
			UserDetail userDetail = (UserDetail) session.getAttribute("loggedInUserInfo");
			post.setPostSendDate(new Timestamp(new java.util.Date().getTime()));
			post.setPostFromName(userDetail.getUserEmail());
			post.setUserDetail(userDetail);
			post = service.addPost(post);
			attr.addAttribute("status", "Post Added Successfully");
			return "redirect:/alumni/alumni_post";
		} catch (Exception e) {
			System.out.println("in process post formin excep " + post);
			System.out.println("in process reg form " + e.getMessage());
			attr.addAttribute("status", "Post Add Failed");
			return "alumni_post";
		}
	}

	@RequestMapping(value = "/alumni_post", method = RequestMethod.GET)
	public String showAlumniPost(Model map, HttpSession hs) {
		System.out.println("show alumni_post form ");
		UserDetail us = (UserDetail) hs.getAttribute("loggedInUserInfo");

		List<PostDetail> userpost = service.listUserPosts(us.getUserEmail());
		map.addAttribute("userposts_detail", userpost);

		List<VacanciesDetail> userVacancies = service.listVacanciesDetail(us);
		map.addAttribute("userVacancies_detail", userVacancies);

		return "alumni_post";
	}

	@RequestMapping(value = "/alumni_profile_userinfo_edit", method = RequestMethod.GET)
	public String showAalumniProfileEdit(Model map, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		map.addAttribute("valid_user", session.getAttribute("loggedInUserInfo"));
		return "alumni_profile_edit";
	}

	@RequestMapping(value = "/alumni_profile_edit", method = RequestMethod.POST)
	public String processEditForm(@Valid @ModelAttribute("userModel") UserDetail userModel, BindingResult res,
			HttpServletRequest request, Model map, RedirectAttributes attr) {
		HttpSession session = request.getSession(false);
		if (res.hasErrors()) {
			System.out.println("alumni_profile_edit P.L errs " + userModel + "\n" + res.getAllErrors());
			return "alumni_profile";
		}
		System.out.println("register : no p.l errs");
		try {
			AlumniDetail alumniDetail = (AlumniDetail) session.getAttribute("loggedInUserInfo");
			// invoke service layer method for updation
			alumniDetail.setUserAddr(userModel.getUserAddr());
			alumniDetail.setUserFname(userModel.getUserFname());
			alumniDetail.setUserLname(userModel.getUserLname());
			alumniDetail.setUserMobile(userModel.getUserMobile());
			alumniDetail.setUserCity(userModel.getUserCity());
			alumniDetail.setUserCountry(userModel.getUserCountry());
			alumniDetail.setUserState(userModel.getUserState());
			alumniDetail.setUserDob(userModel.getUserDob());
			System.out.println("user after next button click from form" + alumniDetail);

			session.setAttribute("modifiedUserDetailInfo", alumniDetail);

			map.addAttribute("valid_user",alumniDetail);
			System.out.println("in process reg form success");
			return "alumni_profile_edit1";
		} catch (Exception e) {
			System.out.println("in process reg form " + e.getMessage());
			return "alumni_profile";
		}
	}

	@RequestMapping(value = "/alumni_profile_edit1", method = RequestMethod.POST)
	public String processAlumniProfileEditForm1(@Valid @ModelAttribute("alumniModel") AlumniDetail alumniModel,
			BindingResult res, HttpServletRequest request, Model map, RedirectAttributes attr) {
		HttpSession session = request.getSession(false);
		if (res.hasErrors()) {
			System.out.println("alumni_profile_edit1 P.L errs " + alumniModel + "\n" + res.getAllErrors());
			return "index";
		}
		System.out.println("alumni_profile_edit1 : no p.l errs");
		try {
			AlumniDetail alumniDetailToBeModified = (AlumniDetail) session.getAttribute("modifiedUserDetailInfo");
			alumniDetailToBeModified.setApproveStatus(true);
			alumniDetailToBeModified.setUserApproveStatus(1);
			alumniDetailToBeModified.setAlumniCourse(alumniModel.getAlumniCourse());
			alumniDetailToBeModified.setYearOfJoining(alumniModel.getYearOfJoining());
			alumniDetailToBeModified.setYearOfPassing(alumniModel.getYearOfPassing());
			alumniDetailToBeModified.setAlumniRoll(alumniModel.getAlumniRoll());

			AlumniDetail alumniDetail = service.updateAlumni(alumniDetailToBeModified);
			session.setAttribute("loggedInUserInfo", alumniDetail);//
			session.setAttribute("userId", alumniDetail.getUserId());
			attr.addAttribute("status", "Profile Updated Successfully");
			// redirect after post pattern -- redirected to cust list page.
			System.out.println("in process alumni_profile_edit1 form success");
			return "redirect:/alumni/alumni_profile";
		} catch (Exception e) {
			System.out.println("exception in alumni_profile_edit1 post method " + alumniModel + e.getMessage());
			e.printStackTrace();
			attr.addAttribute("status", "Profile Update Failed");
			return "alumni_profile";
		}
	}

	@RequestMapping(value = "/alumni_profile", method = RequestMethod.GET)
	public String showAlumniProfile(Model map, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		map.addAttribute("valid_user", session.getAttribute("loggedInUserInfo"));
		System.out.println("show alumni_profile form ");
		return "alumni_profile";
	}

	@RequestMapping(value = "/alumni_vacancies_add", method = RequestMethod.GET)
	public String showAlumniVacanciesAdd(Model map) {
		System.out.println("show alumni_vacancies_add form ");
		map.addAttribute("vacancyModel", new VacanciesDetail());
		return "alumni_vacancies_add";
	}

	@RequestMapping(value = "/alumni_vacancies_add", method = RequestMethod.POST)
	public String processAddVacancies(@Valid @ModelAttribute("vacancyModel") VacanciesDetail vacancyModel,
			BindingResult result, Model map, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("show alumni_vacancies_add form ");

		if (result.hasErrors()) {
			System.out.println("errors in alumni_vacancies_add suibmit" + result);
			return "index";
		}
		System.out.println("vacancyDetails-->" + vacancyModel);
		HttpSession session = request.getSession(false);
		AlumniDetail alumniDetail = (AlumniDetail) session.getAttribute("loggedInUserInfo");
		vacancyModel.setVacancyCreateDate(new Timestamp(new java.util.Date().getTime()));
		vacancyModel.setUserDetail(alumniDetail);
		service.addVacanciesDetail(vacancyModel);
		attr.addAttribute("status", "Vacancy Added Successfully");
		return "redirect:/alumni/alumni_post";
	}

	@RequestMapping(value = "/alumni_vacancies_edit/{vacancyId}", method = RequestMethod.GET)
	public String showAlumniVacanciesEdit(@PathVariable int vacancyId, Model map, HttpSession hs) {
		System.out.println("show alumni_vacancies_edit form ");
		// invoke service layer method to add cust details
		VacanciesDetail vacancy = service.getVacancyDetails(vacancyId);
		hs.setAttribute("vacancyData", vacancy);
		// map.addAttribute("userModel", new UserDetail());//
		// System.out.println("in process goto gallary form " );
		map.addAttribute("userModel", vacancy);
		return "alumni_vacancies_edit";
	}

	@RequestMapping(value = "/alumni_vacancies_edit/{vacancyId}", method = RequestMethod.POST)
	public String processUpdateForm(@Valid @ModelAttribute("userModel") VacanciesDetail vacancy, BindingResult res,
			HttpSession hs, Model map, RedirectAttributes attr) {

		System.out.println("in process alumni_vacancies_edit form " + vacancy);
		if (res.hasErrors()) {
			System.out.println("alumni_vacancies_edit P.L errs ");
			return "alumni_vacancies_edit";
		}
		System.out.println("alumni_vacancies_edit : no p.l errs");
		try {

			VacanciesDetail vacancySession = (VacanciesDetail) hs.getAttribute("vacancyData");
			// invoke service layer method for updation
			vacancySession.setApproveStatus(false);
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
			return "redirect:/alumni/alumni_post";
		} catch (Exception e) {
			res.rejectValue("email", "code", e.getMessage());
			attr.addAttribute("status", "Vacancy Update Failed");
			return "alumni_post";
		}

	}

	@RequestMapping(value = "/alumni_vacancies", method = RequestMethod.GET)
	public String showAlumniVacancies(Model map, HttpSession hs) {
		AlumniDetail us = (AlumniDetail) hs.getAttribute("loggedInUserInfo");
		List<VacanciesDetail> userVacancies = service.listVacanciesDetail(us);
		List<VacanciesDetail> allVacancies = service.listAllVacancies();
		map.addAttribute("allVacancies_detail", allVacancies);
		map.addAttribute("userVacancies_detail", userVacancies);

		System.out.println("show alumni_vacancies form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto alumni_vacancies form ");
		return "alumni_vacancies";
	}

	@RequestMapping(value = "/alumni_contact", method = RequestMethod.GET)
	public String showAlumniContact(Model map) {
		System.out.println("show alumni_dashboard form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());
		System.out.println("in process goto gallary form ");
		return "alumni_contact";
	}

	@RequestMapping(value = "/alumni_logout", method = RequestMethod.GET)
	public String showAlumniLogout(Model map, HttpSession hs) {
		System.out.println("show alumni_logout form ");
		// invoke service layer method to add cust details
		// map.addAttribute("userModel", new UserDetail());

		hs.invalidate();
		System.out.println("in process goto gallary form ");
		return "redirect:/user/index";
	}
}
