import LoginForm from "../components/LoginForm";

export default function LoginPage() {
    return (
        <main className="min-h-screen bg-linear-to-br from-slate-100 via-blue-50 to-white flex items-center justify-center p-6">
            <div className="w-full max-w-md rounded-3xl border bg-white shadow-xl p-8">

                <div className="mb-8 text-center">

                    <div className="mx-auto mb-4 flex h-20 w-20 items-center justify-center rounded-full bg-blue-600 text-3xl font-bold text-white">
                        G
                    </div>

                    <h1 className="text-3xl font-bold text-slate-800">
                        GTP
                    </h1>

                    <p className="mt-2 text-slate-500">
                        Gestor de Territórios e Publicações
                    </p>

                </div>

                <LoginForm />

                <div className="mt-8 border-t pt-6 text-center text-sm text-slate-400">
                    Versão 1.0
                </div>

            </div>
        </main>
    );
}