import { Routes, Route } from 'react-router-dom';

import LoginPage from '@/features/auth/pages/LoginPage';
import DashboardPage from "@/features/dashboard/pages/DashboardPage";
import AppLayout from "@/app/layouts/AppLayout";

import ProtectedRoute from "./ProtectedRoute";

export default function AppRoutes() {
  return (
    <Routes>
      <Route
        path="/"
        element={<LoginPage />}
      />

      <Route
        element={<ProtectedRoute />}
      >
        <Route element={<AppLayout />}>

          <Route
            path="/dashboard"
            element={<DashboardPage />}
          />
          
        </Route>
        
      </Route>
      
    </Routes>
  );
}