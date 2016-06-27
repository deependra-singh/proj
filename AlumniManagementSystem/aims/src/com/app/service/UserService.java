package com.app.service;

import com.app.pojos.AlumniDetail;
import com.app.pojos.EventsDetail;
import com.app.pojos.AdminDetail;

import com.app.pojos.PostDetail;
import com.app.pojos.UserDetail;
import com.app.pojos.VacanciesDetail;

import java.util.List;

public interface UserService {

    UserDetail validateUser(String email, String pass);

    UserDetail registerUser(UserDetail u);

    AlumniDetail registerAlumni(AlumniDetail a);

    UserDetail getUserDetails(String email);

    AlumniDetail getAlumniDetails(String email);

    AdminDetail getAdminDetails(String email);

    UserDetail updateUser(UserDetail uu);

    AlumniDetail updateAlumni(AlumniDetail user);

    PostDetail addPost(PostDetail post);

	List<PostDetail> listPosts();
	

	List<PostDetail> listUserPosts(String userEmail);

	List<VacanciesDetail> listVacanciesDetail(UserDetail userDetail);

	VacanciesDetail addVacanciesDetail(VacanciesDetail vacanciesDetail);

	List<VacanciesDetail> listAllVacancies();

	VacanciesDetail getVacancyDetails(int vacancyId);

	VacanciesDetail updateVacancy(VacanciesDetail vacancy);

	AdminDetail registerAdmin(AdminDetail admin);

	AdminDetail updateAdmin(AdminDetail adminDetailToBeModified);

	List<AlumniDetail> getAllUnAproovedAlumnis();

	AlumniDetail setAppprovedAlumni(String alumniEmail);

	EventsDetail addEventDetail(EventsDetail eventModel);

	List<EventsDetail> listEventDetail(UserDetail userDetail);

	List<EventsDetail> listAllEvents();

	EventsDetail getEventDetails(int eventId);

	EventsDetail updateEvent(EventsDetail eventSession);

	List<AlumniDetail> search(String fname, String lname);

	AlumniDetail getAlumniDetails(long id);

	
	PostDetail getPostDetails(int postId);
	
	String deleteAPost(PostDetail post);
	
	PostDetail updatePost(PostDetail post);

	String deleteAlumni(AlumniDetail alumni);

	String deleteVacancy(VacanciesDetail vacancy);

	List<VacanciesDetail> getAllUnAproovedVacancies();

	List<PostDetail> getAllUnAproovedPost();

	List<AdminDetail> getAllUnAproovedAdmin();

	String deleteAdmin(AdminDetail admin);

	AdminDetail getAdminDetails(Long userId);
}
