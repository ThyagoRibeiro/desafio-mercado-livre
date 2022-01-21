package br.com.mercado_livre.desafio.unittests.adapters.http.rest.v1.validators;

import br.com.mercado_livre.desafio.adapters.http.v1.validators.UUIDValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UUIDValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    public void is_valid_retorna_true() {
        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";
        UUIDValidator uuidValidator = new UUIDValidator();
        boolean valid = uuidValidator.isValid(idPedido, constraintValidatorContext);
        assertEquals(true, valid);
    }

    @Test
    public void is_valid_retorna_false() {
        String idPedido = "1";
        UUIDValidator uuidValidator = new UUIDValidator();
        boolean valid = uuidValidator.isValid(idPedido, constraintValidatorContext);
        assertEquals(false, valid);
    }

}
