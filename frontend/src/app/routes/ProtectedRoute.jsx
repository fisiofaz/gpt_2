import { Navigate, Outlet } from "react-router-dom";

import AuthService from "@/features/auth/services/AuthService";

export default function ProtectedRoute() {

    const isAuthenticated = AuthService.isAuthenticated();

    if (!isAuthenticated) {
        return <Navigate to="/" replace />;
    }

    return <Outlet />;
}