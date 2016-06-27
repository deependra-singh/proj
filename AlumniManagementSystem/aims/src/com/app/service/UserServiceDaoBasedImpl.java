package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojos.AlumniDetail;

import com.app.pojos.EventsDetail;
import com.app.pojos.AdminDetail;

import com.app.pojos.PostDetail;
import com.app.pojos.UserDetail;
import com.app.pojos.VacanciesDetail;

@Service("user_service")
// mandatory
@Transactional
// mandatory
public class UserServiceDaoBasedImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public UserDetail registerUser(UserDetail u) {
		return dao.registerUser(u);
	}

	@Override
	public UserDetail validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateUser(email, pass);
	}

	@Override
	public AlumniDetail registerAlumni(AlumniDetail a) {
		// TODO Auto-generated method stub
		return dao.registerAlumni(a);
	}

	@Override
	public UserDetail getUserDetails(String email) {
		// TODO Auto-generated method stub
		return dao.getUserDetails(email);
	}

	@Override
	public AlumniDetail getAlumniDetails(String email) {
		// TODO Auto-generated method stub
		return dao.getAlumniDetails(email);
	}

	@Override
	public AdminDetail getAdminDetails(String email) {
		// TODO Auto-generated method stub
		return dao.getAdminDetails(email);
	}

	@Override
	public UserDetail updateUser(UserDetail uu) {
		// TODO Auto-generated method stub
		UserDetail c = dao.updateUser(uu);// c --- PERSISTENT
		return c;
	}

	@Override
	public AlumniDetail updateAlumni(AlumniDetail user) {
		AlumniDetail c = dao.updateAlumni(user);// c --- PERSISTENT
		// persistent state in service method
		return c;
	}

	@Override
	public PostDetail addPost(PostDetail post) {

		return dao.addPost(post);
	}

	@Override
	public List<PostDetail> listPosts() {
		return dao.listPosts();
	}

	@Override
	public List<PostDetail> listUserPosts(String userEmail) {
		return dao.listUserPosts(userEmail);
	}

	@Override
	public VacanciesDetail addVacanciesDetail(VacanciesDetail vacanciesDetail) {
		return dao.addVacanciesDetail(vacanciesDetail);
	}

	@Override
	public List<VacanciesDetail> listVacanciesDetail(UserDetail userDetail) {
		return dao.listVacanciesDetail(userDetail);
	}

	@Override
	public List<VacanciesDetail> listAllVacancies() {
		// TODO Auto-generated method stub
		return dao.listAllVacancies();
	}

	@Override
	public VacanciesDetail getVacancyDetails(int vacancyId) {
		// TODO Auto-generated method stub
		return dao.getVacancyDetails(vacancyId);
	}

	@Override
	public VacanciesDetail updateVacancy(VacanciesDetail vacancy) {
		// TODO Auto-generated method stub
		return dao.updateVacancy(vacancy);
	}

	@Override
	public AdminDetail registerAdmin(AdminDetail admin) {
		// TODO Auto-generated method stub
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminDetail updateAdmin(AdminDetail adminDetailToBeModified) {
		// TODO Auto-generated method stub
		return dao.updateAdmin(adminDetailToBeModified);
	}

	@Override
	public List<AlumniDetail> getAllUnAproovedAlumnis() {
		return dao.getAllUnAproovedAlumnis();
	}

	@Override
	public AlumniDetail setAppprovedAlumni(String alumniEmail) {
		// TODO Auto-generated method stub
		return dao.setAppprovedAlumni(alumniEmail);
	}

	@Override
	public EventsDetail addEventDetail(EventsDetail eventModel) {
		// TODO Auto-generated method stub
		return dao.addEventDetail(eventModel);
	}

	@Override
	public List<EventsDetail> listEventDetail(UserDetail userDetail) {
		return dao.listEventDetail(userDetail);
	}

	@Override
	public List<EventsDetail> listAllEvents() {
		return dao.listAllEvents();
	}

	@Override
	public EventsDetail getEventDetails(int eventId) {
		// TODO Auto-generated method stub
		return dao.getEventDetails(eventId);
	}

	@Override
	public EventsDetail updateEvent(EventsDetail eventSession) {
		// TODO Auto-generated method stub
		return dao.updateEvent(eventSession);
	}

	@Override
	public List<AlumniDetail> search(String fname, String lname) {

		return dao.search(fname, lname);
	}

	// **************code for search*************
	@Override
	public AlumniDetail getAlumniDetails(long id) {
		return dao.getAlumniDetails(id);
	}

	@Override
	public String deleteAlumni(AlumniDetail alumni) {
		return dao.deleteAlumni(alumni);
	}

	@Override
	public String deleteVacancy(VacanciesDetail vacancy) {
		return dao.deleteVacancy(vacancy);
	}

	@Override
	public List<VacanciesDetail> getAllUnAproovedVacancies() {
		// TODO Auto-generated method stub
		return dao.getAllUnAproovedVacancies();
	}

	@Override
	public List<PostDetail> getAllUnAproovedPost() {
		// TODO Auto-generated method stub
		return dao.getAllUnAproovedPost();
	}

	@Override
	public PostDetail getPostDetails(int postId) {
		// TODO Auto-generated method stub
		return dao.getPostDetails(postId);
	}

	@Override
	public String deleteAPost(PostDetail post) {
		// TODO Auto-generated method stub
		return dao.deleteAPost(post);
	}

	@Override
	public PostDetail updatePost(PostDetail post) {
		// TODO Auto-generated method stub
		return dao.updatePost(post);
	}

	@Override
	public List<AdminDetail> getAllUnAproovedAdmin() {
		// TODO Auto-generated method stub
		return dao.getAllUnAproovedAdmin();
	}

	@Override
	public String deleteAdmin(AdminDetail admin) {
		// TODO Auto-generated method stub
		return dao.deleteAdmin(admin);
	}

	@Override
	public AdminDetail getAdminDetails(Long userId) {
		// TODO Auto-generated method stub
		return dao.getAdminDetails(userId);
	}

}
