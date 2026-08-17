import {
  Box,
  Container,
  Stack,
  Typography,
} from '@mui/material';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import { Outlet } from 'react-router';

function AuthLayout() {
  return (
    <Box
      component="main"
      sx={{
        minHeight: '100vh',
        display: 'flex',
		alignItems: {
		  xs: 'flex-start',
		  md: 'center',
		},
        backgroundColor: 'background.default',
      }}
    >
	<Container
	  maxWidth="lg"
	  disableGutters
	  sx={{
	    px: {
	      xs: 0,
	      md: 3,
	    },
	    py: {
	      xs: 0,
	      md: 6,
	    },
	  }}
	>
	  <Box
	    sx={{
	      minHeight: {
	        xs: '100vh',
	        md: 620,
	      },
	      display: 'grid',
	      gridTemplateColumns: {
	        xs: '1fr',
	        md: '1.1fr 0.9fr',
	      },
	      overflow: 'hidden',

	      borderRadius: {
	        xs: 0,
	        md: 3,
	      },

	      backgroundColor: 'background.paper',

	      boxShadow: {
	        xs: 0,
	        md: 3,
	      },
	    }}
	  >
		<Box
		  sx={{
		    display: {
		      xs: 'none',
		      md: 'flex',
		    },
		    flexDirection: 'column',
		    justifyContent: 'space-between',
		    p: 6,
		    color: 'primary.contrastText',
		    backgroundColor: 'primary.dark',
		  }}
		>
		  <Stack spacing={2}>
		    <Box
		      sx={{
		        width: 64,
		        height: 64,
		        display: 'flex',
		        alignItems: 'center',
		        justifyContent: 'center',
		        borderRadius: 2,
		        backgroundColor: 'secondary.main',
		        color: 'secondary.contrastText',
		      }}
		    >
		      <LocalGasStationOutlinedIcon sx={{ fontSize: 38 }} />
		    </Box>

		    <Typography
		      variant="h4"
		      component="h1"
		      sx={{
		        maxWidth: 420,
		        lineHeight: 1.25,
		      }}
		    >
		      Fuel Station Shift Reconciliation
		    </Typography>

		    <Typography
		      variant="body1"
		      sx={{
		        maxWidth: 440,
		        color: 'rgba(255, 255, 255, 0.82)',
		        lineHeight: 1.7,
		      }}
		    >
		      A reliable platform for shift operations, receipt processing,
		      collections and reconciliation.
		    </Typography>
		  </Stack>

		  <Stack spacing={1}>
		    <Typography
		      variant="body2"
		      sx={{
		        color: 'secondary.main',
		        fontWeight: 600,
		      }}
		    >
		      ACCURATE • AUDITABLE • EFFICIENT
		    </Typography>

		    <Typography
		      variant="caption"
		      sx={{
		        color: 'rgba(255, 255, 255, 0.65)',
		      }}
		    >
		      Fuel Station Operations Platform
		    </Typography>
		  </Stack>
		</Box>

          <Box
            sx={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
			  p: {
			    xs: 3,
			    sm: 4,
			    md: 6,
			  },
            }}
          >
            <Outlet />
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default AuthLayout;