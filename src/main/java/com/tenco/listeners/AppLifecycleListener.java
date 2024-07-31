package com.tenco.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * 리스너 사용해보기 ServletContext 구현 어떠한 이벤트가 발생했을때 동작하는 트리거 > web.xml 파일과 어노테이션 기반으로
 * 설정가능
 */
public class AppLifecycleListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(AppLifecycleListener.class.getName());

	// 만들기
	private String timeFormat() {
		// yyyy-MM-dd HH:mm:ss
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(new Date());
	}
   
   // 애플케이션의 시작을 로그나 파일로 남겨야 될 상황에 사용한다 > 라고 가정
   @Override
   public void contextInitialized(ServletContextEvent sce) {
      System.out.println("---------------------------");
      logger.info("웹 애플리케이션 시작됨 >>>" + System.currentTimeMillis());
      System.out.println("---------------------------");
   
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce) {
      System.out.println("---------------------------");
      logger.info("웹 애플리케이션 종료됨 >>>" + System.currentTimeMillis());
      System.out.println("---------------------------");
   }

}
