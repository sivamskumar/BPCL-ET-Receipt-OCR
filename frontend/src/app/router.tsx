import { createBrowserRouter } from 'react-router';

import AuthLayout from '../layouts/AuthLayout';
import LoginPage from '../features/auth/LoginPage';

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
]);

export default router;