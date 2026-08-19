import { createBrowserRouter } from 'react-router';

import AuthLayout from '../layouts/AuthLayout';
import AppLayout from '../layouts/AppLayout';
import LoginPage from '../features/auth/LoginPage';
import DashboardPage from '../features/dashboard/DashboardPage';
import CollectionsPage from '../features/collections/CollectionsPage';
import ReconciliationPage from '../features/reconciliation/ReconciliationPage';
import ShiftPage from '../features/shift/ShiftPage';
import PrototypePage from '../features/common/PrototypePage';
import ReceiptCapturePage from '../features/receipt/ReceiptCapturePage';
import OcrReviewPage from '../features/receipt/OcrReviewPage';
import ReconciliationDetailPage from '../features/reconciliation/ReconciliationDetailPage';
import PendingReviewsPage from '../features/review/PendingReviewsPage';
import ReconciliationReviewPage from '../features/review/ReconciliationReviewPage';
import PendingApprovalsPage from '../features/approval/PendingApprovalsPage';
import ReconciliationApprovalPage from '../features/approval/ReconciliationApprovalPage';
import ApprovalHistoryPage from '../features/approval/ApprovalHistoryPage';
import ApprovalHistoryDetailPage from '../features/approval/ApprovalHistoryDetailPage';

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
	    element: <ReceiptCapturePage />,
	  },
	  {
	    path: 'receipts/ocr-review',
	    element: <OcrReviewPage />,
	  },
	  {
	    path: 'reconciliation/detail',
	    element: <ReconciliationDetailPage />,
	  },
	  {
	    path: 'reviews/pending',
	    element: <PendingReviewsPage />,
	  },
	  {
	    path: 'reviews/pending/detail',
	    element: <ReconciliationReviewPage />,
	  },
	  {
	    path: 'reviews/history',
	    element: <PrototypePage title="Review History" />,
	  },
	  {
	    path: 'approvals/pending',
	    element: <PendingApprovalsPage />,
	  },
	  {
	    path: 'approvals/pending/detail',
	    element: <ReconciliationApprovalPage />,
	  },
	  {
	    path: 'approvals/history',
	    element: <ApprovalHistoryPage />,
	  },
	  {
	    path: 'approvals/history/detail',
	    element: <ApprovalHistoryDetailPage />,
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