import { useState } from 'react';

import {
  Box,
  Button,
  IconButton,
  InputAdornment,
  Stack,
  TextField,
  Typography,
} from '@mui/material';

import AccountCircleOutlinedIcon from '@mui/icons-material/AccountCircleOutlined';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import VisibilityOffOutlinedIcon from '@mui/icons-material/VisibilityOffOutlined';
import VisibilityOutlinedIcon from '@mui/icons-material/VisibilityOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';

function LoginPage() {
  const [showPassword, setShowPassword] = useState(false);

  return (
    <Box
      sx={{
        width: '100%',
        maxWidth: 420,
      }}
    >
	<Stack
	  spacing={1.5}
	  sx={{
	    display: {
	      xs: 'flex',
	      md: 'none',
	    },
	    mb: 4,
	  }}
	>
	  <Box
	    sx={{
	      width: 52,
	      height: 52,
	      display: 'flex',
	      alignItems: 'center',
	      justifyContent: 'center',
	      borderRadius: 2,
	      backgroundColor: 'secondary.main',
	      color: 'secondary.contrastText',
	    }}
	  >
	    <LocalGasStationOutlinedIcon sx={{ fontSize: 30 }} />
	  </Box>

	  <Typography
	    variant="h5"
	    component="h1"
	    sx={{
	      color: 'primary.dark',
	      fontWeight: 700,
	    }}
	  >
	    Fuel Station Shift Reconciliation
	  </Typography>
	</Stack>
      <Stack spacing={1} sx={{ mb: 4 }}>
        <Typography
          variant="h4"
          component="h2"
          sx={{
            color: 'primary.dark',
          }}
        >
          Welcome back
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
        >
          Sign in to continue to your station workspace.
        </Typography>
      </Stack>

	  <Box
	    component="form"
	    onSubmit={(event) => event.preventDefault()}
	    sx={{
          display: 'flex',
          flexDirection: 'column',
          gap: 2.5,
        }}
      >
        <TextField
          label="Username"
          name="username"
          autoComplete="username"
          fullWidth
          slotProps={{
            input: {
              startAdornment: (
                <InputAdornment position="start">
                  <AccountCircleOutlinedIcon color="action" />
                </InputAdornment>
              ),
            },
          }}
        />

        <TextField
          label="Password"
          name="password"
          type={showPassword ? 'text' : 'password'}
          autoComplete="current-password"
          fullWidth
          slotProps={{
            input: {
              startAdornment: (
                <InputAdornment position="start">
                  <LockOutlinedIcon color="action" />
                </InputAdornment>
              ),
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    aria-label={
                      showPassword ? 'Hide password' : 'Show password'
                    }
                    onClick={() => setShowPassword((current) => !current)}
                    edge="end"
                  >
                    {showPassword ? (
                      <VisibilityOffOutlinedIcon />
                    ) : (
                      <VisibilityOutlinedIcon />
                    )}
                  </IconButton>
                </InputAdornment>
              ),
            },
          }}
        />

        <Button
          type="submit"
          variant="contained"
          size="large"
          sx={{
            mt: 1,
            py: 1.4,
            backgroundColor: 'secondary.main',
            color: 'secondary.contrastText',
            '&:hover': {
              backgroundColor: 'secondary.dark',
            },
          }}
        >
          Sign In
        </Button>
      </Box>

      <Typography
        variant="caption"
        color="text.secondary"
        sx={{
          display: 'block',
          mt: 3,
          textAlign: 'center',
        }}
      >
        Authorized users only
      </Typography>
    </Box>
  );
}

export default LoginPage;