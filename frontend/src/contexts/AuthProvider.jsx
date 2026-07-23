import { useState } from "react";

import AuthContext from "./AuthContext";
import AuthService from "@/features/auth/services/AuthService";

export default function AuthProvider({ children }) {

    const [isAuthenticated, setIsAuthenticated] = useState(
        () => AuthService.isAuthenticated()
    );

    const [loading] = useState(false);

    async function login(credentials) {
        await AuthService.login(credentials);
        setIsAuthenticated(true);
    }

    function logout() {
        AuthService.logout();
        setIsAuthenticated(false);
    }

    return (
        <AuthContext.Provider
            value={{
                isAuthenticated,
                loading,
                login,
                logout,
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}