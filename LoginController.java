package com.thekiranacademy.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.thekiranacademy.dao.QuestionDAO;
import com.thekiranacademy.entity.Answer;
import com.thekiranacademy.entity.Question;
import com.thekiranacademy.entity.User;

@Controller
public class LoginController 
{
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	QuestionDAO dao;
	
	// localhost:8080
		@RequestMapping("/")
		public String login()
		{
			return "login";
		}
		
		
		@RequestMapping("validate")
		public ModelAndView validate(String username,String password,String subject,HttpServletRequest request)
		{
			
			ModelAndView modelAndView = new ModelAndView();
						
			System.out.println(request.getMethod());
			
			System.out.println(username + " " + password);// nikita abc
						
			Session session=factory.openSession();
			
			User userFromDB=session.get(User.class,username);
			
			//userFromDB==> [ username='nikita' password='xyz' emailid='d@jk.com' imagepath=1.jpg ] User class's object having data from database
			
			if(userFromDB==null)
			{
				modelAndView.setViewName("login");
				
				modelAndView.addObject("message","username wrong");
				
			}
			
			else if(password.equals(userFromDB.getPassword()))
			{
				modelAndView.setViewName("question");
//				modelAndView.addObject("imagepath",userFromDB.getImagepath());
				
				List<Question> list=dao.getAllQuestions(subject);
				
				Question question=list.get(0);
						

				HttpSession httpsession=request.getSession();

				httpsession.setAttribute("question", question);
				httpsession.setAttribute("imagepath",userFromDB.getImagepath());

				httpsession.setAttribute("questions",list);

				httpsession.setAttribute("qno",0);
				
				httpsession.setAttribute("score",0);
				
				
				HashMap<Integer,Answer>  hashmap=new HashMap<Integer, Answer>();
				
				httpsession.setAttribute("submittedDetails",hashmap);
				
				
			}
			
			else
			{
				
				modelAndView.setViewName("login");
				
				modelAndView.addObject("message","password wrong");
			
			}
			
			
			return modelAndView;
			
		}
		
		@RequestMapping("register")
		public String register()
		{
			return "register";
		}
		
		

		@RequestMapping("saveToDB")
		public ModelAndView saveToDB(User user,HttpServletRequest request) throws Exception
		{
			
			
			Session session=factory.openSession();
			
			Transaction tx=session.beginTransaction();
				
				user.setImagepath("/images/" + user.getImage().getOriginalFilename());
				
				session.save(user);
			
			tx.commit();
			
			
			// image uploading code
			
			MultipartFile image=user.getImage();
			
			String foldername=request.getServletContext().getRealPath("/images");
			
			image.transferTo(new File(foldername, image.getOriginalFilename()));
			
			
			ModelAndView modelAndView = new ModelAndView();
			
			modelAndView.setViewName("login");
			
			modelAndView.addObject("message","registration successful");
			
			return modelAndView;
		}
		
		
}
