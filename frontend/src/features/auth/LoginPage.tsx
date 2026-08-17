import { Box, Button, Paper, TextField, Typography } from '@mui/material';

function LoginPage() {
  return (
    <Paper
      elevation={3}
      sx={{
        width: '100%',
        maxWidth: 420,
        p: 4,
      }}
    >
      <Box
        component="form"
        sx={{
          display: 'flex',
          flexDirection: 'column',
          gap: 2.5,
        }}
      >
	  <Typography
	    variant="h5"
	    component="h1"
	    sx={{ textAlign: 'center' }}
	  >
	    Fuel Station Shift Reconciliation
	  </Typography>

	  <Typography
	    variant="body2"
	    color="text.secondary"
	    sx={{ textAlign: 'center' }}
	  >
	    Sign in to continue
	  </Typography>

        <TextField
          label="Username"
          name="username"
          fullWidth
        />

        <TextField
          label="Password"
          name="password"
          type="password"
          fullWidth
        />

        <Button
          type="submit"
          variant="contained"
          size="large"
        >
          Sign In
        </Button>
      </Box>
    </Paper>
  );
}

export default LoginPage;