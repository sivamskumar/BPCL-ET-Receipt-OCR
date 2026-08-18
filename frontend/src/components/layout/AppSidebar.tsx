import { Box } from '@mui/material';

import AppNavigation from './AppNavigation';

function AppSidebar() {
  return (
    <Box
      component="aside"
      sx={{
        width: 260,
        flexShrink: 0,
        backgroundColor: 'primary.dark',
        color: 'primary.contrastText',
      }}
    >
      <AppNavigation />
    </Box>
  );
}

export default AppSidebar;