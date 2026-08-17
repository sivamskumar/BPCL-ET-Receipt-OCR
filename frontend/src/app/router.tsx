import { createBrowserRouter } from 'react-router';

import AuthLayout from '../layouts/AuthLayout';
import AppLayout from '../layouts/AppLayout';
import LoginPage from '../features/auth/LoginPage';
import DashboardPage from '../features/dashboard/DashboardPage';
import CollectionsPage from '../features/collections/CollectionsPage';
import ReconciliationPage from '../features/reconciliation/ReconciliationPage';
import ShiftPage from '../features/shift/ShiftPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <AuthLayout />,
    children: [
      {
        index: true,
        element: <LoginPage />,
      },
      {
        path: 'login',
        element: <LoginPage />,
      },
    ],
  },
  {
    path: '/app',
    element: <AppLayout />,
    children: [
      {
        index: true,
        element: <DashboardPage />,
      },
      {
        path: 'dashboard',
        element: <DashboardPage />,
      },
      {
        path: 'shift',
        element: <ShiftPage />,
      },
      {
        path: 'collections',
        element: <CollectionsPage />,
      },
      {
        path: 'reconciliation',
        element: <ReconciliationPage />,
      },
    ],
  },
]);

export default router;