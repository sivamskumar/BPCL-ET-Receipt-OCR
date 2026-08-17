import { Box, Typography } from '@mui/material';

function AppFooter() {
  return (
    <Box
      component="footer"
      sx={{
        minHeight: 40,
        flexShrink: 0,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        px: 3,
        backgroundColor: 'background.paper',
        borderTop: 1,
        borderColor: 'divider',
      }}
    >
      <Typography
        variant="caption"
        color="text.secondary"
      >
        © 2026 Fuel Station Shift Reconciliation System
      </Typography>

      <Typography
        variant="caption"
        color="text.secondary"
      >
        Version 0.1.0
      </Typography>
    </Box>
  );
}

export default AppFooter;