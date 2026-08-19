import type { ReactNode } from 'react';

import {
  Alert,
  Box,
  Typography,
} from '@mui/material';

type ApplicationAlertProps = {
  severity: 'success' | 'error';
  title: string;
  children?: ReactNode;
};

function ApplicationAlert({
  severity,
  title,
  children,
}: ApplicationAlertProps) {
  return (
    <Alert
      severity={severity}
      sx={{
        alignItems: 'flex-start',
        border: 1,
        borderColor:
          severity === 'success'
            ? 'success.light'
            : 'error.light',
      }}
    >
      <Typography
        variant="subtitle1"
        sx={{
          fontWeight: 700,
        }}
      >
        {title}
      </Typography>

      {children && (
        <Box
          sx={{
            mt: 0.25,
          }}
        >
          {children}
        </Box>
      )}
    </Alert>
  );
}

export default ApplicationAlert;