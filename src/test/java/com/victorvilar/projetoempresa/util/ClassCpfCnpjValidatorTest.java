package com.victorvilar.projetoempresa.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClassCpfCnpjValidatorTest {


	//passing a valid cpf
	@Test
	public void checkIfIsValidTestSendingCpfAsParamMustReturnTrue() {
		Assertions.assertEquals(true, CpfCnpjValidator.checkIfIsValid("12525299701"));
	}
	
	//passing a valid cnpj
	@Test
	public void chechIfIsValidSendingCnpjAsParamMustReturnTrue() {
		Assertions.assertEquals(true, CpfCnpjValidator.checkIfIsValid("08454836000178"));
	}
	
	//passing a invalid cpf
	@Test
	public void checkIfIsValidWrongCpfMustReturnFalse() {
		Assertions.assertEquals(false, CpfCnpjValidator.checkIfIsValid("12525299700"));
	}
	
	//passing a invalid cnpj
	@Test
	public void checkIfIsValidWrongCnpjMustReturnFalse() {
		Assertions.assertEquals(false, CpfCnpjValidator.checkIfIsValid("08454836000170"));
	}
	
	@Test
	public void checkIfTheRightLenth() {
		Assertions.assertEquals(false,CpfCnpjValidator.checkIfIsValid("483600"));
	}
	
	@Test
	public void passingNotANumber() {
		Assertions.assertEquals(false,CpfCnpjValidator.checkIfIsValid("48ss31"));
	}
}
