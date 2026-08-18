import AccessTimeOutlinedIcon from '@mui/icons-material/AccessTimeOutlined';
import AssignmentTurnedInOutlinedIcon from '@mui/icons-material/AssignmentTurnedInOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import PaymentsOutlinedIcon from '@mui/icons-material/PaymentsOutlined';

import {
  Box,
  Button,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

import { useNavigate } from 'react-router';

import { prototypeUser } from '../../app/prototype/prototypeUser';
import DashboardStatCard from '../../components/dashboard/DashboardStatCard';

function EmployeeDashboard() {
  const navigate = useNavigate();

  return (
    <Stack spacing={3}>
      <Box>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Dashboard
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{
            mt: 0.5,
          }}
        >
          Welcome back, {prototypeUser.name}.
        </Typography>
      </Box>

      <Box
        sx={{
          display: 'grid',
          gridTemplateColumns: {
            xs: '1fr',
            sm: 'repeat(2, minmax(0, 1fr))',
            lg: 'repeat(4, minmax(0, 1fr))',
          },
          gap: 2,
        }}
      >
        <DashboardStatCard
          title="Current Shift"
          value="Shift 1"
          helperText="06:00 - 14:00"
          icon={<AccessTimeOutlinedIcon />}
        />

        <DashboardStatCard
          title="Assigned Nozzles"
          value="2"
          helperText="Petrol & Diesel"
          icon={<LocalGasStationOutlinedIcon />}
        />

        <DashboardStatCard
          title="Receipt Status"
          value="START Confirmed"
          helperText="END receipt pending"
          icon={<AssignmentTurnedInOutlinedIcon />}
        />

        <DashboardStatCard
          title="Collections"
          value="₹ 42,750"
          helperText="Current entered total"
          icon={<PaymentsOutlinedIcon />}
        />
      </Box>

      <Box
        sx={{
          display: 'grid',
          gridTemplateColumns: {
            xs: '1fr',
            lg: '1.4fr 1fr',
          },
          gap: 2,
        }}
      >
        <Paper
          elevation={0}
          sx={{
            p: 3,
            border: 1,
            borderColor: 'divider',
            borderRadius: 2,
          }}
        >
          <Typography
            variant="h6"
            sx={{
              fontWeight: 700,
              color: 'primary.dark',
              mb: 2,
            }}
          >
            Current Shift
          </Typography>

          <Stack spacing={1.5}>
            <Typography variant="body2">
              <strong>Station:</strong> {prototypeUser.stationName}
            </Typography>

            <Typography variant="body2">
              <strong>Shift:</strong> Shift 1
            </Typography>

            <Typography variant="body2">
              <strong>Working Time:</strong> 06:00 - 14:00
            </Typography>

            <Typography variant="body2">
              <strong>Assigned Nozzles:</strong> N1 Petrol, N2 Diesel
            </Typography>
          </Stack>

          <Button
            variant="contained"
            onClick={() => navigate('/app/shift')}
            sx={{
              mt: 3,
            }}
          >
            View My Shift
          </Button>
        </Paper>

        <Paper
          elevation={0}
          sx={{
            p: 3,
            border: 1,
            borderColor: 'divider',
            borderRadius: 2,
          }}
        >
          <Typography
            variant="h6"
            sx={{
              fontWeight: 700,
              color: 'primary.dark',
              mb: 2,
            }}
          >
            Quick Actions
          </Typography>

          <Stack spacing={1.5}>
            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/receipts')}
            >
              Capture Receipt
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/collections')}
            >
              Enter Collections
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/reconciliation')}
            >
              View Reconciliation
            </Button>
          </Stack>
        </Paper>
      </Box>
    </Stack>
  );
}

export default EmployeeDashboard;