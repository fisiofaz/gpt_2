import React from 'react';
import ReactDOM from 'react-dom/client';

import { BrowserRouter } from "react-router-dom";
import { Toaster } from "sonner";

import "@/styles/globals.css";

import App from './App';
import AppProvider from "@/app/providers";

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <AppProvider>
      <BrowserRouter>

            <Toaster
                richColors
                position="top-right"
                closeButton
                duration={3000}
            />

            <App />

        </BrowserRouter>
    </AppProvider>
  </React.StrictMode>
);