package br.com.uff.internships.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private String COORDINATOR_ROLE = "COORDINATOR";
	private String STUDENT_ROLE = "STUDENT";
	private String COMPANY_ROLE = "COMPANY";

	private String USER_PASSOWRD_QUERY = "select email, password, true from user where email=?";
	private String USER_ROLE_QUERY = "select email, \n" + "	case when s.enrollment_code is not null then 'STUDENT'\n"
			+ "	when c.cnpj is not null then 'COMPANY'\n" + "	when co.teacher_code is not null then 'COORDINATOR' \n"
			+ "	end as role \n" + "	from user u\n" + "	left join student s on s.id = u.id\n"
			+ "	left join company c on c.id = u.id\n" + "	left join coordinator co on co.id = u.id\n"
			+ "	where email=?";

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(USER_PASSOWRD_QUERY)
				.authoritiesByUsernameQuery(USER_ROLE_QUERY).passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/hello").usernameParameter("email").passwordParameter("password").permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/webjars/**");
	}
}
