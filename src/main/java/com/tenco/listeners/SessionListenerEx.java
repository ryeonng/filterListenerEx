package com.tenco.listeners;

import java.util.logging.Logger;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListenerEx implements HttpSessionListener{

	private static final Logger logger = Logger.getLogger(SessionListenerEx.class.getName());
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 세션 생성 시 실행
		logger.info("새로운 세션 생셩 : " + se.getSession().getId());
		se.getSession().setAttribute("loginTime", System.currentTimeMillis());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {


		// 세션 소멸 시 실행 됨
		Long loginTime = (Long) se.getSession().getAttribute("loginTime");
		Long logoutTime = System.currentTimeMillis();
		
		if(loginTime != null) {
			
			Long sessionDurationMs = logoutTime - loginTime; // 밀리초 단위
			double sessionDurationSec = sessionDurationMs / 1000.0; // 초 단위로 변환
			System.out.println("세션 지속 시간 : " + sessionDurationSec);
		}
}
	}
