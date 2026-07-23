import { api } from "@/lib/api";
import { tokenStorage } from "../storage/tokenStorage";

class AuthService {
  async login(credentials) {
    try {
      const { data } = await api.post("/auth/login", credentials);

      tokenStorage.set(data.token);

      return data;
    } catch (error) {
      console.error("Erro ao fazer login:", error);
      throw error;
    }
  }

  logout() {
    tokenStorage.remove();
  }

  getToken() {
    return tokenStorage.get();
  }

  isAuthenticated() {
    return tokenStorage.has();
  }
}

export default new AuthService();