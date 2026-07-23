import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { zodResolver } from "@hookform/resolvers/zod";
import { toast } from "sonner";

import loginSchema from "../schemas/loginSchema";
import  useAuth  from "@/hooks/useAuth";

export default function LoginForm() {
    
    const { login } = useAuth();
    const navigate = useNavigate();
    
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginSchema),
        defaultValues: {
            email: "",
            password: "",
        },
    });

    async function onSubmit(data) {
        
        try {
            await login(data);
            toast.success("Login realizado com sucesso.");
            navigate("/dashboard",  {
            replace: true,
        });

        } catch (error) {
            if (error.response?.status === 401) {
                toast.error("E-mail ou senha inválidos.");
            } else if (error.response?.status === 403) {
                toast.error("Usuário sem permissão para acessar o sistema.");
            } else if (error.code === "ERR_NETWORK") {
                toast.error("Não foi possível conectar ao servidor.");
            } else {
                toast.error("Ocorreu um erro inesperado.");
            }

            console.error(error);
        }
    }

    return (
        <form 
            className="space-y-5"
            onSubmit={handleSubmit(onSubmit)}
        >

            <div>
                <label 
                className="mb-2 block text-sm font-medium text-slate-700"
                >
                    E-mail
                </label>
                <input
                    type="email"
                    placeholder="Digite seu e-mail"
                    className="w-full rounded-xl border border-slate-300 px-4 py-3 outline-none transition focus:border-blue-600 focus:ring-2 focus:ring-blue-200"
                    {...register("email")}
                />
                {errors.email && (
                    <p>{errors.email.message}</p>
                )}
            </div>

            <div>
                <label 
                    className="mb-2 block text-sm font-medium text-slate-700"
                >
                    Senha
                </label>
                <input
                    type="password"
                    placeholder="Digite sua senha"
                    className="w-full rounded-xl border border-slate-300 px-4 py-3 outline-none transition focus:border-blue-600 focus:ring-2 focus:ring-blue-200"
                    {...register("password")}
                />
                {errors.password && (
                    <p>{errors.password.message}</p>
                )}
            </div>

            <button
                type="submit"
                className="w-full rounded-xl bg-blue-600 py-3 font-semibold text-white transition hover:bg-blue-700"
            >
                Entrar
            </button>

        </form>
    );
}