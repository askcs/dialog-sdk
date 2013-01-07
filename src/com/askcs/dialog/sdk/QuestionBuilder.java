package com.askcs.dialog.sdk;


import java.util.logging.Logger;

import com.askcs.dialog.sdk.model.Answer;
import com.askcs.dialog.sdk.model.Question;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionBuilder {
	
	static final Logger log = Logger.getLogger(QuestionBuilder.class.getName());

	public static String build(Question question, String url) {
		
		String res="{}";
		if(question.getQuestion_id()==null || question.getQuestion_id().equals(""))
			return res;
		
		if(question.getQuestion_text()==null || question.getQuestion_text().equals(""))
			return res;
		
		String question_url = url+"/questions/";
		question.setBase_url(url);
		question.setQuestion_url(question_url+question.getQuestion_id());
		if(question.getQuestion_text().endsWith(".wav")) {
			if(question.getAnswers()!=null) {
				for(Answer answer : question.getAnswers()) {

					if(answer.getCallback()!=null)
						answer.setCallback(question_url+answer.getCallback());
				}
			}
		} else {
			question.setQuestion_expandedtext(question.getQuestion_text());
			question.setQuestion_text("text://"+question.getQuestion_text());
			
			if(question.getAnswers()!=null) {
				for(Answer answer : question.getAnswers()) {
					
					answer.setAnswer_expandedtext(answer.getAnswer_text());
					answer.setAnswer_text("text://"+answer.getAnswer_text());
					if(answer.getCallback()!=null)
						answer.setCallback(question_url+answer.getCallback());
				}
			}
		}
		
		ObjectMapper om = new ObjectMapper();
		try {
			res = om.writeValueAsString(question);
		} catch(Exception ex) {
			log.warning("Failed to parse next question");
		}
		return res;
	}
}
