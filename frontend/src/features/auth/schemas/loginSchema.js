import { z } from "zod";

const loginSchema = z.object({
    email: z
        .string()
        .email("Informe um e-mail válido."),

    password: z
        .string()
        .min(6, "A senha deve possuir no mínimo 6 caracteres."),
});

export default loginSchema;