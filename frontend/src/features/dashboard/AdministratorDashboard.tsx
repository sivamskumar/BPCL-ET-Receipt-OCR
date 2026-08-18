import AccountTreeOutlinedIcon from '@mui/icons-material/AccountTreeOutlined';
import GroupsOutlinedIcon from '@mui/icons-material/GroupsOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import ManageAccountsOutlinedIcon from '@mui/icons-material/ManageAccountsOutlined';

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

function AdministratorDashboard() {
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
          Administrator Dashboard
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
          title="Fuel Stations"
          value="3"
          helperText="Active stations"
          icon={<LocalGasStationOutlinedIcon />}
        />

        <DashboardStatCard
          title="Employees"
          value="18"
          helperText="Active employees"
          icon={<GroupsOutlinedIcon />}
        />

        <DashboardStatCard
          title="Dispenser Units"
          value="8"
          helperText="Configured units"
          icon={<AccountTreeOutlinedIcon />}
        />

        <DashboardStatCard
          title="Application Users"
          value="12"
          helperText="Active user accounts"
          icon={<ManageAccountsOutlinedIcon />}
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
            System Overview
          </Typography>

          <Stack spacing={1.5}>
            <Typography variant="body2">
              <strong>Organization:</strong> Demo Organization
            </Typography>

            <Typography variant="body2">
              <strong>Fuel Stations:</strong> 3 active
            </Typography>

            <Typography variant="body2">
              <strong>Employees:</strong> 18 active
            </Typography>

            <Typography variant="body2">
              <strong>Configured Nozzles:</strong> 24
            </Typography>

            <Typography variant="body2">
              <strong>Open Shifts:</strong> 4
            </Typography>
          </Stack>

          <Button
            variant="contained"
            onClick={() => navigate('/app/admin/stations')}
            sx={{
              mt: 3,
            }}
          >
            Manage Fuel Stations
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
              onClick={() => navigate('/app/admin/employees')}
            >
              Manage Employees
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/admin/users')}
            >
              Manage Users
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/reports')}
            >
              Open Reports
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/admin/audit-history')}
            >
              View Audit History
            </Button>
          </Stack>
        </Paper>
      </Box>
    </Stack>
  );
}

export default AdministratorDashboard;