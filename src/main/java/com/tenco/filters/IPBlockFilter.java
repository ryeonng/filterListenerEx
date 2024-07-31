package com.tenco.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * 1. Filter 구현
 * 2. URL 패턴 설정 (web.xml 파일에서 설정해 볼 예정)
 */
public class IPBlockFilter implements Filter {

	// 192.168.0.48 : 내 아이피
	// http://192.168.0.48:8080/fl/home
	// 차단할 IP 대역의 접두사
	private static final String BLOCKED_IP_PREFIX = "192.168.0.25";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("IPBlockFilter 초기화");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 서블릿으로 보내기 전 전처리 - 요청자의 IP 확인 (요청자의 정보는 request 객체 안에 담긴다.)
		String remoteIP = request.getRemoteAddr();
		System.out.println("Request from IP : " + remoteIP);
		
		// 차단 시킬 코드를 작성
		if(remoteIP.startsWith(BLOCKED_IP_PREFIX)) {
			System.out.println("차단할 IP가 여기서 걸림");
			response.setContentType("text/plain; charset=UTF-8");
			response.getWriter().println("Access Denied !");
			response.getWriter().println("통과할 수 없습니다.");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
