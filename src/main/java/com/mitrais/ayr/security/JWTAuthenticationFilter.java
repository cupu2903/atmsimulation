package com.mitrais.ayr.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitrais.ayr.dto.AccountDto;
import com.mitrais.ayr.dto.ReqLoginDto;
import com.mitrais.ayr.dto.ResponseDto;
import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.service.AccountService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.mitrais.ayr.security.SecurityConstants.HEADER_STRING;
import static com.mitrais.ayr.security.SecurityConstants.TOKEN_PREFIX;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
    private AuthenticationManager authenticationManager;
    private AccountService accountService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            String reqStr = IOUtils.toString(req.getReader());
            ReqLoginDto creds = new ObjectMapper().readValue(reqStr, ReqLoginDto.class);

            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(creds.getAccountNo(), creds.getPin()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        User user = (User) auth.getPrincipal();
        Account userDb = accountService.findByID(user.getUsername());
        String token = accountService.createToken(userDb);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType("application/json");
        PrintWriter writer = res.getWriter();
        AccountDto respDto = accountService.asUserDto(userDb.getAcctNo());
        writer.write(new ObjectMapper().writeValueAsString(respDto));
        writer.flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        // super.unsuccessfulAuthentication(request, response, failed);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        ResponseDto respDto = new ResponseDto();
        respDto.setMessage("Invalid User or Password");
        writer.write(new ObjectMapper().writeValueAsString(respDto));
        writer.flush();
    }
}