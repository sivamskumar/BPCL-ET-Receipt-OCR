import { useState } from 'react';

import {
  Box,
  Drawer,
} from '@mui/material';

import { Outlet } from 'react-router';

import AppFooter from '../components/layout/AppFooter';
import AppHeader from '../components/layout/AppHeader';
import AppNavigation from '../components/layout/AppNavigation';
import AppSidebar from '../components/layout/AppSidebar';

const MOBILE_DRAWER_WIDTH = 280;

function AppLayout() {
  const [mobileNavigationOpen, setMobileNavigationOpen] =
    useState(false);

  const handleMobileNavigationOpen = () => {
    setMobileNavigationOpen(true);
  };

  const handleMobileNavigationClose = () => {
    setMobileNavigationOpen(false);
  };

  return (
    <Box
      sx={{
        minHeight: '100vh',
        display: 'flex',
        flexDirection: 'column',
        backgroundColor: 'background.default',
      }}
    >
      <AppHeader
        onMenuClick={handleMobileNavigationOpen}
      />

      <Box
        sx={{
          flexGrow: 1,
          display: 'flex',
          minHeight: 0,
        }}
      >
        <Box
          sx={{
            display: {
              xs: 'none',
              md: 'block',
            },
          }}
        >
          <AppSidebar />
        </Box>

        <Drawer
          anchor="left"
          open={mobileNavigationOpen}
          onClose={handleMobileNavigationClose}
          sx={{
            display: {
              xs: 'block',
              md: 'none',
            },
            '& .MuiDrawer-paper': {
              width: MOBILE_DRAWER_WIDTH,
              boxSizing: 'border-box',
              backgroundColor: 'primary.dark',
              color: 'primary.contrastText',
            },
          }}
        >
          <AppNavigation
            onNavigate={handleMobileNavigationClose}
          />
        </Drawer>

        <Box
          component="main"
          sx={{
            flexGrow: 1,
            minWidth: 0,
            p: {
              xs: 2,
              sm: 2.5,
              md: 3,
            },
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