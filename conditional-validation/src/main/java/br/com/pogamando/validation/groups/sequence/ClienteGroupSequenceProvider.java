package br.com.pogamando.validation.groups.sequence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.pogamando.validation.entity.Cliente;
import br.com.pogamando.validation.groups.PessoaFisica;
import br.com.pogamando.validation.groups.PessoaJuridica;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

	public List<Class<?>> getValidationGroups(Cliente entity) {
		List<Class<?>> groups = new ArrayList<>();
		
		/*
		 * Informamos ao HibernateValidator para usar as validações default
		 * definidas na classe Cliente.
		 */
		groups.add(Cliente.class);
		
		if (entity != null) {
			/*
			 * Aqui nós implementamos a lógica que determina o grupo de
			 * validação a ser aplicado ao bean.
			 */
			if ("PF".equalsIgnoreCase(entity.getTipo())) {
				groups.add(PessoaFisica.class);
			} else if ("PJ".equalsIgnoreCase(entity.getTipo())) {
				groups.add(PessoaJuridica.class);
			}
		}
		
		return groups;
	}

}
