import { AuthProvider } from "@/features/auth/context";

export default function AppProvider({ children }) {
    return (
        <AuthProvider>
            {children}
        </AuthProvider>
    );
}