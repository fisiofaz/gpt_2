import DashboardHeader from "../components/DashboardHeader";
import DashboardWelcome from "../components/DashboardWelcome";

export default function DashboardPage() {
    return (
        <div className="space-y-6">
            <DashboardHeader />
            <DashboardWelcome />
        </div>
    );
}