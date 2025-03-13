package in.QuizHub.Services.Impl;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtService {
	 // Ensure this is a secure, long key(256 bits)
		private static final String SECRET_KEY_STRING = "token@#$%^&*7489654123mahstnxbgrtuh";
		
		private final Key SECRET_Key = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

		
		public String generateToken(String email) {
			
			String token = Jwts.builder()
					       .setSubject(email)
					       .setIssuedAt(new Date())
					       .setExpiration(new Date(System.currentTimeMillis()+1000*60*30)) 
					       .signWith(SECRET_Key)
					       .compact();
			System.out.println("Generated Token: "+token);
			return token;
		}


		public boolean validateToken(String token){
			try {
				Jwts.parserBuilder().setSigningKey(SECRET_Key).build().parseClaimsJws(token);
				return true;
			} catch (ExpiredJwtException e) {
				System.out.println("Token Expired : "+e.getMessage());
				return false;
			} catch (MalformedJwtException e) {
				System.out.println("Invalid JWT Token : "+e.getMessage());
				return false;
			} catch (UnsupportedJwtException e) {
				System.out.println("Jwt Token is UnSupported : "+e.getMessage());
				return false;
			} catch (JwtException e) {
				System.out.println("JwtException : "+e.getMessage());
				return false;
			}
			
		}
}
