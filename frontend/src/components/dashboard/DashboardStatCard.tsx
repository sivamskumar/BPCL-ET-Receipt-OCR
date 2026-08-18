import type { ReactNode } from 'react';

import {
  Box,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

type DashboardStatCardProps = {
  title: string;
  value: string;
  icon: ReactNode;
  helperText?: string;
};

function DashboardStatCard({
  title,
  value,
  icon,
  helperText,
}: DashboardStatCardProps) {
  return (
    <Paper
      elevation={0}
      sx={{
        height: '100%',
        p: 2.5,
        border: 1,
        borderColor: 'divider',
        borderRadius: 2,
        backgroundColor: 'background.paper',
      }}
    >
      <Stack
        direction="row"
        spacing={2}
		sx={{
		    alignItems: 'center',
		  }}
      >
        <Box
          sx={{
            width: 48,
            height: 48,
            flexShrink: 0,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            borderRadius: 2,
            backgroundColor: 'primary.light',
            color: 'primary.contrastText',
          }}
        >
          {icon}
        </Box>

        <Box
          sx={{
            minWidth: 0,
          }}
        >
          <Typography
            variant="body2"
            color="text.secondary"
          >
            {title}
          </Typography>

          <Typography
            variant="h5"
            sx={{
              mt: 0.25,
              fontWeight: 700,
              color: 'primary.dark',
            }}
          >
            {value}
          </Typography>

          {helperText && (
            <Typography
              variant="caption"
              color="text.secondary"
              sx={{
                display: 'block',
                mt: 0.5,
              }}
            >
              {helperText}
            </Typography>
          )}
        </Box>
      </Stack>
    </Paper>
  );
}

export default DashboardStatCard;