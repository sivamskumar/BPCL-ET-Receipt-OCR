import AccountCircleOutlinedIcon from '@mui/icons-material/AccountCircleOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import { Box, Typography } from '@mui/material';
import { prototypeUser } from '../../app/prototype/prototypeUser';

function AppHeader() {
  return (
    <Box
      component="header"
      sx={{
        height: 64,
        flexShrink: 0,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        px: 3,
        backgroundColor: 'background.paper',
        borderBottom: 1,
        borderColor: 'divider',
      }}
    >
      <Box
        sx={{
          display: 'flex',
          alignItems: 'center',
          gap: 1.5,
        }}
      >
        <Box
          sx={{
            width: 40,
            height: 40,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            borderRadius: 1.5,
            backgroundColor: 'secondary.main',
          }}
        >
          <LocalGasStationOutlinedIcon />
        </Box>

        <Typography
          variant="h6"
          component="div"
          sx={{
            fontWeight: 700,
            color: 'primary.dark',
          }}
        >
          Fuel Station Shift Reconciliation
        </Typography>
      </Box>

      <Box
        sx={{
          display: 'flex',
          alignItems: 'center',
          gap: 1.5,
        }}
      >
        <Box
          sx={{
            textAlign: 'right',
          }}
        >
		<Typography
		  variant="body2"
		  sx={{
		    fontWeight: 600,
		  }}
		>
		  {prototypeUser.name}
		</Typography>

		<Typography
		  variant="body2"
		  sx={{
		    fontWeight: 600,
		  }}
		>
		  {prototypeUser.stationName}
		</Typography>

		<Typography
		  variant="caption"
		  color="text.secondary"
		>
		  {prototypeUser.role}
		</Typography>
        </Box>

        <AccountCircleOutlinedIcon
          sx={{
            fontSize: 34,
            color: 'primary.main',
          }}
        />
      </Box>
    </Box>
  );
}

export default AppHeader;