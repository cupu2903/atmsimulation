package com.mitrais.ayr.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitrais.ayr.dto.ResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.mitrais.ayr.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);

		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		try {
			UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(req, res);
		} catch (ExpiredJwtException ex) {
			res.setStatus(HttpStatus.UNAUTHORIZED.value());
			res.setContentType("application/json");
			PrintWriter writer = res.getWriter();
			ResponseDto respDto = new ResponseDto();
			respDto.setRespCode("00");
			respDto.setMessage("Expired Login, please relogin");
			writer.write(new ObjectMapper().writeValueAsString(respDto));
			writer.flush();
		}

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		System.out.println("here");
		String token = request.getHeader(HEADER_STRING);
		if (token == null) {
			token = request.getParameter("access_token");
		}
		return auth(token);
	}

	public static UsernamePasswordAuthenticationToken auth(String token) {

		if (token != null) {
			// parse the token.
			Jws<Claims> jws = Jwts.parser().setSigningKey(SECRET.getBytes())
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
			String user = jws.getBody().getSubject();
                        System.out.println("user :"+user);
			Class<List<String>> clazz = (Class) List.class;
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			List<String> authorities = jws.getBody().get("authorities", clazz);
			authorities.forEach(authStr -> grantedAuthorities.add(new SimpleGrantedAuthority(authStr)));
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities);
			}
			return null;
		}
		return null;
	}
}