import AssignmentLateOutlinedIcon from '@mui/icons-material/AssignmentLateOutlined';
import ErrorOutlineOutlinedIcon from '@mui/icons-material/ErrorOutlineOutlined';
import HistoryOutlinedIcon from '@mui/icons-material/HistoryOutlined';
import WarningAmberOutlinedIcon from '@mui/icons-material/WarningAmberOutlined';

import {
  Box,
  Button,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

import { useNavigate } from 'react-router';

import DashboardStatCard from '../../components/dashboard/DashboardStatCard';
import { prototypeUser } from '../../app/prototype/prototypeUser';

function ReviewerDashboard() {
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
          Reviewer Dashboard
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
          title="Pending Reviews"
          value="6"
          helperText="Awaiting Level-1 review"
          icon={<AssignmentLateOutlinedIcon />}
        />

        <DashboardStatCard
          title="Shortage Cases"
          value="2"
          helperText="Require attention"
          icon={<ErrorOutlineOutlinedIcon />}
        />

        <DashboardStatCard
          title="Excess Cases"
          value="1"
          helperText="Outside tolerance"
          icon={<WarningAmberOutlinedIcon />}
        />

        <DashboardStatCard
          title="Reviewed Today"
          value="8"
          helperText="Completed decisions"
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
            Pending Review Summary
          </Typography>

          <Stack spacing={1.5}>
            <Typography variant="body2">
              <strong>Matched:</strong> 3
            </Typography>

            <Typography variant="body2">
              <strong>Shortage:</strong> 2
            </Typography>

            <Typography variant="body2">
              <strong>Excess:</strong> 1
            </Typography>

            <Typography variant="body2">
              <strong>Oldest Pending:</strong> 1 hour 25 minutes
            </Typography>
          </Stack>

          <Button
            variant="contained"
            onClick={() => navigate('/app/reviews/pending')}
            sx={{
              mt: 3,
            }}
          >
            Open Pending Reviews
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
              onClick={() => navigate('/app/reviews/pending')}
            >
              Review Pending Cases
            </Button>

            <Button
              variant="outlined"
              fullWidth
              onClick={() => navigate('/app/reviews/history')}
            >
              View Review History
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

export default ReviewerDashboard;