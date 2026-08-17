import { Box } from '@mui/material';
import { Outlet } from 'react-router';

import AppHeader from '../components/layout/AppHeader';
import AppFooter from '../components/layout/AppFooter';
import AppSidebar from '../components/layout/AppSidebar';

function AppLayout() {
  return (
    <Box
      sx={{
        minHeight: '100vh',
        display: 'flex',
        flexDirection: 'column',
        backgroundColor: 'background.default',
      }}
    >
      <AppHeader />

      <Box
        sx={{
          flexGrow: 1,
          display: 'flex',
          minHeight: 0,
        }}
      >
        <AppSidebar />

        <Box
          component="main"
          sx={{
            flexGrow: 1,
            minWidth: 0,
            p: 3,
          }}
        >
          <Outlet />
        </Box>
      </Box>

      <AppFooter />
    </Box>
  );
}

export default AppLayout;