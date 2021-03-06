package com.jbarragan.jcastro.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jbarragan.jcastro.dao.PostDAO;
import com.jbarragan.jcastro.dto.ContactDTO;
import com.jbarragan.jcastro.dto.PostDTO;
import com.jbarragan.jcastro.util.Constant;

@Controller("index")
@Scope("session")
public class IndexController implements Serializable {

	/**
    * 
    */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PostDAO postDAO;

	private ArrayList<PostDTO> listPost;

	private PostDTO selectPost;

	private String textEdit;

	private String tituloWhere;

	private ArrayList<String> listMessage;

	private ArrayList<ContactDTO> contacts;

	private String editor;

	@PostConstruct
	private void initialize() throws IOException {
		this.textEdit = "";
		this.tituloWhere = "�DONDE PUTAS ESTAMOS?";
		this.listMessage = new ArrayList<String>();
		this.listMessage
				.add("Para la mayor�a de las cosas importantes, el momento siempre es p�simo.");
		this.listMessage
				.add("�Est�s esperando un buen momento para dejar tu trabajo? Las estrellas nunca se alinear�n y los sem�foros de la vidad nunca se pondr�n todos verdes al mismo tiempo. El universo no conspira contra ti, pero tampoco se volver� loco para apartarte obst�culos del camino. Las condiciones nunca ser�n las ideales. <<Alg�n d�a>> es  listas de pros y contras tampoco ayuda.");
		this.listMessage
				.add("Si algo es importante para ti y quieres hacerlo <<alg�n d�a>>, hazlo y corrige el rumbo mientras caminas.");
		this.contacts = new ArrayList<ContactDTO>();
		this.contacts.add(new ContactDTO("Juli�n Barrag�n Verano",
				"julbarg@gmail.com"));
		this.contacts.add(new ContactDTO("Johnatan Felipe Castro",
				"johntcastro@gmail.com"));
		loadPost();
		loadSelect();
		editor = "dfskdfj jakslfjslkfj lkfsjlksjfdlkj kljlkfjlaskjf lkjflkjsalkfj alksjfkljsaflkj kajsfl�kjsaf�lk�j lkajflkasjfklsja klasjflkjaslkfj kslfjsklajflksj lkasjflkasjflkjsa aksljlkfjsalkjflkjsf�lk�j klsjfl�kasjlfkjsa lkfjlaskjfl�kjasl klfsjlk�jfkljsal�kfj klfjsal�kjfl{ksajlkfjas lkjsfakljslkfjlksaj kljfslkjsalkjfl kjl�kfjlkjsalk jflk�sajlk jflk�saj lkfjlksajf kaljf klj lk�j lk jlkfjlksajflkjs alkjflkjsflkj salkjf a�klfj lkjsflkjs alkjflkjsaklfjsa kljfklsajflkjsalkjf sklfjlksajklfjlaskjfs jlksfjkljaf�lkjasklfja lksajflkjsalfkjsalkjf lksajf�lk jsalkfjlks lkfjl�kasjflkjsalkj lkfjsalkfjlk�asjfkljsa klfjaskljf�lksjaf�lkj lksafjlksjaf�lkjaslk flskjalkfjlkasjfl�k l�sfkj�lkjasf�lkj l�sakjas�lkfj�klsajf �lkajsflkjaslkfja lkafsjlkasjflkjas lkajflksajlkfjlks lkfjlaksjflkjslk lkjflksajflkjs lkjsflkasjlkj lkjflkjsalfkjasklj kljfslkjflkjsalkf lksfjl kjfl kjsaflkj flkj kljsflk jlsakfj lkjlkjf flkasj flkjfslkjlkj �lkj fkljslkfj lkf sjlkasj lkfjsklajfl kjsl kjkl j�lkjf lkajsf&nbsp;<img src='http://www.dgadmin.com.ar/images/Claro-2.gif' style='float:left;'>fasflaslf�kj kasfjlkasjfl�kjsalkfj lkjals kjfl�ksajl�kj ljflskjal�kf jslkj lkjf l�kj l�kjf�lkjf alkj aflkjalk fjalkf jlkjs flaksj lk jslkaj SLKJslkjSOIETIOWEUT OIGDKSJGLKSJkjgs�lkdjgl�kj kljg lkdjgl�k jglkj l�kgdj�k ljgflkj lkfgjlkfglkjfd lkjlfgkjkgljlkfgj�lkgd kljgk�l jsd�glkjsg �lkjdf lkj lkfj gl�kjg lkjf kljdglk jdglk jfglkjsd lkdsjg �klsj dlkgj�lkjd�lkjkl kljglkj kljgl kfgklgjl kgj�dlgk jlkj g�kl klgk gf �k�gkg�k lkjglkjdf�kgljdgkjdg�dkl� jgl�kjg�lk jg�lkjg�lkjg lkjg�lkjd�glk j�jlkg";

	}

	private void loadSelect() {
		selectPost = new PostDTO();
	}

	private void loadPost() {
		try {
			PostDTO post;
			listPost = new ArrayList<PostDTO>();
			for (int i = 0; i < 8; i++) {
				post = new PostDTO();
				post.setTitle(i + ". TITLE ARTICLE");
				post.setSubtitle("Subtitle of Aticle... Details or Resume about Story, no more than 30 words");
				post.setCityFrom("Cali, Colombia");
				post.setCityTo("Popayan, Colombia");
				post.setDescription("Lorem Ipsum is simply dummy text "
						+ "of the printing and typesetting industry. Lorem Ipsum has been "
						+ "the industry's standard dummy text ever since the 1500s.");
				post.setDate("10 de enero de 2015");
				String urlImg = getURLImag("trujillo.jpg");

				post.setImage("background-image:url('" + urlImg + "');");
				listPost.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getURLImag(String img) {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String url = origRequest.getRequestURL().toString();
		int index = url.indexOf(Constant.PATH_NAME_APPLICATION)
				+ Constant.PATH_NAME_APPLICATION.length();
		url = url.substring(0, index);

		String urlImg = url + "resources/img/" + img;

		return urlImg;
	}

	public String goPost() {
		return "/pages/post.xhtml?faces-redirect=true";
	}

	public String getTextEdit() {
		return textEdit;
	}

	public void setTextEdit(String textEdit) {
		this.textEdit = textEdit;
	}

	public ArrayList<PostDTO> getListPost() {
		return listPost;
	}

	public void setListPost(ArrayList<PostDTO> listPost) {
		this.listPost = listPost;
	}

	public String getTituloWhere() {
		return tituloWhere;
	}

	public void setTituloWhere(String tituloWhere) {
		this.tituloWhere = tituloWhere;
	}

	public ArrayList<String> getListMessage() {
		return listMessage;
	}

	public void setListMessage(ArrayList<String> listMessage) {
		this.listMessage = listMessage;
	}

	public ArrayList<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<ContactDTO> contacts) {
		this.contacts = contacts;
	}

	public PostDTO getSelectPost() {
		return selectPost;
	}

	public void setSelectPost(PostDTO selectPost) {
		this.selectPost = selectPost;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}
