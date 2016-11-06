package br.com.pogamando.beanvalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import br.com.pogamando.validation.entity.Cliente;

public class ConditionHibernateValidatorTest {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private <T> void validate(T bean) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean);

		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
	
	/*
	 * Cliente Pessoa Física
	 */
	
	@Test(expected = ConstraintViolationException.class)
	public void clientePessoaFisicaVazio() {
		Cliente entity = new Cliente(null, "PF", null);
		validate(entity);
	}
	
	@Test
	public void clientePessoaFisicaCpfValido() {
		Cliente entity = new Cliente("Cliente CPF valido", "PF", "165.842.126-45");
		validate(entity);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void clientePessoaFisicaCpfInvalido() {
		Cliente entity = new Cliente("Cliente CPF invalido", "PF", "123.456.789-00");
		validate(entity);
	}
	
	/*
	 * Cliente Pessoa Jurídica
	 */
	
	@Test(expected = ConstraintViolationException.class)
	public void clientePessoaJuridicaVazio() {
		Cliente entity = new Cliente(null, "PJ", null);
		validate(entity);
	}
	
	@Test
	public void clientePessoaJuridicaCnpjValido() {
		Cliente entity = new Cliente("Cliente CNPJ valido", "PJ", "14.333.694/0001-93");
		validate(entity);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void clientePessoaJuridicaCnpjInvalido() {
		Cliente entity = new Cliente("Cliente CNPJ invalido", "PJ", "12.345.678/0001-09");
		validate(entity);
	}
	
}
