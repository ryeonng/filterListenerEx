package com.tenco.listeners;

import java.util.logging.Logger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * 세션이 생성될 때 / 감지될 때 HttpSessionListener 리스너 사용한다.
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

	private static final Logger logger = Logger.getLogger(MySessionListener.class.getName());
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("----------------------");
		// 세션 생성 시 실행 됨
		logger.info("새로운 세션이 생성 됨 : " + se.getSession().getId());
		se.getSession().setAttribute("loginTime", System.currentTimeMillis());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		
		// 세션 소멸 시 실행 됨
		Long loginTime = (Long) se.getSession().getAttribute("loginTime");
		// 세션 생성 시 실했했던 키 값을 동일하게 넣으면 생성했던 시간을 담을 수 있다.
		Long logoutTime = System.currentTimeMillis();
		
		if(loginTime != null) {
			
			Long sessionDurationMs = logoutTime - loginTime; // 밀리초 단위
			double sessionDurationSec = sessionDurationMs / 1000.0; // 초 단위로 변환
			System.out.println("세션 지속 시간 : " + sessionDurationSec);
		}
		
		System.out.println("-----------------------");
	}
}
