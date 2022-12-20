package com.safa.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	// extraire token du request de la requete et verifier son authenticite
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// declarer token
		String jwt = request.getHeader("Authorization");
		// test si pas de token,prefix bearer:transporteur
		if (jwt == null || !jwt.startsWith(SecParams.PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		// verfier l'authenticite du token (signature de l'algotithm).build:construire
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecParams.SECRET)).build();
		// enlever le préfixe Bearer du jwt
		jwt = jwt.substring(SecParams.PREFIX.length()); // longueur 7 caractères dans "Bearer "
		// decoder token
		DecodedJWT decodedJWT = verifier.verify(jwt);
		// extraire les infromation du token(claims) getsubject:username
		String username = decodedJWT.getSubject();
		// extraire les roles des utilisateurs
		List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
		// parcourir liste des roles grantedauthority type utlilisé par spring security
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String r : roles)
			authorities.add(new SimpleGrantedAuthority(r));
		// transmettre l'information:username,role a spring security =>mettre a jour le
		// contexte du spring security (null:password)
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null, authorities);
		// mettre a jour
		SecurityContextHolder.getContext().setAuthentication(user);
		// passe au filtre suivant
		filterChain.doFilter(request, response);
	}
}