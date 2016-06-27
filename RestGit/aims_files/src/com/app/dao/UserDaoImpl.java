package com.app.dao;

import com.app.pojos.AlumniDetail;

import com.app.pojos.EventsDetail;
import com.app.pojos.AdminDetail;

import com.app.pojos.PostDetail;
import com.app.pojos.UserDetail;
import com.app.pojos.VacanciesDetail;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	// dependency factory

	@Autowired
	private SessionFactory factory;

	@Override
	public UserDetail registerUser(UserDetail u) {
		factory.getCurrentSession().save(u);
		return u;
	}

	@Override
	public UserDetail validateUser(String email, String pass) {
		// TODO Auto-generated method stubreturn (Customer) factory
		return (UserDetail) factory.getCurrentSession()
				.createQuery("select c from UserDetail c where c.userEmail = :em and c.userPassword = :pass")
				.setParameter("em", email).setParameter("pass", pass).uniqueResult();
	}

	@Override
	public AlumniDetail registerAlumni(AlumniDetail a) {
		factory.getCurrentSession().save(a);
		return a;
	}

	public UserDetail getUserDetails(String email) {
		// TODO Auto-generated method stub
		return (UserDetail) factory.getCurrentSession()
				.createQuery("select c from UserDetail c where c.userEmail = :em ").setParameter("em", email)
				.uniqueResult();
	}

	public AlumniDetail getAlumniDetails(String email) {
		// TODO Auto-generated method stub
		return (AlumniDetail) factory.getCurrentSession()
				.createQuery("select c from AlumniDetail c where c.alumniEmail = :em ").setParameter("em", email)
				.uniqueResult();
	}

	public AdminDetail getAdminDetails(String email) {
		// TODO Auto-generated method stub
		return (AdminDetail) factory.getCurrentSession()
				.createQuery("select c from AdminDetail c where c.adminEmail = :em ").setParameter("em", email)
				.uniqueResult();
	}

	@Override
	public UserDetail updateUser(UserDetail uu) {
		System.out.println("in dao " + uu);
		// accept detached cust pojo & rets persistent
		factory.getCurrentSession().merge(uu);
		return uu;// rets persistent
	}

	@Override
	public AlumniDetail updateAlumni(AlumniDetail user) {
		System.out.println("in dao " + user);
		// accept detached cust pojo & rets persistent
		factory.getCurrentSession().update(user);
		System.out.println("in dao updated" + user);
		return user;// rets persistent
	}

	@Override
	public PostDetail addPost(PostDetail post) {
		factory.getCurrentSession().save(post);
		return post;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostDetail> listPosts() {
		return factory.getCurrentSession()
				.createQuery("select c from PostDetail c where c.approveStatus=true order by c.postSendDate desc")
				.list();
		// .getNamedQuery("PostDetail.findAll").list();
	}

	@SuppressWarnings("unchecked")
	public List<PostDetail> listUserPosts(String userEmail) {
		return factory.getCurrentSession()
				.createQuery("select c from PostDetail  c  where c.postFromName = :em order by c.postSendDate desc")
				.setParameter("em", userEmail).list();
		// .getNamedQuery("PostDetail.findAll").list();
	}

	@Override
	public VacanciesDetail addVacanciesDetail(VacanciesDetail vacanciesDetail) {
		factory.getCurrentSession().save(vacanciesDetail);
		return vacanciesDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VacanciesDetail> listVacanciesDetail(UserDetail userDetail) {
		return factory.getCurrentSession().getNamedQuery("listVacanciesDetailByUser")
				.setEntity("userDetail", userDetail).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VacanciesDetail> listAllVacancies() {
		return factory.getCurrentSession().getNamedQuery("VacanciesDetail.findAll").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventsDetail> listEventDetail(UserDetail userDetail) {
		return factory.getCurrentSession().getNamedQuery("listEventsDetailByUser").setEntity("userDetail", userDetail)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventsDetail> listAllEvents() {
		return factory.getCurrentSession().getNamedQuery("EventsDetail.findAll").list();
	}

	@Override
	public VacanciesDetail getVacancyDetails(int vacancyId) {
		// TODO Auto-generated method stub
		return (VacanciesDetail) factory.getCurrentSession().get(VacanciesDetail.class, vacancyId);
	}

	@Override
	public VacanciesDetail updateVacancy(VacanciesDetail vacancy) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().update(vacancy);

		return vacancy;
	}

	@Override
	public AdminDetail registerAdmin(AdminDetail admin) {
		factory.getCurrentSession().save(admin);
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AlumniDetail> getAllUnAproovedAlumnis() {
		return factory.getCurrentSession().createQuery("select c from AlumniDetail  c  where c.approveStatus = :em")
				.setParameter("em", false).list();

	}

	@Override
	public AlumniDetail setAppprovedAlumni(String alumniEmail) {
		// TODO Auto-generated method stub
		AlumniDetail a = (AlumniDetail) factory.getCurrentSession()
				.createQuery("select c from AlumniDetail  c  where c.alumniEmail = :em").setParameter("em", alumniEmail)
				.uniqueResult();
		a.setApproveStatus(true);
		factory.getCurrentSession().update(a);
		return a;
	}

	@Override
	public EventsDetail addEventDetail(EventsDetail eventModel) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().save(eventModel);
		return eventModel;
	}

	@Override
	public EventsDetail getEventDetails(int eventId) {
		// TODO Auto-generated method stub
		return (EventsDetail) factory.getCurrentSession().get(EventsDetail.class, eventId);
	}

	@Override
	public EventsDetail updateEvent(EventsDetail eventSession) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().merge(eventSession);
		return null;
	}

	// **************code for search*************
	@Override
	@SuppressWarnings("unchecked")
	public List<AlumniDetail> search(String fname, String lname) {

		return factory.getCurrentSession()
				.createQuery("select c from UserDetail c where c.userFname = :fnm or c.userLname = :lnm")
				.setParameter("fnm", fname).setParameter("lnm", lname).list();
	}

	// **************code for search*************
	@Override
	public AlumniDetail getAlumniDetails(long id) {
		return (AlumniDetail) factory.getCurrentSession()
				.createQuery("select c from AlumniDetail c where c.userId = :id ").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public String deleteAlumni(AlumniDetail alumni) {

		if (alumni != null)
			factory.getCurrentSession().delete(alumni);
		return "AlumniDetail " + alumni.getUserEmail() + "Un approoved";
	}

	@Override
	public String deleteVacancy(VacanciesDetail vacancy) {

		if (vacancy != null)
			factory.getCurrentSession().delete(vacancy);
		return "AlumniDetail " + vacancy.getVacancyCompany() + "not approoved";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VacanciesDetail> getAllUnAproovedVacancies() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().createQuery("select c from VacanciesDetail  c  where c.approveStatus = :em")
				.setParameter("em", false).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostDetail> getAllUnAproovedPost() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().createQuery("select c from PostDetail  c  where c.approveStatus=false")
				.list();

	}

	@Override
	public PostDetail getPostDetails(int postId) {
		// TODO Auto-generated method stub
		return (PostDetail) factory.getCurrentSession().get(PostDetail.class, postId);
	}

	@Override
	public String deleteAPost(PostDetail post) {
		if (post != null)
			factory.getCurrentSession().delete(post);
		return "AlumniDetail " + post.getPostFromName() + "Un approoved";
	}

	@Override
	public PostDetail updatePost(PostDetail post) {
		// TODO Auto-generated method stub
		System.out.println("in dao " + post);
		// accept detached cust pojo & rets persistent
		factory.getCurrentSession().update(post);
		System.out.println("in dao updated" + post);

		return post;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminDetail> getAllUnAproovedAdmin() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().createQuery("select c from AdminDetail  c  where c.approveStatus=false")
				.list();
	}

	@Override
	public String deleteAdmin(AdminDetail admin) {
		if (admin != null)
			factory.getCurrentSession().delete(admin);
		return "AdminDetail " + admin.getUserEmail() + "Un approoved";
	}

	@Override
	public AdminDetail getAdminDetails(Long userId) {
		// TODO Auto-generated method stub
		return (AdminDetail) factory.getCurrentSession()
				.createQuery("select f from AdminDetail f where f.userId = :id ").setParameter("id", userId)
				.uniqueResult();
	}

	public AdminDetail updateAdmin(AdminDetail admin) {
		System.out.println("in dao " + admin);
		// accept detached cust pojo & rets persistent
		factory.getCurrentSession().update(admin);
		System.out.println("in dao updated" + admin);
		return admin;// rets persistent
	}

}
