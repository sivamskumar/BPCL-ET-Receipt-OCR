import { Box } from '@mui/material';
import { Outlet } from 'react-router';

function AuthLayout() {
  return (
    <Box
      component="main"
      sx={{
        minHeight: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'background.default',
      }}
    >
      <Outlet />
    </Box>
  );
}

export default AuthLayout;