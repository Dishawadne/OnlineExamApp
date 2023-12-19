package com.thekiranacademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question 
{
	
		@Id
		int qno;
		
		String subject;
		
		String qtext,op1,op2,op3,op4,answer;

		public int getQno() {
			return qno;
		}

		public void setQno(int qno) {
			this.qno = qno;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getQtext() {
			return qtext;
		}

		public void setQtext(String qtext) {
			this.qtext = qtext;
		}

		public String getOp1() {
			return op1;
		}

		public void setOp1(String op1) {
			this.op1 = op1;
		}

		public String getOp2() {
			return op2;
		}

		public void setOp2(String op2) {
			this.op2 = op2;
		}

		public String getOp3() {
			return op3;
		}

		public void setOp3(String op3) {
			this.op3 = op3;
		}

		public String getOp4() {
			return op4;
		}

		public void setOp4(String op4) {
			this.op4 = op4;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		@Override
		public String toString() {
			return "Question [qno=" + qno + ", subject=" + subject + ", qtext=" + qtext + ", op1=" + op1 + ", op2="
					+ op2 + ", op3=" + op3 + ", op4=" + op4 + ", answer=" + answer + "]";
		}
		
		
		
		
		
		

}
