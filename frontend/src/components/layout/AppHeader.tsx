import AccountCircleOutlinedIcon from '@mui/icons-material/AccountCircleOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import MenuOutlinedIcon from '@mui/icons-material/MenuOutlined';

import {
  Box,
  IconButton,
  Typography,
} from '@mui/material';

import { prototypeUser } from '../../app/prototype/prototypeUser';

type AppHeaderProps = {
  onMenuClick?: () => void;
};

function AppHeader({
  onMenuClick,
}: AppHeaderProps) {
  return (
    <Box
      component="header"
      sx={{
        height: 64,
        flexShrink: 0,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        px: {
          xs: 1.5,
          sm: 2,
          md: 3,
        },
        backgroundColor: 'background.paper',
        borderBottom: 1,
        borderColor: 'divider',
      }}
    >
      <Box
        sx={{
          display: 'flex',
          alignItems: 'center',
          gap: {
            xs: 1,
            sm: 1.5,
          },
          minWidth: 0,
        }}
      >
        <IconButton
          aria-label="Open navigation menu"
          onClick={onMenuClick}
          sx={{
            display: {
              xs: 'inline-flex',
              md: 'none',
            },
            color: 'primary.dark',
          }}
        >
          <MenuOutlinedIcon />
        </IconButton>

        <Box
          sx={{
            width: 40,
            height: 40,
            flexShrink: 0,
            display: {
              xs: 'none',
              sm: 'flex',
            },
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
            whiteSpace: 'nowrap',
            overflow: 'hidden',
            textOverflow: 'ellipsis',
            fontSize: {
              xs: '1rem',
              sm: '1.25rem',
            },
          }}
        >
          Fuel Station Shift Reconciliation
        </Typography>
      </Box>

      <Box
        sx={{
          display: 'flex',
          alignItems: 'center',
          gap: {
            xs: 0.5,
            sm: 1.5,
          },
          flexShrink: 0,
        }}
      >
        <Box
          sx={{
            textAlign: 'right',
            display: {
              xs: 'none',
              sm: 'block',
            },
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
            fontSize: {
              xs: 30,
              sm: 34,
            },
            color: 'primary.main',
          }}
        />
      </Box>
    </Box>
  );
}

export default AppHeader;