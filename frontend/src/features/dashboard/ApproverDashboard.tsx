import AssignmentTurnedInOutlinedIcon from '@mui/icons-material/AssignmentTurnedInOutlined';
import FactCheckOutlinedIcon from '@mui/icons-material/FactCheckOutlined';
import HistoryOutlinedIcon from '@mui/icons-material/HistoryOutlined';
import ReportProblemOutlinedIcon from '@mui/icons-material/ReportProblemOutlined';

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

function ApproverDashboard() {
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
          Approver Dashboard
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
          title="Pending Approvals"
          value="4"
          helperText="Awaiting Level-2 approval"
          icon={<FactCheckOutlinedIcon />}
        />

        <DashboardStatCard
          title="Exception Cases"
          value="2"
          helperText="Shortage / excess cases"
          icon={<ReportProblemOutlinedIcon />}
        />

        <DashboardStatCard
          title="Approved Today"
          value="7"
          helperText="Completed approvals"
          icon={<AssignmentTurnedInOutlinedIcon />}
        />

        <DashboardStatCard
          title="Returned / Rejected"
          value="1"
          helperText="Requires employee action"
          icon={<HistoryOutlinedIcon />}
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
            Pending Approval Summary
          </Typography>

          <Stack spacing={1.5}>
            <Typography variant="body2">
              <strong>Matched:</strong> 2
            </Typography>

            <Typography variant="body2">
              <strong>Shortage:</strong> 1
            </Typography>

            <Typography variant="body2">
              <strong>Excess:</strong> 1
            </Typography>

            <Typography variant="body2">
              <strong>Oldest Pending:</strong> 45 minutes
            </Typography>
          </Stack>

          <Button
            variant="contained"
            onClick={() => navigate('/app/approvals/pending')}
            sx={{
              mt: 3,
            }}
          >
            Open Pending Approvals
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
              onClick={() => navigate('/app/approvals/pending')}
            >
              Review Pending Approvals
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/approvals/history')}
            >
              View Approval History
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/reports')}
            >
              Open Reports
            </Button>
          </Stack>
        </Paper>
      </Box>
    </Stack>
  );
}

export default ApproverDashboard;