import { createBrowserRouter } from 'react-router';

import AuthLayout from '../layouts/AuthLayout';
import AppLayout from '../layouts/AppLayout';
import LoginPage from '../features/auth/LoginPage';
import DashboardPage from '../features/dashboard/DashboardPage';
import CollectionsPage from '../features/collections/CollectionsPage';
import ReconciliationPage from '../features/reconciliation/ReconciliationPage';
import ShiftPage from '../features/shift/ShiftPage';
import PrototypePage from '../features/common/PrototypePage';

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
	  {
	    path: 'receipts',
	    element: <PrototypePage title="Receipts / OCR" />,
	  },
	  {
	    path: 'reviews/pending',
	    element: <PrototypePage title="Pending Reviews" />,
	  },
	  {
	    path: 'reviews/history',
	    element: <PrototypePage title="Review History" />,
	  },
	  {
	    path: 'approvals/pending',
	    element: <PrototypePage title="Pending Approvals" />,
	  },
	  {
	    path: 'approvals/history',
	    element: <PrototypePage title="Approval History" />,
	  },
	  {
	    path: 'reports',
	    element: <PrototypePage title="Reports" />,
	  },
	  {
	    path: 'admin/organization',
	    element: <PrototypePage title="Organization" />,
	  },
	  {
	    path: 'admin/stations',
	    element: <PrototypePage title="Fuel Stations" />,
	  },
	  {
	    path: 'admin/shift-definitions',
	    element: <PrototypePage title="Shift Definitions" />,
	  },
	  {
	    path: 'admin/fuel-types',
	    element: <PrototypePage title="Fuel Types" />,
	  },
	  {
	    path: 'admin/fuel-prices',
	    element: <PrototypePage title="Fuel Prices" />,
	  },
	  {
	    path: 'admin/dispenser-units',
	    element: <PrototypePage title="Dispenser Units" />,
	  },
	  {
	    path: 'admin/dispenser-sides',
	    element: <PrototypePage title="Dispenser Sides" />,
	  },
	  {
	    path: 'admin/nozzles',
	    element: <PrototypePage title="Nozzles" />,
	  },
	  {
	    path: 'admin/employees',
	    element: <PrototypePage title="Employees" />,
	  },
	  {
	    path: 'admin/users',
	    element: <PrototypePage title="Users" />,
	  },
	  {
	    path: 'admin/roles',
	    element: <PrototypePage title="Roles" />,
	  },
	  {
	    path: 'admin/station-access',
	    element: <PrototypePage title="Station Access" />,
	  },
	  {
	    path: 'admin/audit-history',
	    element: <PrototypePage title="Audit History" />,
	  },
    ],
  },
]);

export default router;