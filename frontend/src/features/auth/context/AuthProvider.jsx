import { useMemo, useState } from "react";

import AuthContext from "./AuthContext";
import AuthService from "@/features/auth/services/AuthService";

export default function AuthProvider({ children }) {
    const [isAuthenticated, setIsAuthenticated] = useState(
        () => AuthService.isAuthenticated()
    );

    const login = async (credentials) => {
        await AuthService.login(credentials);

        setIsAuthenticated(true);
    };

    const logout = () => {
        AuthService.logout();

        setIsAuthenticated(false);
    };

    const value = useMemo(
        () => ({
            isAuthenticated,
            login,
            logout,
        }),
        [isAuthenticated]
    );

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    );
}