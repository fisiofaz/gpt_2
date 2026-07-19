package br.com.gtp.shared.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import br.com.gtp.shared.exception.BusinessException;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    /**
     * Valida se um objeto foi informado.
     */
    public static void validateRequired(Object value, String field) {

        if (value == null) {
            throw new BusinessException(field + " é obrigatório.");
        }

    }

    /**
     * Valida se uma String foi informada.
     */
    public static void validateRequired(String value, String field) {

        if (StringUtils.isNullOrBlank(value)) {
            throw new BusinessException(field + " é obrigatório.");
        }

    }

    /**
     * Valida números inteiros positivos.
     */
    public static void validatePositive(Integer value, String field) {

        if (value == null || value <= 0) {
            throw new BusinessException(field + " deve ser maior que zero.");
        }

    }

    /**
     * Valida números Long positivos.
     */
    public static void validatePositive(Long value, String field) {

        if (value == null || value <= 0) {
            throw new BusinessException(field + " deve ser maior que zero.");
        }

    }

    /**
     * Valida BigDecimal positivo.
     */
    public static void validatePositive(BigDecimal value, String field) {

        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException(field + " deve ser maior que zero.");
        }

    }

    /**
     * Valida e-mail.
     */
    public static void validateEmail(String email) {

        validateRequired(email, "E-mail");

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new BusinessException("E-mail inválido.");
        }

    }

    /**
     * Valida CEP (somente quantidade de dígitos).
     */
    public static void validateZipCode(String zipCode) {

        validateRequired(zipCode, "CEP");

        String cep = StringUtils.onlyNumbers(zipCode);

        if (cep.length() != 8) {
            throw new BusinessException("CEP inválido.");
        }

    }

    /**
     * Valida telefone (10 ou 11 dígitos).
     */
    public static void validatePhone(String phone) {

        validateRequired(phone, "Telefone");

        String numero = StringUtils.onlyNumbers(phone);

        if (numero.length() < 10 || numero.length() > 11) {
            throw new BusinessException("Telefone inválido.");
        }

    }

}